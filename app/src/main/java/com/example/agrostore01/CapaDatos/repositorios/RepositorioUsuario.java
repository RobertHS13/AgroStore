package com.example.agrostore01.CapaDatos.repositorios;

import com.example.agrostore01.CapaDatos.contratos.IContratoUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class RepositorioUsuario extends Repositorio implements IContratoUsuario {

    private String sqlSeleccionarNombreUsuario;
    private String sqlProcConfirmarExistencia;
    private String sqlProcSeleccionarContrasena;

    public RepositorioUsuario(){
        this.sqlAlta = "insert into Usuario values (?, ?, ?, ?, ?)";
        this.sqlBaja = "delete from Usuario where IDUsuario = ?";
        this.sqlCambio = "update Usuario set " +
                "IDUsuario = ?, " +
                "Contraseña = ?, " +
                "IDTipo = ?, " +
                "IDDetalles = ?, " +
                "Foto = ?, " +
                "Correo = ? " +
                "where IDUsuario = ?";
        this.sqlSeleccionarId = "select * from Usuario where IDUsuario = ?";
        this.sqlSeleccionarTodo = "select * from Usuario";
        this.sqlSeleccionarNombreUsuario = "select * from [Usuario] where [Usuario].Usuario = ?";

        this.sqlProcConfirmarExistencia = "{ call PROC_USUARIO_CONFIRMAR_EXISTENCIA(?, ?, ?) }";
        this.sqlProcSeleccionarContrasena = "{ call PROC_USUARIO_RETURN_CONTRASEÑA(?, ?) }";
    }

    @Override
    public boolean alta(Usuario e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdUsuario());
        parametros.add(e.getContrasenaUsuario());
        parametros.add(e.getIdTipo());
        parametros.add(e.getIdDetalles());
        parametros.add(e.getFoto());
        parametros.add(e.getCorreo());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Usuario e) {
        parametros = new ArrayList<>();
        parametros.add(e.getIdUsuario());
        parametros.add(e.getContrasenaUsuario());
        parametros.add(e.getIdTipo());
        parametros.add(e.getIdDetalles());
        parametros.add(e.getFoto());
        parametros.add(e.getCorreo());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public Usuario seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();
            String idUsuario = resultado.getString("IDUsuario");
            byte[] foto = resultado.getBytes("Foto");
            int idtipo = resultado.getInt("IDTipo");
            long iddetalles= resultado.getLong("IDDetalles");
            String usuario = resultado.getString("Usuario");
            String contraseña= resultado.getString("Contraseña");
            String correo = resultado.getString("Correo");
            return new Usuario(idUsuario, foto, idtipo, iddetalles, usuario, contraseña, correo);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    @Override
    public ArrayList<Usuario> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            while (resultado.next()) {
                String idUsuario = resultado.getString("IDUsuario");
                byte[] foto = resultado.getBytes("Foto");
                int idtipo = resultado.getInt("IDTipo");
                long iddetalles = resultado.getLong("IDDetalles");
                String usuario = resultado.getString("Usuario");
                String contrasena = resultado.getString("Contraseña");
                String correo = resultado.getString("Correo");
                usuarios.add(new Usuario(idUsuario, foto, idtipo, iddetalles, usuario, contrasena, correo));
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return usuarios;
    }

    @Override
    public Usuario seleccionarNombreUsuario(String nombreUsuario) {
        parametros = new ArrayList<>();
        parametros.add(nombreUsuario);

        resultado = ejecutarLectura(sqlSeleccionarNombreUsuario);

        try {
            resultado.next();
            String idUsuario = resultado.getString("IDUsuario");
            byte[] foto = resultado.getBytes("Foto");
            int idtipo = resultado.getInt("IDTipo");
            long iddetalles= resultado.getLong("IDDetalles");
            String usuario = resultado.getString("Usuario");
            String contraseña = resultado.getString("Contraseña");
            String correo = resultado.getString("Correo");
            return new Usuario(idUsuario, foto, idtipo, iddetalles, usuario, contraseña, correo);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    @Override
    public boolean confirmarExistencia(String idUsuario, String contrasena) {
        parametros = new ArrayList<>();
        parametrosDeSalida = new ArrayList<>();

        parametros.add(idUsuario);
        parametros.add(contrasena);
        parametrosDeSalida.add(Types.BOOLEAN);

        resultado = ejecutarProcedimientoConSalida(sqlProcConfirmarExistencia);
        try {
            if (resultado != null)
                while (resultado.next()) {}

            boolean success = procedimiento.getBoolean(3);

            System.out.println("The output paramter is: " + success);
            return success;
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String seleccionarContrasena(String idUsuario) {
        parametros = new ArrayList<>();
        parametrosDeSalida = new ArrayList<>();

        parametros.add(idUsuario);
        parametrosDeSalida.add(Types.VARCHAR);

        resultado = ejecutarProcedimientoConSalida(sqlProcSeleccionarContrasena);
        try {
            if (resultado != null)
                while (resultado.next()) {}

            String contrasena = procedimiento.getString(2);

            System.out.println("The output paramter is: " + contrasena);
            return contrasena;
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
