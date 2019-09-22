package xyz.guoxingwu.coderhotel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelClockTest {

    @Test
    void updateTime() {
        PhoneClock phoneClock = new PhoneClock(20,20,20);
        List<String> cityList = Arrays.asList("����","�׶�","Ī˹��","Ϥ��","ŦԼ");
        for (String city:cityList
             ) {
            HotelClock hotelClock = new HotelClock(10,10,10,city,phoneClock);
            hotelClock.updateTime();
            switch (hotelClock.getPlace()) {
                case "����":{
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(0,phoneClock.getHour()-hotelClock.getHour()),
                            () -> assertEquals(0,phoneClock.getMinute()-hotelClock.getMinute()),
                            () -> assertEquals(0,phoneClock.getSecond()-hotelClock.getSecond())
                    );
                    break;
                }
                case "Ī˹��":{
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(4,phoneClock.getHour()-hotelClock.getHour()),
                            () -> assertEquals(0,phoneClock.getMinute()-hotelClock.getMinute()),
                            () -> assertEquals(0,phoneClock.getSecond()-hotelClock.getSecond())
                    );
                    break;
                }
                case "�׶�":{
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(8,phoneClock.getHour()-hotelClock.getHour()),
                            () -> assertEquals(0,phoneClock.getMinute()-hotelClock.getMinute()),
                            () -> assertEquals(0,phoneClock.getSecond()-hotelClock.getSecond())
                    );
                    break;
                }
                case "ŦԼ":{
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(13,phoneClock.getHour()-hotelClock.getHour()),
                            () -> assertEquals(0,phoneClock.getMinute()-hotelClock.getMinute()),
                            () -> assertEquals(0,phoneClock.getSecond()-hotelClock.getSecond())
                    );
                    break;
                }
                case "Ϥ��":{
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(-2,phoneClock.getHour()-hotelClock.getHour()),
                            () -> assertEquals(0,phoneClock.getMinute()-hotelClock.getMinute()),
                            () -> assertEquals(0,phoneClock.getSecond()-hotelClock.getSecond())
                    );
                    break;
                }
            }
            }
        }
    }