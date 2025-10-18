package ru.yandex.practicum.delivery.Boxs;

import ru.yandex.practicum.delivery.Parcels.Parcel;

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

    public String addParcel(T parcel) {
        String result;
        if ((currentBoxWeight+ parcel.getWeight()) <= maxBoxWeight) {
            boxList.add(parcel);
            currentBoxWeight+=parcel.getWeight();
            result = "Посылка <" + parcel.getDescription() + "> упакована в коробку.";
        } else {
            result = "Коробка переполнена, посылка не добавлена в коробку";
        }
        return result;

    }

    public void getAllParcels() {
        System.out.println("В коробке находится:");
        for (T parcel : boxList) {
            System.out.println(parcel.getDescription());
        }
    }
}
