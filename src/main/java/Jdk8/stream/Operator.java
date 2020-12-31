package Jdk8.stream;

import java.util.*;

public class Operator {

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

        // 1.filter 过滤掉不符合断言判断的数据
        users.stream().filter(user -> user.getAge()>20).forEach(System.out::println);

        // 2.map  将一个元素转换成另一个元素
        users.stream().map(user -> user.getName()).forEach(System.out::println);

        // 3.flatMap 将一个元素转换成流
        users.stream().flatMap(user -> Arrays.stream(user.getName().split(""))).forEach(System.out::println);

        // 4.peek 对流中元素进行遍历操作，与forEach类似，但不会销毁流元素
        // 如果没有foreach的终端操作 peek的中间操作不会执行 stream懒加载
        users.stream().peek(user -> System.out.println(user.getId())).forEach(System.out::println);

        // 5.sort 对流中元素进行排序，可选则自然排序或指定排序规则。有状态操作
        users.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);

        // 6.对流元素进行去重。有状态操作
        users.stream().map(User::getAge).distinct().forEach(System.out::println);

        // 7.skip 跳过前N条记录。有状态操作
        // 8.limit 截断前N条记录。有状态操作
        users.stream().sorted(Comparator.comparing(User::getAge)).skip(1).limit(3).forEach(System.out::println);

        // 9.allMatch 终端操作，短路操作。 判断是否有某个元素匹配 遇到匹配的后不再遍历后续元素
        boolean isHasMan = users.stream().peek(System.out::println).allMatch(user -> user.getSex().equals(1));
        System.out.println(isHasMan);

        // 10.anyMatch 终端操作，短路操作。 任何一个元素匹配，返回true
        boolean isHasAge = users.stream().anyMatch(user -> user.getAge() >= 20);
        System.out.println(isHasAge);

        // 11.noneMatch 任何元素都不匹配，返回true
        boolean isHasNameRocks = users.stream().noneMatch(user -> user.getName().equals("Rocks"));
        System.out.println(isHasNameRocks);

        // 12.findFirst  返回第一个元素
        Optional<User> first = users.stream().findFirst();
        System.out.println(first.get());

        // 13.findAny 返回任意一个元素 有可能返回不是第一个(并行操作 但性能比findFirst高)
        Optional<User> any = users.stream().findAny();
        System.out.println(any.get());

        // 14.count 获取数量
        long count = users.stream().count();
        System.out.println(count);

        // 15.max 获取最大
        OptionalInt max_age = users.stream().mapToInt(user -> user.getAge()).max();
        System.out.println(max_age);

        // 16.min 获取最小
        OptionalInt min_age = users.stream().mapToInt(User::getAge).min();
        System.out.println(min_age);
    }

}
