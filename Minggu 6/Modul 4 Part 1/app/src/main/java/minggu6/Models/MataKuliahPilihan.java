package minggu6.Models;

public class MataKuliahPilihan extends MataKuliah {
    private int jumlahMinimal;

    public MataKuliahPilihan(String kode, String nama, int sks, int minimal) {
        super(kode, nama, sks);
        this.jumlahMinimal = minimal;
    }

    public int getJumlahMinimal() {
        return jumlahMinimal;
    }
    public void setJumlahMinimal(int inputMinimal) {
        this.jumlahMinimal = inputMinimal;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Jumlah Minimal SKS: " + jumlahMinimal + " SKS";
    }
    
}
