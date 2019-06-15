package com.example.agrostore01;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

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

    @SuppressLint("ClickableViewAccessibility")
    public static void setListViewScrollInsideScrollView(ListView listView) {
        listView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;

        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public static void setListViewShowableAmountOfItems(ListView listView, int showableAmountOfItems) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;

        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = (totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1))) * showableAmountOfItems;
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}
