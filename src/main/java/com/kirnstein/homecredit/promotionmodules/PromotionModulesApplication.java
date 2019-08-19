package com.kirnstein.homecredit.promotionmodules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.kirnstein.homecredit.promotionmodules.repo"})
@EntityScan(basePackages = {"com.kirnstein.homecredit.promotionmodules.model"})
public class PromotionModulesApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PromotionModulesApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PromotionModulesApplication.class);
    }
}
