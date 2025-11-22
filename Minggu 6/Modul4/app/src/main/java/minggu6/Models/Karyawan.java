package minggu6.Models;

import java.util.ArrayList;
import java.util.List;

public class Karyawan {
    private double salary;
    private List<PresensiStaff> presensiStaff;  

    public Karyawan(double salary) {
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
