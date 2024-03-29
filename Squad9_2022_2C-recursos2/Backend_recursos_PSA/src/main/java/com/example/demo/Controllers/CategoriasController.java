package com.example.demo.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.Model.Categoria;
import com.example.demo.Service.CategoriasService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/recursos/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriaService;

    public CategoriasController(CategoriasService categoriaService){
        this.categoriaService = categoriaService;
    }

    //POST
    @PostMapping("/categorias")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria createCategoria(@RequestBody Categoria categoria){
        return categoriaService.createCategoria(categoria);
    }

    //GET
    @GetMapping("/categorias")
    public Collection<Categoria> getCategorias(){
        return categoriaService.getCategorias();
    }

    @GetMapping("/categoria/{id}")
    public Categoria getSingleCategorais(Integer id){
        return categoriaService.getCategoriaById(id);
    }

    //DELETE
    @DeleteMapping(path = "/categorias{categoriaId}")
    public void deleteCategoriaById(@PathVariable Integer categoriaId){
        categoriaService.deleteByCategoriaId(categoriaId);
    }

    //PUT
    @PutMapping(path = "/categoria/{categoriaId}")
    public Categoria updateCategoria(@PathVariable Integer categoriaId, @RequestParam(required = false) String nombre, @RequestParam(required = false) String descripcion){
        return categoriaService.updateCargaHoras(categoriaId,nombre,descripcion);
    }
}
