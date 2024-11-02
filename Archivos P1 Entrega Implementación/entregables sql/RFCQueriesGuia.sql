-- Consultas hechas para las pruebas de los RFC--

-- RFC1 --
-- Sumamos cantidad_en_bodega para los productos de dicha bodega y lo dividimos entre Bodega.capacidad--
SELECT Bodega.id, Bodega.nombre, (SUM(Producto_En_Bodega.cantidad_En_Bodega) / Bodega.capacidad) AS porcentajeOcupacion FROM Bodega 
INNER JOIN Producto_En_Bodega ON Producto_En_Bodega.id_Bodega = Bodega.id
INNER JOIN Producto ON Producto.identificador = Producto_En_Bodega.identificador_Producto
WHERE Bodega.id_sucursal = 3
AND Producto.identificador IN (1,2,3)
GROUP BY Bodega.id, Bodega.nombre, Bodega.capacidad;

-- RFC2 --
-- Aqui sale la leche de la sucursal 3 filtrada de acuerdo a sus datos --
SELECT * FROM Producto
INNER JOIN Producto_En_Bodega ON Producto_En_Bodega.identificador_Producto = Producto.identificador
INNER JOIN Bodega ON Bodega.id = Producto_En_Bodega.id_Bodega
INNER JOIN Sucursal ON Sucursal.id = Bodega.id_sucursal
INNER JOIN Categoria ON Categoria.codigo = Producto.clasificacion_categoria
WHERE (Producto.costo_en_bodega >= 4499)
AND (Producto.costo_en_bodega <= 4501)
AND (Producto.fecha_expiracion > TO_DATE('2025-11-04', 'YYYY-MM-DD'))
AND (Producto.fecha_expiracion < TO_DATE('2025-11-06', 'YYYY-MM-DD'))
AND  (Bodega.id_sucursal = 3) 
AND (Categoria.nombre = 'PERECEDERO');

-- Aqui se unifica los datos de la leche ya que solo piden la informacion del producto, en caso de que haya mas de uno--
SELECT DISTINCT Producto.* FROM Producto
INNER JOIN Producto_En_Bodega ON Producto_En_Bodega.identificador_Producto = Producto.identificador
INNER JOIN Bodega ON Bodega.id = Producto_En_Bodega.id_Bodega
INNER JOIN Sucursal ON Sucursal.id = Bodega.id_sucursal
INNER JOIN Categoria ON Categoria.codigo = Producto.clasificacion_categoria
WHERE (Producto.costo_en_bodega >= 4499)
AND (Producto.costo_en_bodega <= 4501)
AND (Producto.fecha_expiracion > TO_DATE('2025-11-04', 'YYYY-MM-DD'))
AND (Producto.fecha_expiracion < TO_DATE('2025-11-06', 'YYYY-MM-DD'))
AND  (Bodega.id_sucursal = 3) 
AND (Categoria.nombre = 'PERECEDERO');

-- RFC3 --
-- Elegimos bodegita Harry, en la sucursal 3
SELECT PRODUCTO.IDENTIFICADOR, PRODUCTO.NOMBRE, PRODUCTO_EN_BODEGA.NIVEL_MINIMO_REORDEN, PRODUCTO_EN_BODEGA.COSTO_PROMEDIO, PRODUCTO_EN_BODEGA.CANTIDAD_EN_BODEGA
FROM PRODUCTO
INNER JOIN PRODUCTO_EN_BODEGA ON PRODUCTO_EN_BODEGA.IDENTIFICADOR_PRODUCTO = PRODUCTO.IDENTIFICADOR
INNER JOIN BODEGA ON BODEGA.ID = PRODUCTO_EN_BODEGA.ID_BODEGA 
INNER JOIN SUCURSAL ON SUCURSAL.ID = BODEGA.ID_SUCURSAL
WHERE SUCURSAL.ID = 3
AND Bodega.id = 2;

-- RFC4 --
-- Se buscan las sucursales donde la leche este disponible --
-- Se espera que de sucursal occidente y sucursal sur --
SELECT DISTINCT Sucursal.*
FROM Sucursal INNER JOIN Bodega ON Sucursal.id = Bodega.id_sucursal
INNER JOIN Producto_en_bodega ON Bodega.id = Producto_En_Bodega.id_bodega
INNER JOIN Producto ON Producto_En_Bodega.identificador_producto = Producto.identificador
WHERE (Producto.identificador = 2 OR Producto.nombre = 'Leche')
AND Producto_en_bodega.cantidad_en_bodega > 0;


-- Veamos que productos debemos tener en cuenta para lo anterior. Asi manualmente podemos confirmar.
-- Manualmente el resultado deberia ser 2.75
SELECT *
FROM PRODUCTO_EN_BODEGA 
INNER JOIN BODEGA ON PRODUCTO_EN_BODEGA.ID_BODEGA = BODEGA.ID
WHERE BODEGA.ID = 2
AND Producto_en_bodega.identificador_producto IN (1,2,3);


-- RFC5--
SELECT PRODUCTO.IDENTIFICADOR , PRODUCTO.NOMBRE, BODEGA.NOMBRE AS BODEGA_NOMBRE, SUCURSAL.NOMBRE AS SUCURSAL_NOMBRE, PROVEEDOR.NOMBRE AS PROVEEDOR_NOMBRE,PRODUCTO_EN_BODEGA.CANTIDAD_EN_BODEGA,PRODUCTO_EN_BODEGA.NIVEL_MINIMO_REORDEN 
FROM PRODUCTO 
INNER JOIN PRODUCTO_EN_BODEGA  ON PRODUCTO.IDENTIFICADOR = PRODUCTO_EN_BODEGA.IDENTIFICADOR_PRODUCTO
INNER JOIN BODEGA ON PRODUCTO_EN_BODEGA.ID_BODEGA = BODEGA.ID
INNER JOIN SUCURSAL ON BODEGA.ID_SUCURSAL = SUCURSAL.ID
INNER JOIN PRODUCTO_PROVEEDOR ON PRODUCTO.IDENTIFICADOR = PRODUCTO_PROVEEDOR.IDENTIFICADOR_PRODUCTO
INNER JOIN PROVEEDOR ON PRODUCTO_PROVEEDOR.NIT_PROVEEDOR = PROVEEDOR.NIT
WHERE PRODUCTO_EN_BODEGA.CANTIDAD_EN_BODEGA < PRODUCTO_EN_BODEGA.NIVEL_MINIMO_REORDEN
ORDER BY PRODUCTO.NOMBRE, BODEGA.NOMBRE;
