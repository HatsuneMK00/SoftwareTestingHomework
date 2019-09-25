package xyz.guoxingwu.coderhotel.clock;

import org.junit.jupiter.api.Test;
import xyz.guoxingwu.coderhotel.clock.Hotel;
import xyz.guoxingwu.coderhotel.clock.UTCClock;
import xyz.guoxingwu.coderhotel.factory.HotelFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
//    ִ�иò�������ʱ����Ҫ��HotelFactory�и�������û��Զ�������ʱ��Ĵ���ע�͵�
//    ��Ԫ���Դ������޷����� �Ῠס
    void hotelInitialization() throws IOException {
        HotelFactory hotelFactory = new HotelFactory();
        Hotel hotel = hotelFactory.createHotel();
        assertAll(
                "assert the hotel has all the clock",
        () -> assertEquals("����",hotel.getHotelClocks().get(0).getPlace()),
        () -> assertEquals("�׶�",hotel.getHotelClocks().get(1).getPlace()),
        () -> assertEquals("Ī˹��",hotel.getHotelClocks().get(2).getPlace()),
        () -> assertEquals("ŦԼ",hotel.getHotelClocks().get(3).getPlace()),
        () -> assertEquals("Ϥ��",hotel.getHotelClocks().get(4).getPlace())
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