package minggu6.Models;

import java.util.ArrayList;
import java.util.List;

public abstract class Dosen extends Staff{
    private String departemen;
    private List<MatKulAjar> matkulAjar;

    public Dosen(String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, String departemen, UserType userType) {
        super(nik, nama, tempatLahir, tanggalLahir, alamat, telepon, userType);
        this.departemen = departemen;
        this.matkulAjar = new ArrayList<>();
    }

    public String getDepartemen() {
        return departemen;
    }
    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public List<MatKulAjar> getMatkulAjar() {
        return matkulAjar;
    }
    public void addMatkulAjar(MatKulAjar matkulAjar) {
        this.matkulAjar.add(matkulAjar);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Departemen: " + departemen + "\n" +
               "Mata Kuliah Ajar: " + matkulAjar.toString();
    }

}
