package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.ProductoComprado;

public class ValidacionProductoComprado extends Validacion<ProductoComprado> {
    public ValidacionProductoComprado(ProductoComprado productoComprado) {
        super(productoComprado);
    }
    public boolean validarIdProductoComprado(){
        if (entidad.getIdProdComprado()==0)
            return false;
        return true;
    }
    public boolean validarIdTerreno(){
        if (entidad.getIdTerreno()==0)
            return false;
        return true;
    }
    public boolean validarLocalizacion(){
        if (entidad.getLocalizacion().length==0)
            return false;
        return true;
    }
    public boolean validarTiempo(){
        if (entidad.getTiempo().toString().length()==0)
            return false;
        return true;
    }

    @Override
    public boolean validar() {
        return validarIdProductoComprado() && validarIdTerreno() && validarLocalizacion() && validarTiempo();
    }
}
