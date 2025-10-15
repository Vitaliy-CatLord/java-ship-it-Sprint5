package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {
    protected static int baseCoast = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem(Parcel parcel) {
        System.out.println("Посылка <" + parcel.getDescription() + "> обёрнута в защитную плёнку");
        System.out.println("Посылка <" + parcel.getDescription() + "> упакована");
    }
}
