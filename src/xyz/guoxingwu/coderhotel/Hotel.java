package xyz.guoxingwu.coderhotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// the Observer Pattern User
public class Hotel {
    private List<HotelClock> hotelClocks = new ArrayList<HotelClock>();
    private PhoneClock servantClock;

    public Hotel(List<HotelClock> hotelClocks, PhoneClock servantClock) {
        this.hotelClocks = hotelClocks;
        this.servantClock = servantClock;
    }

    public List<HotelClock> getHotelClocks() {
        return hotelClocks;
    }

    public void setHotelClocks(List<HotelClock> hotelClocks) {
        this.hotelClocks = hotelClocks;
    }

    public PhoneClock getServantClock() {
        return servantClock;
    }

    public void setServantClock(PhoneClock servantClock) {
        this.servantClock = servantClock;
    }

    public Hotel() throws IOException {
        ArrayList<HotelClock> hotelClocks = new ArrayList<>();
        PhoneClock phoneClock = new PhoneClock();
        while(!phoneClock.setTime());
        hotelClocks.add(0,new HotelClock("北京",phoneClock));
        hotelClocks.add(1,new HotelClock("伦敦",phoneClock));
        hotelClocks.add(2,new HotelClock("莫斯科",phoneClock));
        hotelClocks.add(3,new HotelClock("纽约",phoneClock));
        hotelClocks.add(4,new HotelClock("悉尼",phoneClock));
        phoneClock.setObserverClocks(hotelClocks);
        this.servantClock = phoneClock;
        this.hotelClocks = hotelClocks;
    }

    public void clockRun() throws InterruptedException {
        int incTime, round;
        Scanner scanner = new Scanner(System.in);
        for(incTime=0;incTime<Integer.MAX_VALUE;incTime++){
            System.out.println("press number '0' to ask the servant to calibration the hotel clocks");
            System.out.println("press number 'n' to move 'n' time round");
            System.out.println();
            round = scanner.nextInt();
            if(round==0)
                servantClock.notifyAllHotelClock();
            else{
                servantClock.timePassNStep(round);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Hotel hotel = new Hotel();
        try{
            hotel.clockRun();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
