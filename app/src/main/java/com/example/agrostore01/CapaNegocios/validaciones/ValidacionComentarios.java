package com.example.agrostore01.CapaNegocios.validaciones;

import com.example.agrostore01.CapaEntidades.Comentarios;

public class ValidacionComentarios extends Validacion<Comentarios> {

    public ValidacionComentarios(Comentarios comentarios) {
        super(comentarios);
    }
    public boolean validarIdComentarios(){
        System.out.println("Validating Comentarios.IdComentarios" +entidad.getIdComentarios());
        if (entidad.getIdComentarios() <= -1)
            return false;

        return true;
    }
    public boolean validarIdUsuario(){
        System.out.println("Validating Comentarios.IdUsuario" +entidad.getIdUsuario());
        if (entidad.getIdUsuario().isEmpty())
            return false;
        if (entidad.getIdUsuario() == null)
            return false;


        return true;

    }
    public boolean validarComentario(){
        System.out.println("Validating Comentarios.Comentario" +entidad.getComentario());
        if (entidad.getComentario().isEmpty())
            return false;
        if (entidad.getComentario() == null)
            return false;

            return true;
    }
    public boolean validarFecha(){
        System.out.println("Validating Comentarios.Fecha" +entidad.getFecha());
        return true;
    }
    public boolean validarRespuesta(){
        System.out.println("Validating Comentarios.Respuesta" +entidad.getRespuesta());
        if (entidad.getRespuesta() == null)
            return false;

        if (entidad.getRespuesta().isEmpty())
            return false;

        return true;
    }


    @Override
    public boolean validar() {
        return validarIdComentarios() && validarIdUsuario() && validarComentario() &&validarFecha() && validarRespuesta();
    }
}
