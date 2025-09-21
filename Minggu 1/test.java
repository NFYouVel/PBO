
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Jurusan {
    String kode;
    String nama;
    ArrayList<MataKuliah> mataKuliahList;
}

class Mahasiswa {
    String nim;
    String nama;
    Jurusan jurusan;
    Map<MataKuliah, String> indeksNilai;
}

class MataKuliah {
    String kode;
    String nama;
    int sks;
}

class modul1_no1 {
    static ArrayList<Jurusan> listJurusan = new ArrayList<>();
    static ArrayList<MataKuliah> listMk = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void dataDummy(){
        Jurusan j1 = new Jurusan();
        j1.nama = "Informatika";
        j1.kode = "1";
        listJurusan.add(j1);

        Jurusan j2 = new Jurusan();
        j2.nama = "Online Bisnis";
        j2.kode = "2";
        listJurusan.add(j2);

        Jurusan j3 = new Jurusan();
        j3.nama = "Sistem Informasi";
        j3.kode = "3";
        listJurusan.add(j3);

        MataKuliah mk1 = new MataKuliah();
        mk1.kode = "a";
        mk1.nama = "Algo";
        mk1.sks = 4;
        listMk.add(mk1);

        MataKuliah mk2 = new MataKuliah();
        mk2.kode = "b";
        mk2.nama = "Indo";
        mk2.sks = 2;
        listMk.add(mk2);
    }

    public static void cekJurusan() {
        System.out.println("1. Input Jurusan Baru");
        System.out.println("2. Daftar Jurusan");
        System.out.println("3. Menghapus Jurusan");
        System.out.print("Masukan pilihan dlm bentuk angka (0 = exit)): ");
        int pilihan = sc.nextInt();
        sc.nextLine();

        while (pilihan != 0) {
            Jurusan j = new Jurusan();
            if (pilihan == 1) {
                System.out.print("Masukkan nama jurusan: ");
                j.nama = sc.nextLine();
                System.out.print("Masukkan kode jurusan: ");
                j.kode = sc.nextLine();
                listJurusan.add(j);
                System.out.println("jurusan berhasil di input");
    
            } else if (pilihan == 2) {
                for (int i = 0; i < listJurusan.size(); i++) {
                    j = listJurusan.get(i);
                    System.out.println((i+1) + ". " + j.kode + " - " + j.nama + "\n");
                }
            } else if (pilihan == 3) {
                System.out.print("Masukan kode jurusan yang akan dihapus: ");
                String jurusanDihapus = sc.nextLine();
                for (int i = 0; i < listJurusan.size(); i++) {
                    if (listJurusan.get(i).kode.equalsIgnoreCase(jurusanDihapus)) {
                        listJurusan.remove(i);
                        System.out.println("berhasil dihapus");
                        break;
                    } 
                }
                System.out.println("Jurusan tidak terdaftar");
            } else {
                System.out.println("error");
            }
            System.out.print("Masukan pilihan (bentuk angka): ");
            pilihan = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void cekMataKuliah(){
        System.out.println("1. Input Mata Kuliah Baru");
        System.out.println("2. Menghapus Mata kuliah");
        System.out.println("3. Menambahkan mata kuliah kedalam jurusan");
        System.out.println("4. List matakuliah");
        System.out.print("Masukan pilihan dlm bentuk angka (0 = exit)): ");
        int pilihan = sc.nextInt();
        sc.nextLine();

        while (pilihan != 0) {
            MataKuliah mk = new MataKuliah();
            if (pilihan == 1) {
                System.out.print("Masukkan Kode Matakuliah: ");
                mk.kode = sc.nextLine();
                System.out.print("Masukkan nama mata kuliah: ");
                mk.nama = sc.nextLine();
                listMk.add(mk);
            } else if (pilihan == 2) {
                System.out.print("Masukkan kode mata kuliah: ");
                String kodeDelete = sc.nextLine();
                for (int i = 0; i < listMk.size(); i++) {
                    if (listMk.get(i).kode.equalsIgnoreCase(kodeDelete)) {
                        listMk.remove(i);
                        System.out.println("Berhasil dihapus");
                    }
                }
            } else if (pilihan == 3) {
                System.out.print("Masukkan kode matakuliah: ");
                String kodeMk = sc.nextLine();
                
                MataKuliah temp = new MataKuliah();
                temp.kode = kodeMk;

                System.out.print("Masukkan kode jurusan: ");
                String kodeJ = sc.nextLine();

                for (int i = 0; i < listJurusan.size(); i++) {
                    Jurusan current = listJurusan.get(i);
                    if (current.kode.equalsIgnoreCase(kodeJ)) {
                        current.mataKuliahList.add(temp);
                    }
                }
            } else if (pilihan == 4) {
                for (int i = 0; i < listMk.size(); i++) {
                    mk = listMk.get(i);
                    System.out.println((i+1) + ". " + mk.kode + " - " + mk.nama + " - " + mk. sks + " sks\n");
                }
            }
            System.out.print("Masukan pilihan dlm bentuk angka (0 = exit)): ");
            pilihan = sc.nextInt();
            sc.nextLine();
        }
    }

    
    public static void main(String[] args) {
        // dataDummy();
        // cekJurusan();
        // cekMataKuliah();

        System.out.print("Menu: \n 1. Jurusan \n 2. Matakuliah \n 3. Exit \n Masukan angka: ");
        int pil = sc.nextInt();

        while (pil != 3) {
            dataDummy();
            switch (pil) {
                case 1:
                    cekJurusan();
                    break;
                case 2:
                    cekMataKuliah();
                    break;
                default:
                    break;
            }
        }
    }
}