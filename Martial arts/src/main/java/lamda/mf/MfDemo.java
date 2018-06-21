package lamda.mf;

import java.util.ArrayList;
import java.util.List;

/**
 * 静态引用
 *
 */
public class MfDemo {
    public static void main(String[] args) {

        PersonFactory personFactory = new PersonFactory(Person::new);//类构造函数
        Person p1 = personFactory.getPerson();

        List<Person> list = new ArrayList<>();
        p1.setName("Li");
        list.add(p1);

        Person p2 = personFactory.getPerson();
        p2.setName("Zhang");
        list.add(p2);

        Person p3 = personFactory.getPerson();
        p3.setName("Tony");
        list.add(p3);

        print(list);
//        list.sort(MfDemo::myCompare);//静态方法引用
//        list.sort(p1::compare);//方法引用
        list.sort(Person::compareTo);//用特定对象的实例方法
        print(list);

    }
    private static int myCompare(Person p1,Person p2){
        return p2.getName().compareTo(p1.getName());
    }
    private static void print(List<Person> list){
        list.forEach(p-> System.out.print(p.getName()+"--"));
        System.out.println();
    }
}
