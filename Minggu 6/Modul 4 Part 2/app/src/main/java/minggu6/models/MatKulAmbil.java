package minggu6.models;

import java.util.ArrayList;
import java.util.List;

public class MatKulAmbil {

    private MataKuliah matakuliah;
    private int n1;
    private int n2;
    private int n3;
    private List<Presensi> presensi;

    public MatKulAmbil(MataKuliah matakuliah, int n1, int n2, int n3) {
        this.matakuliah = matakuliah;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.presensi = new ArrayList<>();
    }

    public MataKuliah getMatakuliah() {
        return matakuliah;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public int getN3() {
        return n3;
    }

    public List<Presensi> getPresensi() {
        return presensi;
    }

    public void setMataKuliah(MataKuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public void addPresensi(Presensi presensi) {
        this.presensi.add(presensi);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mata Kuliah: ").append(matakuliah.getNama()).append("\n");
        sb.append("Nilai: N1=").append(n1).append(", N2=").append(n2).append(", N3=").append(n3).append("\n");
        sb.append("Presensi:\n");
        for (Presensi p : presensi) {
            sb.append("  - ").append(p.toString()).append("\n");
        }
        return sb.toString();
    }

}
