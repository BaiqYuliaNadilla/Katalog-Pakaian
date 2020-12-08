package com.La.salsabila;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.La.salsabila.Model.Pakaian;

import java.util.List;

public class GaleryActivity extends AppCompatActivity {

    List<Pakaian> pakaians;
    int indeksTampil = 0;
    String jenisPakaian;
    Button btnPertama, btnTerakhir, btnSebelumnya, btnBerikutnya;
    TextView txMerek, txHarga, txDeskripsi, txJudul;
    ImageView ivFotoPakaian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galery_activity);
        Intent intent = getIntent();
        jenisPakaian = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        pakaians = DataProvider.getPakaiansByTipe(this, jenisPakaian);
        inisialisasiView();
        tampilkanProfil();

    }
    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> pakaianPertama());
        btnTerakhir.setOnClickListener(view -> pakaianTerakhir());
        btnSebelumnya.setOnClickListener(view -> pakaianSebelumnya());
        btnBerikutnya.setOnClickListener(view -> pakaianBerikutnya());

        txMerek = findViewById(R.id.txMerek);
        txHarga = findViewById(R.id.txHarga);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoPakaian = findViewById(R.id.gambarPakaian);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Pakaian " +jenisPakaian);
    }

    private void tampilkanProfil() {
        Pakaian k = pakaians.get(indeksTampil);
        Log.d("Gamis", "Menampilkan gamis " + k.getMerek());
        txMerek.setText(k.getMerek());
        txHarga.setText(k.getHarga());
        txDeskripsi.setText(k.getDeskripsi());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivFotoPakaian.setImageDrawable(this.getDrawable(k.getDrawableRes()));
        }
    }

    private void pakaianPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this, "Sudah di posisi pertama", Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void pakaianTerakhir() {
        int posAkhir = pakaians.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this, "Sudah di posisi terakhir", Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void pakaianBerikutnya() {
        if (indeksTampil == pakaians.size() - 1) {
            Toast.makeText(this, "Sudah di posisi terakhir", Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void pakaianSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this, "Sudah di posisi pertama", Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }

    }
}
