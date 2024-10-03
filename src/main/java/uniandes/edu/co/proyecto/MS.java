package uniandes.edu.co.proyecto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MS {

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


    enum Resultado{OK , NOT_OK}

    // Ciudad
    public static final String CIUDAD_CREATE_OK = ret("ciudad", "create", Resultado.OK);
    public static final String CIUDAD_CREATE_NOT_OK = ret("ciudad", "create", Resultado.NOT_OK);
    public static final String CIUDAD_GET_OK = ret("ciudad", "get", Resultado.OK);
    public static final String CIUDAD_GET_NOT_OK = ret("ciudad", "get", Resultado.NOT_OK);
    public static final String CIUDAD_UPDATE_OK = ret("ciudad", "update", Resultado.OK);
    public static final String CIUDAD_UPDATE_NOT_OK = ret("ciudad", "update", Resultado.NOT_OK);
    public static final String CIUDAD_DELETE_OK = ret("ciudad", "delete", Resultado.OK);
    public static final String CIUDAD_DELETE_NOT_OK = ret("ciudad", "delete", Resultado.NOT_OK);

    // Sucursal
    public static final String SUCURSAL_CREATE_OK = ret("sucursal", "create", Resultado.OK);
    public static final String SUCURSAL_CREATE_NOT_OK = ret("sucursal", "create", Resultado.NOT_OK);
    public static final String SUCURSAL_GET_OK = ret("sucursal", "get", Resultado.OK);
    public static final String SUCURSAL_GET_NOT_OK = ret("sucursal", "get", Resultado.NOT_OK);
    public static final String SUCURSAL_UPDATE_OK = ret("sucursal", "update", Resultado.OK);
    public static final String SUCURSAL_UPDATE_NOT_OK = ret("sucursal", "update", Resultado.NOT_OK);
    public static final String SUCURSAL_DELETE_OK = ret("sucursal", "delete", Resultado.OK);
    public static final String SUCURSAL_DELETE_NOT_OK = ret("sucursal", "delete", Resultado.NOT_OK);

    // Contacto
    public static final String CONTACTO_CREATE_OK = ret("contacto", "create", Resultado.OK);
    public static final String CONTACTO_CREATE_NOT_OK = ret("contacto", "create", Resultado.NOT_OK);
    public static final String CONTACTO_GET_OK = ret("contacto", "get", Resultado.OK);
    public static final String CONTACTO_GET_NOT_OK = ret("contacto", "get", Resultado.NOT_OK);
    public static final String CONTACTO_UPDATE_OK = ret("contacto", "update", Resultado.OK);
    public static final String CONTACTO_UPDATE_NOT_OK = ret("contacto", "update", Resultado.NOT_OK);
    public static final String CONTACTO_DELETE_OK = ret("contacto", "delete", Resultado.OK);
    public static final String CONTACTO_DELETE_NOT_OK = ret("contacto", "delete", Resultado.NOT_OK);

    // Orden_compra
    public static final String ORDEN_COMPRA_CREATE_OK = ret("orden_compra", "create", Resultado.OK);
    public static final String ORDEN_COMPRA_CREATE_NOT_OK = ret("orden_compra", "create", Resultado.NOT_OK);
    public static final String ORDEN_COMPRA_GET_OK = ret("orden_compra", "get", Resultado.OK);
    public static final String ORDEN_COMPRA_GET_NOT_OK = ret("orden_compra", "get", Resultado.NOT_OK);
    public static final String ORDEN_COMPRA_UPDATE_OK = ret("orden_compra", "update", Resultado.OK);
    public static final String ORDEN_COMPRA_UPDATE_NOT_OK = ret("orden_compra", "update", Resultado.NOT_OK);
    public static final String ORDEN_COMPRA_DELETE_OK = ret("orden_compra", "delete", Resultado.OK);
    public static final String ORDEN_COMPRA_DELETE_NOT_OK = ret("orden_compra", "delete", Resultado.NOT_OK);

    // Bodega
    public static final String BODEGA_CREATE_OK = ret("bodega", "create", Resultado.OK);
    public static final String BODEGA_CREATE_NOT_OK = ret("bodega", "create", Resultado.NOT_OK);
    public static final String BODEGA_GET_OK = ret("bodega", "get", Resultado.OK);
    public static final String BODEGA_GET_NOT_OK = ret("bodega", "get", Resultado.NOT_OK);
    public static final String BODEGA_UPDATE_OK = ret("bodega", "update", Resultado.OK);
    public static final String BODEGA_UPDATE_NOT_OK = ret("bodega", "update", Resultado.NOT_OK);
    public static final String BODEGA_DELETE_OK = ret("bodega", "delete", Resultado.OK);
    public static final String BODEGA_DELETE_NOT_OK = ret("bodega", "delete", Resultado.NOT_OK);

    // Documento
    public static final String DOCUMENTO_CREATE_OK = ret("documento", "create", Resultado.OK);
    public static final String DOCUMENTO_CREATE_NOT_OK = ret("documento", "create", Resultado.NOT_OK);
    public static final String DOCUMENTO_GET_OK = ret("documento", "get", Resultado.OK);
    public static final String DOCUMENTO_GET_NOT_OK = ret("documento", "get", Resultado.NOT_OK);
    public static final String DOCUMENTO_UPDATE_OK = ret("documento", "update", Resultado.OK);
    public static final String DOCUMENTO_UPDATE_NOT_OK = ret("documento", "update", Resultado.NOT_OK);
    public static final String DOCUMENTO_DELETE_OK = ret("documento", "delete", Resultado.OK);
    public static final String DOCUMENTO_DELETE_NOT_OK = ret("documento", "delete", Resultado.NOT_OK);

    // Proveedor
    public static final String PROVEEDOR_CREATE_OK = ret("proveedor", "create", Resultado.OK);
    public static final String PROVEEDOR_CREATE_NOT_OK = ret("proveedor", "create", Resultado.NOT_OK);
    public static final String PROVEEDOR_GET_OK = ret("proveedor", "get", Resultado.OK);
    public static final String PROVEEDOR_GET_NOT_OK = ret("proveedor", "get", Resultado.NOT_OK);
    public static final String PROVEEDOR_UPDATE_OK = ret("proveedor", "update", Resultado.OK);
    public static final String PROVEEDOR_UPDATE_NOT_OK = ret("proveedor", "update", Resultado.NOT_OK);
    public static final String PROVEEDOR_DELETE_OK = ret("proveedor", "delete", Resultado.OK);
    public static final String PROVEEDOR_DELETE_NOT_OK = ret("proveedor", "delete", Resultado.NOT_OK);

    // Contiene
    public static final String CONTIENE_CREATE_OK = ret("contiene", "create", Resultado.OK);
    public static final String CONTIENE_CREATE_NOT_OK = ret("contiene", "create", Resultado.NOT_OK);
    public static final String CONTIENE_GET_OK = ret("contiene", "get", Resultado.OK);
    public static final String CONTIENE_GET_NOT_OK = ret("contiene", "get", Resultado.NOT_OK);
    public static final String CONTIENE_UPDATE_OK = ret("contiene", "update", Resultado.OK);
    public static final String CONTIENE_UPDATE_NOT_OK = ret("contiene", "update", Resultado.NOT_OK);
    public static final String CONTIENE_DELETE_OK = ret("contiene", "delete", Resultado.OK);
    public static final String CONTIENE_DELETE_NOT_OK = ret("contiene", "delete", Resultado.NOT_OK);

    // Compra
    public static final String COMPRA_CREATE_OK = ret("compra", "create", Resultado.OK);
    public static final String COMPRA_CREATE_NOT_OK = ret("compra", "create", Resultado.NOT_OK);
    public static final String COMPRA_GET_OK = ret("compra", "get", Resultado.OK);
    public static final String COMPRA_GET_NOT_OK = ret("compra", "get", Resultado.NOT_OK);
    public static final String COMPRA_UPDATE_OK = ret("compra", "update", Resultado.OK);
    public static final String COMPRA_UPDATE_NOT_OK = ret("compra", "update", Resultado.NOT_OK);
    public static final String COMPRA_DELETE_OK = ret("compra", "delete", Resultado.OK);
    public static final String COMPRA_DELETE_NOT_OK = ret("compra", "delete", Resultado.NOT_OK);

    // Especificacion
    public static final String ESPECIFICACION_CREATE_OK = ret("especificacion", "create", Resultado.OK);
    public static final String ESPECIFICACION_CREATE_NOT_OK = ret("especificacion", "create", Resultado.NOT_OK);
    public static final String ESPECIFICACION_GET_OK = ret("especificacion", "get", Resultado.OK);
    public static final String ESPECIFICACION_GET_NOT_OK = ret("especificacion", "get", Resultado.NOT_OK);
    public static final String ESPECIFICACION_UPDATE_OK = ret("especificacion", "update", Resultado.OK);
    public static final String ESPECIFICACION_UPDATE_NOT_OK = ret("especificacion", "update", Resultado.NOT_OK);
    public static final String ESPECIFICACION_DELETE_OK = ret("especificacion", "delete", Resultado.OK);
    public static final String ESPECIFICACION_DELETE_NOT_OK = ret("especificacion", "delete", Resultado.NOT_OK);

    // Producto
    public static final String PRODUCTO_CREATE_OK = ret("producto", "create", Resultado.OK);
    public static final String PRODUCTO_CREATE_NOT_OK = ret("producto", "create", Resultado.NOT_OK);
    public static final String PRODUCTO_GET_OK = ret("producto", "get", Resultado.OK);
    public static final String PRODUCTO_GET_NOT_OK = ret("producto", "get", Resultado.NOT_OK);
    public static final String PRODUCTO_UPDATE_OK = ret("producto", "update", Resultado.OK);
    public static final String PRODUCTO_UPDATE_NOT_OK = ret("producto", "update", Resultado.NOT_OK);
    public static final String PRODUCTO_DELETE_OK = ret("producto", "delete", Resultado.OK);
    public static final String PRODUCTO_DELETE_NOT_OK = ret("producto", "delete", Resultado.NOT_OK);

    // Ofrece
    public static final String OFRECE_CREATE_OK = ret("ofrece", "create", Resultado.OK);
    public static final String OFRECE_CREATE_NOT_OK = ret("ofrece", "create", Resultado.NOT_OK);
    public static final String OFRECE_GET_OK = ret("ofrece", "get", Resultado.OK);
    public static final String OFRECE_GET_NOT_OK = ret("ofrece", "get", Resultado.NOT_OK);
    public static final String OFRECE_UPDATE_OK = ret("ofrece", "update", Resultado.OK);
    public static final String OFRECE_UPDATE_NOT_OK = ret("ofrece", "update", Resultado.NOT_OK);
    public static final String OFRECE_DELETE_OK = ret("ofrece", "delete", Resultado.OK);
    public static final String OFRECE_DELETE_NOT_OK = ret("ofrece", "delete", Resultado.NOT_OK);

    // Tipo_categoria
    public static final String TIPO_CATEGORIA_CREATE_OK = ret("tipo_categoria", "create", Resultado.OK);
    public static final String TIPO_CATEGORIA_CREATE_NOT_OK = ret("tipo_categoria", "create", Resultado.NOT_OK);
    public static final String TIPO_CATEGORIA_GET_OK = ret("tipo_categoria", "get", Resultado.OK);
    public static final String TIPO_CATEGORIA_GET_NOT_OK = ret("tipo_categoria", "get", Resultado.NOT_OK);
    public static final String TIPO_CATEGORIA_UPDATE_OK = ret("tipo_categoria", "update", Resultado.OK);
    public static final String TIPO_CATEGORIA_UPDATE_NOT_OK = ret("tipo_categoria", "update", Resultado.NOT_OK);
    public static final String TIPO_CATEGORIA_DELETE_OK = ret("tipo_categoria", "delete", Resultado.OK);
    public static final String TIPO_CATEGORIA_DELETE_NOT_OK = ret("tipo_categoria", "delete", Resultado.NOT_OK);
    
    public static String ret(String nameClase, String accion, Resultado resultado){
        return "resultado : " + resultado + "\naccion : " + accion.toUpperCase() + "\nentidad : " + nameClase.toUpperCase();
    
    }

    private String resultado;

    private String accion;

    private String nameClase;

    private String name;

    private String descripcion;

    public void Messages(String resultado, String accion, String nameClase, String descripcion, String name) {
        this.resultado = resultado;
        this.accion = accion;
        this.nameClase = nameClase;
        this.descripcion = descripcion;
        this.name = name;
    }

    @Override
    public String toString() {
        int tamanio = ("\nentidad ----------> " + nameClase.toUpperCase()).length() +2;
        String composeName = "";
        for(int i = 0; i < tamanio; i++){
            composeName += "_";
        }

        return "resultado --------> " + resultado.toUpperCase() +
             "\naccion -----------> " + accion.toUpperCase() +
             "\nentidad ----------> " + nameClase.toUpperCase() +
             "\n" + composeName +
             "\n" + name + ": \n" + descripcion ;
    }

    
}