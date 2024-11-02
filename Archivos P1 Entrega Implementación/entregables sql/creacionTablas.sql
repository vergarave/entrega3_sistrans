-- Creemos las relaciones necesarias --

-- Relacion ciudad--
CREATE TABLE CIUDAD (
    CODIGO NUMBER(38,0) PRIMARY KEY,
    NOMBRE VARCHAR2(100) NOT NULL,
    
    -- Verificacion de los valores de principales ciudades en Colombia --
    CONSTRAINT CK_NOMBRE_CIUDAD CHECK (NOMBRE IN ('BOGOTA', 'MEDELLIN', 'CALI', 'BARRANQUILLA', 'CARTAGENA', 'CUCUTA', 'BUCARAMANGA', 
    'PEREIRA', 'MANIZALES', 'IBAGUE', 'SANTA_MARTA', 'PASTO', 'VILLAVICENCIO', 'NEIVA', 'ARMENIA', 'MONTERIA', 'SINCELEJO', 
    'POPAYAN', 'RIO_NEGRO', 'YOPAL')),
    
    -- Verificacion de no duplicados para nombre -- 
    CONSTRAINT UNQ_NOMBRE UNIQUE (NOMBRE)
);

-- Relacion sucursal --
CREATE TABLE SUCURSAL (
    ID NUMBER(38,0) PRIMARY KEY,
    NOMBRE VARCHAR2(200) NOT NULL,
    TAMANIO NUMBER(7,2) NOT NULL,
    DIRECCION VARCHAR2(400) NOT NULL,
    TELEFONO VARCHAR2(100) NOT NULL,
    CODIGO_CIUDAD NUMBER (38,0) NOT NULL,
    
    -- Verificacion de tamanio mayor a cero --
    CONSTRAINT CK_TAMANIO_SUCURSAL CHECK (TAMANIO > 0),
    -- Verificacion de no duplicados para telefono --
    CONSTRAINT UNQ_TELEFONO UNIQUE (TELEFONO),
    -- Asignacion de referenciacion para llave foranea en codigo_ciudad --
    CONSTRAINT FK_CIUDAD FOREIGN KEY(CODIGO_CIUDAD) REFERENCES CIUDAD(CODIGO) 
);

-- Relacion bodega --
CREATE TABLE BODEGA (
    ID NUMBER(38,0) PRIMARY KEY,
    NOMBRE VARCHAR2(200) NOT NULL,
    TAMANIO NUMBER(7,2) NOT NULL,
    CAPACIDAD NUMBER(5,0) NOT NULL,
    ID_SUCURSAL NUMBER(38,0) NOT NULL,
    
    -- Verificacion de tamanio bodega mayor a cero --
    CONSTRAINT CK_TAMANIO_BODEGA CHECK (TAMANIO > 0),
    -- Verificacion de capacidad mayor a cero --
    CONSTRAINT CK_CAPACIDAD CHECK (CAPACIDAD >0),
    -- Asignacion de referenciacion para llave foranea en id_sucursal_bodega --
    CONSTRAINT FK_ID_SUCURSAL_BODEGA FOREIGN KEY(ID_SUCURSAL) REFERENCES SUCURSAL(ID)
);

-- Relacion proveedor -- 
CREATE TABLE PROVEEDOR(
    NIT VARCHAR2(38) PRIMARY KEY,
    NOMBRE VARCHAR2(200) NOT NULL,
    DIRECCION VARCHAR2(300) NOT NULL,
    NOMBRE_PERSONA_CONTACTO VARCHAR2(100) NOT NULL,
    TELEFONO_PERSONA_CONTACTO VARCHAR2(100) NOT NULL UNIQUE
);

-- Relacion categoria --
CREATE TABLE CATEGORIA(
    CODIGO NUMBER(38,0) PRIMARY KEY,
    NOMBRE VARCHAR2(200) NOT NULL UNIQUE,
    DESCRIPCION VARCHAR2(2000) NOT NULL,
    CARACTERISTICAS_ALMACENAMIENTO VARCHAR2(2000) NOT NULL,
    
    -- Verificacion de los valores de nombre de categoria --
    CONSTRAINT CK_NOMBRE_CATEGORIA CHECK (NOMBRE IN ('PERECEDERO', 'NO_PERECEDERO', 'ASEO', 'CONGELADO', 
    'PRENDA_DE_VESTIR', 'MUEBLE', 'HERRAMIENTA', 'ELECTRODOMESTICO'))
);

