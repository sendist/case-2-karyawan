package com.tes.karyawan.repository;

import com.tes.karyawan.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}
