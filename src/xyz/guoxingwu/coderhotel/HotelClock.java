package xyz.guoxingwu.coderhotel;

import java.util.Observer;
import java.util.Random;

public class HotelClock extends Clock {
    private int beiJingOffset;
    private String place;
    private PhoneClock observeeClock;

    public HotelClock(int second, int minute, int hour, String place, PhoneClock observeeClock) {
        super(second, minute, hour);
        this.place = place;
        this.observeeClock = observeeClock;
        if (place.equals("北京")) beiJingOffset = 0;
        else if (place.equals("伦敦")) beiJingOffset = -8;
        else if (place.equals("莫斯科")) beiJingOffset = -4;
        else if (place.equals("悉尼")) beiJingOffset = 2;
        else if (place.equals("纽约")) beiJingOffset = -13;
        this.hour += beiJingOffset;
    }

    public HotelClock(String place, PhoneClock observeeClock) {
        super();
        this.place = place;
        this.observeeClock = observeeClock;
        if (place.equals("北京")) beiJingOffset = 0;
        else if (place.equals("伦敦")) beiJingOffset = -8;
        else if (place.equals("莫斯科")) beiJingOffset = -4;
        else if (place.equals("悉尼")) beiJingOffset = 2;
        else if (place.equals("纽约")) beiJingOffset = -13;
        this.hour += beiJingOffset;
    }

    public PhoneClock getObserverClock() {
        return observeeClock;
    }

    public void setObserverClock(PhoneClock observeeClock) {
        this.observeeClock = observeeClock;
    }

    public int getBeiJingOffset() {
        return beiJingOffset;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    void timeInc() {
        Random random = new Random(System.currentTimeMillis() + beiJingOffset);
        // 8% one second slower that the standard clock(phone clock)
        // 8% one second faster that the standard clock(phone clock)
        int tempRandom = random.nextInt(100);
        if (tempRandom >= 8 && tempRandom < 92) second++;
        else if (tempRandom >= 92) second = second + 2;
        if (second >= 60) {
            minute++;
            second = 0;
            if (minute >= 60) {
                hour++;
                minute = 0;
            }
        }
    }

    void updateTime(){
        System.out.println(getPlace() + ": the current time is " + getTime());
        System.out.println("Phone: the current time is " + observeeClock.getTime());
        this.second = observeeClock.getSecond();
        this.minute = observeeClock.getMinute();
        this.hour = observeeClock.getHour() + beiJingOffset;
        System.out.println("calibration complete");
        System.out.println(getPlace() + ": the current time is " + getTime());
        System.out.println("Phone: the current time is " + observeeClock.getTime());
        System.out.println();
    }
}
