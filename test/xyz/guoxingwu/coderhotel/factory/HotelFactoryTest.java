package xyz.guoxingwu.coderhotel.factory;

import org.junit.jupiter.api.Test;
import xyz.guoxingwu.coderhotel.clock.Hotel;
import xyz.guoxingwu.coderhotel.clock.HotelClock;
import xyz.guoxingwu.coderhotel.clock.PhoneClock;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelFactoryTest {

    @Test
    void createHotel() throws IOException {
        HotelFactory hotelFactory = new HotelFactory();
        PhoneClock phoneClock = new PhoneClock();
        HotelClock hotelClock = new HotelClock("Ï¤Äá",phoneClock);
        Hotel hotel = hotelFactory.createHotel(Arrays.asList(hotelClock),phoneClock);
        assertNotNull(hotel);
    }
}