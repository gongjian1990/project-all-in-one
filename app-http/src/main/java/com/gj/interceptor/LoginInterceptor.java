package com.gj.interceptor;

import com.gj.exception.UnAuthException;
import com.gj.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginInterceptor
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/21 20:01
 * @Version: V1.0
 **/
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {

        log.info("[login ckeck start]............");

        final String token = request.getHeader("token");
        if (StringUtils.isNotBlank(token)){

            log.info("[login token is] .................: {}",token);
            return checkToken(token);
        }
        //return false; 此处注释，不影响正常调试，todo: 实际项目中是return false;
        return true;
    }

    private boolean checkToken(String token) {

        try {
            final Claims claims = JwtUtil.parseJwt(token);
            final String userId = (String)claims.get("userId");
            final String tokenFromRedis = getTokenFromRedis(userId);
            if (StringUtils.isBlank(tokenFromRedis) && !StringUtils.equals(tokenFromRedis,token)){
                throw new UnAuthException(4001,"用户未登录或token无效");
            }
            return true;

        } catch (Exception e) {
            log.error("[checkToken error].......: {}",e);
        }
        return false;
    }

    public String getTokenFromRedis(String userId){
        // todo: 从redis中获取token，如果存在则返回，如果不存在或token已过期，则返回null
        return "";
    }
}
