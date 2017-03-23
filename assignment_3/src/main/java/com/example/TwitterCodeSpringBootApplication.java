package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class TwitterCodeSpringBootApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TwitterCodeSpringBootApplication.class, args);
	}
	@Bean 
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public CommandLineRunner clr(TwitterScrap scrap,ApplicationContext ctx,DAO d){
		return (args) -> {
			
//			String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
			scrap.startTwitter();
			Thread.sleep(15000);//Data gathered for 5 secs
			scrap.stopTwitter();
			ArrayList<TwitterEntity> en=(ArrayList<TwitterEntity>) ctx.getBean("twitterEntityListBean");
			d.save(en);
			
		};
	}

}
