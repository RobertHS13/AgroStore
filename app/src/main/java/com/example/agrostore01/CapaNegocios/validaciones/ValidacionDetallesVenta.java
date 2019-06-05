package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.DetalleVenta;

public class ValidacionDetallesVenta extends  Validacion<DetalleVenta> {
    public ValidacionDetallesVenta(DetalleVenta detalleVenta) {
        super(detalleVenta);
    }
    public boolean validarIdDetalle(){
        if (entidad.getIdDetalle()==0)
            return false;
        return true;
    }
    public boolean validarIdTerreno(){
        if (entidad.getIdTerreno()==0)
            return false;
        return true;
    }
    public boolean validarFecha(){
        if (entidad.getFecha().toString().isEmpty())
            return false;
        return true;
    }
    public boolean validarPrecioTonelada(){
        if (entidad.getPrecioTonelada().longValue()==0)
            return false;
        return true;
    }
    public boolean validarProducto(){
        if (entidad.getProducto().isEmpty())
            return false;
        return true;
    }
    public boolean validarTamano(){
        if (entidad.getTamaño()==0)
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdDetalle() && validarIdTerreno() && validarFecha() && validarPrecioTonelada() && validarProducto() && validarTamano();
    }
}
