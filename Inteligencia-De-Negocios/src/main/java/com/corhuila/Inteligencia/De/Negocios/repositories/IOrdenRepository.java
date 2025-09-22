package com.corhuila.Inteligencia.De.Negocios.repositories;

import org.springframework.data.repository.CrudRepository;


import com.corhuila.Inteligencia.De.Negocios.models.Orden;

public interface IOrdenRepository extends CrudRepository<Orden, Long> {

}
