package com.julie.mikaelson;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Controller
@EnableWebMvc
public class Application {
	private final Logger logger = Logger.getLogger(Application.class) ;
	
	@RequestMapping({"/","/home"})
	public String showHome() {
		logger.error("==============Go to Home=========================");
		return "index";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
