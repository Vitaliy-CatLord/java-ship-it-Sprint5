package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel>  {
    protected int maxBoxWeight;
    protected int currentBoxWeight;

    public ParcelBox(int maxBoxWeight) {
        this.maxBoxWeight = maxBoxWeight;
        currentBoxWeight = 0;
    }

    private List<T> boxList = new ArrayList<>();

    public void addParcel(T parcel) {
        if ((currentBoxWeight+ parcel.getWeight()) <= maxBoxWeight) {
            boxList.add(parcel);
            currentBoxWeight+=parcel.getWeight();
            System.out.println("Посылка <" + parcel.getDescription() + "> упакована в коробку.");
        } else {
            System.out.println("Коробка переполнена, посылка не добавлена в коробку");
        }
        System.out.println();
    }

    public void getAllParcels() {
        System.out.println("В коробке находится:");
        for (T parcel : boxList) {
            System.out.println(parcel.getDescription());
        }
    }
}
