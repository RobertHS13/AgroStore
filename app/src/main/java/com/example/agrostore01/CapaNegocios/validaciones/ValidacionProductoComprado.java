package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.ProductoComprado;

import java.util.Arrays;

public class ValidacionProductoComprado extends Validacion<ProductoComprado> {
    public ValidacionProductoComprado(ProductoComprado productoComprado) {
        super(productoComprado);
    }

    public boolean validarIdProductoComprado(){
        System.out.println("Validating ProductoComprado.IdProductoComprado " + entidad.getIdProdComprado() );

        if (entidad.getIdProdComprado()<=-1)
            return false;

        return true;
    }
    public boolean validarIdTerreno(){
        System.out.println("Validating ProductoComprado.IdTerreno " + entidad.getIdTerreno() );
        if (entidad.getIdTerreno()<=-1)
            return false;

        return true;
    }
    public boolean validarLocalizacion(){
        System.out.println("Validating ProductoComprado.Localizacion " + Arrays.toString( entidad.getLocalizacion()));
        return true;
    }
    public boolean validarTiempo(){
        System.out.println("Validating ProductoComprado.Tiempo " +entidad.getTiempo());
        return true;
    }

    @Override
    public boolean validar() {
        return validarIdProductoComprado() && validarIdTerreno() && validarLocalizacion() && validarTiempo();
    }
}
