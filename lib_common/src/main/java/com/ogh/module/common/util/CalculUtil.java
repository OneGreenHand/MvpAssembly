package com.ogh.module.common.util;

import java.math.BigDecimal;

/**
 * date: 2018/11/10 16:49
 * author: wenxy
 * version: V1.0
 * description: 高精度计算工具类
 */
public class CalculUtil {


    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算
     *
     * ROUND_HALF_UP 四舍五入
     * ROUND_FLOOR 不四舍五入
     *
     * @param v1 被加数
     * @param v2 加数
     * @param scale 保留scale 位小数
     * @return 两个参数的和
     */
    public static String add(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("保留的小数位数必须大于零");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_FLOOR).toString();
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算
     *
     * ROUND_HALF_UP 四舍五入
     * ROUND_FLOOR 不四舍五入
     *
     * @param v1 被减数
     * @param v2 减数
     * @param scale 保留scale 位小数
     * @return 两个参数的差
     */
    public static String sub(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("保留的小数位数必须大于零");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_FLOOR).toString();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * ROUND_HALF_UP 四舍五入
     * ROUND_FLOOR 不四舍五入
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @param scale 保留scale 位小数
     * @return 两个参数的积
     */
    public static String mul(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("保留的小数位数必须大于零");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_FLOOR).toString();
    }

    /**
     * 提供精确的除法运算
     *
     * ROUND_HALF_UP 四舍五入
     * ROUND_FLOOR 不四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @param scale 保留scale 位小数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("保留的小数位数必须大于零");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    /**
     * 提供精确的除法运算
     *
     * ROUND_HALF_UP 四舍五入
     * ROUND_FLOOR 不四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @param scale 保留scale 位小数
     * @return 两个参数的商
     */
    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("保留的小数位数必须大于零");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_FLOOR).toString();
    }

    /**
     * 提供精确的小数位处理
     *
     * ROUND_HALF_UP 四舍五入
     * ROUND_FLOOR 不四舍五入
     *
     * @param v 需要四舍五入的数字
     * @param scale 保留scale 位小数
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("保留的小数位数必须大于零");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        return b.setScale(scale, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    /**
     * 提供精确的小数位处理
     *
     * ROUND_HALF_UP 四舍五入
     * ROUND_FLOOR 不四舍五入
     *
     * @param v 需要四舍五入的数字
     * @param scale 保留scale 位小数
     * @return 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("保留的小数位数必须大于零");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, BigDecimal.ROUND_FLOOR).toString();
    }

    /**
     * 取余数
     *
     * ROUND_HALF_UP 四舍五入
     * ROUND_FLOOR 不四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @param scale 保留scale 位小数
     * @return 余数
     */
    public static String remainder(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("保留的小数位数必须大于零");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_FLOOR).toString();
    }

    /**
     * 比较大小
     *
     * @param v1 被比较数
     * @param v2 比较数
     * @return 如果v1 大于v2 则 返回true 否则false
     */
    public static boolean compare(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        if (bj > 0)
            return true;
        else
            return false;
    }

}
