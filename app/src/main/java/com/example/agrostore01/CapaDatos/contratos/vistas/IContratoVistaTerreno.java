package com.example.agrostore01.CapaDatos.contratos.vistas;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.vistas.VistaTerreno;

import java.util.List;

public interface IContratoVistaTerreno extends IContrato<VistaTerreno> {

    List<VistaTerreno> seleccionarTerrenos(String idUsuario);

}
