package com.example.agrostore01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.agrostore01.CapaEntidades.DetallesUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;

import java.io.ByteArrayOutputStream;

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

    public static DetallesUsuario getTestDetalles() {
        return new DetallesUsuario(
                1,
                "Pablo Alejandro",
                "Castillo Ramirez",
                "Tulipanes",
                "Union Burocratica #1",
                "Tamaulipas",
                "Mexico",
                89810,
                null,
                5,
                null,
                null,
                "El Mante",
                "97-11-13"
        );
    }

    public static byte[] bitmapToByteArray(Bitmap bmp) {
        if (bmp == null)
            return null;

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static Bitmap byteArrayToBitmap(byte[] image) {
        if (image == null)
            return null;

        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public static void setImageViewByteArray(ImageView imageView, byte[] image) {
        if (image == null)
            return;

        Bitmap bmp = byteArrayToBitmap(image);
        if (bmp == null)
            return;

        imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, imageView.getWidth(), imageView.getHeight(), false));
    }

}
