package com.cybersoft.osahaneat.config;

import io.lettuce.core.support.LettuceCdiExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnection() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();

        config.setHostName("localhost");
        config.setPort(6379);

        return new LettuceConnectionFactory(config);
    }
    @Bean
    RedisTemplate <String , Object> redisTemplate (LettuceConnectionFactory redisConnection ){
            RedisTemplate<String , Object> template = new RedisTemplate<>();
            template.setConnectionFactory(redisConnection);

            return template;
    }
}
