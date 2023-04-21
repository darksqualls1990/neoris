package com.neoris.account;


import com.neoris.account.infrastructure.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins ="*")
@Import( value= {AppConfig.class} )
@SpringBootApplication
public class NeorisApplication {
	
	/**
	 * Main method to start the spring boot application.
	 * 
	 * @param args application  arguments.
	 */
	public static void main(String[] args)  
	{    
		SpringApplication.run(NeorisApplication.class, args);
	}   

}
