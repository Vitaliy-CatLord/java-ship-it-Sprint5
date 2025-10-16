package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> parcelsStatus = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    checkStatus();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить статус доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        int parcelType;
        while (true) { //зациклил, тк при неверном выборе надоест заново вводить
            System.out.println("Выберите тип посылки: 1- стандартная, 2 - хрупкая, 3- быстропортящаяся");
            parcelType = Integer.parseInt(scanner.nextLine());
            if (parcelType==1 || parcelType==2 || parcelType==3) {
                break;
            } else {
                System.out.println("Неверно выбран тип посылки, выберете снова");
            }
        }

        System.out.println("Введите название посылки:");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес доставки:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите день отправления:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        if(parcelType == 1) {
            StandardParcel parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(parcel);
        } else if(parcelType == 2) {
            FragileParcel parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(parcel);
            parcelsStatus.add((Trackable) parcel);
        } else {  //if (parcelType == 3)
            System.out.println("Введите срок годности посылки:");
            int timeToLive = Integer.parseInt(scanner.nextLine());
            PerishableParcel parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
            allParcels.add(parcel);
        }

    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCoast = 0;
        for (Parcel parcel : allParcels) {
            totalCoast+= parcel.calculateDeliveryCost();
        }
        System.out.println("общая стоимость доставки: " + totalCoast);
    }

    private static void checkStatus() {
        // отслеживание точек логистики

        for (Trackable parcel : parcelsStatus) {
            System.out.println("Введите промежуточную точку доставки:");
            String logisticPoint = scanner.nextLine();
            parcel.reportStatus(logisticPoint);
            System.out.println();
        }

    }

}

