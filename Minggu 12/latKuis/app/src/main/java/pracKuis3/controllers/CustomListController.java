package pracKuis3.controllers;


import pracKuis3.models.CustomList;
import pracKuis3.models.NegativeNumberException;

public class CustomListController {
    CustomList customList;

    public CustomListController() {
        customList = new CustomList<>();
    }

    public void addNumberToList(Number num) throws NegativeNumberException {
        customList.addNumber(num);
    }

    public int getTenPercentIndex(){
        int index = ((customList.getList().size() / 10) - 1) == -1 ? 0 : (customList.getList().size() / 10) - 1;
        return (int) customList.getList().get(index);
    }

    public CustomList getCustomList() {
        return customList;
    }
}
