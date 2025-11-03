package co.edu.unbosque.entity;

import java.io.Serializable;
import java.util.Objects;

public class DetalleCompraId implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long compra;
    private Long producto;

    // Constructores, getters, setters, equals y hashCode
    public DetalleCompraId() {}
    
    public DetalleCompraId(Long compra, Long producto) {
        this.compra = compra;
        this.producto = producto;
    }

    public Long getCompra() { return compra; }
    public void setCompra(Long compra) { this.compra = compra; }
    
    public Long getProducto() { return producto; }
    public void setProducto(Long producto) { this.producto = producto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleCompraId)) return false;
        DetalleCompraId that = (DetalleCompraId) o;
        return Objects.equals(compra, that.compra) && 
               Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compra, producto);
    }
}