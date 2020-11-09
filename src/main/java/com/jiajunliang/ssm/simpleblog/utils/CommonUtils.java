package com.jiajunliang.ssm.simpleblog.utils;

import java.util.Random;

/**
 * @project: SimpleBlog
 * @program: CommonUtils
 * @description: CommonUtils
 * @author: JIAJUN LIANG
 * @create: 2020-11-08 09:53
 **/
public class CommonUtils {
    private static Random random = new Random();

    public static int getRandomNum(int bound) {
        return random.nextInt(bound);
    }

}
