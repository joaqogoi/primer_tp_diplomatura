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
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Entidad_usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean esCliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Entidad_producto> productos = new ArrayList<>();

    public Entidad_usuario() {}

    public Entidad_usuario(String nombre, String email, boolean esCliente) {
        this.nombre = nombre;
        this.email = email;
        this.esCliente = esCliente;
        this.productos = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEsCliente() {
        return esCliente;
    }

    public void setEsCliente(boolean esCliente) {
        this.esCliente = esCliente;
    }

    
    public void agregarProducto(Entidad_producto producto){
        productos.add(producto);
    }

    public void eliminarProducto(Entidad_producto producto){
        productos.remove(producto);
    }

    public List<Entidad_producto> getProductos() {
        return productos;
    }

    


}
