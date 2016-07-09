package com.app.mockitos;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
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

        //Don't know what this meaning.... ORZ..
    }

    @Test
    public void test_stub() {
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("First");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);

        mockedList.add("one");
        mockedList.add("two");
        verify(mockedList).add("one");
        verifyNoMoreInteractions(mockedList);
    }
}
