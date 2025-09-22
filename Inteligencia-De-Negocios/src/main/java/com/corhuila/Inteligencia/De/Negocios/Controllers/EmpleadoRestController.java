package com.corhuila.Inteligencia.De.Negocios.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.corhuila.Inteligencia.De.Negocios.models.Empleado;
import com.corhuila.Inteligencia.De.Negocios.services.IEmpleadoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> index() {
        return empleadoService.findAll();
    }

    @GetMapping("/empleados/{id}")
    public Empleado show(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    @PostMapping("/empleados")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado create(@RequestBody Empleado empleado) {
        return empleadoService.save(empleado);
    }

    @PutMapping("/empleados/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado update(@RequestBody Empleado empleado, @PathVariable Long id) {
        Empleado empleadoActual = empleadoService.findById(id);

        empleadoActual.setNombre(empleado.getNombre());
        empleadoActual.setApellido(empleado.getApellido());
        empleadoActual.setCorreo(empleado.getCorreo());
        empleadoActual.setTelefono(empleado.getTelefono());
        empleadoActual.setPuesto(empleado.getPuesto());
        empleadoActual.setSalario(empleado.getSalario());

        return empleadoService.save(empleadoActual);
    }

    @DeleteMapping("/empleados/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        empleadoService.delete(id);
    }
}