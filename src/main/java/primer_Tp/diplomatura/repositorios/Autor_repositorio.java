package primer_Tp.diplomatura.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import primer_Tp.diplomatura.entidades.Entidad_Autor;


@Repository
public interface Autor_repositorio extends CrudRepository<Entidad_Autor, Long> {
    Entidad_Autor findByName(String name);
}
