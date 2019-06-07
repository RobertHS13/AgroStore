package com.example.agrostore01;

import com.example.agrostore01.CapaEntidades.DetallesUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;

public class AgroUtils {

    public static Usuario getTestUser() {
        return new Usuario(
                "TestUserId",
                null,
                1,
                1,
                "TestUserName",
                "TestPassword",
                "Test@Mail.com"
        );
    }

    //public DetallesUsuario(
    // long idDetalles,
    // String calle,
    // String colonia,
    // String cuidad,
    // String estado,
    // String pais,
    // int cp,
    // String escrituraOPermiso,
    // double estrellas,
    // String rfc,
    // String firmaElectronica,
    // String nombres,
    // String apellidos) {
    public static DetallesUsuario getTestDetalles() {
        return new DetallesUsuario(
                1,
                "Tulipanes",
                "Union Burocratica #1",
                "El Mante",
                "Tamaulipas",
                "Mexico",
                89810,
                null,
                5,
                null,
                null,
                "Pablo Alejandro",
                "Castillo Ramirez"
        );
    }
}
