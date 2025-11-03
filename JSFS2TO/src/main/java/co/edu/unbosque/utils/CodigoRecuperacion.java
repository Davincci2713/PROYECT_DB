package co.edu.unbosque.utils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;


@Service
public class CodigoRecuperacion {
	
	  private static final int CODIGO_EXPIRACION_MINUTOS = 15;
	  private final Map<String, String> codigosActivos = new ConcurrentHashMap<>();
	  private final Map<String, Long> fechasExpiracion = new ConcurrentHashMap<>();

	    public void guardarCodigo(String email, String codigo) {
	        String emailLower = email.toLowerCase();
	        long fechaExpiracion = System.currentTimeMillis() + (CODIGO_EXPIRACION_MINUTOS * 60 * 1000L);
	        
	        codigosActivos.put(emailLower, codigo);
	        fechasExpiracion.put(emailLower, fechaExpiracion);
	    }

	    public boolean verificarCodigo(String email, String codigo) {
	        String emailLower = email.toLowerCase();
	        String codigoGuardado = codigosActivos.get(emailLower);
	        Long fechaExpiracion = fechasExpiracion.get(emailLower);
	        
	        if (codigoGuardado == null || fechaExpiracion == null) {
	            return false;
	        }
	        
	        if (fechaExpiracion < System.currentTimeMillis()) {
	            eliminarCodigo(email);
	            return false;
	        }
	        
	        if (codigoGuardado.equals(codigo)) {
	            eliminarCodigo(email); 
	            return true;
	        }
	        
	        return false;
	    }

	    public boolean tieneCodigo(String email) {
	        String emailLower = email.toLowerCase();
	        Long fechaExpiracion = fechasExpiracion.get(emailLower);
	        
	        if (fechaExpiracion != null && fechaExpiracion > System.currentTimeMillis()) {
	            return true;
	        } else if (fechaExpiracion != null) {
	            eliminarCodigo(email);
	        }
	        return false;
	    }

	    public void eliminarCodigo(String email) {
	        String emailLower = email.toLowerCase();
	        codigosActivos.remove(emailLower);
	        fechasExpiracion.remove(emailLower);
	    }

	    public int obtenerTiempoRestante(String email) {
	        Long fechaExpiracion = fechasExpiracion.get(email.toLowerCase());
	        if (fechaExpiracion != null) {
	            long restante = fechaExpiracion - System.currentTimeMillis();
	            return restante > 0 ? (int) (restante / (60 * 1000)) : -1;
	        }
	        return -1;
	    }

}
