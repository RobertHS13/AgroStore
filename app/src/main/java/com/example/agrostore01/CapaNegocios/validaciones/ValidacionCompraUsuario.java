package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.CompraUsuario;

public class ValidacionCompraUsuario extends Validacion<CompraUsuario> {
    public ValidacionCompraUsuario(CompraUsuario compraUsuario) {
        super(compraUsuario);
    }
    public boolean validarIdProductoComprado(){
        if (entidad.getIdProductoComprado()==0)
            return false;
        return true;
    }
    public boolean validarIdUsuario(){
        if (entidad.getIdUsuario().isEmpty())
            return false;
        return true;
    }
    @Override
    public boolean validar() {
        return validarIdProductoComprado() && validarIdUsuario();
    }
}
