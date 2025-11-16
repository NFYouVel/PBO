package minggu6.models;

public class MataKuliah {
    private String kode;
    private int sks;
    private String nama;

    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }


    public void setKode(String kode) {
        this.kode = kode;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setSks(int sks) {
        this.sks = sks;
    }
    
    @Override
    public String toString() {
        return "Kode: " + kode + "\n" +
               "Nama: " + nama + "\n" +
               "SKS: " + sks;
    }
}
