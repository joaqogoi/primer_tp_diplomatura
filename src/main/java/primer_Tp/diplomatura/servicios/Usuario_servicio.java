package primer_Tp.diplomatura.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import primer_Tp.diplomatura.entidades.Entidad_producto;
import primer_Tp.diplomatura.entidades.Entidad_usuario;
import primer_Tp.diplomatura.repositorios.Usuario_repositorio;

@Service
public class Usuario_servicio {
    
    @Autowired
    Usuario_repositorio usuario_repositorio;

    //SERVICIOS CRUD

    //Create
    public Entidad_usuario guardarUsuario(Entidad_usuario usuario) {
        return usuario_repositorio.save(usuario);
    }

    //Read
    public ArrayList<Entidad_usuario> obtenerListaUsuarios() {
        return (ArrayList<Entidad_usuario>) usuario_repositorio.findAll(); 
    }

    public Entidad_usuario obtenerUsuarioPorEmail(String email) {
        return usuario_repositorio.findByEmail(email);
    }

    public Entidad_usuario obtenerUsuarioPorId(long id) {
        return usuario_repositorio.findById(id).get();
    }

    //Update
    public Entidad_usuario actualizarUsuario(Entidad_usuario usuarioActualizado) {
        Entidad_usuario usuario = usuario_repositorio.findById(usuarioActualizado.getId()).get();
        if (usuario!=null) {
            usuario = usuarioActualizado;
            usuario_repositorio.save(usuario);
        } else {
            System.out.println("Usuario no encontrado");
        }
        return usuario;
    }
    
    //Delete
    public boolean eliminarUsuario(long id) {
        try {
            usuario_repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Metodos Propios
    public List<Entidad_producto> obtenerListaProductos(String email){
        Entidad_usuario usuario = usuario_repositorio.findByEmail(email);
        List<Entidad_producto> productosDelUsuario = usuario.getProductos();
        return productosDelUsuario;
    }

}

