package Jdk8.lambda;

/**
 * 自定义函数式接口 文件处理类
 */
@FunctionalInterface
public interface FileConsumer {

    void fileHandler(String fileContent);

}
