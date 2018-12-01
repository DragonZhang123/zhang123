package SpringG.mvc.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Title:
 * @Package com.soflyit.crane.core.redis
 * @Description:
 * @Author elwin
 * @Date 2018/3/6  16:24
 */
public interface IRedis {

    //String
    void set(String key, String value) throws Exception;//添加
    String get(String key) throws Exception;//获取
    //set
    void sadd(String key, Set<String> value) throws Exception;//添加
    void srem(String key, Set<String> value) throws Exception;//删除
    Long scard(String key) throws Exception;//获取key对应的value总数
    Set<String> smembers(String key) throws Exception;//获取key对应的所有value
    boolean sismember(String key, String value) throws Exception;//判断是否存在
    String srandmember(String key) throws Exception;//随机获取数据
    //map
    void hmset(String key, Map<String, String> map) throws Exception;//添加
    Long hlen(String key) throws Exception;//mapkey个数
    Set<String> hkeys(String key) throws Exception;//map中所有键值
    List<String> hvals(String key) throws Exception;//map中所有value
    List<String> hmget(String key, String s1, String s2) throws Exception;//取出map中的name、password字段值
    void hdel(String key, String s) throws Exception;//删除map中的某一个键值 password
    //list
    void lpush(String key, List<String> list) throws Exception;//添加
    List<String> lrange(String key, Long start, Long end) throws Exception;//获取
    void del(String key) throws Exception;//删除

    //append
    void append(String key, String value) throws Exception;//追加
}
