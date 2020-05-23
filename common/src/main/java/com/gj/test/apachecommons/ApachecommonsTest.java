package com.gj.test.apachecommons;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * @ClassName: ApachecommonsTest
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/23 13:56
 * @Version: V1.0
 **/

public class ApachecommonsTest {

    public static void test01(){

        final double v = RandomUtils.nextDouble();

        // final boolean b = ObjectUtils.allNotNull(null);

        // System.out.println(v);

        final String hostName = SystemUtils.getHostName();

        System.out.println(hostName);

    }

    public static void test02(){
        final int compare = StringUtils.compare("a", "c");

        System.out.println(compare);

        final boolean contains = StringUtils.contains("abc", "a");

        System.out.println(contains);

        final String s = StringUtils.deleteWhitespace(" a b c");

        System.out.println(s);

        final boolean numeric = StringUtils.isNumeric("123c");

        System.out.println(numeric);

        final String abc = StringUtils.joinWith(",","cde","","A");

        System.out.println(abc);

        final Date date = DateUtils.addDays(new Date(), 3);

        System.out.println(date);

    }

    public static void main(String[] args) {
        test02();
    }
}
