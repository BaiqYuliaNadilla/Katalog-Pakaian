package com.La.salsabila;

import android.content.Context;

import com.La.salsabila.Model.Gamis;
import com.La.salsabila.Model.Koko;
import com.La.salsabila.Model.Pakaian;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Pakaian> pakaians = new ArrayList<>();

    private static List<Koko> initDataKoko(Context ctx) {
        List<Koko> kokos = new ArrayList<>();
        kokos.add(new Koko("zoya ", "Rp 399.900.00",
                "Berat 230 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional ", R.drawable.koko_zoya));
        kokos.add(new Koko("samase ", "Rp 279.000.00",
                "Berat 500 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional ", R.drawable.koko_samase));
        kokos.add(new Koko("rabbani ", "Rp 274.800.00",
                "Berat 250 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional ", R.drawable.koko_rabbani));
        kokos.add(new Koko("gera hawa ", "Rp 599.000.00",
                "Berat 500 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional ", R.drawable.koko_gera_hawa));
        kokos.add(new Koko("elzatta ", "Rp 329.000.00",
                "Berat 250 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional", R.drawable.koko_elzatta));
        return kokos;
    }

    private static List<Gamis> initDataGamis(Context ctx) {
        List<Gamis> gamiss = new ArrayList<>();
        gamiss.add(new Gamis("amima", "Rp 259.000.00",
                "Berat 500 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional ", R.drawable.gamis_amima));
        gamiss.add(new Gamis("cassie label", "Rp 299.800.00",
                "Berat 375 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional ", R.drawable.gamis_cassie_label));
        gamiss.add(new Gamis("zazira", "Rp 355.000.00",
                "Berat 600 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional", R.drawable.gamis_zazira));
        gamiss.add(new Gamis("jasmine", "Rp 299.000.00",
                "Berat 500 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional ", R.drawable.gamis_jasmine));
        gamiss.add(new Gamis("yasmeera", "Rp 245.000.00",
                "Berat 500 gr \n" +
                        "Kondisi baru \n" +
                        "Asuransi opsional ", R.drawable.gamis_yasmeera));
        return gamiss;
    }

    private static void initAllPakaians(Context ctx) {
        pakaians.addAll(initDataKoko(ctx));
        pakaians.addAll(initDataGamis(ctx));
    }

    public static List<Pakaian> getAllPakaian(Context ctx) {
        if (pakaians.size() == 0) {
            initAllPakaians(ctx);
        }
        return pakaians;
    }

    public static List<Pakaian> getPakaiansByTipe(Context ctx, String jenis) {
        List<Pakaian> pakaiansByType = new ArrayList<>();
        if (pakaians.size() == 0) {
            initAllPakaians(ctx);
        }
        for (Pakaian h : pakaians) {
            if (h.getJenis().equals(jenis)) {
                pakaiansByType.add(h);
            }
        }
        return pakaiansByType;
    }
}