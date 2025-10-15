package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    String description;
    int weight;
    String deliveryAddress;
    int sendDay;


    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem(Parcel parcel) {
        System.out.println("Посылка <" + parcel.description + "> упакована");
    }

    public void deliver(Parcel parcel) {
        System.out.println("Посылка <" + parcel.description + "> доставлена по адресу " + parcel.deliveryAddress + ".");
    }

    public void calculateDeliveryCost(Parcel parcel) {
        System.out.println("Стоимость отправления = " + parcel.weight * parcel.getBaseCoast() + ".");
    }

    public abstract  int getBaseCoast();
}
