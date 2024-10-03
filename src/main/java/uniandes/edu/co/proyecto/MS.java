package uniandes.edu.co.proyecto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MS {

    /**
     * @param resultado
     * @param accion
     * @param object
     * @return
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