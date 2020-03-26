package redis.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/*
测试类
 */
public class Jedispool1 {

    @Test
    public void test4(){
        //0. 创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //0.1 设置连接池参数
        config.setMaxTotal(50);
        config.setMaxIdle(10);//最大空闲链接
        //1. 创建连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        // 2. 获取连接对象
        Jedis jedis = jedisPool.getResource();
        //3. 使用
        jedis.set("name","唐绍权");
        String name = jedis.get("name");
        System.out.println(name);

        //4. 归还连接池
        jedis.close();

    }
}
