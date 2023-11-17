package primer_Tp.diplomatura.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Entidad_Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Entidad_producto> libros = new ArrayList<>();

    public Entidad_Autor(){}

    public Entidad_Autor(String name) {
        this.name = name;
        this.libros = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entidad_producto> getLibros() {
        return libros;
    }

    public void setLibros(List<Entidad_producto> libros) {
        this.libros = libros;
    }

    public void agregarLibros(Entidad_producto libro) {
        libros.add(libro);
        libro.setAutor(this);
    }

    public void eliminarLibro(Entidad_producto libro) {
        libros.remove(libro);
        libro.setAutor(null);
    }

}
