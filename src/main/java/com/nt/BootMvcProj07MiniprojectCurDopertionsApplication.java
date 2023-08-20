package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootMvcProj07MiniprojectCurDopertionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj07MiniprojectCurDopertionsApplication.class, args);
	}
	
	@Bean(name="entityManagerFactory")
        public LocalSessionFactoryBean sessionFactory() {
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
             return sessionFactory;
        }

}
