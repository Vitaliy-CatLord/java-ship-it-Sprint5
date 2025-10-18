package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.yandex.practicum.delivery.Parcels.FragileParcel;
import ru.yandex.practicum.delivery.Boxs.ParcelBox;
import ru.yandex.practicum.delivery.Parcels.PerishableParcel;
import ru.yandex.practicum.delivery.Parcels.StandardParcel;

public class DeliveryCostTest {
    StandardParcel standardParcel= new StandardParcel("testStandardName", 23, "testStandardAddress", 1);
    PerishableParcel perishableParcel = new PerishableParcel("testPerishableName", 19, "testPerishableAddress", 5, 10);
    FragileParcel  fragileParcel = new FragileParcel("testFragileName", 17, "testFragileAddress", 10);
    ParcelBox<StandardParcel> standardBox = new ParcelBox<>(46);

   //проверка расчета цен
    @Test
    public void shouldBe46WhenStandardAndWeight23() {
        Assertions.assertEquals(46, standardParcel.getCoast());
    }

    @Test
    public void shouldBe57WhenPerishableAndWeight19() {
        Assertions.assertEquals(57, perishableParcel.getCoast());
    }

    @Test
    public void shouldBe68WhenFragileAndWeight17() {
        Assertions.assertEquals(68, fragileParcel.getCoast());
    }


    //проверка работы сроков годности
    @Test
    public void shouldBeTrueAt10Day() {
        Assertions.assertTrue(perishableParcel.isExpired(10));
    }
    @Test
    public void shouldBeFalseAt15Day() {
        Assertions.assertFalse(perishableParcel.isExpired(15));
    }

    @Test
    public void shouldBeFalseAt20Day() {
        Assertions.assertFalse(perishableParcel.isExpired(20));
    }


    //проверка вместимости коробок по массе
    @Test
    public void shouldReturnIsAddedWhenHalfPackaged() {
        Assertions.assertEquals(standardBox.addParcel(standardParcel), "Посылка <" + standardParcel.getDescription() + "> упакована в коробку.");
    }

    @Test
    public void shouldReturnIsAddedWhenFullPackaged() {
        standardBox.addParcel(standardParcel);
        Assertions.assertEquals(standardBox.addParcel(standardParcel), "Посылка <" + standardParcel.getDescription() + "> упакована в коробку.");
    }

    @Test
    public void shouldReturnNotAddedWhenOverPackaged() {
        standardBox.addParcel(standardParcel);
        standardBox.addParcel(standardParcel);
        Assertions.assertEquals("Коробка переполнена, посылка не добавлена в коробку", standardBox.addParcel(standardParcel));
    }



}
