package com.example.MobileDevelopPractice.viewmodels;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.MobileDevolopPractice.R;

public class ServiceNew extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        final WindowManager.LayoutParams params = new
                WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);


        View rootView = LayoutInflater.from(this).inflate(R.layout.overlay, null);

        ((TextView) rootView.findViewById(R.id.overlayTextView)).setText(intent.getStringExtra("email"));

        windowManager.addView(rootView, params);
        params.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER;
        windowManager.updateViewLayout(rootView, params);

        rootView.findViewById(R.id.closeOverlayBtn).setOnClickListener(v -> {
            windowManager.removeView(rootView);
            stopSelf();
        });
        return super.onStartCommand(intent, flags, startId);
    }
}
