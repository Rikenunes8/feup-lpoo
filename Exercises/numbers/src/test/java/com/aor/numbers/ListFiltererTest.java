package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFiltererTest {

    @Test
    void filter() {
        GenericListFilter filter = Mockito.mock(PositiveFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(5)).thenReturn(true);
        Mockito.when(filter.accept(0)).thenReturn(false);
        Mockito.when(filter.accept(-3)).thenReturn(false);
        List<Integer> list = Arrays.asList(1, -3, 5, 0);
        List<Integer> expected = Arrays.asList(1, 5);

        ListFilterer filterer = new ListFilterer(filter);
        List<Integer> res = filterer.filter(list);

        Assertions.assertEquals(expected, res);
    }
}