package com.leonardo.searchbookmusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class where the application runs.
 * @author lemoraes
 * @since 29/09/2019
 */

@SpringBootApplication(scanBasePackages = {"com.leonardo"}) 
public class SearchBookMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchBookMusicApplication.class, args);
	}

}
