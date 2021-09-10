package com.bazzi.explore.test.kmp;

import com.bazzi.explore.kmp.KmpAlgorithm;
import org.junit.Assert;
import org.junit.Test;

public class KmpAlgorithmTest {

    @Test
    public void testKmpFind() {
        String str = "hello";
        String pattern = "ll";
        int expected = 2;

        int idx = KmpAlgorithm.kmpFind(str, pattern);
        Assert.assertEquals(expected, idx);

        int idx1 = KmpAlgorithm.kmpFind1(str, pattern);
        Assert.assertEquals(expected, idx1);

        str = "aaaaa";
        pattern = "bba";
        expected = -1;
        idx = KmpAlgorithm.kmpFind(str, pattern);
        Assert.assertEquals(expected, idx);

        idx1 = KmpAlgorithm.kmpFind1(str, pattern);
        Assert.assertEquals(expected, idx1);

        str = "q";
        pattern = "";
        expected = 0;
        idx = KmpAlgorithm.kmpFind(str, pattern);
        Assert.assertEquals(expected, idx);

        idx1 = KmpAlgorithm.kmpFind1(str, pattern);
        Assert.assertEquals(expected, idx1);

        str = "";
        pattern = "v";
        expected = -1;
        idx = KmpAlgorithm.kmpFind(str, pattern);
        Assert.assertEquals(expected, idx);

        idx1 = KmpAlgorithm.kmpFind1(str, pattern);
        Assert.assertEquals(expected, idx1);

        str = "";
        pattern = "";
        expected = 0;
        idx = KmpAlgorithm.kmpFind(str, pattern);
        Assert.assertEquals(expected, idx);

        idx1 = KmpAlgorithm.kmpFind1(str, pattern);
        Assert.assertEquals(expected, idx1);
    }
}
