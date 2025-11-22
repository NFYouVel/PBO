package pracKuis3.views;

import pracKuis3.controllers.CustomListController;
import pracKuis3.models.NegativeNumberException;
import pracKuis3.util.CLIUtil;

public class Menu {

    CustomListController customListController;

    public Menu() {
        customListController = new CustomListController();
    }

    public void render() throws NegativeNumberException {
        this.printMenu();
        int menu = CLIUtil.getInt();
        while (menu != 0) {
            switch (menu) {
                case 1:
                    this.handleInput();
                    break;
                case 2:
                    System.out.print(customListController.getCustomList().getList() + " -> ");
                    System.out.println(customListController.getTenPercentIndex());
                    break;
                case 0:
                    return;
            }
            this.printMenu();
            menu = CLIUtil.getInt();
        }
    }

    private void printMenu() {
        System.out.println("======= Menu Nilai Positif ========");
        System.out.println("1. Add Number to List");
        System.out.println("2. Print Number in List in 10% Index");
        System.out.println("0. Exit");
    }

    private void handleInput() throws NegativeNumberException {
        System.out.println("Masukkan Angka Positif: ");
        int num = CLIUtil.getInt();
        customListController.addNumberToList(num);
    }
}
