package minggu6.models;

public class Presensi {
    private String tanggal;
    private int status; // 1 = hadir, 0 = tidak hadir

    public Presensi(String tanggal, int status) {
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Status getStatus() {
        if (status == 1) {
            return Status.HADIR;
        } else {
            return Status.TIDAK_HADIR;
        }
    }


    public void setStatus(int input){
        this.status = input;
    }

    @Override
    public String toString(){
        return "Tanggal: " + tanggal + "\n" +
               "Status: " + status;
    }
}
