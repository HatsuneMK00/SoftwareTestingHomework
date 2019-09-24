package xyz.guoxingwu.coderhotel;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
    void hotelInitialization() throws IOException {
        Hotel hotel = new Hotel();
        assertAll(
                "assert the hotel has all the clock",
        () -> assertEquals("北京",hotel.getHotelClocks().get(0).getPlace()),
        () -> assertEquals("伦敦",hotel.getHotelClocks().get(1).getPlace()),
        () -> assertEquals("莫斯科",hotel.getHotelClocks().get(2).getPlace()),
        () -> assertEquals("纽约",hotel.getHotelClocks().get(3).getPlace()),
        () -> assertEquals("悉尼",hotel.getHotelClocks().get(4).getPlace())
        );
    }

    @Test
    void hotelClockTimeCheck() throws IOException {
        Hotel hotel = new Hotel();
        UTCClock utcClock = new UTCClock();
        assertAll(
                "assert the hotel clock has the right offset to utc-clock",
                () -> assertEquals(8,hotel.getHotelClocks().get(0).getHour() - utcClock.getHour()),
                () -> assertEquals(0,hotel.getHotelClocks().get(1).getHour() - utcClock.getHour()),
                () -> assertEquals(4,hotel.getHotelClocks().get(2).getHour() - utcClock.getHour()),
                () -> assertEquals(-5,hotel.getHotelClocks().get(3).getHour() - utcClock.getHour()),
                () -> assertEquals(10,hotel.getHotelClocks().get(4).getHour() - utcClock.getHour())
        );
    }

}