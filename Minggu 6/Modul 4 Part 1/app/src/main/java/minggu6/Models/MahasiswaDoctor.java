package minggu6.Models;

public class MahasiswaDoctor extends Mahasiswa {
    private String judulDisertasi;
    private int ns1;
    private int ns2;
    private int ns3;

    public MahasiswaDoctor(String nim, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, String kodeJurusan, String judul, int n1, int n2, int n3) {
        super(nim, nama, tempatLahir, tanggalLahir, alamat, telepon, kodeJurusan);
        this.judulDisertasi = judul;
        this.ns1 = n1;
        this.ns2 = n2;
        this.ns3 = n3;
    }

    public String getJudulDisertasi() {
        return judulDisertasi;
    }
    public int getNs1() {
        return ns1;
    }
    public int getNs2() {
        return ns2;
    }
    public int getNs3() {
        return ns3;
    }

    public void setJudulDisertasi(String judulDisertasi) {
        this.judulDisertasi = judulDisertasi;
    }
    public void setNs1(int ns1) {
        this.ns1 = ns1;
    }
    public void setNs2(int ns2) {
        this.ns2 = ns2;
    }
    public void setNs3(int ns3) {
        this.ns3 = ns3;
    }


    @Override
    public String toString() {
        return super.toString() + "\nJudul Disertasi: " + judulDisertasi + "\n" +
               "Nilai: NS1=" + ns1 + ", NS2=" + ns2 + ", NS3=" + ns3;
    }
}
