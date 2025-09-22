package com.corhuila.Inteligencia.De.Negocios.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.corhuila.Inteligencia.De.Negocios.models.Platillo;
import com.corhuila.Inteligencia.De.Negocios.services.IPlatilloService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PlatilloRestController {

    @Autowired
    private IPlatilloService platilloService;

    @GetMapping("/platillos")
    public List<Platillo> index() {
        return platilloService.findAll();
    }

    @GetMapping("/platillos/{id}")
    public Platillo show(@PathVariable Long id) {
        return platilloService.findById(id);
    }

    @PostMapping("/platillos")
    @ResponseStatus(HttpStatus.CREATED)
    public Platillo create(@RequestBody Platillo platillo) {
        return platilloService.save(platillo);
    }

    @PutMapping("/platillos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Platillo update(@RequestBody Platillo platillo, @PathVariable Long id) {
        Platillo platilloActual = platilloService.findById(id);

        platilloActual.setNombre(platillo.getNombre());
        platilloActual.setDescripcion(platillo.getDescripcion());
        platilloActual.setPrecio(platillo.getPrecio());

        return platilloService.save(platilloActual);
    }

    @DeleteMapping("/platillos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        platilloService.delete(id);
    }
}