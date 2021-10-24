package com.novihub.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HrShiftApplication {

	public static void main(String[] args) {
	    SpringApplication.run(HrShiftApplication.class, args);
	  }
}
