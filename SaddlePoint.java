package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SaddlePoint {
	private static int[] getColumn(int[][] matrix, int col) {
		int[] column = new int[matrix.length];

		for (int j = 0; j < matrix.length; j++) {
			column[j] = matrix[j][col];
		}
		return column;
	}

	private static int getMin(int[] inputArray) {
		int minValue = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] < minValue) {
				minValue = inputArray[i];
			}
		}
		return minValue;
	}
	private static int getMax(int[] inputArray) {
		int maxValue = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] > maxValue) {
				maxValue = inputArray[i];
			}
		}
		return maxValue;
	}

	public static List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		int m = matrix.length, n = matrix[0].length;
		int[] row = new int[m];
		int[] col = new int[n];

		for (int i = 0; i < m; i++) {
			row[i] = getMin(matrix[i]);
		}
		for (int i = 0; i < n; i++) {
			col[i] = getMax(getColumn(matrix, i));
		}

		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < col.length; j++) {
				if (row[i] == col[j])
					res.add(row[i]);
			}
		}
		return res;
	}



	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 10, 4, 2 }, { 9, 3, 8, 7 }, { 15, 16, 17, 12 } };
		List<Integer> res = luckyNumbers(matrix1);
		for (int i : res)
			System.out.println(i);
		int[][] matrix2 = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
		res = luckyNumbers(matrix2);
		for (int i : res)
			System.out.println(i);
		int[][] matrix3 = { { 7, 8 }, { 1, 2 } };
		res = luckyNumbers(matrix3);
		for (int i : res)
			System.out.println(i);
	}
}
