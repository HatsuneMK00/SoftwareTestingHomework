package xyz.guoxingwu.coderhotel;

import java.util.ArrayList;
import java.util.List;

public class PhoneClock extends Clock {
    private String place;
    private int beiJingOffset;
    private List<HotelClock> observerClocks = new ArrayList<HotelClock>();

    public PhoneClock(int second, int minute, int hour) {
        super(second, minute, hour);
        this.place = "北京";
        this.beiJingOffset = 0;
    }

    public PhoneClock() {
        this.place = "北京";
        this.beiJingOffset = 0;
    }

    public List<HotelClock> getObserverClocks() {
        return observerClocks;
    }

    public void setObserverClocks(List<HotelClock> observerClocks) {
        this.observerClocks = observerClocks;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
        if (place.equals("北京")) beiJingOffset = 0;
        else if (place.equals("伦敦")) beiJingOffset = -8;
        else if (place.equals("莫斯科")) beiJingOffset = -4;
        else if (place.equals("悉尼")) beiJingOffset = 2;
        else if (place.equals("纽约")) beiJingOffset = -13;
        this.hour += beiJingOffset;
    }

    @Override
    void timeInc() {
        second++;
        if(second>=60){
            minute++;
            second=0;
            if(minute>=60){
                hour++;
                minute=0;
            }
        }
    }

    private boolean isHotelClockAccurate(HotelClock hotelClock){
        return (this.second == hotelClock.getSecond()
                && this.minute == hotelClock.getMinute()
                && this.hour == hotelClock.getHour() - hotelClock.getBeiJingOffset());
    }

    public void notifyAllHotelClock(){
        for (HotelClock hotelClock:observerClocks
             ) {
            if(!isHotelClockAccurate(hotelClock)){
                hotelClock.updateTime();
            }else{
                System.out.println(hotelClock.getPlace() + " hotel clock is accurate");
                System.out.println("the current" + hotelClock.getPlace() + "time is " + hotelClock.getTime());
                System.out.println("the current phone clock time is " + getTime());
            }
        }
    }
}
