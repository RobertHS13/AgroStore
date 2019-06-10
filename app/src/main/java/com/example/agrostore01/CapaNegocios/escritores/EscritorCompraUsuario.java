package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioCompraUsuario;
import com.example.agrostore01.CapaEntidades.CompraUsuario;

public class EscritorCompraUsuario extends EscritorRelacion<CompraUsuario> {
    private RepositorioCompraUsuario repositorio = new RepositorioCompraUsuario();
    public EscritorCompraUsuario(int operacion, CompraUsuario compraUsuario) {
        super(operacion, compraUsuario);
    }

    public EscritorCompraUsuario(int operacion, CompraUsuario compraUsuario, CompraUsuario entidadCambio) {
        super(operacion, compraUsuario, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            return repositorio.alta(entidad);

        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdProductoComprado());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad,entidadCambio);



        return false;
    }
}
