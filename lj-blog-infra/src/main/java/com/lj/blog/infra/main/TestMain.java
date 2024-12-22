package com.lj.blog.infra.main;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @ClassName TestMain
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/21 17:59
 * @Version JDK 17
 */
public class TestMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //创建stream流并打印
        Stream<String> a = Stream.of("A", "B", "C");
        a.forEach(System.out::println);
        int x = 2147483640;
        int y = 15;
        int sum = x + y;
        System.out.println(sum);
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s);
        System.out.println(names[1]);
        int[] arr = new int[]{1, 4, 5, 2, 7};
        Integer[] array = Arrays.stream(arr).boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
        for (String arg : args) {
            if ("version".equals(arg)) {
                System.out.println("v 1.0");
                break;
            }
        }

        String p = "jie";
        Person person = new Person();
        person.setAge(1);
        person.setName(p);
        //利用反射获取对象的值
        Class<? extends Person> aClass1 = person.getClass();
        Field name1 = aClass1.getDeclaredField("name");
        name1.setAccessible(true);
        System.out.println(name1);
        System.out.println(name1.get(person));
        System.out.println(person.getAge() + person.getName());
        p = "jie2";
        System.out.println(person.getAge() + person.getName());
        String [] name = new String[]{
                "bob",
                "tom"
        };
        Human human = new Human();
        human.setNames(name);
        for(String na : human.getNames()){
            System.out.println(na);
        }
        //引用类型变换会导致使用这个对象也变换
        name[0] = "bob2";
        for(String na : human.getNames()){
            System.out.println(na);
        }
        System.out.println(TestMain.doSomeThing(10));
        //初始化实例才可以访问非静态方法
        TestMain testMain = new TestMain();
        testMain.test();
        //String
        String sd = "Hello";
        String sd1 = sd;
        System.out.println(sd);
        sd = sd.toUpperCase();
        System.out.println(sd1);
        System.out.println(sd);
        Class<? extends String> aClass = sd.getClass();
        printClassInfo(aClass);
    }
    static void printClassInfo(Class<?> cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
    private static int doSomeThing(int a){
        return a + 10;
    }

    private void test(){
        int h = h(11);
        System.out.println(h);
    }
    private int h(int a){
        return a + 10;
    }
}
@Data
class Person{
    private String name;
    private int age;
}
@NoArgsConstructor
@Data
class Human{
    //使用自己的构造方法就没有默认的无参构造了
    public Human(String[] names){
        this.names = names;
    }
    private String[] names;

}
