package Pattern;



/**
 * 具体的观察者对象
 * 实现更新的方法，使自身的状态和目标的状态 保持一致
 */
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerStatus;

    /**
     * 获取目标类的状态同步到观察者。。。
     * @param subject 传入的目标对象 方便获取相应目标对象的状态
     */


    @Override
    public void update(Subject subject) {
        observerStatus = ((ConcreteSubject) subject).getSubjectStatus();
    }
}
