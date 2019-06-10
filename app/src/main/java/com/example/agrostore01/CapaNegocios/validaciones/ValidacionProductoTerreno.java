package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.ProductoTerreno;

public class ValidacionProductoTerreno extends Validacion<ProductoTerreno> {

    public ValidacionProductoTerreno(ProductoTerreno productoTerreno) {
        super(productoTerreno);
    }

    public boolean validarIdNumProducto(){
        System.out.println("Validating ProductoTerreno.IdNumProducto " + entidad.getIdNumProduc());

        if (entidad.getIdNumProduc()<=-1)
            return false;
        return true;
    }
    public boolean validarIdProducto(){
        System.out.println("Validating ProductoTerreno.IdProducto " + entidad.getIdProducto());
        if (entidad.getIdProducto()<=-1)
            return false;

        return true;
    }
    public boolean validarIdTerreno(){
        System.out.println("Validating ProductoTerreno.IdTerreno " + entidad.getIdTerreno());

        if (entidad.getIdTerreno()<=-1)
            return false;

        return true;
    }
    public boolean validarPrecio(){
        System.out.println("Validating ProductoTerreno.Precio "+  entidad.getPrecio());
        //check this afrer------
            return true;
    }
    public boolean validarHectareas(){
        System.out.println("Validating ProductoTerreno.Hectareas " + entidad.getHectareas());
        if (entidad.getHectareas() <=-1)
            return false;

        return true;
    }
    public boolean validarDescripcion(){
        System.out.println("Validating ProductoTerreno.Descripcion "+ entidad.getDescripcion());
        if (entidad.getDescripcion() == null)
            return false;

        if (entidad.getDescripcion().isEmpty())
            return false;

        return true;
    }

    @Override
    public boolean validar() {
        return validarIdNumProducto() && validarIdProducto() && validarIdTerreno();
    }
}
