package xyz.guoxingwu.coderhotel.clock;

import org.junit.jupiter.api.Test;
import xyz.guoxingwu.coderhotel.clock.HotelClock;
import xyz.guoxingwu.coderhotel.clock.PhoneClock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelClockTest {

    @Test
    void updateTimeTest1() {
        PhoneClock phoneClock = new PhoneClock(20, 20, 20);
        List<String> cityList = Arrays.asList("±±¾©", "Â×¶Ø", "ÄªË¹¿Æ", "Ï¤Äá", "Å¦Ô¼");
        for (String city : cityList
        ) {
            HotelClock hotelClock = new HotelClock(10, 10, 10, city, phoneClock);
            hotelClock.updateTime();
            switch (hotelClock.getPlace()) {
                case "±±¾©": {
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(0, phoneClock.getHour() - hotelClock.getHour()),
                            () -> assertEquals(0, phoneClock.getMinute() - hotelClock.getMinute()),
                            () -> assertEquals(0, phoneClock.getSecond() - hotelClock.getSecond())
                    );
                    break;
                }
                case "ÄªË¹¿Æ": {
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(4, phoneClock.getHour() - hotelClock.getHour()),
                            () -> assertEquals(0, phoneClock.getMinute() - hotelClock.getMinute()),
                            () -> assertEquals(0, phoneClock.getSecond() - hotelClock.getSecond())
                    );
                    break;
                }
                case "Â×¶Ø": {
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(8, phoneClock.getHour() - hotelClock.getHour()),
                            () -> assertEquals(0, phoneClock.getMinute() - hotelClock.getMinute()),
                            () -> assertEquals(0, phoneClock.getSecond() - hotelClock.getSecond())
                    );
                    break;
                }
                case "Å¦Ô¼": {
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(13, phoneClock.getHour() - hotelClock.getHour()),
                            () -> assertEquals(0, phoneClock.getMinute() - hotelClock.getMinute()),
                            () -> assertEquals(0, phoneClock.getSecond() - hotelClock.getSecond())
                    );
                    break;
                }
                case "Ï¤Äá": {
                    assertAll(
                            "assert all the hotel clock can be adjusted correctly by servant's phone clock",
                            () -> assertEquals(-2, phoneClock.getHour() - hotelClock.getHour()),
                            () -> assertEquals(0, phoneClock.getMinute() - hotelClock.getMinute()),
                            () -> assertEquals(0, phoneClock.getSecond() - hotelClock.getSecond())
                    );
                    break;
                }
            }
        }
    }

    @Test
    void updateTimeTest2() {
        PhoneClock phoneClock = new PhoneClock();
        assertEquals("±±¾©", phoneClock.getPlace());
        HotelClock hotelClock = new HotelClock("Â×¶Ø", phoneClock);
        hotelClock.setHour(234);
        hotelClock.updateTime();
        assertEquals(8, phoneClock.getHour() - hotelClock.getHour());
    }


//    has defect
    @Test
    void updateTimeTest3() {
        PhoneClock phoneClock = new PhoneClock();
        phoneClock.setPlace("Â×¶Ø");
        assertEquals("Â×¶Ø", phoneClock.getPlace());
        HotelClock hotelClock = new HotelClock("Â×¶Ø", phoneClock);
        hotelClock.setHour(234);
        hotelClock.updateTime();
        assertEquals(0, phoneClock.getHour() - hotelClock.getHour());
    }

    @Test
    void timeIncRandom(){
        PhoneClock phoneClock = new PhoneClock();
        HotelClock hotelClock1 = new HotelClock("Ï¤Äá",phoneClock);
        HotelClock hotelClock2 = new HotelClock("Å¦Ô¼",phoneClock);
        hotelClock1.timePassNStep(10000);
        hotelClock2.timePassNStep(10000);
        assertNotEquals(hotelClock1.getSecond(),hotelClock2.getSecond());
        assertNotEquals(hotelClock1.getMinute(),hotelClock2.getMinute());
    }
}