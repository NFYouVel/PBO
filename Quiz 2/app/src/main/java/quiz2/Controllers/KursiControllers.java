package quiz2.Controllers;

import java.util.ArrayList;
import java.util.List;

import quiz2.Models.Bahan;
import quiz2.Models.Furniture;
import quiz2.Models.Kursi;

public class KursiControllers {

    private static List<Kursi> listKursi = new ArrayList<>();

    public static void InputNewObject(String[] inputBeratDanSandaran, String bahan){
        Bahan bahanUtama = null;
        String berat = inputBeratDanSandaran[0];
        if (bahan.equalsIgnoreCase("besi")) {
            bahanUtama = bahanUtama.BESI;
        } else if (bahan.equalsIgnoreCase("kayu")) {
            bahanUtama = bahanUtama.KAYU;
        } else {
            bahanUtama = bahanUtama.PLASTIK;
        }

        boolean adaSandaran;
        adaSandaran = !inputBeratDanSandaran[1].equalsIgnoreCase("n");

        Kursi kursi = new Kursi(berat, bahanUtama, adaSandaran);
        listKursi.add(kursi);
    }

    public static void PrintAllKursi(){
        for (Kursi kursi : listKursi) {
            System.out.println(kursi);
        }
    }
}
