package com.tes.karyawan.repository;

import com.tes.karyawan.model.Departements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementsRepository extends JpaRepository<Departements, Integer> {

    @Query()
    List<Departements> findThreeHighestSalaryDepartements();
}
