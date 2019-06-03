package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioProductoCompra;
import com.example.agrostore01.CapaEntidades.ProductoComprado;

public class EscritorProductoComprado extends Escritor<ProductoComprado> {

    private RepositorioProductoCompra repositorio = new RepositorioProductoCompra();

    public EscritorProductoComprado(int operacion, ProductoComprado productoComprado) {
        super(operacion, productoComprado);
    }

    public EscritorProductoComprado(int operacion, ProductoComprado productoComprado, ProductoComprado entidadCambio) {
        super(operacion, productoComprado, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            //return repositorio.alta(entidad);
            return false;

        if (operacion == OPERACION_BAJA)
            //return repositorio.baja(entidad.getIdDetalles());
            return false;
        if (operacion == OPERACION_CAMBIO)
            //return repositorio.cambio(entidad,entidadCambio);
            return false;


        return false;
    }
}
