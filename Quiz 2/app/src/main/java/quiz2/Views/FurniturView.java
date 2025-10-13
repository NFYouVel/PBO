package quiz2.Views;

import java.awt.print.Printable;

import quiz2.Controllers.KursiControllers;
import quiz2.Controllers.MejaControllers;
import quiz2.Util.CLIUtil;

public class FurniturView {

  public void render() {
    int menu = this.getMenuInput();// 1
    
    while (menu != 0) {

      if (menu == 2) {
        PrintAll();
        continue;
      }
      int subMenu = this.getMenuFurnitur(); // 2
      CLIUtil.getString();
      String bahan = this.getMenuBahan(); // Besi
      handleMenu(menu, subMenu, bahan);
      menu = this.getMenuInput();
    }
  }

 private void handleMenu(int menu, int subMenu, String bahan) {
    switch (menu) {
        case 1:
            switch (subMenu) {
                case 1:
                    MejaControllers.InputNewObject();
                    break;
                case 2:
                    String getData[];
                    getData = getMenuKursi();
                    KursiControllers.InputNewObject(getData, bahan);
                    break;
                case 3:
                    ObjectControllers.InputNewObject();
                    break;
                case 4:
                    ObjectControllers.InputNewObject();
                    break;
            }
            break;
        case 2:
            PrintAll();
            break;
        
    }
 }

  private void PrintAll(){
    KursiControllers.PrintAllKursi();
  }

  private String[] getMenuKursi(){
    System.out.println("Menu Detail Kursi: ");
    System.out.print("1. Masukkan berat kursi: ");
    String berat = CLIUtil.getString();
    System.out.print("2. Apakah ada sandaran(y/n)? ");
    String sandaran = CLIUtil.getString();

    String output[] = new String[2];
    output[0] = berat;
    output[1] = sandaran;
    return output;
  }

  private String[] getMenuMeja(){
    System.out.println("Menu Detail Kursi: ");
    System.out.print("1. Masukkan berat kursi: ");
    String berat = CLIUtil.getString();
    System.out.print("2. Jumlah Laci: ");
    String laci = CLIUtil.getString();

    String output[] = new String[2];
    output[0] = berat;
    output[1] = laci;
    return output;
  }

  private int getMenuInput() {
    System.out.println("Menu:");
    System.out.println("1. Tambah furnitur");
    System.out.println("2. Tampilkan semua");
    System.out.println("0. Keluar");
    System.out.print("Pilihanmu: ");
    return CLIUtil.getInt();
  }

  private int getMenuFurnitur() {
    System.out.println("Menu:");
    System.out.println("1. Meja");
    System.out.println("2. Kursi");
    System.out.println("3. Meja lipat");
    System.out.println("4. Sofa");
    System.out.println("0. Keluar");
    System.out.print("Pilihanmu: ");
    return CLIUtil.getInt();
  }

  private String getMenuBahan() {
    System.out.println("Bahan:");
    System.out.println("1. Besi");
    System.out.println("2. Kayu");
    System.out.println("3. Plastik");
    System.out.println("0. Keluar");
    System.out.print("Pilihanmu: ");
    return CLIUtil.getString();
  }
}
