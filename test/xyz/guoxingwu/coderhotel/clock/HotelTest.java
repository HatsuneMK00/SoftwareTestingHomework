package xyz.guoxingwu.coderhotel.clock;

import org.junit.jupiter.api.Test;
import xyz.guoxingwu.coderhotel.clock.Hotel;
import xyz.guoxingwu.coderhotel.clock.UTCClock;
import xyz.guoxingwu.coderhotel.factory.HotelFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
//    执行该测试用例时，需要把HotelFactory中负责接收用户自定义输入时间的代码注释掉
//    单元测试代码中无法输入 会卡住
    void hotelInitialization() throws IOException {
        HotelFactory hotelFactory = new HotelFactory();
        Hotel hotel = hotelFactory.createHotel();
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
        HotelFactory hotelFactory = new HotelFactory();
        Hotel hotel = hotelFactory.createHotel();
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