package com.example.passwordencoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
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

	// Hashing -> Hashing solves the problem of immediate access to the system with exposed passwords.
	// Hashing is a one-way function that converts the input to a line of symbols. Normally the length of this line is fixed.

	// When the user registers in the application we hash the password and save it to the database. When the user wants to authenticate
	// we hash the provided password and compare it with the password hash from the database.

	// Salting the password - To prevent an attack with rainbow tables we can use salted password. A salt is a sequence of randomly generated bytes that
	// is hashed along with the password. The salt is stored in the storage and doesn't need to be protected.

	// Password Hashing Function -> Hash functions were not created to hash only passwords. The inventor of hash functions did a very good job and made the hash function very fast.
	// If we can hash passwords very fast, though, then an attacker can run the brute force attack very fast too.

	// Work Factor -> The work factor is a configuration of the encoding algorithms that we can increase with growing hardware power.

	// Spring Security -> All Password Encoders implement the interface PasswordEncoder.
	// This interface encode() method to convert the plain password, the encoded password from and
	// matches() method to compare a plain password with the encoded password.

	// Every Encoder has a default constructor that creates an instance with the default work factor.

	// TODO
	// https://reflectoring.io/spring-security-password-handling/

	// TODO
	// Configuring a Password Encoder 부터 공부 하기 !!!

	public static void main(String[] args) {
		SpringApplication.run(PasswordEncodingApplication.class, args);
	}

}
