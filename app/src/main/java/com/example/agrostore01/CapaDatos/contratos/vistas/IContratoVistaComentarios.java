package com.example.agrostore01.CapaDatos.contratos.vistas;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.vistas.VistaComentarios;

import java.util.List;

public interface IContratoVistaComentarios extends IContrato<VistaComentarios> {

    List<VistaComentarios> seleccionarComentarios(int idProductoTerreno);

}
