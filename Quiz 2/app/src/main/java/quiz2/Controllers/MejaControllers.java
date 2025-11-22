package quiz2.Controllers;

import java.util.ArrayList;
import java.util.List;

import quiz2.Models.Bahan;
import quiz2.Models.Furniture;
import quiz2.Models.Meja;

public class MejaControllers {

    private static List<Meja> listMeja = new ArrayList<>();

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

        Meja meja = new Meja(berat, bahanUtama, adaSandaran);
        listMeja.add(meja);
    }

    public static void PrintAllKursi(){
        for (Meja meja : listMeja) {
            System.out.println(meja);
        }
    }
}
