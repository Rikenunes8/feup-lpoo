package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        List<Integer> list2 = Arrays.asList(-1, -4, -5);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);
        aggregator = new ListAggregator();
        int max2 = aggregator.max(list2);


        Assertions.assertEquals(5, max);
        Assertions.assertEquals(-1, max2);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    class StubListDeduplicator implements GenericListDeduplicator {
        @Override
        public List<Integer> deduplicate(List<Integer> list, GenericListSort sorter) {
            if (list.equals(Arrays.asList(1, 2, 4, 2, 5))){
                return Arrays.asList(1, 2, 4, 5);
            }
            else if (list.equals(Arrays.asList(1, 2, 4, 2))){
                return Arrays.asList(1, 2, 4);
            }
            else
                return Arrays.asList(1, 2, 4);
        }
    }

    @Test
    public void distinct() {

        List<Integer> list2 = Arrays.asList(1, 2, 4, 2);


        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator deduplicator = new StubListDeduplicator();
        GenericListSort sorter = new ListDeduplicatorTest.StubListSort();

        int distinct = aggregator.distinct(list, deduplicator, sorter);

        aggregator = new ListAggregator();
        GenericListDeduplicator deduplicator2 = new StubListDeduplicator();
        int distinct2 = aggregator.distinct(list2, deduplicator2, sorter);


        Assertions.assertEquals(4, distinct);
        Assertions.assertEquals(3, distinct2);
    }
}
