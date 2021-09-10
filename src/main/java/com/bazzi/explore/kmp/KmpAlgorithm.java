package com.bazzi.explore.kmp;

/**
 * 描述：https://zh.wikipedia.org/wiki/KMP%E7%AE%97%E6%B3%95
 * 代码：https://leetcode.com/problems/implement-strstr/discuss/535326/Java-KMP-Solution-O(m%2Bn)-Clean-code
 * 其他：https://blog.csdn.net/bjweimengshu/article/details/104528964
 */
public class KmpAlgorithm {
    public static int kmpFind(String str, String pattern) {
        if (str == null || pattern == null)
            return -1;
        if (pattern.isEmpty()) return 0;
        int[] lps = computeKMPTable(pattern);
        int n = str.length(), m = pattern.length();
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j))
                j = lps[j - 1];
            if (str.charAt(i) == pattern.charAt(j) && ++j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


    public static int kmpFind1(String str, String pattern) {
        if (str == null || pattern == null)
            return -1;
        if (pattern.isEmpty())
            return 0;
        int[] lps = computeKMPTable1(pattern);
        int i = 0, j = 0, n = str.length(), m = pattern.length();
        while (i < n) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m)
                    return i - m;
            } else {
                if (j != 0)
                    j = lps[j - 1]; // try match with the longest prefix suffix
                else
                    i++; // don't match -> go to next character of `str` string
            }
        }
        return -1;
    }

    private static int[] computeKMPTable(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = lps[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j))
                lps[i] = ++j;
        }
        return lps;
    }

    private static int[] computeKMPTable1(String pattern) {
        int i = 1, j = 0, n = pattern.length();
        int[] lps = new int[n];
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j != 0)
                    j = lps[j - 1]; // try match with the longest prefix suffix
                else
                    i++; // don't match -> go to next character
            }
        }
        return lps;
    }
}
