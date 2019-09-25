package xyz.guoxingwu.coderhotel.clock;

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
        // 12% one second slower that the standard clock(phone clock)
        // 12% one second faster that the standard clock(phone clock)
        int tempRandom = random.nextInt(100);
        if (tempRandom >= 12 && tempRandom < 88) second++;
        else if (tempRandom >= 88) second = second + 2;
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
        this.second = observeeClock.getSecond();
        this.minute = observeeClock.getMinute();
        this.hour = observeeClock.getHour() - observeeClock.getBeiJingOffset() + beiJingOffset;
    }
}
