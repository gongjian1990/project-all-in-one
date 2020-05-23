package com.gj.test.stringformat;

/**
 * @ClassName: Test001
 * @Description: String.format();
 * @Author: 赵云
 * @Date: 2020/5/22 14:06
 * @Version: V1.0
 **/

public class Test001 {

    public static void main(String[] args) {
        /**
            %s ----> 字符串类型
            %c ----> 字符类型
            %b ----> 布尔类型
            %d ----> 整数类型（十进制）
            %x ----> 整数类型（十六进制）
            %o ----> 整数类型（把进制）
            %f ----> 浮点类型
            %% ----> 百分比类型
        */

        String s = String.format("my name is %s", "龚剑");

        System.out.println(s);

        String s1 = String.format("char is %c", 'A');

        System.out.println(s1);

        String s2 = String.format("折扣是%d%%", 85);

        System.out.println(s2);

    }
}
