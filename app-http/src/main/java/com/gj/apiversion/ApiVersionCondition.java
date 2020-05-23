package com.gj.apiversion;

import com.gj.exception.BizException;
import com.gj.res.ResStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * @ClassName: ApiVersionCondition
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/23 14:58
 * @Version: V1.0
 **/
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    private static final String VERSION_REGEX = "^(\\d{1,2})\\.(\\d{1,2})\\.(\\d{1,2})";

    private static final String VERSION_SPLIT_REGEX = "\\.";

    private static final String VERSION = "version";

    private String apiVersion;

    public ApiVersionCondition(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        return new ApiVersionCondition(other.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        final String version = request.getHeader(VERSION);
        if (StringUtils.isNotBlank(version)){
            // 检查版本是否合法
            if (!Pattern.matches(VERSION_REGEX,version)){
                throw new BizException(ResStatus.PARAMETER_ERROR.getCode(),"请求版本号格式错误");
            }
            if (compareTo(version,this.apiVersion)){
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest httpServletRequest) {
        return compareTo(other.getApiVersion(),this.apiVersion)?1:-1;
    }

    private boolean compareTo(String version1, String version2) {
        final String[] split1 = StringUtils.split(version1, VERSION_SPLIT_REGEX);
        final String[] split2 = StringUtils.split(version2, VERSION_SPLIT_REGEX);
        int length = split1.length;
        int versionSum1 = 0;
        int versionSum2 = 0;
        for (int i = 0; i < length; i++) {
            final double pow = Math.pow(100, (length - 1 - i));
            versionSum1+= Integer.valueOf(split1[i])*pow;
            versionSum2+= Integer.valueOf(split2[i])*pow;
        }
        if (versionSum1< versionSum2){
            return false;
        }
        return true;
    }
}
