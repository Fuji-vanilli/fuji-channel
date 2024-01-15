package com.fujichanel.videoservice;

import com.fujichanel.videoservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@RequiredArgsConstructor
public class VideoServiceApplication {
	private final MovieService movieService;

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			movieService.addFromTmdb();
		};
	}
}
