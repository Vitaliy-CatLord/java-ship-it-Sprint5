package ru.yandex.practicum.delivery;

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

    public void packageItem(Parcel parcel) {
        System.out.println("Посылка <" + parcel.getDescription() + "> упакована");
    }

    public void deliver(Parcel parcel) {
        System.out.println("Посылка <" + parcel.getDescription() + "> доставлена по адресу " + parcel.getDeliveryAddress()  + ".");
    }

    public void calculateDeliveryCost(Parcel parcel) {
        System.out.println("Стоимость отправления = " + parcel.getWeight() * parcel.getBaseCoast() + ".");
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

    public int getBaseCoast() {
        return baseCoast;
    }
}
