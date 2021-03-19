package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    private List<Integer> list;

    @BeforeEach
    public void init() {
        this.list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
    }

    @Test
    public void sort() {

        List<Integer> list2 = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected2 = Arrays.asList(1,2,2,4);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);


        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);
        sorter = new ListSorter();
        List<Integer> sorted2 = sorter.sort(list2);

        Assertions.assertEquals(expected, sorted);
        Assertions.assertEquals(expected2, sorted2);
    }
}
