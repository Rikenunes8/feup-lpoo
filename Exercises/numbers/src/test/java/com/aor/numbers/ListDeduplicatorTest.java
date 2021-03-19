package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;

    @BeforeEach
    public void init() {
        this.list = Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void deduplicate() {
        class StubListSort implements GenericListSort {
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1, 2, 2, 4, 5);
            }
        }
        //GenericListSort sorter = new StubListSort();
        GenericListSort sorter = Mockito.mock(GenericListSort.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4, 5));


        List<Integer> expected = Arrays.asList(1,2,4,5);

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);

    }
    @Test
    public void deduplicate_bug_8726() {
        class StubListSort implements GenericListSort {
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1, 2, 2, 4);
            }
        }
        //GenericListSort sorter = new StubListSort();
        GenericListSort sorter = Mockito.mock(GenericListSort.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));

        List<Integer> list2 = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected2 = Arrays.asList(1,2,4);

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct2 = deduplicator.deduplicate(list2);


        Assertions.assertEquals(expected2, distinct2);
    }
}
