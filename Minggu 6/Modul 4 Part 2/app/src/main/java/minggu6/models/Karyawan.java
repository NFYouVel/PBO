package minggu6.models;

import java.util.ArrayList;
import java.util.List;

public class Karyawan extends Staff {
    private double salary;
    private List<PresensiStaff> presensiStaff;  

    public Karyawan(String nik, String nama, String tempatLahir, String tanggalLahir, String alamat, String telepon, double salary) {
        super(nik, nama, tempatLahir, tanggalLahir, alamat, telepon, UserType.KARYAWAN);
        this.salary = salary;
        this.presensiStaff = new ArrayList<>();
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<PresensiStaff> getPresensiStaff() {
        return presensiStaff;
    }
    public void addPresensiStaff(PresensiStaff presensiStaff) {
        this.presensiStaff.add(presensiStaff);
    }

    @Override
    public String toString() {
        return super.toString() + "Karyawan\n" +
               "Salary: " + salary + "\n" +
               "Presensi Staff: " + presensiStaff.toString();
    }


}
