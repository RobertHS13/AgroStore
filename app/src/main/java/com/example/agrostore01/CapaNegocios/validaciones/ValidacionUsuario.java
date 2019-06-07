package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Usuario;

import java.util.Arrays;

public class ValidacionUsuario extends Validacion<Usuario> {

    public ValidacionUsuario(Usuario usuario) {
        super(usuario);
    }

    public boolean validarIdUsuario() {
        System.out.println("Validating Usuario.IdUsuario: " + entidad.getIdUsuario());

        if (entidad.getIdUsuario() == null)
            return false;

        if (entidad.getIdUsuario().isEmpty())
            return false;

        return true;
    }

    public boolean validarContrasenaUsuario() {
        System.out.println("Validating Usuario.Contrasena: " + entidad.getContrasenaUsuario());

        if (entidad.getContrasenaUsuario() == null)
            return false;

        if (entidad.getContrasenaUsuario().isEmpty())
            return false;

        return true;
    }

    public boolean validarIdTipo() {
        System.out.println("Validating Usuario.IdTipo: " + entidad.getIdTipo());

        if (entidad.getIdTipo() <= -1)
            return false;

        return true;
    }

    public boolean validarIdDetalles() {
        System.out.println("Validating Usuario.IdDetalles: " + entidad.getIdDetalles());

        if (entidad.getIdDetalles() <= -1)
            return false;

        return true;
    }

    public boolean validarFoto() {
        System.out.println("Validating Usuario.Foto: " + Arrays.toString(entidad.getFoto()));
        return true;
    }

    public boolean validarCorreo() {
        System.out.println("Validating Usuario.Correo: " + entidad.getCorreo());

        if (entidad.getCorreo() == null)
            return false;

        if (entidad.getCorreo().isEmpty())
            return false;

        return true;
    }

    @Override
    public boolean validar() {
        return validarIdUsuario() && validarContrasenaUsuario() && validarIdTipo() && validarIdDetalles() && validarFoto() && validarCorreo();
    }
}