-- Relacion producto --
CREATE TABLE PRODUCTO(
    IDENTIFICADOR NUMBER(38,0) PRIMARY KEY,
    NOMBRE VARCHAR2(200) NOT NULL,
    COSTO_EN_BODEGA NUMBER(20,0) NOT NULL,
    PRESENTACION VARCHAR2(2000) NOT NULL,
    CANTIDAD_PRESENTACION NUMBER(10,2) NOT NULL,
    UNIDAD_MEDIDA VARCHAR2(2) NOT NULL,
    VOLUMEN_EMPAQUE VARCHAR2(40) NOT NULL,
    PESO_EMPAQUE VARCHAR2(40) NOT NULL, 
    FECHA_EXPIRACION DATE,
    CODIGO_DE_BARRAS VARCHAR2(200) NOT NULL UNIQUE,
    CLASIFICACION_CATEGORIA NUMBER(38,0) NOT NULL,
    
    -- Verificacion de costo en bodega mayor a cero --
    CONSTRAINT CK_COSTO_EN_BODEGA CHECK(COSTO_EN_BODEGA >0),
    -- Verificacion de cantidad presentacion mayor a cero --
    CONSTRAINT CK_CANTIDAD_PRESENTACION CHECK(CANTIDAD_PRESENTACION >0),
    -- Verificacion de valores de unidad de medida --
    CONSTRAINT CK_UNIDAD_MEDIDA CHECK(UNIDAD_MEDIDA IN ('ML', 'GR')),
    --  Asignacion de referenciacion para llave foranea en clasificacion_categoria --
    CONSTRAINT FK_CLASIFICACION_CATEGORIA FOREIGN KEY(CLASIFICACION_CATEGORIA) REFERENCES CATEGORIA(CODIGO)
);

-- Relacion orden de compra --
CREATE TABLE ORDEN_DE_COMPRA(
    NUMERO NUMBER(38,0) PRIMARY KEY,
    FECHA_ENTREGA DATE NOT NULL,
    ESTADO VARCHAR2(15) NOT NULL,
    FECHA_CREACION DATE NOT NULL,
    ID_SUCURSAL NUMBER(38,0) NOT NULL,
    NIT_PROVEEDOR VARCHAR2(38) NOT NULL,
    
    -- Verificacion de valores de estado --
    CONSTRAINT CK_ESTADO CHECK (ESTADO IN('VIGENTE', 'ANULADA', 'ENTREGADA')),
    -- Asignacion de referenciacion para llave foranea en id_sucursal_orden_de_compra --
    CONSTRAINT FK_ID_SUCURSAL_ORDEN_DE_COMPRA FOREIGN KEY(ID_SUCURSAL) REFERENCES SUCURSAL(ID),
    -- Asignacion de referenciacion para llave foranea en nit_proveedor --
    CONSTRAINT FK_NIT_PROVEEDOR FOREIGN KEY(NIT_PROVEEDOR) REFERENCES PROVEEDOR(NIT)
);


