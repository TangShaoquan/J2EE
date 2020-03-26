package redis.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/*
测试类
 */
public class JedisTest2 {

    @Test
    public void test2(){
        //1. 获取链接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.set("username","tangshaoquan");
        //或缺
        String username = jedis.get("username");
        System.out.println(username);
        //指定过期时间,存有时效的激活码之类的
        jedis.setex("activecode",30,"ninhao");

        //3.关闭链接
        jedis.close();
    }
}
