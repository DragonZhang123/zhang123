package Pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标类 目标对象
 * 知道观察他的观察者，并提供注册（添加），删除的接口
 */
public class Subject {
    //定义一个集合用来保存注册的观察者对象
    private List<Observer> observers = new ArrayList<>();
    // attach  detach notifyObservers
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void detach (Observer observer){
        observers.remove(observer);
    }
    //通知所有注册的观察者
    protected void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
