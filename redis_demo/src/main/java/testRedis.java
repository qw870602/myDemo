
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class testRedis {

   @Test
   public void testRedisPool() {
      RedisUtilPool redisUtilPool = new RedisUtilPool();
      Jedis jedis = redisUtilPool.getJedis();
      //jedis.set("test2", "2");
      System.out.println(jedis.get("test2"));
   }
}