-- Relacion producto en bodega
CREATE TABLE PRODUCTO_EN_BODEGA(
    IDENTIFICADOR_PRODUCTO NUMBER(38,0),
    ID_BODEGA NUMBER(38,0),
    NIVEL_MINIMO_REORDEN NUMBER(20,0) NOT NULL,
    COSTO_PROMEDIO NUMBER(20,2) NOT NULL,
    CAPACIDAD_ALMACENAR_PRODUCTO NUMBER(10,0) NOT NULL,
    CANTIDAD_EN_BODEGA NUMBER(10,0) NOT NULL,
    
    -- Verificacion de nivel minimo reorden mayor a cero --
    CONSTRAINT CK_NIVEL_MINIMO_REORDEN CHECK (NIVEL_MINIMO_REORDEN >0),
     -- Verificacion de costo promedio mayor a cero --
    CONSTRAINT CK_COSTO_PROMEDIO CHECK (COSTO_PROMEDIO >0),
     -- Verificacion de capacidad almacenar producto mayor a cero --
    CONSTRAINT CK_CAPACIDAD_ALMACENAR_PRODUCTO CHECK (CAPACIDAD_ALMACENAR_PRODUCTO >0),
     -- Verificacion de cantidad en bodega mayor a cero --
    CONSTRAINT CK_CANTIDAD_EN_BODEGA CHECK (CANTIDAD_EN_BODEGA >0),
    -- Asignacion de referenciacion para llave foranea en identificador_producto --
    CONSTRAINT FK_IDENTIFICADOR_PRODUCTO_PRODUCTO_EN_BODEGA FOREIGN KEY (IDENTIFICADOR_PRODUCTO) REFERENCES PRODUCTO(IDENTIFICADOR),
    -- Asignacion de referenciacion para llave foranea en id bodega --
    CONSTRAINT FK_ID_BODEGA FOREIGN KEY (ID_BODEGA) REFERENCES BODEGA(ID),
     -- Asignacion de llave primaria pero esta vez en constraint, para poder hacer claro que es una llave compuesta --
    CONSTRAINT PK_PRODUCTO_EN_BODEGA PRIMARY KEY (IDENTIFICADOR_PRODUCTO, ID_BODEGA)
);

CREATE TABLE PRODUCTO_PEDIDO(
    IDENTIFICADOR_PRODUCTO NUMBER(38,0),
    NUMERO_ORDEN_DE_COMPRA NUMBER(38,0),
    CANTIDAD_EN_ORDEN NUMBER(20,0) NOT NULL,
    
    -- Verificacion de cantidad en orden mayor a cero --
    CONSTRAINT CK_CANTIDAD_EN_ORDEN CHECK (CANTIDAD_EN_ORDEN > 0),
    -- Asignacion de referenciacion para llave foranea en identificador_producto--
    CONSTRAINT FK_IDENTIFICADOR_PRODUCTO_PRODUCTO_PEDIDO FOREIGN KEY (IDENTIFICADOR_PRODUCTO) REFERENCES PRODUCTO(IDENTIFICADOR),
    -- Asignacion de referenciacion para llave foranea en numero_orden_de_compra --
    CONSTRAINT FK_NUMERO_ORDEN_DE_COMPRA FOREIGN KEY (NUMERO_ORDEN_DE_COMPRA) REFERENCES ORDEN_DE_COMPRA(NUMERO),
     -- Asignacion de llave primaria pero esta vez en constraint, para poder hacer claro que es una llave compuesta --
    CONSTRAINT PK_PRODUCTO_PEDIDO PRIMARY KEY(IDENTIFICADOR_PRODUCTO, NUMERO_ORDEN_DE_COMPRA)
);

-- Relacion producto proveedor --
CREATE TABLE PRODUCTO_PROVEEDOR(
    IDENTIFICADOR_PRODUCTO NUMBER(38,0),
    NIT_PROVEEDOR VARCHAR2(38),
    
     -- Asignacion de llave primaria pero esta vez en constraint, para poder hacer claro que es una llave compuesta --
    CONSTRAINT PK_PRODUCTO_PROVEEDOR PRIMARY KEY (IDENTIFICADOR_PRODUCTO, NIT_PROVEEDOR),
    
    -- Asignacion de referenciacion para llave foranea en identificador_producto --
    CONSTRAINT FK_IDENTIFICADOR_PRODUCTO_PRODUCTO_PROVEEDOR FOREIGN KEY (IDENTIFICADOR_PRODUCTO) REFERENCES PRODUCTO(IDENTIFICADOR),
    
   -- Asignacion de referenciacion para llave foranea en nit_proveedor --
    CONSTRAINT FK_PROVEEDOR_PRODUCTO_PROVEEDOR FOREIGN KEY (NIT_PROVEEDOR) REFERENCES PROVEEDOR(NIT)
);

