package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.DetalleVenta;

public class ValidacionDetallesVenta extends  Validacion<DetalleVenta> {
    public ValidacionDetallesVenta(DetalleVenta detalleVenta) {
        super(detalleVenta);
    }

    public boolean validarIdDetalle(){
        System.out.println("Validating DetalleVenta.IdDetalle "+ entidad.getIdDetalle());
        if (entidad.getIdDetalle()<= -1)
            return false;

        return true;
    }
    public boolean validarIdTerreno(){
        System.out.println("Validating DetalleVenta.IdTerreno "+ entidad.getIdTerreno());

        if (entidad.getIdTerreno()<=-1)
            return false;

        return true;
    }

    public boolean validarFecha(){
        System.out.println("Validating DetalleVenta.Fecha "+ entidad.getFecha());
        return true;
    }
    public boolean validarPrecioTonelada(){
        System.out.println("Validating DetalleVenta.PrecioTonelada "+entidad.getPrecioTonelada());
        if (entidad.getPrecioTonelada().longValue()<=0)
            return false;
        return true;
    }
    public boolean validarProducto(){
        System.out.println("Validating DetalleVenta.Producto "+ entidad.getProducto());

        if (entidad.getProducto() == null)
            return false;
        if (entidad.getProducto().isEmpty())
            return false;
        return true;
    }
    public boolean validarTamano(){
        System.out.println("Validating DetalleVenta.Tamano "+entidad.getTamaño());

        if (entidad.getTamaño()<=-1)
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdDetalle() && validarIdTerreno() && validarFecha() && validarPrecioTonelada() && validarProducto() && validarTamano();
    }
}
