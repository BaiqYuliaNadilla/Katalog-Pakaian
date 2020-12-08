package com.La.salsabila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKoko, btnGamis;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }
    private void inisialisasiView(){
        btnKoko = findViewById(R.id.btn_buka_Koko);
        btnGamis = findViewById(R.id.btn_buka_Gamis);

        btnKoko.setOnClickListener(view -> bukaGaleri("Koko"));
        btnGamis.setOnClickListener(view -> bukaGaleri("Gamis"));
    }

    private void bukaGaleri(String jenisPakaian) {
        Log.d("MAIN", "Buka activity Pakaian");
        Intent intent = new Intent(this, GaleryActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisPakaian);
        startActivity(intent);
    }
}
