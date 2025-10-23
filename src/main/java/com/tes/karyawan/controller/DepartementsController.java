package com.tes.karyawan.controller;

import com.tes.karyawan.model.Departements;
import com.tes.karyawan.service.DepartementsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/departements")
public class DepartementsController {

    private final DepartementsService service;

    public DepartementsController(DepartementsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Departements>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Departements> create(@RequestBody Departements req) {
        Departements saved = service.create(req);
        return ResponseEntity.created(URI.create("/api/departements/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departements> update(@PathVariable Integer id, @RequestBody Departements req) {
        return ResponseEntity.ok(service.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
