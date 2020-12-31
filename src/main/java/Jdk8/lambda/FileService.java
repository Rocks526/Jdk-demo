package Jdk8.lambda;

import java.io.*;
import java.util.function.Consumer;

/**
 * 函数式接口测试
 */
public class FileService {

    // 使用自定义函数式接口
    public void getFile(String filePath,FileConsumer fileConsumer) throws Exception {
        // 获取一个文件
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
        StringBuilder fileContent = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            fileContent.append(line + "\n");
        }

        // 对数据做处理
        fileConsumer.fileHandler(fileContent.toString());
    }


    // 使用Jdk自带的函数式接口
    public void getFile(String filePath, Consumer<String> fileConsumer) throws Exception {
        // 获取一个文件
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
        StringBuilder fileContent = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            fileContent.append(line + "\n");
        }

        // 对数据做处理
        fileConsumer.accept(fileContent.toString());
    }


    public static void main(String[] args) throws Exception {

        FileService fileService = new FileService();
        fileService.getFile("E:\\git-repository\\Jdk-demo\\src\\main\\java\\Jdk8\\lambda\\Lambda.java", new FileConsumer() {
            @Override
            public void fileHandler(String fileContent) {
                System.out.println(fileContent);
            }
        });

        fileService.getFile("E:\\git-repository\\Jdk-demo\\src\\main\\java\\Jdk8\\lambda\\Lambda.java", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

    }

}
