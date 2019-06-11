package com.example.agrostore01.CapaDatos.contratos;

import com.example.agrostore01.CapaEntidades.Notificaciones;

import java.util.List;

public interface IContratoNotificaciones extends IContrato<Notificaciones> {

    List<String> getNotificaciones(String idUsuario);

}
