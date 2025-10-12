package minggu6.views;

import minggu6.util.CLIUtil;
import minggu6.views.mahasiswa.MahasiswaView;

public class MenuView {
    private MahasiswaView mahasiswaView;

    public MenuView() {
        this.mahasiswaView = new MahasiswaView();
    }

    public void render(){
        System.out.println("Menu SIA: ");
        System.out.println("1. Mahasiswa");


    }

    private void handleMenuInput(){
        int menuInput = CLIUtil.getInt();
        switch(menuInput){
            case 1:
                this.mahasiswaView.render();
                break;
            
        }
    }
}
