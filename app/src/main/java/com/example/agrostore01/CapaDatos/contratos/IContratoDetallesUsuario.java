package com.example.agrostore01.CapaDatos.contratos;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.DetallesUsuario;

public interface IContratoDetallesUsuario extends IContrato<DetallesUsuario> {

    DetallesUsuario mostrarDetallesUsuario(String idUsuario);

}
