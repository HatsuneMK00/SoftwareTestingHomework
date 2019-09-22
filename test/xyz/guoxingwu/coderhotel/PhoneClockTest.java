package xyz.guoxingwu.coderhotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneClockTest {
    @Test
    void setPlace(){
        PhoneClock phoneClock = new PhoneClock();
        UTCClock utcClock = new UTCClock();
        phoneClock.setPlace("����");
        assertAll(
                "assert the servant phone clock is set to BeiJing",
                () -> assertEquals("����",phoneClock.getPlace()),
                () -> assertEquals(8,phoneClock.getHour() - utcClock.getHour())
        );
    }
}