package co.edu.unbosque.entity;

import java.io.Serializable;
import java.util.Objects;

public class DetalleFacturaId implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long factura;
    private Long producto;

    public DetalleFacturaId() {}
    
    public DetalleFacturaId(Long factura, Long producto) {
        this.factura = factura;
        this.producto = producto;
    }

    public Long getFactura() { return factura; }
    public void setFactura(Long factura) { this.factura = factura; }
    
    public Long getProducto() { return producto; }
    public void setProducto(Long producto) { this.producto = producto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleFacturaId)) return false;
        DetalleFacturaId that = (DetalleFacturaId) o;
        return Objects.equals(factura, that.factura) && 
               Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factura, producto);
    }
}