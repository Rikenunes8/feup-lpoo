package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    @BeforeEach
    public void init() {
        this.list = Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }
    @Test
    public void max_bug_7263() {

        List<Integer> list2 = Arrays.asList(-1, -4, -4);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list2);

        Assertions.assertEquals(-1, max);
    }


    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }
    @Test
    public void min_equal() {
        List<Integer> list2 = Arrays.asList(1, 2, 2);
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list2);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class StubListDeduplicator implements GenericListDeduplicator {
            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4, 5);
            }
        }
        //GenericListDeduplicator deduplicator = new StubListDeduplicator();

        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4, 5));


        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(this.list, deduplicator);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8726() {
        class StubListDeduplicator implements GenericListDeduplicator {
            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4);
            }
        }

        //GenericListDeduplicator deduplicator = new StubListDeduplicator();
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));

        List<Integer> list2 = Arrays.asList(1, 2, 4, 2);

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list2, deduplicator);

        Assertions.assertEquals(3, distinct);
    }
}
