package com.tes.karyawan.service;

import com.tes.karyawan.model.Departements;
import com.tes.karyawan.model.Employees;
import com.tes.karyawan.repository.DepartementsRepository;
import com.tes.karyawan.repository.EmployeesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeesService {

    private final EmployeesRepository employeeRepo;
    private final DepartementsRepository departementRepo;

    public EmployeesService(EmployeesRepository employeeRepo, DepartementsRepository departementRepo) {
        this.employeeRepo = employeeRepo;
        this.departementRepo = departementRepo;
    }

    public List<Employees> findAll() {
        return employeeRepo.findAll();
    }

    public Employees findById(Integer id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employees create(Employees e) {
        Departements d = departementRepo.findById(e.getDepartements().getId())
                .orElseThrow(() -> new RuntimeException("Departement not found"));
        e.setDepartements(d);
        return employeeRepo.save(e);
    }

    public Employees update(Integer id, Employees e) {
        Employees exist = findById(id);
        if (e.getName() != null) exist.setName(e.getName());
        if (e.getSalary() != null) exist.setSalary(e.getSalary());
        if (e.getDepartements() != null) {
            Departements d = departementRepo.findById(e.getDepartements().getId())
                    .orElseThrow(() -> new RuntimeException("Departement not found"));
            exist.setDepartements(d);
        }
        return employeeRepo.save(exist);
    }

    public void delete(Integer id) {
        employeeRepo.deleteById(id);
    }
}
