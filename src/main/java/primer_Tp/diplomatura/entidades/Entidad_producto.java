package primer_Tp.diplomatura.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Entidad_producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Entidad_Autor autor;
    
    @Column(nullable = false)
    private boolean isAvailable;

    public Entidad_producto() {}

    public Entidad_producto(String nombre, String autor, boolean isAvailable) {
        this.nombre = nombre;
        this.autor = new Entidad_Autor(autor);
        this.isAvailable = isAvailable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entidad_Autor getAutor() {
        return autor;
    }

    public void setAutor(Entidad_Autor autor) {
        this.autor = autor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    


    
    

    
}

/* 
 * @Entity indica que esta clase es una entidad que se mapeara
 * a una tabla en la base de datos del repositorio
 * 
 * @Id marca el campo "id" como la clave primaria de la tabla
 * 
 * @GeneratedValue con @GenerationType.IDENTITY se utiliza para
 * indicar que el valor "id" se genera automaticamente y que es
 * una clave primaria autoincremental
 * 
 * @Column(nullable = false) se utiliza para especificar que los
 * atributos nombre, stock y precio no pueden ser nulos
*/
