package com.corhuila.Inteligencia.De.Negocios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.corhuila.Inteligencia.De.Negocios.models.Orden;
import com.corhuila.Inteligencia.De.Negocios.repositories.IOrdenRepository;

@Service
public class OrdenServiceImpl implements IOrdenService {

    @Autowired
    private IOrdenRepository ordenRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Orden> findAll() {
        return (List<Orden>) ordenRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Orden findById(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }
}