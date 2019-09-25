package xyz.guoxingwu.coderhotel.factory;

import xyz.guoxingwu.coderhotel.clock.Hotel;
import xyz.guoxingwu.coderhotel.clock.HotelClock;
import xyz.guoxingwu.coderhotel.clock.PhoneClock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelFactory {
    public Hotel createHotel() throws IOException {
        Hotel hotel = new Hotel();
        ArrayList<HotelClock> hotelClocks = new ArrayList<>();
        PhoneClock phoneClock = new PhoneClock();
        // ����HotelTestʱ��Ҫע�͸���
        while(!phoneClock.setTime());

        hotelClocks.add(0,new HotelClock("����",phoneClock));
        hotelClocks.add(1,new HotelClock("�׶�",phoneClock));
        hotelClocks.add(2,new HotelClock("Ī˹��",phoneClock));
        hotelClocks.add(3,new HotelClock("ŦԼ",phoneClock));
        hotelClocks.add(4,new HotelClock("Ϥ��",phoneClock));
        phoneClock.setObserverClocks(hotelClocks);
//        �޸�ǰ
//   ----------------------------------------------------------
//        �޸ĺ�
        phoneClock.notifyAllHotelClockToInitialize();
//   ----------------------------------------------------------
        hotel.setHotelClocks(hotelClocks);
        hotel.setServantClock(phoneClock);
        return hotel;
    }

    public Hotel createHotel(List<HotelClock> hotelClocks, PhoneClock servantClock){
        Hotel hotel = new Hotel();
        servantClock.setObserverClocks(hotelClocks);
        hotel.setServantClock(servantClock);
        hotel.setHotelClocks(hotelClocks);
//        �޸�ǰ

//   ----------------------------------------------------------
//        �޸ĺ�
        servantClock.notifyAllHotelClockToInitialize();
//   ----------------------------------------------------------
        return hotel;
    }
}
