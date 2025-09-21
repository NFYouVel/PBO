import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class Jurusan {
    String kode;
    String nama;
    ArrayList<MataKuliah> matkul = new ArrayList<>();
    Jurusan next;
}

class Mahasiswa {
    String nim;
    String nama;
    Jurusan jurusan;
    Map<MataKuliah, String> indeksnilai;
}

class MataKuliah {
    String kode;
    String nama;
    int sks;
}

public class Modul1 {
    static Jurusan headJurusan = null;
    static Jurusan tailJurusan = null;
    static ArrayList<MataKuliah> matkulList = new ArrayList<>();
    static ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

    public static void main(String[] args) {
        Dummy();
        ViewJurusan();
        Menu();
    }

    // Menu
    public static void Menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Jurusan");
            System.out.println("2. Mata Kuliah");
            System.out.println("3. Mahasiswa");
            System.out.println("4. Exit");
            System.out.print("Pilih menu: ");
            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                System.out.println("\n--- MENU JURUSAN ---");
                System.out.println("1. Input Jurusan Baru");
                System.out.println("2. View Jurusan");
                System.out.println("3. Delete Jurusan");
                System.out.print("Pilih: ");
                int sub = sc.nextInt();
                sc.nextLine();

                if (sub == 1) {
                    System.out.print("Kode jurusan: ");
                    String kode = sc.nextLine();
                    System.out.print("Nama jurusan: ");
                    String nama = sc.nextLine();
                    System.out.print("Jumlah mata kuliah: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    MataKuliah[] temp = new MataKuliah[n];
                    for (int i = 0; i < n; i++) {
                        MataKuliah mk = new MataKuliah();
                        System.out.print("Kode MK: ");
                        mk.kode = sc.nextLine();
                        System.out.print("Nama MK: ");
                        mk.nama = sc.nextLine();
                        System.out.print("SKS: ");
                        mk.sks = sc.nextInt();
                        sc.nextLine();
                        temp[i] = mk;

                        matkulList.add(mk);
                    }
                    InputJurusan(kode, nama, temp);
                    System.out.println("Jurusan berhasil ditambahkan!");

                } else if (sub == 2) {
                    ViewJurusan();
                } else if (sub == 3) {
                    System.out.print("Kode jurusan yg mau dihapus: ");
                    String kode = sc.nextLine();
                    DeleteJurusan(kode);
                }

            } else if (menu == 2) {
                // Submenu Mata Kuliah
                System.out.println("\n--- MENU MATA KULIAH ---");
                System.out.println("1. Input Mata Kuliah Baru");
                System.out.println("2. View Mata Kuliah");
                System.out.println("3. Delete Mata Kuliah");
                System.out.print("Pilih: ");
                int sub = sc.nextInt();
                sc.nextLine();

                if (sub == 1) {
                    System.out.print("Kode MK: ");
                    String kode = sc.nextLine();
                    System.out.print("Nama MK: ");
                    String nama = sc.nextLine();
                    System.out.print("SKS: ");
                    int sks = sc.nextInt();
                    sc.nextLine();

                    InputMatakuliah(kode, nama, sks);
                    System.out.println("Mata kuliah berhasil ditambahkan!");
                } else if (sub == 2) {
                    for (MataKuliah mk : matkulList) {
                        System.out.println(mk.kode + " - " + mk.nama + " (" + mk.sks + " SKS)");
                    }
                } else if (sub == 3) {
                    System.out.print("Kode MK yg mau dihapus: ");
                    String kode = sc.nextLine();
                    DeleteMatakuliah(kode);
                }

            } else if (menu == 3) {
                // Submenu Mahasiswa
                System.out.println("\n--- MENU MAHASISWA ---");
                System.out.println("1. Input Mahasiswa Baru");
                System.out.println("2. View Mahasiswa");
                System.out.println("3. Detail & Hitung IP");
                System.out.print("Pilih: ");
                int sub = sc.nextInt();
                sc.nextLine();

                if (sub == 1) {
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Kode jurusan: ");
                    String kodeJur = sc.nextLine();

                    Jurusan jur = headJurusan;
                    while (jur != null) {
                        if (jur.kode.equalsIgnoreCase(kodeJur))
                            break;
                        jur = jur.next;
                    }

                    if (jur != null) {
                        InputMahasiswa(nim, nama, jur);
                        mahasiswaList.get(mahasiswaList.size() - 1).indeksnilai = new java.util.HashMap<>();
                        System.out.println("Mahasiswa berhasil ditambahkan!");
                    } else {
                        System.out.println("Jurusan tidak ditemukan!");
                    }

                } else if (sub == 2) {
                    ViewMahasiswa();
                } else if (sub == 3) {
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = sc.nextLine();
                    for (Mahasiswa mhs : mahasiswaList) {
                        if (mhs.nim.equalsIgnoreCase(nim)) {
                            System.out.println("Detail Mahasiswa: " + mhs.nama);
                            for (Map.Entry<MataKuliah, String> e : mhs.indeksnilai.entrySet()) {
                                System.out.println(e.getKey().kode + " - " + e.getKey().nama + " : " + e.getValue());
                            }
                            System.out.println("IP: " + CountIP(nim));
                        }
                    }
                }

            } else if (menu == 4) {
                System.out.println("Keluar...");
                break;
            }
        }

        sc.close();
    }

    // Count IP
    public static double CountIP(String input_nim) {
        int totalSKS = 0;
        int totalPembilang = 0;

        for (Mahasiswa searchIP : mahasiswaList) {
            if (searchIP.nim.equalsIgnoreCase(input_nim)) {
                if (searchIP.indeksnilai == null)
                    continue;

                for (Map.Entry<MataKuliah, String> entry : searchIP.indeksnilai.entrySet()) {
                    MataKuliah mk = entry.getKey();
                    String index = entry.getValue();

                    totalSKS += mk.sks;

                    int ina;
                    if (index.equalsIgnoreCase("A"))
                        ina = 4;
                    else if (index.equalsIgnoreCase("B"))
                        ina = 3;
                    else if (index.equalsIgnoreCase("C"))
                        ina = 2;
                    else if (index.equalsIgnoreCase("D"))
                        ina = 1;
                    else
                        ina = 0;

                    totalPembilang += mk.sks * ina;
                }
                break;
            }
        }

        if (totalSKS == 0)
            return 0.0;

        return (double) totalPembilang / totalSKS;
    }

    // Count Nilai
    public static int InputNilai(int input_nilai, String input_kode_mk, String nim) {
        int count = 0;
        String idx;
        if (input_nilai >= 80) {
            idx = "A";
        } else if (input_nilai >= 68) {
            idx = "B";
        } else if (input_nilai >= 56) {
            idx = "C";
        } else if (input_nilai >= 50) {
            idx = "D";
        } else {
            idx = "E";
        }

        int tempIDX = -1;
        for (int i = 0; i < matkulList.size(); i++) {
            MataKuliah current = matkulList.get(i);
            if (current.kode.equalsIgnoreCase(input_kode_mk)) {
                tempIDX = i;
                break;
            }
        }
        if (tempIDX == -1) {
            System.out.println("Tidak ada Mata Kuliah dengan kode: " + input_kode_mk);
            return 0;
        }

        int mhsSize = mahasiswaList.size();
        while (count != mhsSize) {
            Mahasiswa current = mahasiswaList.get(count);
            if (current.nim.equalsIgnoreCase(nim)) {
                current.indeksnilai.put(matkulList.get(tempIDX), idx);
            }
            count++;
        }

        if (count == mhsSize) {
            System.out.println("Tidak ada mahasiswa dengan NIM: " + nim);
            return 0;
        }
        return 1;
    }

    // Mahasiswa
    public static int InputMahasiswa(String input_nim, String input_nama, Jurusan input_jurusan) {
        Mahasiswa temp = new Mahasiswa();
        temp.nim = input_nim;
        temp.nama = input_nama;
        temp.jurusan = input_jurusan;

        mahasiswaList.add(temp);
        return 0;
    }

    public static void ViewMahasiswa() {
        for (int i = 0; i < mahasiswaList.size(); i++) {
            Mahasiswa current = mahasiswaList.get(i);
            System.out.println("Mahasiswa ke-" + (i + 1) + "\nNama: " + current.nama);
            System.out.println("--------------------------");

        }
    }

    public static void DetailMahasiswa(String input_nim) {
        int count = 0;
        while (true) {
            Mahasiswa current = mahasiswaList.get(count);
            if (current == null) {
                break;
            }
            if (current.nim.equalsIgnoreCase(input_nim)) {
                System.out.println("Mahasiswa ke-" + (count + 1) + ":\nNim: " + current.nim + "\nNama: " + current.nama
                        + "\nJurusan: " + current.jurusan.nama);
                System.out.println("--------------------------");
            }
            count++;
        }
    }

    // Mata Kuliah
    public static int InputMatakuliah(String kodeMatkul, String namaMatkul, int temp_sks) {
        MataKuliah matkul = new MataKuliah();
        matkul.kode = kodeMatkul;
        matkul.nama = namaMatkul;
        matkul.sks = temp_sks;

        matkulList.add(matkul);
        return 0;
    }

    public static int DeleteMatakuliah(String search) {
        if (matkulList.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang ditambahkan.");
        }

        for (int i = 0; i < matkulList.size(); i++) {
            MataKuliah current = matkulList.get(i);
            if (current.kode.equalsIgnoreCase(search)) {
                matkulList.remove(i);
            }
            ;

        }
        return 0;
    }

    public static int AddMatakuliahToJurusan(String kodeMatkul, String namaMatkul, int temp_sks, String kode_jurusan) {
        MataKuliah temp_matkul = new MataKuliah();
        temp_matkul.kode = kodeMatkul;
        temp_matkul.nama = namaMatkul;
        temp_matkul.sks = temp_sks;

        Jurusan current = headJurusan;
        while (current != null) {
            if (current.kode.equalsIgnoreCase(kode_jurusan)) {
                current.matkul.add(temp_matkul);
                break;
            }
            current = current.next;
        }

        return 0;
    }

    // Jurusan
    public static int InputJurusan(String kodeJurusan, String namaJurusan, MataKuliah[] temp_MataKuliah) {
        Jurusan jurusan = new Jurusan();
        jurusan.kode = kodeJurusan;
        jurusan.nama = namaJurusan;
        for (int i = 0; i < temp_MataKuliah.length; i++) {
            jurusan.matkul.add(temp_MataKuliah[i]);
        }
        if (headJurusan == null) {
            headJurusan = jurusan;
            tailJurusan = jurusan;
        } else {
            tailJurusan.next = jurusan;
            tailJurusan = jurusan;
        }
        return 0;
    }

    public static void ViewJurusan() {
        Jurusan current = headJurusan;
        int count = 0;
        while (current != null) {
            count++;
            System.out.println("Jurusan ke-" + count + ":\nCode: " + current.kode + "\nNama: " + current.nama);
            System.out.println("--------------------------");
            current = current.next;
        }
    }

    public static int DeleteJurusan(String search) {
        if (headJurusan == null) {
            return 0;
        }

        if (headJurusan.kode.equalsIgnoreCase(search)) {
            headJurusan = headJurusan.next;
            if (headJurusan == null) {
                tailJurusan = null;
            }
            return 1;
        }

        Jurusan current = headJurusan;
        while (current.next != null) {
            if (current.next.kode.equalsIgnoreCase(search)) {
                if (current.next == tailJurusan) {
                    tailJurusan = current;
                }
                current.next = current.next.next;
                return 1;
            }
            current = current.next;
        }

        return 0;
    }

    public static void Dummy() {
        System.out.println("===== TEST INPUT JURUSAN =====");
        MataKuliah[] matkulTI = {
                new MataKuliah() {
                    {
                        kode = "TI301";
                        nama = "Basis Data";
                        sks = 3;
                    }
                },
                new MataKuliah() {
                    {
                        kode = "TI302";
                        nama = "Jaringan Komputer";
                        sks = 2;
                    }
                }
        };
        InputJurusan("TI", "Teknik Informatika", matkulTI);

        ViewJurusan();

        for (MataKuliah mk : matkulTI) {
            matkulList.add(mk);
        }

        System.out.println("\n===== TEST INPUT MATKUL GLOBAL =====");
        InputMatakuliah("UM101", "Bahasa Indonesia", 2);
        InputMatakuliah("UM102", "Pancasila", 2);
        for (MataKuliah mk : matkulList) {
            System.out.println(mk.kode + " - " + mk.nama + " (" + mk.sks + " sks)");
        }

        System.out.println("\n===== TEST ADD MATKUL TO JURUSAN =====");
        AddMatakuliahToJurusan("TI401", "Pemrograman Java", 3, "TI");

        Jurusan current = headJurusan;
        while (current != null) {
            if (current.kode.equalsIgnoreCase("TI")) {
                System.out.println("Matkul di jurusan TI:");
                for (MataKuliah mk : current.matkul) {
                    System.out.println("- " + mk.kode + " " + mk.nama + " (" + mk.sks + " sks)");
                }
            }
            current = current.next;
        }

        System.out.println("\n===== TEST DELETE MATKUL GLOBAL =====");
        DeleteMatakuliah("UM101");
        for (MataKuliah mk : matkulList) {
            System.out.println(mk.kode + " - " + mk.nama);
        }

        // System.out.println("\n===== TEST DELETE JURUSAN =====");
        // DeleteJurusan("TI");
        // ViewJurusan();

        System.out.println("\n===== TEST INPUT MAHASISWA =====");

        Jurusan jurusanTI = headJurusan;

        InputMahasiswa("12345", "Marvel", jurusanTI);
        InputMahasiswa("67890", "Leonard", jurusanTI);

        for (Mahasiswa mhs : mahasiswaList) {
            mhs.indeksnilai = new java.util.HashMap<>();
        }

        InputNilai(85, "TI301", "12345");
        InputNilai(70, "TI302", "12345");
        InputNilai(60, "TI301", "67890");

        System.out.println("\n===== VIEW MAHASISWA =====");
        ViewMahasiswa();

        System.out.println("\n===== DETAIL & HITUNG IP =====");
        for (Mahasiswa mhs : mahasiswaList) {
            System.out.println("Detail Mahasiswa:");
            System.out.println("NIM: " + mhs.nim);
            System.out.println("Nama: " + mhs.nama);

            for (Map.Entry<MataKuliah, String> entry : mhs.indeksnilai.entrySet()) {
                MataKuliah mk = entry.getKey();
                String nilai = entry.getValue();
                System.out.println("  " + mk.kode + " - " + mk.nama + " (" + mk.sks + " SKS) : " + nilai);
            }

            double ip = CountIP(mhs.nim);
            System.out.println("IP: " + ip);
            System.out.println("--------------------------");
        }
    }

}