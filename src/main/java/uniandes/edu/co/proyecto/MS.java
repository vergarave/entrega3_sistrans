package uniandes.edu.co.proyecto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MS {

    /**
     * Crea un mapa con la respuesta dado sus resultados, este será incluido como argumento principal en una ResponseEntity
     * @param resultado ok o not ok dependiendo si se pudo hacer la accion o no
     * @param accion accion que se ejecuto (create, get, update, delete)
     * @param object objeto importante ara la respuesta, puede ser una clase del modelo o un string
     * @return mapa con la respuesta de a transaccion
     */
    public static Map<String, Object> response(String resultado, String accion, Object object){
        if(object == null){
            return response("not ok", accion, "object not found - object = null");
        }
        Map<String, Object> out = new HashMap<>();
        out.put("resultado", resultado.toUpperCase());
        out.put("accion", accion.toUpperCase());
        if(object instanceof String){
            out.put("message" , object);
        }else{
            Map<String,Object> map0 = new HashMap<>();
            Class<?> clase = object.getClass();
            Field[] campos = clase.getDeclaredFields();
            for (Field campo : campos) {
                campo.setAccessible(true);
                try {
                    map0.put(campo.getName(), campo.get(object));
                } catch (IllegalAccessException e) {
                    return response(resultado, accion, e.getMessage());
                }
            }
            out.put(object.getClass().getName(), map0);
        }
        return out;
    }

}