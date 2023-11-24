package com.meftauddin.springdemoh2db;

import com.meftauddin.springdemoh2db.ExampleBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
// @EnableAutoConfiguration
// @Configuration
// @Component
// @ComponentScan(basePackages = {"com.meftauddin.springdemoh2db.ComponentScanExample.Flowers", "com.meftauddin.springdemoh2db.ComponentScanExample.Animals"})

public class SpringDemoH2dbApplication {
	private static ApplicationContext applicationContext;
	@Bean
	public ExampleBean getExampleBean () {
		return new ExampleBean();
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringDemoH2dbApplication.class, args);
		checkBeansPresence("cat", "dog", "rose", "exampleBean", "SpringDemoH2dbApplication");
	}

	private static void checkBeansPresence(String... beans) {
		for (String beanName : beans) {
			System.out.println("Is " + beanName + " in ApplicationContext: " + applicationContext.containsBean(beanName));
		}
	}

}
