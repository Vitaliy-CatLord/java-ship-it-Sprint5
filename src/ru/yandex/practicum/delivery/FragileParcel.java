package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {


    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
        baseCoast = 4;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <" + getDescription() + "> обёрнута в защитную плёнку");
        System.out.println("Посылка <" + getDescription() + "> упакована");
    }

    //честно говоря, глобально очень странная логика задания с указанием нового места самому
    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <" + getDescription() + "> изменила местоположение на " + newLocation + ".");
    }
}
