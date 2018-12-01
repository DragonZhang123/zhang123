package Pattern;

/**
 * 具体目标对象
 * 复杂把有关状态存入观察者对象
 *
 */
public class ConcreteSubject extends Subject{
    //提供对外触发的方法，并保存目标的状态
    /**
     * 目标对象的状态
     */
    private String subjectStatus;

    public String getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(String subjectStatus) {
        //通知
        this.subjectStatus = subjectStatus;
        this.notifyObservers();
    }
}
