package ru.yandex.practicum.delivery.Parcels;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    protected int baseCoast;
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;


    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <" + getDescription() + "> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <" + getDescription() + "> доставлена по адресу " + getDeliveryAddress()  + ".");
    }

    public int calculateDeliveryCost() {
        System.out.println("Стоимость отправления " + getDescription() + " = " + getCoast() + ".");
        return getCoast();
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int getCoast() {
        return weight * baseCoast;
    }
}
