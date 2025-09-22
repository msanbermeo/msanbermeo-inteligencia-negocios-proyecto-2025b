package com.corhuila.Inteligencia.De.Negocios.services;

import java.util.List;

import com.corhuila.Inteligencia.De.Negocios.models.Empleado;



public interface IEmpleadoService {

 public List<Empleado> findAll();

public Empleado findById(Long id);

public Empleado save(Empleado empleados);

 public void delete(Long id);
    
}
