package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.ProductoTerreno;

public class ValidacionProductoTerreno extends Validacion<ProductoTerreno> {
    public ValidacionProductoTerreno(ProductoTerreno productoTerreno) {
        super(productoTerreno);
    }
    public boolean validarIdnumProducto(){
        if (entidad.getIdNumProduc()==0)
            return false;
        return true;
    }
    public boolean validarIdProducto(){
        if (entidad.getIdProducto()==0)
            return false;
        return true;
    }
    public boolean validarIdTerreno(){
        if (entidad.getIdTerreno()==0)
            return false;
        return true;
    }

    @Override
    public boolean validar() {
        return validarIdnumProducto() && validarIdProducto() && validarIdTerreno();
    }
}
