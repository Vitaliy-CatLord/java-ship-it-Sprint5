package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {

    protected int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
        baseCoast = 3;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    //странно, что не попросили в главное меню запихнуть, например в отслеживание статуса подпихнуть
    public boolean isExpired(int currentDay) {
        if (sendDay+timeToLive >= currentDay) {
            return false;
        } else {
            return true;
        }
    }

}
