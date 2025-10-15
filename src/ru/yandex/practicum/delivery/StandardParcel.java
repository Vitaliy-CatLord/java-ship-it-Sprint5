package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{
    protected static int baseCoast = 2;
    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);

    }


}
