package com.ecnu.luogu;

/**
 * https://www.luogu.org/problem/P1022
 */
public class Calculator {
    public static void main(String[] args) {
        String str = "-a+3a-15=a-3";// 提交代码要Scanner读入
        String[] strings = str.split("=");
        float[] left = calcu(strings[0]);
        float[] right = calcu(strings[1]);
        char c = 'x';
        // 确定未知数字母
        for(char ch : str.toCharArray()) {
            if(ch >= 97 && ch <= 122) {
                c = ch;
                break;
            }
        }
        System.out.printf(c + "=%.3f\n", (left[0] - right[0]) / (right[1] - left[1]));
    }

    public static float[] calcu(String str) {
        float[] res = new float[2];

        StringBuffer strBuff = new StringBuffer(str);
        if(strBuff.charAt(0) != '-') {// 加上"+"
            strBuff.insert(0, "+");
        }

        while(strBuff.toString().length() > 0) {
            int index1 = strBuff.substring(1).indexOf("+");
            int index2 = strBuff.substring(1).indexOf("-");
            // 确定截取范围
            int symbolIndex =
                    Math.min(index1 == -1 ? Integer.MAX_VALUE - 1 : index1
                            ,index2 == -1 ? Integer.MAX_VALUE - 1: index2)
                            + 1;
            if(index1 == -1 && index2 == -1) {
                symbolIndex = strBuff.length();
            }
            char c = strBuff.charAt(0);
            String num = strBuff.substring(1, symbolIndex);
            if (num.matches("[0-9]+(\\.[0-9]+)?")) {
                if(c == '+') {
                    res[0] += Float.parseFloat(num);
                    strBuff.delete(0, symbolIndex);
                    continue;
                }

                if(c == '-') {
                    res[0] -= Float.parseFloat(num);
                    strBuff.delete(0, symbolIndex);
                    continue;
                }
            } else {
                int len = num.length();
                if(1 == len) {// 解决系数为1时，省略1带来的问题
                    num = 1 + num;
                    len += 1;
                }
                if(c == '+') {
                    res[1] += Float.parseFloat(num.substring(0, len - 1));
                    strBuff.delete(0, symbolIndex);
                    continue;
                }

                if(c == '-') {
                    res[1] -= Float.parseFloat(num.substring(0, len - 1));
                    strBuff.delete(0, symbolIndex);
                    continue;
                }
            }

        }

        return res;
    }
}