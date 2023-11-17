package primer_Tp.diplomatura.repositorios;

import org.springframework.data.repository.CrudRepository;
import primer_Tp.diplomatura.entidades.Entidad_usuario;


public interface Usuario_repositorio extends CrudRepository<Entidad_usuario, Long> {
    Entidad_usuario findByEmail(String email);
}
