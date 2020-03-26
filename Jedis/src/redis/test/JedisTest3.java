package redis.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.sql.SQLOutput;
import java.util.Map;

/*
测试类
 */
public class JedisTest3 {

    @Test
    public void test3(){
        //1. 获取链接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.hset("User","name","lisi");
        jedis.hset("User","gender","male");
        jedis.hset("User","age","23");

        String gender = jedis.hget("User", "gender");
        System.out.println(gender);

        Map<String, String> uSer = jedis.hgetAll("User");
        for (String use: uSer.keySet()) {
            System.out.println(uSer.get(use));
        }
        //3.关闭链接
        jedis.close();
    }
}
