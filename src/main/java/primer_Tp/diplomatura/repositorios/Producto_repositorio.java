package primer_Tp.diplomatura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import primer_Tp.diplomatura.entidades.Entidad_producto;

@Repository
public interface Producto_repositorio extends CrudRepository<Entidad_producto, Long> {
    @Query("SELECT p FROM Entidad_producto p WHERE p.autor.name = :nombreAutor")
    List<Entidad_producto> buscarProductoXautor(@Param("nombreAutor") String nombreAutor);
}
