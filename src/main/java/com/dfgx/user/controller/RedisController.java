package com.dfgx.user.controller;

import com.dfgx.user.annotation.LogAnnotation;
import com.dfgx.user.service.ReService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resources;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
@Api(tags = "操作Redis的5种数据类型")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * @return: void
     * @author: Today
     * @date: 2020/12/23 11:13
     * @description:指定序列化方式
     */
    private void init() {
        StringRedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
    }

    @GetMapping("/list")
    public List<String> listTest() {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list", "hello");
        listOperations.leftPush("list", "world");
        listOperations.leftPush("list", "java");
        List<String> list = listOperations.range("list", 0, 2);   // 取 key 值为 list 的索引0到索引2的list
        redisTemplate.expire("list",6,TimeUnit.SECONDS);
        return list;
    }

    @GetMapping("/set")
    public Set<String> setTest() {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        setOperations.add("set", "hello");
        setOperations.add("set", "world");
        setOperations.add("set", "world");
        setOperations.add("set", "java");
        Set<String> set = setOperations.members("set");   // 取 set
        redisTemplate.expire("list",6,TimeUnit.MINUTES);
        return set;
    }

    @GetMapping("/zset")
    public Set<String> zsetTest() {
        init();
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zset", "java", 1);
        zSetOperations.add("zset", "hello", 3);
        zSetOperations.add("zset", "world", 2);
        Set<String> set = zSetOperations.range("zset", 0, 2);
        redisTemplate.expire("list",6,TimeUnit.MINUTES);
        System.out.println(set);
        return set;
    }

    @GetMapping("/hash")
    public String hashTest() {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("key", "hashkey1", "hello");
        hashOperations.put("key", "hashkey2", "world");
        hashOperations.put("key", "hashkey3", "java");
        redisTemplate.expire("list",6,TimeUnit.MINUTES);
        return hashOperations.get("key", "hashkey2");
    }

    @GetMapping("/Str")
    @LogAnnotation
    public String testString(){
        BoundValueOperations str = redisTemplate.boundValueOps("str");
        str.set("redis-String");
        str.expire(10,TimeUnit.SECONDS);
        String strV = (String)str.get();
        System.out.println(strV);
        return strV;
    }
}
