package com.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTool {
    public JedisPool jedisPool;    //Redis提供的接口

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * get值
     * @param key
     * @return
     */
    public String get(String key){
        Jedis jedis = jedisPool.getResource();    //获取jedis接口
        String value = jedis.get(key);            //使用jedis接口通过键获得值
        jedisPool.returnResource(jedis);          //释放jedis接口资源
        return value;
    }

    /**
     * set值
     * @return
     */
    public String set(String  key,String value){
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key, value);   //存储键值对 返回结果
        jedisPool.returnResource(jedis);          //释放jedis接口资源
        return result;
    }

    /**
     * set重载方法 设置键值对的有效期
     * @return
     */
    public String set(String key,String value,int seconds){
        Jedis jedis = jedisPool.getResource();
        String result = jedis.setex(key, seconds, value);  //存储键值对 返回结果
        jedisPool.returnResource(jedis);          //释放jedis接口资源
        return result;
    }

    /**
     * 判断键值是否存在
     * @return
     */
    public boolean exists(String key){
        Jedis jedis = jedisPool.getResource();
        boolean result = jedis.exists(key);
        jedisPool.returnResource(jedis);          //释放jedis接口资源
        return result;
    }

    /**
     * 查看键值对有效时间
     * @param key
     * @return
     */
    public  long ttl(String key){
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedisPool.returnResource(jedis);          //释放jedis接口资源
        return result;
    }


    /**
     * 删除键值对 参数key
     * @return
     */
    public Long del(String key){
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedisPool.returnResource(jedis);          //释放jedis接口资源
        return result;
    }
    public static void main(String[] ags){
        Jedis jedis = new Jedis("localhost");
        String num = jedis.set("ds","fd");
        System.out.println(num);
        String nu= jedis.get("ds");
        System.out.println(nu);
    }
}
