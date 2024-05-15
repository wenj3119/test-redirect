package com.lenovo.testredirect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestListFilter {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < 10; i ++){
            list.add(i);
        }

        List<Integer> collect = list.stream().filter(l ->
                l == 1
        ).collect(Collectors.toList());

        for(Integer i : collect){
            System.out.println(i);
        }

        list.stream().forEach(System.out::println);
        list.forEach(System.out::println);
    }
}
