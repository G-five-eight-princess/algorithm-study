package com.practice.makes.perfect;

import java.util.Scanner;

public class D3_13218_조별과제_이주현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int idx = 1; idx <= testCase; idx++) {
			int N = sc.nextInt();
			int ans = N/3;
			System.out.println("#"+idx+" "+ans);
		}
		
		

	}

}
