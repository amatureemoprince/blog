package com.lj.blog.infra.main.algorithm;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.convert.Convert;
import org.mapstruct.CollectionMappingStrategy;

import java.util.Scanner;

/**
 * @ClassName Factorial
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/2/1 20:15
 * @Version JDK 17
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个小于20的值：");
        int max = scanner.nextInt();
        System.out.println("递归得到阶乘" + recursion(max));
        System.out.println("循环得到阶乘" + factorial(max));
    }
    public static long factorial(int max) {
        if (max < 0){
            return -1L;
        }
        long result = 1;
        for(int i = 2; i <= max; i++){
            result *= i;
        }
        return result;
    }
    public static long recursion(int max){
        if(max < 0){
            return -1L;
        }
        if(max < 2){
            return 1L;
        }
        return max * recursion(max - 1);
    }
}

