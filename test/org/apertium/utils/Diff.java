package org.apertium.utils;

public class Diff {
	public static String diff(String text1, String text2) {
		StringBuffer ret = new StringBuffer();
		
		String[] x = text1.split("\\n");
		String[] y = text2.split("\\n");

		int m = x.length;
		int n = y.length;

		int[][] opt = new int[m + 1][n + 1];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (x[i].equals(y[j]))
					opt[i][j] = opt[i + 1][j + 1] + 1;
				else
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
			}
		}

		int i = 0, j = 0;
		while (i < m && j < n) {
			if (x[i].equals(y[j])) {
				i++;
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1])
				ret.append("< " + x[i++]);
			else
				ret.append("> " + y[j++]);
		}

		while (i < m || j < n) {
			if (i == m)
				ret.append("> " + y[j++]);
			else if (j == n)
				ret.append("< " + x[i++]);
		}
		
		return ret.toString();
	}
}
