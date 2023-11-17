package primer_Tp.diplomatura.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import primer_Tp.diplomatura.entidades.Entidad_producto;
import primer_Tp.diplomatura.entidades.Entidad_usuario;
import primer_Tp.diplomatura.servicios.Usuario_servicio;

@RestController
@RequestMapping("/usuarios")
public class Usuario_controlador {

    @Autowired
    Usuario_servicio usuario_servicio;

    //rutas GET
    @GetMapping("/")
    public List<Entidad_usuario> listaUsuarios() {
        return usuario_servicio.obtenerListaUsuarios();
    }

    @GetMapping("/informacion/{email}")
    public Entidad_usuario buscarUsuarioPorEmail(@PathVariable("email") String email) {
        return usuario_servicio.obtenerUsuarioPorEmail(email);
    }

    @GetMapping("/informacion/listarLibros/{email}")
    public List<Entidad_producto> getListarLibros(@PathVariable("email") String email) {
        Entidad_usuario usuario = usuario_servicio.obtenerUsuarioPorEmail(email);
        return usuario.getProductos();
    }
    
    //rutas POST
    @PostMapping("/crearUsuario/{nombre}/{email}/{esCliente}")
    public Entidad_usuario crearUsuario(@PathVariable("nombre") String nombre, @PathVariable("email") String email, @PathVariable("esCliente") boolean esCliente) {
        Entidad_usuario nuevoUsuario = new Entidad_usuario(nombre, email, esCliente);
        return usuario_servicio.guardarUsuario(nuevoUsuario);
    }

    //rutas PUT
    @PutMapping("/modificarUsuario/{id}")
    public Entidad_usuario modificarUsuario(@PathVariable("id") long id) {
        Entidad_usuario usuario = usuario_servicio.obtenerUsuarioPorId(id);
        return usuario_servicio.actualizarUsuario(usuario);
    }

    //rutas DELETE
    @DeleteMapping("/eliminarUsuario/{id}")
    public boolean eliminarUsuario(@PathVariable("id") long id) {
        return usuario_servicio.eliminarUsuario(id);
    }
    
}
