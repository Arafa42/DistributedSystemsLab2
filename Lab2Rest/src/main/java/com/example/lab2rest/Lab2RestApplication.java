package com.example.lab2rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class Lab2RestApplication {

	double balance = 100;

	public static void main(String[] args) {
		SpringApplication.run(Lab2RestApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/balance")
	public String getBalance(){
		return String.format("Your balance is %.2f", balance);
	}

	@PostMapping("/balance/deposit")
	public String addMoney(@RequestParam(value = "amount") double amount) {
		balance += amount;
		return String.format("Money has been deposited. Your new balance is %.2f", balance);
	}

	@PostMapping("/balance/withdraw")
	public String withdrawMoney(@RequestParam(value = "amount") double amount) {
		balance -= amount;
		return String.format("Money has been withdrawn. Your new balance is %.2f", balance);
	}
}
