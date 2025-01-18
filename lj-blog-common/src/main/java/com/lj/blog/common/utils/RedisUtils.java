package com.lj.blog.common.utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/**
 * @ClassName RedisUtils
 * @Description  封装的redis工具类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/24 15:45
 * @Version JDK 17
 */
@Component
@Slf4j
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置字符串类型的值
     *
     * @param key   键
     * @param value 值
     * @return 操作是否成功
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            log.info("Redis设置key: {} 成功", key);
            return true;
        } catch (Exception e) {
            log.error("Redis设置key: {} 失败: {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * 设置字符串类型的值，并指定过期时间
     *
     * @param key     键
     * @param value   值
     * @param timeout 过期时间
     * @param unit    时间单位
     * @return 操作是否成功
     */
    public boolean set(String key, Object value, long timeout, TimeUnit unit) {
        try {
            redisTemplate.opsForValue().set(key, value, timeout, unit);
            log.info("Redis设置key: {} 成功，过期时间: {} {}", key, timeout, unit);
            return true;
        } catch (Exception e) {
            log.error("Redis设置key: {} 失败: {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * 获取字符串类型的值
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        try {
            Object value = redisTemplate.opsForValue().get(key);
            log.info("Redis获取key: {} 成功", key);
            return value;
        } catch (Exception e) {
            log.error("Redis获取key: {} 失败: {}", key, e.getMessage());
            return null;
        }
    }

    /**
     * 设置Hash类型的值
     *
     * @param key   键
     * @param field 字段
     * @param value 值
     * @return 操作是否成功
     */
    public boolean hset(String key, String field, Object value) {
        try {
            redisTemplate.opsForHash().put(key, field, value);
            log.info("Redis设置hash key: {}, field: {} 成功", key, field);
            return true;
        } catch (Exception e) {
            log.error("Redis设置hash key: {}, field: {} 失败: {}", key, field, e.getMessage());
            return false;
        }
    }

    /**
     * 获取Hash类型的字段值
     *
     * @param key   键
     * @param field 字段
     * @return 字段值
     */
    public Object hget(String key, String field) {
        try {
            Object value = redisTemplate.opsForHash().get(key, field);
            log.info("Redis获取hash key: {}, field: {} 成功", key, field);
            return value;
        } catch (Exception e) {
            log.error("Redis获取hash key: {}, field: {} 失败: {}", key, field, e.getMessage());
            return null;
        }
    }

    /**
     * 将元素添加到List的左端
     *
     * @param key   键
     * @param value 值
     * @return 操作是否成功
     */
    public boolean lpush(String key, Object value) {
        try {
            redisTemplate.opsForList().leftPush(key, value);
            log.info("Redis左推入list key: {} 成功", key);
            return true;
        } catch (Exception e) {
            log.error("Redis左推入list key: {} 失败: {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * 从List的右端弹出元素
     *
     * @param key 键
     * @return 弹出的元素
     */
    public Object rpop(String key) {
        try {
            Object value = redisTemplate.opsForList().rightPop(key);
            log.info("Redis右弹出list key: {} 成功", key);
            return value;
        } catch (Exception e) {
            log.error("Redis右弹出list key: {} 失败: {}", key, e.getMessage());
            return null;
        }
    }

    /**
     * 向Set中添加元素
     *
     * @param key    键
     * @param values 要添加的元素，可以是多个
     * @return 操作是否成功
     */
    public boolean sadd(String key, Object... values) {
        try {
            redisTemplate.opsForSet().add(key, values);
            log.info("Redis添加set key: {} 成功", key);
            return true;
        } catch (Exception e) {
            log.error("Redis添加set key: {} 失败: {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * 获取Set中的所有成员
     *
     * @param key 键
     * @return Set中的所有成员
     */
    public Set<Object> smembers(String key) {
        try {
            Set<Object> members = redisTemplate.opsForSet().members(key);
            log.info("Redis获取set key: {} 所有成员成功", key);
            return members;
        } catch (Exception e) {
            log.error("Redis获取set key: {} 所有成员失败: {}", key, e.getMessage());
            return null;
        }
    }

    /**
     * 向ZSet中添加元素，并指定分数
     *
     * @param key   键
     * @param value 值
     * @param score 分数
     * @return 操作是否成功
     */
    public boolean zadd(String key, Object value, double score) {
        try {
            redisTemplate.opsForZSet().add(key, value, score);
            log.info("Redis添加zset key: {}, score: {} 成功", key, score);
            return true;
        } catch (Exception e) {
            log.error("Redis添加zset key: {}, score: {} 失败: {}", key, score, e.getMessage());
            return false;
        }
    }

    /**
     * 获取ZSet中指定范围的元素
     *
     * @param key   键
     * @param start 开始位置
     * @param end   结束位置
     * @return 指定范围的元素集合
     */
    public Set<Object> zrange(String key, long start, long end) {
        try {
            Set<Object> range = redisTemplate.opsForZSet().range(key, start, end);
            log.info("Redis获取zset key: {} 范围成功", key);
            return range;
        } catch (Exception e) {
            log.error("Redis获取zset key: {} 范围失败: {}", key, e.getMessage());
            return null;
        }
    }

    /**
     * 删除指定的键
     *
     * @param key 要删除的键
     * @return 操作是否成功
     */
    public boolean delete(String key) {
        try {
            Boolean result = redisTemplate.delete(key);
            log.info("Redis删除key: {} 成功", key);
            return Boolean.TRUE.equals(result);
        } catch (Exception e) {
            log.error("Redis删除key: {} 失败: {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * 设置键的过期时间
     *
     * @param key     键
     * @param timeout 过期时间
     * @param unit    时间单位
     * @return 操作是否成功
     */
    public boolean expire(String key, long timeout, TimeUnit unit) {
        try {
            Boolean result = redisTemplate.expire(key, timeout, unit);
            log.info("Redis设置过期时间 key: {}, timeout: {}, unit: {} 成功", key, timeout, unit);
            return Boolean.TRUE.equals(result);
        } catch (Exception e) {
            log.error("Redis设置过期时间 key: {} 失败: {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * 判断key是否存在
     */
    public boolean hasKey(String key) {
        try {
            return Boolean.TRUE.equals(redisTemplate.hasKey(key));
        } catch (Exception e) {
            log.error("Redis判断key是否存在失败: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 批量删除key
     */
    public boolean deleteKeys(Collection<String> keys) {
        try {
            Long count = redisTemplate.delete(keys);
            log.info("Redis批量删除key成功，删除数量: {}", count);
            return true;
        } catch (Exception e) {
            log.error("Redis批量删除key失败: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 递增
     */
    public long incr(String key, long delta) {
        try {
            Long result = redisTemplate.opsForValue().increment(key, delta);
            if (result == null) {
                log.error("Redis递增操作失败: key {} 不存在", key);
                throw new RuntimeException("Redis递增操作失败: key " + key + " 不存在");
            }
            return result;
        } catch (Exception e) {
            log.error("Redis递增操作失败: {}", e.getMessage());
            throw new RuntimeException("Redis递增操作失败", e);
        }
    }

    /**
     * 递减
     */
    public long decr(String key, long delta) {
        try {
            Long result = redisTemplate.opsForValue().decrement(key, delta);
            if (result == null) {
                log.error("Redis递减操作失败: key {} 不存在", key);
                throw new RuntimeException("Redis递减操作失败: key " + key + " 不存在");
            }
            return result;
        } catch (Exception e) {
            log.error("Redis递减操作失败: {}", e.getMessage());
            throw new RuntimeException("Redis递减操作失败", e);
        }
    }

    /**
     * 获取Hash结构中的所有字段和值
     */
    public Map<Object, Object> hgetAll(String key) {
        try {
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            log.error("Redis获取hash所有字段失败: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 获取List结构的长度
     */
    public long llen(String key) {
        try {
            Long size = redisTemplate.opsForList().size(key);
            return size != null ? size : 0;
        } catch (Exception e) {
            log.error("Redis获取list长度失败: {}", e.getMessage());
            return 0;
        }
    }

    /**
     * 获取Set结构的大小
     */
    public long scard(String key) {
        try {
            Long size = redisTemplate.opsForSet().size(key);
            return size != null ? size : 0;
        } catch (Exception e) {
            log.error("Redis获取set大小失败: {}", e.getMessage());
            return 0;
        }
    }

    /**
     * 获取ZSet结构中元素的分数
     */
    public Double zscore(String key, Object value) {
        try {
            return redisTemplate.opsForZSet().score(key, value);
        } catch (Exception e) {
            log.error("Redis获取zset分数失败: {}", e.getMessage());
            return null;
        }
    }

    /**
     * 批量设置hash的值
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            log.error("Redis批量设置hash值失败: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 指定缓存失效时间（当key不存在时）
     */
    public boolean setIfAbsent(String key, Object value, long timeout, TimeUnit unit) {
        try {
            Boolean result = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
            return Boolean.TRUE.equals(result);
        } catch (Exception e) {
            log.error("Redis设置key: {} 失败: {}", key, e.getMessage());
            return false;
        }
    }
}
