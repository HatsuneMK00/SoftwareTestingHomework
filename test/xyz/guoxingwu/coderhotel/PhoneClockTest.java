package xyz.guoxingwu.coderhotel;

import org.junit.jupiter.api.Test;

import java.io.IOException;

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


//    has defect
    @Test
    void setTime() throws IOException {
        PhoneClock phoneClock = new PhoneClock();
        HotelClock hotelClock = new HotelClock("伦敦",phoneClock);
        phoneClock.setHour(40);
        assertEquals(8,hotelClock.getHour()-phoneClock.getHour());
    }
}