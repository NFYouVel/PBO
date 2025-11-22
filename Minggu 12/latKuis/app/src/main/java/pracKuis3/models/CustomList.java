package pracKuis3.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Number & Comparable<T>> {

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public CustomList(T value) {
        this.list = new ArrayList<T>();
    }

    public void addNumber(T input) throws NegativeNumberException {
        if (input.doubleValue() < 0) {
            throw new NegativeNumberException("Angka harus lebih besar dari 0");
        } else {
            this.list.sort(null);
            list.add(input);
        }

    }

    public List<T> getList() {
        return this.list;
    }

}
