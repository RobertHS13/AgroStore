package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioDetalleVenta;
import com.example.agrostore01.CapaEntidades.DetalleVenta;

public class EscritorDetallesVenta extends Escritor<DetalleVenta> {
    private RepositorioDetalleVenta repositorio = new RepositorioDetalleVenta();
    public EscritorDetallesVenta(int operacion, DetalleVenta detalleVenta) {
        super(operacion, detalleVenta);
    }

    public EscritorDetallesVenta(int operacion, DetalleVenta detalleVenta, DetalleVenta entidadCambio) {
        super(operacion, detalleVenta, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            repositorio.alta(entidad);

        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdDetalle());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdDetalle(),entidadCambio);



        return false;
    }
}
