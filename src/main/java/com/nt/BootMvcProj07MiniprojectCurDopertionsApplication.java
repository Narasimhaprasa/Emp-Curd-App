package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootMvcProj07MiniprojectCurDopertionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj07MiniprojectCurDopertionsApplication.class, args);
	}
	
	@Bean(name=“entityManagerFactory”)
        public LocalSessionFactoryBean sessionFactory() {
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
             return sessionFactory;
        }

}
