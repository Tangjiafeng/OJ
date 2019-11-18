package com.ecnu.leetcode.string;

/**
 * 
 * https://leetcode.com/problems/integer-to-roman/
 * @author A
 *
 */
public class IntegerToRoman {
	/*
	 * Algor 2: most fast version.
	 */
	public static String intToRoman2(int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++) {
            while(num >= values[i]){
                num -=values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
	}
	/*
	 * Alogr 1: most brief version.
	 */
	public static String intToRoman1(int num) {
		String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] C = {"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] M = {"", "M","MM","MMM","MMMM","MMMMM"};
            
       return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] +  I[num%10];
	}
	/*
	 * Algor of mine: separate each digit of the number, resolve the digit from high to low.
	 * 
	 * status: Accepted.
	 */
	static enum ch {
		I,
		V,
		X,
		L,
		C,
		D,
		M
	}
	
	public static String intToRoman(int num) {
		int thousand = num / 1000;
		String thou_str = resolve(thousand, 4);
		int hundred = (num - thousand * 1000) / 100;
		String hund_str = resolve(hundred, 3);
		int ten = (num - thousand * 1000 - hundred * 100) / 10;
		String ten_str = resolve(ten, 2);
		int ideal = num - thousand * 1000 - hundred * 100 - ten * 10;
		String ideal_str = resolve(ideal, 1);
		
        return thou_str + hund_str + ten_str + ideal_str;
    }
	
	private static String resolve(int num, int len) {
		StringBuffer str = new StringBuffer("");
		// V I
		if(num > 0 && num <= 3) {
			for(int i = 0; i < num; i ++) {
				str.append(ch.I);
			}
		} else {
			switch(num) {
			case 4:
				str.append("" + ch.I + ch.V);
				break;
			case 5:
				str.append(ch.V);
				break;
			case 6:
				str.append("" + ch.V + ch.I);
				break;
			case 7:
				str.append("" + ch.V + ch.I + ch.I);
				break;
			case 8:
				str.append("" + ch.V + ch.I + ch.I + ch.I);
				break;
			}
			if(num == 9) str.append("" + ch.I + ch.X);
		}
		String res = "";
		// replace V I
		switch(len) {
		case 1:
			res = str.toString();
			break;
		case 2:
			res = str.toString().replaceAll("" + ch.X, "" + ch.C)
			.replaceAll("" + ch.V, "" + ch.L)
			.replaceAll("" + ch.I, "" + ch.X);
			break;
		case 3:
			res = str.toString().replaceAll("" + ch.X, "" + ch.M)
			.replaceAll("" + ch.V, "" + ch.D)
			.replaceAll("" + ch.I, "" + ch.C);
			break;
		case 4:
			res = str.toString().replace("" + ch.I, "" + ch.M);
			break;
		}
		return res;
	}

}
