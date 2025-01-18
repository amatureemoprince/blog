package com.lj.blog.infra.main;

/**
 * @ClassName ClassLife
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/4 10:48
 * @Version JDK 17
 */
public class ClassLife {
    // 静态属性
    private static final String STATIC_FIELD = getStaticField();
    // 静态方法块
    static {
        System.out.println(STATIC_FIELD);
        System.out.println("静态方法块初始化");
    }
    // 普通属性
    private final String field = getField();
    // 普通方法块
    {
        System.out.println(field);
    }
    // 构造函数
    public ClassLife() {
        System.out.println("构造函数初始化");
    }
    private int sum(int...a){
        return a[0];
    }
    public static String getStaticField() {
        return "静态属性初始化";
    }

    public static String getField() {
        return "属性初始化";
    }
    // 主函数
    public static void main(String[] argc) {
        new ClassLife();
    }
}
