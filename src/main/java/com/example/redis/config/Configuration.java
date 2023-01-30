package com.example.redis.config;

import com.example.redis.config.redis.RedisConfiguration;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({RedisConfiguration.class})
public class Configuration {

}
