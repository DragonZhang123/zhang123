package SpringG.mvc.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Title:
 * @Package com.soflyit.crane.core.redis
 * @Description:
 * @Author elwin
 * @Date 2018/3/6  16:25
 */
public class Redis implements IRedis {

    public void sadd(String key, Set<String> value) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        for(String str: value){
            jedis.sadd(key, str);
        }
//      Iterator<String> it = value.iterator();
//      while (it.hasNext()) {
//       String str = it.next();
//       System.out.println(str);
//       jedis.sadd(key,str);
//      }

    }

    
    public void set(String key, String value) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        jedis.set(key,value);

    }

    
    public void srem(String key, Set<String> value) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        Iterator<String> it = value.iterator();
        while(it.hasNext()){
            String str = it.next();
            jedis.srem(key, str);
        }
    }

    
    public String get(String key) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.get(key);
    }

    
    public Long scard(String key) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.scard(key);
    }

    
    public Set<String> smembers(String key) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.smembers(key);
    }

    
    public boolean sismember(String key, String value) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.sismember(key,value);
    }

    
    public String srandmember(String key) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.srandmember(key);
    }

    
    public void hmset(String key, Map<String, String> map) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        jedis.hmset(key,map);
    }

    
    public Long hlen(String key) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.hlen(key);
    }

    
    public Set<String> hkeys(String key) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.hkeys(key);
    }

    
    public List<String> hvals(String key) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.hvals(key);
    }

    
    public List<String> hmget(String key, String s1, String s2)
            throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.hmget(key,s1,s2);
    }

    
    public void hdel(String key, String s) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        jedis.hdel(key,s);
    }

    
    public void lpush(String key, List<String> list) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        for(String s: list){
            jedis.lpush(key,s);
        }
    }

    
    public List<String> lrange(String key, Long start, Long end)
            throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        return jedis.lrange(key, start, end);
    }

    
    public void del(String key) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        jedis.del(key);
    }

    
    public void append(String key, String value) throws Exception {
        RedisFactory f = RedisFactory.createFactory();
        Jedis jedis = f.connection();
        jedis.append(key,value);
    }
}
