// import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        System.out.println(hitungNilaiAkhir(5, 80));
        System.out.println(hitungNilaiAkhir(5, 80));
        System.out.println(hitungNilaiAkhir(5, 80));
        System.out.println(hitungNilaiAkhir(10, 30));

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Masukkan jumlah alfa: ");
        // int jumlahAlfa = sc.nextInt();
        // System.out.print("Masukkan nilai akhir: ");
        // int na = sc.nextInt();
    }

    public static double hitungNilaiAkhir(int jumlahAlfa, int nilaiAkhir){
        double total = nilaiAkhir;
        if (jumlahAlfa > 2) {
            total = nilaiAkhir - (5 * (jumlahAlfa - 2));
        }
        if (total < 0) {
            total = 0;
        }
        return total;
    }
}