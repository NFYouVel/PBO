package minggu6.models;

public class Mahasiswa extends User {
    private String nim;
    private String kodeJurusan;

    public Mahasiswa(String nim, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, String kodeJurusan) {
        super(nama, tempatLahir, tanggalLahir, alamat, telepon, UserType.MAHASISWA);
        this.nim = nim;
        this.kodeJurusan = kodeJurusan;
    }

    public String getNim(){
        return nim;
    }
    public void setNim(String nim){
        this.nim = nim;
    }

    public String getKodeJurusan(){
        return kodeJurusan;
    }
    public void setKodeJurusan(String kodeJurusan){
        this.kodeJurusan = kodeJurusan;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n" +
               "NIM: " + nim + "\n" +
               "Kode Jurusan: " + kodeJurusan;
    }
}

