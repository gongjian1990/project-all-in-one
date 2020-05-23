package com.gj.test.guava;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Test002
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/23 11:49
 * @Version: V1.0
 **/

public class Test002 {

    public static void main(String[] args) {

        final int compare = Longs.compare(1, 2);

        System.out.println(compare);

        final List<Integer> list = Arrays.asList(1, 2, 7);

        final List<Integer> list1 = Ints.asList(1, 2, 6);

        Ints.max(Ints.toArray(list));


    }

}
