package lamda.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 流操作
 */
public class StreamDemo {
    public static final List<Dish> dishes= Arrays.asList(
            new Dish("meat",800),
            new Dish("milk",333),
            new Dish("laji",222),
            new Dish("cool",20),
            new Dish("tea",10)
            );
    public static void main(String[] args) {

        System.out.println(StreamDemo.getLowCsName2(dishes));
    }

    private static List<String> getLowCsName2(List<Dish> dishes){
       return dishes.stream().filter(dish -> dish.getCs()<300)
                .sorted(Comparator.comparing(Dish::getName))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
    private static List<String> getLowCsName(List<Dish> dishes){
        List<Dish> lowList =new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCs()<300) {
                lowList.add(dish);
            }
        }
        //排序
        List<String> lowNameList =new ArrayList<>();
        Collections.sort(lowList, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Dish dish : lowList) {
            lowNameList.add(dish.getName());
        }
        return lowNameList;
    }
}
