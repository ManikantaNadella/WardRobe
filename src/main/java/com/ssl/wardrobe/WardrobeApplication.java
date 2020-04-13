package com.ssl.wardrobe;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.ssl")
@EnableTransactionManagement
@Slf4j
@EnableEncryptableProperties
public class WardrobeApplication {
	private static final Logger log = LoggerFactory.getLogger(WardrobeApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(WardrobeApplication.class, args);
		log.info("ServerStartup " + new Date());
	}

}
