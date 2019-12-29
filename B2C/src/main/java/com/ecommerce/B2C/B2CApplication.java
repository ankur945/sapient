package com.ecommerce.B2C;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@EnableAsync
public class B2CApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2CApplication.class, args);
	}

	@Bean
	public CacheManager cacheManager(){
		return new ConcurrentMapCacheManager("ProductCache");
	}
}
