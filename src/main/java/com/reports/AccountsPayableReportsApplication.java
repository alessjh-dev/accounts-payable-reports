package com.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class AccountsPayableReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsPayableReportsApplication.class, args);
	}

}
