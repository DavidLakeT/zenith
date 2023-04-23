package me.davidlake.zenith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZenithApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZenithApplication.class, args);
	}

	/*
	 * 
	 * TO-DO:
	 * 1. Implement default behaviour for request parameters on controllers (filter)
	 * 2. Add more filters (marketplace alike)
	 * 
	 */

}
