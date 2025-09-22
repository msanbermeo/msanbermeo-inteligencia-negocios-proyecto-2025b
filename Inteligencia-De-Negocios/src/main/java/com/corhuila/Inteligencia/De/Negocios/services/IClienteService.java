package com.corhuila.Inteligencia.De.Negocios.services;
import java.util.List;
import com.corhuila.Inteligencia.De.Negocios.models.Cliente;

public interface IClienteService {

 public List<Cliente> findAll();

public Cliente findById(Long id);

public Cliente save(Cliente clientes);

 public void delete(Long id);
}
