package com.lj.blog.infra.main;

import com.baomidou.mybatisplus.extension.parser.JsqlParserFunction;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @ClassName StreamMain
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/2 22:00
 * @Version JDK 17
 */
public class StreamMain {
    public static void main(String[] args) {
        List<String> strings = List.of("one","two","three","four");
        Function<String, Integer> stringIntegerJsqlParserFunction = String::length;
        var map = strings.stream()
                .collect(groupingBy(String::length, counting()));
        map.forEach((key, value) -> System.out.println(key + " :: " + value));
        List<Integer> lengths = strings.stream()
                .map(String::length)
                .toList();
        System.out.println("lengths = " + lengths);
        List<City> cities = new ArrayList<>();
        for(int i = 1; i < 5; i++){
            City city = new City();
            city.setName(String.valueOf(i));
            city.setPopulations(i * 1000);
            cities.add(city);
        }
        //获取population>2000的城市并计算总的人数
        int result = cities.stream()
                .map(City::getPopulations)
                .filter(population -> population > 2000).mapToInt(Integer::valueOf).sum();
        System.out.println(result);

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4)
        );
        List<Integer> list = nestedList.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("使用flatMap转换嵌套数组");
        for(Integer i : list){
            System.out.println(i);
        }
        List<Integer> integers = List.of(1, 8, 3, 3, 5, 7);
        List<Integer> list4 = integers.stream()
                .sorted(((a, b) -> b - a))
                .distinct()
                .toList();
        System.out.println("经排序后");
        for(Integer i : list4){
            System.out.println(i);
        }

        List<Integer> list0 = List.of(1, 2, 3);
        List<Integer> list1 = List.of(4, 5, 6);
        List<Integer> list2 = List.of(7, 8, 9);
        List<Integer> list3 = Stream.concat(list0.stream(), list1.stream()).toList();
        int a = Stream.of(list2.stream(), list1.stream())
                //遍历每个stream
                .peek(s -> System.out.println("在Stream中还没有经历flatMap的为"+s.getClass()))
                        .flatMap(stream -> stream)
                //展开后对每个stream中的元素遍历操作
                .peek(s -> System.out.println("stream流为" + s.getClass()))
                        .mapToInt(Integer::valueOf)
                .peek(s -> System.out.println("mapToInt"))
                //终端操作结束
                                .sum();
        System.out.println("和为：" + a);
        System.out.println("合并后的列表");
        for(Integer i : list3){
            System.out.println(i);
        }
        //生成0.8概率的事件
        Random random = new Random(314L);
        List<Boolean> booleans = random.doubles(1000, 0, 1)
                .mapToObj(s -> s <= 0.8)
                .toList();
        long count = booleans.stream()
                .filter(s -> s)
                .count();
        System.out.println("生成小于0.8的个数为："+count);
    }
    @Data
    static class City{
        private String name;
        private Integer populations;
    }
}
