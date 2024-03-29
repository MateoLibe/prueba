package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Categoria;
import com.example.demo.Repository.CategoriasRepository;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step;

import java.util.*;

@Service
public class CategoriasService {

    @Autowired
    CategoriasRepository categoriasRepository;

    public CategoriasService(CategoriasRepository repository){
        this.categoriasRepository=repository;
    }

    public Categoria createCategoria(Categoria categoria){
        return this.categoriasRepository.save(categoria);
    }
    
    public Collection<Categoria> getCategorias(){
        List<Categoria> todaCategoria = new ArrayList<>();
        categoriasRepository.findAll().forEach(todaCategoria::add);
        return todaCategoria;
    }


    public Categoria getCategoriaById(Integer id){
        
        ArrayList<Categoria> categorias = new ArrayList<>(getCategorias());

        Categoria categoriaBuscada = categorias.stream().filter(categoria -> Objects.equals(id, categoria.getIdCategoria())).findAny().orElse(null);
        return categoriaBuscada;
    }

    public void deleteByCategoriaId(Integer id){
        this.categoriasRepository.deleteById(id);
    }

    public Categoria updateCargaHoras(Integer categoriaId, String nombreNuevo, String descripcionNueva) {
        Categoria categoria = categoriasRepository.findById(categoriaId).orElseThrow(() -> new IllegalStateException("categoria con id" + categoriaId + "no existe"));

        if(nombreNuevo != null)
            categoria.setNombre(nombreNuevo);
        if(descripcionNueva != null)
            categoria.setDescripcion(descripcionNueva);
        return categoriasRepository.save(categoria);
    }
}
