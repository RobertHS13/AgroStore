package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Venta;

public class ValidacionVenta extends  Validacion<Venta> {
    public ValidacionVenta(Venta venta) {
        super(venta);
    }
    public boolean validarIdVenta(){
        if (entidad.getIdVenta()==0)
            return false;
        return true;
    }
    public boolean validarIdDetalle(){
        if (entidad.getIdDetalle()==0)
            return false;
        return true;
    }
    public boolean validarIdUsuarioAgricultor(){
        if (entidad.getIdUsuarioAgricultor().isEmpty())
            return false;
        return true;
    }
    public boolean validarIdUsuarioCliente(){
        if (entidad.getIdUsuarioCliente().isEmpty())
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdVenta() && validarIdDetalle() && validarIdUsuarioAgricultor() && validarIdUsuarioCliente();
    }
}
