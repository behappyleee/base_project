package com.example.passwordencoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasswordEncodingApplication {

	// Password Encoding -> Systems with users management require authentication. If we use password-based authentication.
	// have to handle user's password in our system. how to encode and store passwords securely with Spring Security

	// If we want to authenticate the user on the server side, we have to follw these steps.
	// 1. Get the User name and Password from user who wants to authenticate.
	// 2. Find the user name in the storage, usually a database.
	// 3. Compare the password the user provided with the user's password from the database.

	// We have to deal with the fact that we have to save user's password in our
	// system for comparison during authentication.
	// Obviously, it is a bad idea to save passwords as plain text in the database.

	// We should assume that an attacker can steal the database with password or get access
	// to the passwords by other methods like SQL Injection.

	// In this case, the attacker could use the password right away to access the
	// application. So we need to save the passwords in a form that the attacker
	// cant'use it for authentication.

	// TODO
	// Saving Passwords as Plain Text 부터 학습 하기 ~ !
	// https://reflectoring.io/spring-security-password-handling/


	public static void main(String[] args) {
		SpringApplication.run(PasswordEncodingApplication.class, args);
	}

}
