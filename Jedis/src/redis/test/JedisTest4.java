package redis.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/*
测试类
 */
public class JedisTest4 {

    @Test
    public void test4(){
        //1. 获取链接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.lpush("name","a","b","c");//可以存多个
        jedis.rpush("name","a","b","c");

//        List<String> name = jedis.lrange("name", 0, -1);
//        for (String n: name
//             ) {
//            System.out.println(n);
//        }
//
        jedis.lpop("name");
        jedis.rpop("name");


        List<String> name = jedis.lrange("name", 0, -1);
        for (String n: name
        ) {
            System.out.println("name:"+n);
        }
        //3.关闭链接
        jedis.close();
    }
}
