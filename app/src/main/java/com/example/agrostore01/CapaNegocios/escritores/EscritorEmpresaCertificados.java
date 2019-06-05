package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioEmpresaCertificados;
import com.example.agrostore01.CapaEntidades.EmpresaCertificados;

public class EscritorEmpresaCertificados extends EscritorRelacion<EmpresaCertificados> {
    private RepositorioEmpresaCertificados repositorio = new RepositorioEmpresaCertificados();
    public EscritorEmpresaCertificados(int operacion, EmpresaCertificados empresaCertificados) {
        super(operacion, empresaCertificados);
    }

    public EscritorEmpresaCertificados(int operacion, EmpresaCertificados empresaCertificados, EmpresaCertificados entidadCambio) {
        super(operacion, empresaCertificados, entidadCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            repositorio.alta(entidad);


        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdCertificados());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdCertificados(),entidadCambio);



        return false;

    }

}
