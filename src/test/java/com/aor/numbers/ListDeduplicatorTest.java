package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;

    @BeforeEach
    public void init() {
        this.list = Arrays.asList(1,2,4,2,5);
    }

    static class StubListSort implements GenericListSort {
        @Override
        public List<Integer> sort(List<Integer> list) {
            if (list.equals(Arrays.asList(1, 2, 4, 2, 5))){
                return Arrays.asList(1, 2, 2, 4, 5);
            }
            else if (list.equals(Arrays.asList(1, 2, 4, 2)))
                return Arrays.asList(1, 2, 2, 4);
            else
                return Arrays.asList();
        }
    }

    @Test
    public void deduplicate() {
        GenericListSort sorter = new StubListSort();
        List<Integer> list2 = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected2 = Arrays.asList(1,2,4);

        List<Integer> expected = Arrays.asList(1,2,4,5);

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, sorter);

        deduplicator = new ListDeduplicator();
        List<Integer> distinct2 = deduplicator.deduplicate(list2, sorter);

        Assertions.assertEquals(expected, distinct);
        Assertions.assertEquals(expected2, distinct2);
    }
}
