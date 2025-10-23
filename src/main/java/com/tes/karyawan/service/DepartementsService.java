package com.tes.karyawan.service;

import com.tes.karyawan.model.Departements;
import com.tes.karyawan.repository.DepartementsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DepartementsService {

    private final DepartementsRepository repo;

    public DepartementsService(DepartementsRepository repo) {
        this.repo = repo;
    }

    public List<Departements> findAll() {
        return repo.findAll();
    }

    public Departements findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Departement not found"));
    }

    public Departements create(Departements d) {
        d.setId(null);
        return repo.save(d);
    }

    public Departements update(Integer id, Departements d) {
        Departements exist = findById(id);
        exist.setName(d.getName());
        return repo.save(exist);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
