package primer_Tp.diplomatura.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import primer_Tp.diplomatura.entidades.Entidad_producto;
import primer_Tp.diplomatura.repositorios.Producto_repositorio;

@Service
public class Producto_servicio {
    
    @Autowired
    Producto_repositorio producto_repositorio;

    //SERVICIOS CRUD
    
    //Create
    public Entidad_producto guardarProducto(Entidad_producto producto) {
        return producto_repositorio.save(producto);
    }
    
    //Read
    public ArrayList<Entidad_producto> obtenerListaDeProductos() {
        return (ArrayList<Entidad_producto>) producto_repositorio.findAll(); 
    }

    public Optional<Entidad_producto> obtenerProductoPorId(Long id) {
        return producto_repositorio.findById(id);
    }

    public List<Entidad_producto> obtenerProductoPorAutor(String nombreAutor){
        return producto_repositorio.buscarProductoXautor(nombreAutor);
    }

    //Update
    public Entidad_producto actualizarProducto(Entidad_producto productoActualizado) {
        //conversion del javaObj Opcional a Entidad
        Entidad_producto producto = producto_repositorio.findById(productoActualizado.getId()).get();
        if (producto!=null) {
            producto = productoActualizado;
            producto_repositorio.save(producto);
        } else {
            System.out.println("El id del productoActualizado no existe");
        }
        return producto;
    }

    //Delete
    public boolean eliminarProducto(Long id) {
        try {
            producto_repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
