package com.app.mockitos;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by wl on 16/7/8.
 */
@Slf4j
public class MocktioTest {

    @Test
    public void verify_behaviour() {
        List mockList = mock(List.class);

        mockList.add("one");
        mockList.clear();

        verify(mockList).add("one");
        verify(mockList).clear();

        mockList.add("three");
        verify(mockList, never()).add("four");


        when(mockList.get(anyInt())).thenReturn("element");
        System.out.println(mockList.get(9999));
        verify(mockList).get(anyInt());
    }

    @Test
    public void test_stub() {
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("First");
        when(mockedList.get(1)).thenReturn("Two", "Three");
//        when(mockedList.get(1)).thenThrow(new RuntimeException()).thenReturn("MyTest");

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);

        mockedList.add("one");
        mockedList.add("two");
        verify(mockedList).add("one");
//        verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void test_spy() {
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));
        System.out.println(spy.get(1));
        System.out.println(spy.size());

        verify(spy).add("three");
    }
}
