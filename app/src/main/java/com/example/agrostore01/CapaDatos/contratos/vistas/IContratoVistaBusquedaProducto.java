package com.example.agrostore01.CapaDatos.contratos.vistas;

import com.example.agrostore01.CapaDatos.contratos.IContrato;
import com.example.agrostore01.CapaEntidades.vistas.VistaBusquedaProducto;

public interface IContratoVistaBusquedaProducto extends IContrato<VistaBusquedaProducto> {

    VistaBusquedaProducto seleccionarEntidadIdProducto(Object idProducto);

}
