package com.sample.data.sample.repository;

import com.sample.data.sample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Jpa Repository 구현 필요 !!
// Employee Data 가져오기 !!
@Repository
public interface SampleRepository extends JpaRepository<Employee, String> {




}
