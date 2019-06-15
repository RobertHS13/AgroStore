package com.example.agrostore01.CapaNegocios.escritores;

import com.example.agrostore01.CapaDatos.repositorios.RepositorioUsuario;
import com.example.agrostore01.CapaEntidades.DetallesUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;

public class EscritorUsuario extends Escritor<Usuario> {

    public static int OPERACION_REGISTRAR_USUARIO = 4;
    public static int OPERACION_ACTUALIZAR_CONTRASENA = 5;
    public static int OPERACION_ACTUALIZAR_DATOS = 6;

    private RepositorioUsuario repositorio = new RepositorioUsuario();
    private DetallesUsuario detallesUsuario;

    public EscritorUsuario(int operacion, Usuario usuario) {
        super(operacion, usuario);
    }

    public EscritorUsuario(int operacion, Usuario usuario, Usuario entidadCambio) {
        super(operacion, usuario, entidadCambio);
    }

    public EscritorUsuario(int operacion, Usuario usuario, DetallesUsuario detallesUsuario) {
        super(operacion, usuario);
        this.detallesUsuario = detallesUsuario;
    }

    @Override
    public boolean ejecutarCambios() {

        if (operacion == OPERACION_ALTA)
            return repositorio.alta(entidad);

        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getIdUsuario());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getIdUsuario(), entidadCambio);

        if (operacion == OPERACION_REGISTRAR_USUARIO)
            return repositorio.registrarUsuario(entidad, detallesUsuario);

        if (operacion == OPERACION_ACTUALIZAR_CONTRASENA)
            return repositorio.actualizarContrasena(entidad.getIdUsuario(), entidad.getContrasenaUsuario());

        if (operacion == OPERACION_ACTUALIZAR_DATOS)
            return repositorio.actualizarDatos(entidad, detallesUsuario);

        return false;
    }

}
