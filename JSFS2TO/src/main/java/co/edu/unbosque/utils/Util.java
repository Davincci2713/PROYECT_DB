package co.edu.unbosque.utils;

/*
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import co.edu.unbosque.service.impl.ProductoServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import co.edu.unbosque.entity.Categoria;
import co.edu.unbosque.entity.Parametro;
import co.edu.unbosque.entity.Producto;
import co.edu.unbosque.entity.RawgGame;
import co.edu.unbosque.entity.RawgGameResponse;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.repository.ProductoRepository;
import co.edu.unbosque.service.api.CategoriaServiceAPI;
import co.edu.unbosque.service.api.ParametroServiceAPI;

@Component

*/

public class Util {
	/*
    @Autowired
	private  ParametroServiceAPI parametroServiceAPI;
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private CategoriaServiceAPI categoriaServiceAPI;
    
    @Autowired
    private RawgIntegrationService rawgIntegrationService;
 

    public CrudRepository<Producto, Long> getDao() {
        return productoRepository;
    }

	
	private final Long ID_PARAMETRO_IVA = 6L;
	private final Long ID_PARAMETRO_DESCUENTO = 7L;

	
	public double calcularIVA(double precio) {
		
		double valorPar = parametroServiceAPI.get(ID_PARAMETRO_IVA).getValorNumero();
		double valorIVA = valorPar/100.0; 
		
		return (valorIVA*precio);
	}
	
	public Map<String, Object> verificarNecesidadCambioClave(Usuario usuario) {
	    Map<String, Object> resultado = new HashMap<>();
	    int diasMaximos = parametroServiceAPI.findById(3).getValorNumero();

	    Date fechaUltimaClave = usuario.getFchaUltmaClave();
	    if (fechaUltimaClave == null) {
	        fechaUltimaClave = new Date(0);
	    }
	    long diffMillis = new Date().getTime() - fechaUltimaClave.getTime();
	    long diffDias = diffMillis / (1000 * 60 * 60 * 24);

	    if (diffDias >= diasMaximos) {
	        resultado.put("cambioRequerido", true);
	        resultado.put("mensaje", "Debe cambiar su contraseña porque han pasado " + diffDias + " días");
	    } else {
	        resultado.put("cambioRequerido", false);
	        resultado.put("mensaje", "Contraseña vigente");
	    }

	    return resultado;
	}
	
	public double calcularDescuento(double valor) {
		double descuentoPar = parametroServiceAPI.get(ID_PARAMETRO_DESCUENTO).getValorNumero();
		double descuento = descuentoPar/100.0; 
		return (valor*(descuento));
	}
	public double calcularValor(double valorIVA, double valorDescuento, double valor) {
		return valor+valorIVA-valorDescuento;
	}
	

	public Producto saveWithDetails(Producto producto) {

	    Producto productoExistente = null;
	    if (producto.getId() != null) {
	        productoExistente = productoRepository.findById(producto.getId()).orElse(null);
	    }
	    
	    RawgGame gameData = rawgIntegrationService.fetchGameData(producto.getNombre());

	    if (gameData != null) {
	        if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
	            producto.setFotoProducto(gameData.getBackground_image());
	        }
	        if (producto.getReferencia() == null || producto.getReferencia().isEmpty()) {
	            producto.setReferencia(gameData.getSlug());
	        }

	        if ("true".equalsIgnoreCase(gameData.getIsFree())) {
	            producto.setPrecioVentaActual(new BigDecimal(0));
	            producto.setPrecioVentaAnterior(new BigDecimal(0));
	            producto.setCostoCompra(new BigDecimal(0));
	            producto.setValorDescuento(new BigDecimal(0));
	        } else {
	            BigDecimal normalPrice = gameData.getNormalPrice() != null ?
	                new BigDecimal(gameData.getNormalPrice()) : new BigDecimal("0.00");

	            BigDecimal salePrice = gameData.getSalePrice() != null ?
	                new BigDecimal(gameData.getSalePrice()) : normalPrice;

	            BigDecimal precioFinal;
	            if (producto.getPrecioVentaActual() != null && producto.getPrecioVentaActual().compareTo(BigDecimal.ZERO) > 0) {

	                precioFinal = producto.getPrecioVentaActual();
	            } else {

	                precioFinal = normalPrice;
	            }

	            if (productoExistente != null) {
	                BigDecimal precioActualAnterior = productoExistente.getPrecioVentaActual();
	                if (precioActualAnterior != null && precioFinal.compareTo(precioActualAnterior) != 0) {
	                    producto.setPrecioVentaAnterior(precioActualAnterior); 
	                } else {
	                    producto.setPrecioVentaAnterior(productoExistente.getPrecioVentaAnterior()); 
	                }
	            } else {
	   
	            	producto.setExistencia(producto.getStockMaximo());
	                producto.setPrecioVentaAnterior(precioFinal);
	            }
	            
	            producto.setPrecioVentaActual(precioFinal);

	            if (producto.getTieneDescuento() == 1) {
	            	   BigDecimal valorDescuento = calcularValorDescuento(precioFinal);
	                   producto.setValorDescuento(valorDescuento.setScale(2, RoundingMode.HALF_UP));
	            } else {
	            	producto.setValorDescuento(precioFinal.setScale(2, RoundingMode.HALF_UP));
	            }
	        }
	    } else {
	        if (producto.getPrecioVentaActual() != null && producto.getPrecioVentaActual().compareTo(BigDecimal.ZERO) > 0) {
	            
	            if (productoExistente != null) {
	
	                BigDecimal precioActualAnterior = productoExistente.getPrecioVentaActual();
	                if (precioActualAnterior != null && producto.getPrecioVentaActual().compareTo(precioActualAnterior) != 0) {
	                    producto.setPrecioVentaAnterior(precioActualAnterior); // El anterior pasa a ser histórico
	                } else if (producto.getPrecioVentaAnterior() == null) {
	                    producto.setPrecioVentaAnterior(productoExistente.getPrecioVentaAnterior()); // Mantener el anterior
	                }
	            } else {
	                
	                if (producto.getPrecioVentaAnterior() == null) {
	                    producto.setPrecioVentaAnterior(producto.getPrecioVentaActual());
	                }
	            }

	            if (producto.getTieneDescuento() == 1) {
	                producto.setValorDescuento(calcularValorDescuento(producto.getPrecioVentaActual()));
	            } else {
	                producto.setValorDescuento(producto.getPrecioVentaActual());
	            }
	        }
	    }

	    // Procesar categorías
	    if (producto.getCategorias() != null && !producto.getCategorias().isEmpty()) {
	        List<Categoria> categoriasCompletas = new ArrayList<>();
	        for (Categoria categoria : producto.getCategorias()) {
	            if (categoria.getId() != null) {
	                Categoria categoriaCompleta = categoriaServiceAPI.get(categoria.getId());
	                if (categoriaCompleta != null) {
	                    categoriasCompletas.add(categoriaCompleta);
	                }
	            }
	        }
	        producto.setCategorias(categoriasCompletas);

	    }
	    
	    return productoRepository.save(producto);
	}

	    
	 private BigDecimal calcularValorDescuento(BigDecimal precioVentaActual) {
		    if (precioVentaActual == null || precioVentaActual.compareTo(BigDecimal.ZERO) <= 0) {
		        return new BigDecimal("0.00");
		    }
		    
		    BigDecimal porcentajeDescuento = buscarPorcentajePorId(7);
		    
		    if (porcentajeDescuento == null || porcentajeDescuento.compareTo(BigDecimal.ZERO) <= 0) {
		        return precioVentaActual;
		    }
		    
		    BigDecimal factorDescuento = porcentajeDescuento.divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP);
		    BigDecimal montoDescuento = precioVentaActual.multiply(factorDescuento);
		    BigDecimal precioFinal = precioVentaActual.subtract(montoDescuento);
		    
		    return redondearADosDecimales(precioFinal);
		}

	    private BigDecimal redondearADosDecimales(BigDecimal valor) {
	        double valorDouble = valor.doubleValue();
	        double redondeado = Math.round(valorDouble * 100.0) / 100.0;
	        return new BigDecimal(redondeado);
	    
	    }
	    
	    private BigDecimal buscarPorcentajePorId(int id) {
	        try {
	            int valorInt = parametroServiceAPI.findById(id).getValorNumero();
	            return new BigDecimal(valorInt);
	        } catch (Exception e) {
	            return BigDecimal.ZERO;
	        }
	    }
    

    public  String generarCodigoRecuperacion() {
        SecureRandom secureRandom = new SecureRandom();
        int codigo = 100000 + secureRandom.nextInt(900000);
        return String.valueOf(codigo);
    }

*/
}
