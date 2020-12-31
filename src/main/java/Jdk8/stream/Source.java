package Jdk8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的创建
 */
public class Source {

    public static void main(String[] args) throws IOException {

        // 1.通过数值直接构建流
        Stream stream = Stream.of(1,2,3,4,5);
        stream.forEach(System.out::println);

        // 2.通过数组构建流
        int[] numbers = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(numbers);
        intStream.forEach(System.out::println);

        // 3.通过本地文件生成流
        String filePath = "E:\\git-repository\\Jdk-demo\\src\\main\\java\\Jdk8\\lambda\\MethodRefrence.java";
        // Paths.get(filePath)可以设置多个文件URL
        Stream<String> lines = Files.lines(Paths.get(filePath));
        lines.forEach(System.out::println);

        // 4.通过函数生成流 ==>  无限流
        // 从0开始 不断加2生成 遍历时取前一百 否则会一直打印
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        iterate.limit(100).forEach(System.out::println);

        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(100).forEach(System.out::println);

        // 5.通过集合容器获得Stream
        ArrayList<String> strings = new ArrayList<>();
        Stream<String> stream1 = strings.stream();
    }

}
