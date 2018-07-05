import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisUtilPool {
   //Redis 的  地址
   private String url = "127.0.0.1";
   //redis的端口号
   private int port = 6379;
   //可连接的最大数目，默认为8，-1为不限制
   private   int MAX_ACTIVE = 1024;
   //控制一个pool最多有多少个状态为空闲，默认为8
   private int MAX_IDLE = 1024;
   //等待连可用的最大时间，默认为-1表示永不超时
   //如果超时，抛出JedisConnectionException异常
   private int MAX_WAIT = 10000;
   private int TIMEOUT = 10000;
   //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
   private static boolean TEST_ON_BORROW = true;

   private static JedisPool jedisPool = null;


   public RedisUtilPool() throws JedisConnectionException{
      JedisPoolConfig config = new JedisPoolConfig();
      //config.setMaxActive(MAX_ACTIVE);
      config.setMaxIdle(MAX_IDLE);
      config.setMaxWaitMillis(10000);
      config.setTestOnBorrow(TEST_ON_BORROW);
      jedisPool = new JedisPool(config,url,port,TIMEOUT);
   }


   /**
    * 获取Jedis实例
    */

   public Jedis getJedis()throws JedisConnectionException {
      return  jedisPool.getResource();
   }

}