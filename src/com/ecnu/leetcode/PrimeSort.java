package com.ecnu.leetcode;

import java.math.BigInteger;

public class PrimeSort {
	public int numPrimeArrangements(int n) {
        int countPrime = 0;
        if(n == 1 || n == 2) return 1;
        for (int i = 1; i <= n; i++) {
        	if(isPrime(i)) {
        		countPrime ++;
        	}
		}
        int res = result(countPrime).multiply(result(n - countPrime)).mod(new BigInteger((int) Math.pow(10, 9) + 7 + "")).intValue();
        return res;  
    }
	
	public BigInteger result(int n) {
		BigInteger[] dp = new BigInteger[n + 1];
		if(n == 1) return new BigInteger("1");
		if(n == 2) return new BigInteger("2");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("2");
		for (int i = 3; i < dp.length; i++) {
			dp[i] = new BigInteger(i + "").multiply(dp[i - 1]);
		}
		return dp[n];
	}
	
	public boolean isPrime(int n) {
		if(n == 1) {
			return false;
		}
		for(int i = 2; i < n / 2 + 1; i ++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
