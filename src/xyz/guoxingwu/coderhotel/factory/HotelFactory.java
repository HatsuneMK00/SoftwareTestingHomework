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
        // 测试HotelTest时需要注释该行
        while(!phoneClock.setTime());

        hotelClocks.add(0,new HotelClock("北京",phoneClock));
        hotelClocks.add(1,new HotelClock("伦敦",phoneClock));
        hotelClocks.add(2,new HotelClock("莫斯科",phoneClock));
        hotelClocks.add(3,new HotelClock("纽约",phoneClock));
        hotelClocks.add(4,new HotelClock("悉尼",phoneClock));
        phoneClock.setObserverClocks(hotelClocks);
//        修改前
//   ----------------------------------------------------------
//        修改后
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
//        修改前

//   ----------------------------------------------------------
//        修改后
        servantClock.notifyAllHotelClockToInitialize();
//   ----------------------------------------------------------
        return hotel;
    }
}
