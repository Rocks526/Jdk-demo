package Jdk8.lambda;

import java.util.function.Consumer;

/**
 * 方法引用
 */
public class MethodRefrence {

    public static void main(String[] args) {

        // 静态方法引用
        Consumer<String> consumer = (String str) -> Integer.parseInt(str);
        Consumer<String> consumer2 = Integer::parseInt;

        // 实例类型方法的引用
        Consumer<String> consumer3 = str -> str.length();
        Consumer<String> consumer4 = String::length;

        // 外部对象的实例方法引用
        StringBuilder sb = new StringBuilder();
        Consumer<String> consumer5 = str -> sb.append(str);
        Consumer<String> consumer6 = sb::append;

    }

}
