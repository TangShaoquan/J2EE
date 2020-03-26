package redis.test;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/*
测试类
 */
public class JedisTest {

    @Test
    public void test1(){
        //1. 获取链接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.set("username","tangshaoquan");

        //3.关闭链接
        jedis.close();
    }
}
