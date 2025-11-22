package minggu6.Models;

import java.util.ArrayList;
import java.util.List;

public class MatKulAjar {
    private MataKuliah matakuliah;
    private List<PresensiStaff> presensiStaff;

    public MatKulAjar(MataKuliah mk) {
        this.matakuliah = mk;
        this.presensiStaff = new ArrayList<>();
    }

    public MataKuliah getMatakuliah() {
        return matakuliah;
    }
    public void setMatakuliah(MataKuliah mk) {
        this.matakuliah = mk;
    }

    public List<PresensiStaff> getPresensiStaff() {
        return presensiStaff;
    }
    public void addPresensiStaff(PresensiStaff presensi) {
        presensiStaff.add(presensi);
    }

    @Override
    public String toString() {
        return super.toString() + "\nMata Kuliah: " + matakuliah.getNama() + "\n" +
                "Presensi Staff: " + presensiStaff.toString();
    }
}
