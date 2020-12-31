package Jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 流元素的收集
 */
public class Sink {

    private static ArrayList<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User().setId(1L).setAge(22).setName("Rocks").setPass("123").setSex(1));
        users.add(new User().setId(2L).setAge(32).setName("Lucy").setPass("123").setSex(1));
        users.add(new User().setId(3L).setAge(21).setName("Timi").setPass("123").setSex(0));
        users.add(new User().setId(4L).setAge(14).setName("Jack").setPass("123").setSex(1));
        users.add(new User().setId(5L).setAge(16).setName("Jim").setPass("123").setSex(0));
        users.add(new User().setId(6L).setAge(17).setName("DiDi").setPass("123").setSex(1));
        users.add(new User().setId(7L).setAge(22).setName("Body").setPass("123").setSex(1));
        users.add(new User().setId(8L).setAge(23).setName("Jam").setPass("123").setSex(0));
        users.add(new User().setId(9L).setAge(22).setName("Rocks").setPass("123").setSex(1));
    }

    public static void main(String[] args) {
        // 收集所有sex为1的user
        List<User> sex1 = users.stream().filter(user -> user.getSex().equals(1)).collect(Collectors.toList());
        System.out.println(sex1);

        // 过滤所有年龄大于20的user 并根据性别分组
        Map<Integer, List<User>> collect = users.stream().filter(user -> user.getAge() > 20).collect(Collectors.groupingBy(User::getSex));
        System.out.println(collect);

        // 根据年龄是否大于18将user分区
        Map<Boolean, List<User>> collect1 = users.stream().collect(Collectors.partitioningBy(user -> user.getAge() > 18));
        System.out.println(collect1);
    }

}
