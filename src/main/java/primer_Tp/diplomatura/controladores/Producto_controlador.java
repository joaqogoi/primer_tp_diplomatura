package primer_Tp.diplomatura.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import primer_Tp.diplomatura.servicios.Producto_servicio;
import primer_Tp.diplomatura.servicios.Usuario_servicio;

@RestController
@RequestMapping("/")
public class Producto_controlador {
    @Autowired
    Producto_servicio producto_servicio;

    @Autowired
    Usuario_servicio usuario_servicio;

    @GetMapping()
    public String getRutaInicial() {
        return "es usuario? si ->  http://localhost:8080/listarLibros no -> http://localhost:8080/usuarios/crearUsuario/{nombre}/{email}/{esCliente}";
    }

    //Rutas GET 
    @GetMapping("/listarLibros")
    public ArrayList<Entidad_producto> getRutaPrincipalClientes() {
        return producto_servicio.obtenerListaDeProductos();
    }

    @GetMapping("/librosDisponibles")
    public List<Entidad_producto> getLibrosDisponibles() {
        List<Entidad_producto> lista = producto_servicio.obtenerListaDeProductos();
        List<Entidad_producto> listaFiltrada = new ArrayList<>();
        for (Entidad_producto libro : lista) {
            if(libro.isAvailable()) {
                listaFiltrada.add(libro);
            } 
        }
        return listaFiltrada;
    }

    //Rutas POST
    @PostMapping("/{email}/nuevoProducto/{nombre}/{autor}/{available}")
    public ArrayList<Entidad_producto> crearNuevoProducto(@PathVariable("email") String email, @PathVariable("nombre") String nombre, @PathVariable("autor") String autor, @PathVariable("available")boolean available) {
        Entidad_usuario usuario = usuario_servicio.obtenerUsuarioPorEmail(email);
        if(usuario.isEsCliente()) {
            System.out.println("El usuario no es un provedor y no puede crear nuevos productos");
        } else {
            Entidad_producto nuevoProducto = new Entidad_producto(nombre,autor,true);
            producto_servicio.guardarProducto(nuevoProducto);
        }
        return producto_servicio.obtenerListaDeProductos();
    }

    //Rutas PUT
    @PutMapping("/{email}/retirarLibro/{id}")
    public Entidad_producto retirarProducto(@PathVariable("email") String email, @PathVariable("id") long id) {
        Optional<Entidad_producto> productoActualizado = producto_servicio.obtenerProductoPorId(id);
        Entidad_usuario usuario = usuario_servicio.obtenerUsuarioPorEmail(email);
        if (usuario.isEsCliente()) {
            System.out.println("El usuario no posee los permisos para editar un producto");
        } else {
            productoActualizado.get().setAvailable(false);
            usuario.getProductos().add(productoActualizado.get());
            usuario_servicio.guardarUsuario(usuario);
        }
        return producto_servicio.actualizarProducto(productoActualizado.get());
    }

    @PutMapping("/{email}/devolverLibro/{id}")
    public Entidad_producto devolverProducto(@PathVariable("email") String email, @PathVariable("id") long id) {
        Optional<Entidad_producto> productoActualizado = producto_servicio.obtenerProductoPorId(id);
        Entidad_usuario usuario = usuario_servicio.obtenerUsuarioPorEmail(email);
        if (usuario.isEsCliente()) {
            System.out.println("El usuario no posee los permisos para editar un producto");
        } else {
            productoActualizado.get().setAvailable(true);
            usuario.getProductos().add(productoActualizado.get());
            usuario_servicio.guardarUsuario(usuario);
        }
        return producto_servicio.actualizarProducto(productoActualizado.get());
    }

    //Rutas DELETE
    @DeleteMapping("/{email}/eliminarProducto/{id}")
    public boolean eliminarProducto(@PathVariable("id") Long id, @PathVariable("email") String email) {
        Entidad_usuario usuario = usuario_servicio.obtenerUsuarioPorEmail(email);
        if(usuario.isEsCliente()) {
            System.out.println("El usuario no posee los permisos para editar productos");
            return false;
        } else {
            return producto_servicio.eliminarProducto(id);
        }
    }
}
