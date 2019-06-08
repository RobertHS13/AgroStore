package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.ProductoTerreno;

public class ValidacionProductoTerreno extends Validacion<ProductoTerreno> {

    public ValidacionProductoTerreno(ProductoTerreno productoTerreno) {
        super(productoTerreno);
    }

    public boolean validarIdNumProducto(){
        System.out.println("Validating ProductoTerreno.IdNumProducto " + entidad.getIdNumProduc());

        if (entidad.getIdNumProduc()<=0)
            return false;
        return true;
    }
    public boolean validarIdProducto(){
        System.out.println("Validating ProductoTerreno.IdProducto " + entidad.getIdProducto());
        if (entidad.getIdProducto()<=0)
            return false;

        return true;
    }
    public boolean validarIdTerreno(){
        System.out.println("Validating ProductoTerreno.IdTerreno " + entidad.getIdTerreno());

        if (entidad.getIdTerreno()<=0)
            return false;

        return true;
    }

    @Override
    public boolean validar() {
        return validarIdNumProducto() && validarIdProducto() && validarIdTerreno();
    }
}
