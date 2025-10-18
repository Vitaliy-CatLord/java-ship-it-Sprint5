package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.boxs.ParcelBox;
import ru.yandex.practicum.delivery.interfaces.Trackable;
import ru.yandex.practicum.delivery.parcels.FragileParcel;
import ru.yandex.practicum.delivery.parcels.Parcel;
import ru.yandex.practicum.delivery.parcels.PerishableParcel;
import ru.yandex.practicum.delivery.parcels.StandardParcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> parcelsStatus = new ArrayList<>();
    private static ParcelBox<StandardParcel> standartBox = new ParcelBox<>(50);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(15);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(25);

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
                case 5:
                    checkBox();
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
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже
    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        int parcelType;
        while (true) { //зациклил, тк при неверном выборе надоест перевводить все,  в идеале для каждого ввода сделать бы
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

        switch (parcelType) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                System.out.println(standartBox.addParcel(standardParcel));
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                parcelsStatus.add((Trackable) fragileParcel);
                System.out.println(fragileBox.addParcel(fragileParcel));
                break;
            case 3:
                System.out.println("Введите срок годности посылки:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                System.out.println(perishableBox.addParcel(perishableParcel));
                break;
            default:
                System.out.println("Неверный выбор.");
        }
        System.out.println();

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
        System.out.println("Общая стоимость доставки: " + totalCoast);
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

    private static void checkBox() {
        // анбоксинг
        System.out.println("Выберите тип коробки с посылками: 1- стандартная, 2 - хрупкая, 3- быстропортящаяся");
        int boxType = Integer.parseInt(scanner.nextLine());
        switch (boxType) {
            case 1:
                standartBox.getAllParcels();
                break;
            case 2:
                fragileBox.getAllParcels();
                break;
            case 3:
                perishableBox.getAllParcels();
                break;
            default:
                System.out.println("Неверный выбор.");
        }
        System.out.println();
    }

}

