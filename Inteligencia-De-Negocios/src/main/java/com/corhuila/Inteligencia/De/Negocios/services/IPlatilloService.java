package com.corhuila.Inteligencia.De.Negocios.services;

import java.util.List;

import com.corhuila.Inteligencia.De.Negocios.models.Platillo;



public interface IPlatilloService {

public List<Platillo> findAll();

public Platillo findById(Long id);

public Platillo save(Platillo platillos);

 public void delete(Long id);

}
