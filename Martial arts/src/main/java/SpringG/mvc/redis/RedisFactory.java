package SpringG.mvc.redis;

import redis.clients.jedis.Jedis;

/**
 * @Title: redis 操作工具类，注意，后期通过 spring 统一管理
 * @Package com.soflyit.crane.core.redis
 * @Description:
 * @Author elwin
 * @Date 2018/3/6  16:16
 */
public class RedisFactory {
    private static final String ip = "127.0.0.1";
    private static final Integer port = 6379;
    public Jedis connection() throws Exception{
        Jedis jedis = new Jedis(ip,port);
        return jedis;
    }

    public static RedisFactory createFactory() throws Exception{
        return new RedisFactory();
    }
    public static void main(String arg0[]) throws Exception {
        System.out.println("----");
        RedisFactory redisClient = RedisFactory.createFactory();
    }
}
