package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {
    StandardParcel standardParcel= new StandardParcel("testStandardName", 23, "testStandardAddress", 1);
    PerishableParcel perishableParcel = new PerishableParcel("testPerishableName", 19, "testPerishableAddress", 5, 10);
    FragileParcel  fragileParcel = new FragileParcel("testFragileName", 17, "testFragileAddress", 10);
    ParcelBox<StandardParcel> standartBox = new ParcelBox<>(46);

   //проверка расчета цен
    @Test
    public void shouldBeWhenStandardAndWeight23() {
        Assertions.assertTrue(standardParcel.getCoast() == 46);
    }

    @Test
    public void shouldBeWhenPerishableAndWeight19() {
       Assertions.assertTrue(perishableParcel.getCoast() == 57);
    }

    @Test
    public void shouldBeWhenFragileAndWeight17() {
        Assertions.assertTrue(fragileParcel.getCoast() == 68);
    }


    //проверка работы сроков годности
    @Test
    public void shouldBeTrueAt10Day() {
        Assertions.assertTrue(perishableParcel.isExpired(10));
    }
    @Test
    public void shouldBeFalseAt15Day() {
        Assertions.assertTrue(perishableParcel.isExpired(15));
    }

    @Test
    public void shouldBeFalseAt20Day() {
        Assertions.assertTrue(perishableParcel.isExpired(20));
    }


    //проверка вместимости коробок по массе
    @Test
    public void shouldReturnIsAddedWhenHalfPackaged() {
        Assertions.assertEquals(standartBox.addParcel(standardParcel), "Посылка <" + standardParcel.getDescription() + "> упакована в коробку.");
    }

    @Test
    public void shouldReturnIsAddedWhenFullPackaged() {
        standartBox.addParcel(standardParcel);
        Assertions.assertEquals(standartBox.addParcel(standardParcel), "Посылка <" + standardParcel.getDescription() + "> упакована в коробку.");
    }

    @Test
    public void shouldReturnNotAddedWhenOverPackaged() {
        standartBox.addParcel(standardParcel);
        standartBox.addParcel(standardParcel);
        Assertions.assertEquals(standartBox.addParcel(standardParcel), "Коробка переполнена, посылка не добавлена в коробку");
    }



}
