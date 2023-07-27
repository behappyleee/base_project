package com.sample.data.onetomany;


import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToManyCustomerRepostiory extends JpaRepository<OneToManyCustomer, Long> {



}
