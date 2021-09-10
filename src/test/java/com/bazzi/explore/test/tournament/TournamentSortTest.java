package com.bazzi.explore.test.tournament;

import com.bazzi.explore.tournament.TournamentSort;
import org.junit.Assert;
import org.junit.Test;

public class TournamentSortTest {

    @Test
    public void testTournamentSort() {
        int[] array = {4, 9, 3, 4, 7, 1, 5, 2, 8, 10, 11, 19, 4};
        int[] expected = {1, 2, 3, 4, 4, 4, 5, 7, 8, 9, 10, 11, 19};

        TournamentSort.tournamentSort(array);

        Assert.assertArrayEquals(expected, array);
    }
}
