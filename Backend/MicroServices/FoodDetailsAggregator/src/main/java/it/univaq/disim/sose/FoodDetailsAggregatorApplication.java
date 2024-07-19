/**
 * This class represents the main application for the MangaStore Eureka Discovery Service.
 * It enables the Eureka server and starts the Spring Boot application.
 * 
 * @author Adam Bouafia
 */
package it.univaq.disim.sose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author: Adam Bouafia,

 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("it.univaq.disim.sose")


public class FoodDetailsAggregatorApplication {

	/**
	 * The entry point of the application.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(FoodDetailsAggregatorApplication.class, args);
	}

	/**
	 * Configures CORS (Cross-Origin Resource Sharing) for the application.
	 *
	 * @return The WebMvcConfigurer object with CORS configuration.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*").allowedOrigins("*");
			}
		};
	}
}
