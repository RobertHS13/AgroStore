package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.CompraUsuario;

public class ValidacionCompraUsuario extends Validacion<CompraUsuario> {
    public ValidacionCompraUsuario(CompraUsuario compraUsuario) {
        super(compraUsuario);
    }

    public boolean validarIdProductoComprado(){
        System.out.println("Validating CompraUsuario.IdProductoComprado "+ entidad.getIdProductoComprado());
        if (entidad.getIdProductoComprado() <= -1)
            return false;

        return true;
    }

    public boolean validarIdUsuario(){
        System.out.println("Validating CompraUsuario.IdProductoComprado " + entidad.getIdUsuario());
        if(entidad.getIdUsuario() == null)
            return false;

        if (entidad.getIdUsuario().isEmpty())
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdProductoComprado() && validarIdUsuario();
    }
}
