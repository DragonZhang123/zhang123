package Pattern;



/**
 * 观察者接口
 *定义一个更新的接口，给那些在目标发生改变的时候被通知的对象
 *
 */
public interface Observer {
    /**
     *更新接口
     * @param subject 传入的目标对象 方便获取相应目标对象的状态
     */
    public void update(Subject subject);
}
