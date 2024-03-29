package com.ogh.module.common.util;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.StringTokenizer;


/**
 * date：2018/5/21 16:09
 * author: wenxy
 * description:
 */
public class PriceUtil {

    /**
     * 千位分隔符
     * digit 小数点后保留几位（价格相关慎用，会被四舍五入）
     */
    public static String qianWeiFenGe(float num, int digit) {
        DecimalFormat df = new DecimalFormat(digit == 1 ? "#,##0.0" : "#,##0.00");
        String ss = df.format(num);
        return ss;
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     */
    public static String subZeroAndDot(String s) {
        if (TextUtils.isEmpty(s) || s.trim().isEmpty()) {
            return "0";
        } else if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    /**
     * 比例转换，例如100:1
     */
    public static String priceConversion(String price, int bili) {
        String num = "";
        if (TextUtils.isEmpty(price) || price.trim().isEmpty())
            return "0";
        else
            num = subZeroAndDot(CalculUtil.div(price, bili + "", 2));
        return num;
    }

    /**
     * 只保留一位小数，不四舍五入
     */
    public static String splitOnePoint(String s, int pointCount) {
        if (TextUtils.isEmpty(s) || s.trim().isEmpty()) {
            s = "0.0";
        } else {
            if (s.contains(".")) {
                if (s.split("\\.")[1].length() > pointCount) {
                    s = s.split("\\.")[0] + "." + s.split("\\.")[1].substring(0, pointCount);
                    s = subZeroAndDot(s);
                }
            }
        }
        return s;
    }

    // m 转化为 km(四舍五入，保留小数点一位)
    public static String KmConversion(int m) {
        String distance = m + "";
        if (distance.length() <= 3) {
            distance = m + "m";
        } else {
            distance = round2((float) ((m / 100) * 0.1), 1).toString() + "km";
        }
        return distance;
    }

    // 值转化为W(不四舍五入保留两位小数,最多99亿)
    public static String PopularityConversion(int popularity) {
        String distance = popularity + "";
        if (distance.length() <= 4) {
            distance = popularity + "";
        } else {
            if (popularity % 10000 == 0) {//整数
                distance = popularity / 10000 + "w";
            } else {
                distance = subZeroAndDot(splitOnePoint((((float) popularity / 1000) * 0.1) + "", 2)) + "w";//这里要去除多余的0
            }
        }
        return distance;
    }

    /**
     * 四舍五入精确到小数随你几位
     */
    public static BigDecimal round2(float aFloat, int digit) {
        return new BigDecimal(String.valueOf(aFloat)).setScale(digit, BigDecimal.ROUND_HALF_UP);
    }

    public static Spannable getPriceSpDouble(double allpriceCart, int font1, int font2, int font3) {
        String[] prices = getPriceDouble(allpriceCart);
        int index = prices[0].length();
        Spannable sp = new SpannableString("￥" + prices[0] + "." + prices[1]);
        sp.setSpan(new AbsoluteSizeSpan(font1, true), 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        sp.setSpan(new AbsoluteSizeSpan(font2, true), 1, index + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        sp.setSpan(new AbsoluteSizeSpan(font3, true), index + 1, index + 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return sp;
    }

    public static Spannable getPriceSp(String allpriceCart, int font1, int font2, int font3, String color1, String color2) {
        Spannable sp = new SpannableString("￥" + allpriceCart + "起");
        sp.setSpan(new AbsoluteSizeSpan(font1, true), 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        sp.setSpan(new AbsoluteSizeSpan(font2, true), 1, allpriceCart.length() + 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        sp.setSpan(new AbsoluteSizeSpan(font3, true), allpriceCart.length() + 1, allpriceCart.length() + 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.parseColor(color1)), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.parseColor(color1)), 1, allpriceCart.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.parseColor(color2)), allpriceCart.length() + 1, allpriceCart.length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
    }

    public static String[] getPriceDouble(double allpriceCart) {
        int scale = 1;//设置位数
        int roundingMode = 4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
        BigDecimal bd = new BigDecimal(allpriceCart);
        bd = bd.setScale(scale, roundingMode);
        allpriceCart = bd.doubleValue();
        String[] prices = new String[2];
        //以.分割价格字符串
        StringTokenizer priceSt = new StringTokenizer(String.valueOf(allpriceCart), ".");
        if (priceSt.hasMoreTokens()) {
            prices[0] = priceSt.nextToken();
        } else {
            prices[0] = "0";
        }
        if (priceSt.hasMoreTokens()) {
            String s = priceSt.nextToken();
            prices[1] = s;
            s = null;
        } else {
            prices[1] = "0";
        }
        return prices;
    }
}
