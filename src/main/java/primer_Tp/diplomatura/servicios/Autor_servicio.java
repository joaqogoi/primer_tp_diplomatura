package primer_Tp.diplomatura.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import primer_Tp.diplomatura.entidades.Entidad_Autor;
import primer_Tp.diplomatura.repositorios.Autor_repositorio;

@Service
public class Autor_servicio {
    
    @Autowired
    Autor_repositorio autor_repositorio;

    //SERVICIOS CRUD
    //CREATE
    public Entidad_Autor guardarAutor(Entidad_Autor entidad_Autor) {
        return autor_repositorio.save(entidad_Autor);
    }

    //READ
    public List<Entidad_Autor> obtenerListaDeAutores() {
        return (List<Entidad_Autor>) autor_repositorio.findAll();
    }

    public Entidad_Autor obtenerXnombre(String nombre) {
        return autor_repositorio.findByName(nombre);
    }


    //UPDATE
    /*Los autores son entidades muy simples que funcionan 
    principalmente como atributos de clase, por lo cual
    simplemente existen o no para poder ser asociados a alguna
    entidad de tipo producto, por lo tanto los prod que se
    agregan en las listas de los autores se gestionan desde
    la capa de servicio de los productos*/

    //DELETE
    public boolean eliminarAutor(String nombre) {
        try {
            String nombreStd = nombre.toLowerCase();
            Long idAutor = autor_repositorio.findByName(nombreStd).getId();
            autor_repositorio.deleteById(idAutor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
