package xyz.guoxingwu.coderhotel;

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

    public Hotel() {
        ArrayList<HotelClock> hotelClocks = new ArrayList<>();
        PhoneClock phoneClock = new PhoneClock();
        hotelClocks.add(0,new HotelClock("����",phoneClock));
        hotelClocks.add(1,new HotelClock("�׶�",phoneClock));
        hotelClocks.add(2,new HotelClock("Ī˹��",phoneClock));
        hotelClocks.add(3,new HotelClock("ŦԼ",phoneClock));
        hotelClocks.add(4,new HotelClock("Ϥ��",phoneClock));
        phoneClock.setObserverClocks(hotelClocks);
        this.servantClock = phoneClock;
        this.hotelClocks = hotelClocks;
    }

    public void clockRun() throws InterruptedException {
        int incTime;
        Scanner scanner = new Scanner(System.in);
        for(incTime=0;incTime<Integer.MAX_VALUE;incTime++){
            for (HotelClock hotelClock:hotelClocks
                 ) {
                hotelClock.timePassOneStep();
            }
            servantClock.timePassOneStep();
            System.out.println("press number '0' to ask the servant to calibration the hotel clocks");
            System.out.println("press number '1' to move to the next time round");
            if(scanner.nextInt()==0)
                servantClock.notifyAllHotelClock();
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        try{
            hotel.clockRun();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
