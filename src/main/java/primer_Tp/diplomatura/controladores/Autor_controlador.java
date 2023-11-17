package primer_Tp.diplomatura.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import primer_Tp.diplomatura.entidades.Entidad_Autor;
import primer_Tp.diplomatura.entidades.Entidad_producto;
import primer_Tp.diplomatura.servicios.Autor_servicio;

@RestController
@RequestMapping("/autores")
public class Autor_controlador {
    
    @Autowired
    Autor_servicio autor_servicio;

    //rutas Get
    @GetMapping("/listarAutores")
    public List<Entidad_Autor> getListaAutores() {
        return autor_servicio.obtenerListaDeAutores();
    }

    @GetMapping("/filtrarPorAutor/{nombre}")
    public List<Entidad_producto> getLibrosXautor(@PathVariable("nombre")String nombre) {
        Entidad_Autor autor = autor_servicio.obtenerXnombre(nombre);
        return autor.getLibros();
    }

    //rutas Post
    @PostMapping("/nuevoAutor/{nombre}")
    public Entidad_Autor postNuevoAutor(@PathVariable("nombre")String nombre) {
        Entidad_Autor nuevAutor = new Entidad_Autor(nombre);
        return autor_servicio.guardarAutor(nuevAutor);
    }

    //rutas Put
    //no son necesarias en nuestra logica

    //rutas Delete
    @DeleteMapping("/eliminarAutor/{nombre}")
    public boolean elimiarAutor(@PathVariable("nombre")String nombre) {
        return autor_servicio.eliminarAutor(nombre);
    }




}
