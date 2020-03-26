package Service.Impl;

import Dao.Impl.PrivnceDaoImpl;
import Dao.PrivnceDao;
import Service.PrivnceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class PrivnceServiceIpl implements PrivnceService {
    @Override
    public List<Province> findall() {

        PrivnceDao privnceDao = new PrivnceDaoImpl();
        return privnceDao.findall();
    }

    //        1. 先从redis中查询
//            有则直接返回
//            没有则
//                    1. 从数据库中查询
//                    2. 存入redis缓存
//                    3. 返回
    @Override
    public String findallFromRedis() {
        //1. 从redis查询数据
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        
        Jedis jedis = jedisPool.getResource();
        String provience = jedis.get("provience");
        System.out.println(provience);
        if(provience == null || provience.length()<=0){
            System.out.println("redis中没有数据库，正在查询数据！");
            //redis中没有数据调用上面的函数从数据库中查询
            PrivnceDao privnceDao = new PrivnceDaoImpl();
            List<Province> list = findall();
            //将list序列化
            ObjectMapper mapper = new ObjectMapper();
            String json = null;
            try {
                json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //存入缓存
            jedis.set("provience",json);
            provience = jedis.get("provience");
            System.out.println(provience);
            jedis.close();
        }
        return provience;
    }
}
