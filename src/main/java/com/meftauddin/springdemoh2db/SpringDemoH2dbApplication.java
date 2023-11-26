package com.meftauddin.springdemoh2db;

import com.meftauddin.springdemoh2db.ExampleBean;
import com.meftauddin.springdemoh2db.client.JsonPlaceHolderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import com.meftauddin.springdemoh2db.client.JsonPlaceHolderService;

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

	@Bean
	JsonPlaceHolderService jsonPlaceHolderService() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(restClient))
				.build();
		return factory.createClient(JsonPlaceHolderService.class);
	}

}
