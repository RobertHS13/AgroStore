package com.example.agrostore01.CapaDatos.contratos;

import com.example.agrostore01.CapaEntidades.DetallesUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;

public interface IContratoUsuario extends IContrato<Usuario> {

    Usuario seleccionarNombreUsuario(String nombreUsuario);
    boolean confirmarExistencia(String idUsuario, String contrasena);
    String seleccionarContrasena(String idUsuario);
    boolean registrarUsuario(Usuario usuario, DetallesUsuario detallesUsuario);

}
