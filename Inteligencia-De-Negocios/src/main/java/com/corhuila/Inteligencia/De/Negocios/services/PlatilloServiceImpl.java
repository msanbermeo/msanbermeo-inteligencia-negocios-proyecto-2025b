package com.corhuila.Inteligencia.De.Negocios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.corhuila.Inteligencia.De.Negocios.models.Platillo;
import com.corhuila.Inteligencia.De.Negocios.repositories.IPlatilloRepository;

@Service
public class PlatilloServiceImpl implements IPlatilloService {

    @Autowired
    private IPlatilloRepository platilloRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Platillo> findAll() {
        return (List<Platillo>) platilloRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Platillo findById(Long id) {
        return platilloRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Platillo save(Platillo platillo) {
        return platilloRepository.save(platillo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        platilloRepository.deleteById(id);
    }
}