package com.example.springrocking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.aopcustom.aop.AopLogger;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.springrocking.entity"})
@EnableJpaRepositories(basePackages = "com.example.springrocking.repository")

//@EnableAspectJAutoProxy annotation enables support for handling the components marked with @Aspect annotation. It is similar to tag in the xml configuration.  
@EnableAspectJAutoProxy
@Import(AopLogger.class)
public class SpringrockingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrockingApplication.class, args);
	}


	/* @Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
    	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

    	return sessionFactory;
	} */

	

}
