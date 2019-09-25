package xyz.guoxingwu.coderhotel.clock;

import xyz.guoxingwu.coderhotel.factory.HotelFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// the Observer Pattern User
public class Hotel {
    private List<HotelClock> hotelClocks = new ArrayList<HotelClock>();
    private PhoneClock servantClock;

    public Hotel() {
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

    public void clockRun() throws InterruptedException {
        int round;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("input number '0' to ask the servant to calibration the hotel clocks");
            System.out.println("input number 'n' to move 'n' time round");
            System.out.println("input number '-1' to end the simulation");
            System.out.println();
            round = scanner.nextInt();
            if(round==0)
                servantClock.notifyAllHotelClock();
            else if(round>0){
                servantClock.timePassNStep(round);
                for (HotelClock hotelClock:hotelClocks
                     ) {
                    hotelClock.timePassNStep(round);
                }
            }else if(round==-1){
                return;
            }else{
                System.out.println("please input the right number");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        HotelFactory hotelFactory = new HotelFactory();
        Hotel hotel = hotelFactory.createHotel();
        hotel.clockRun();
    }

}
