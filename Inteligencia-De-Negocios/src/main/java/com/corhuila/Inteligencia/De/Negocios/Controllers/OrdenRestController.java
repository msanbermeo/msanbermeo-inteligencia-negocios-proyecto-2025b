package com.corhuila.Inteligencia.De.Negocios.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.corhuila.Inteligencia.De.Negocios.models.Orden;
import com.corhuila.Inteligencia.De.Negocios.services.IOrdenService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OrdenRestController {

    @Autowired
    private IOrdenService ordenService;

    @GetMapping("/ordenes")
    public List<Orden> index() {
        return ordenService.findAll();
    }

    @GetMapping("/ordenes/{id}")
    public Orden show(@PathVariable Long id) {
        return ordenService.findById(id);
    }

    @PostMapping("/ordenes")
    @ResponseStatus(HttpStatus.CREATED)
    public Orden create(@RequestBody Orden orden) {
        return ordenService.save(orden);
    }

    @PutMapping("/ordenes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Orden update(@RequestBody Orden orden, @PathVariable Long id) {
        Orden ordenActual = ordenService.findById(id);

        ordenActual.setFecha(orden.getFecha());
        ordenActual.setTotal(orden.getTotal());
        ordenActual.setIdCliente(orden.getIdCliente());
        ordenActual.setIdEmpleado(orden.getIdEmpleado());

        return ordenService.save(ordenActual);
    }

    @DeleteMapping("/ordenes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ordenService.delete(id);
    }
}