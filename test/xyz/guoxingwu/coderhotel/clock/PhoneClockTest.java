package xyz.guoxingwu.coderhotel.clock;

import org.junit.jupiter.api.Test;
import sun.nio.cs.ext.PCK;
import xyz.guoxingwu.coderhotel.clock.HotelClock;
import xyz.guoxingwu.coderhotel.clock.PhoneClock;
import xyz.guoxingwu.coderhotel.clock.UTCClock;
import xyz.guoxingwu.coderhotel.factory.HotelFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PhoneClockTest {
    @Test
    void setPlace(){
        PhoneClock phoneClock = new PhoneClock();
        UTCClock utcClock = new UTCClock();
        phoneClock.setPlace("北京");
        assertAll(
                "assert the servant phone clock is set to BeiJing",
                () -> assertEquals("北京",phoneClock.getPlace()),
                () -> assertEquals(8,phoneClock.getHour() - utcClock.getHour())
        );
    }

    @Test
    void setTime(){
        PhoneClock phoneClock = new PhoneClock();
        HotelClock hotelClock = new HotelClock("伦敦",phoneClock);
        HotelFactory hotelFactory = new HotelFactory();
        phoneClock.setHour(40); // a part of setTime
        Hotel hotel = hotelFactory.createHotel(Arrays.asList(hotelClock),phoneClock);
        assertEquals(-8,hotelClock.getHour() - phoneClock.getHour());
    }
}