package com.corhuila.Inteligencia.De.Negocios.services;

import java.util.List;

import com.corhuila.Inteligencia.De.Negocios.models.Orden;



public interface IOrdenService {

public List<Orden> findAll();

public Orden findById(Long id);

public Orden save(Orden ordenes);

 public void delete(Long id);

}
