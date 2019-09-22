package xyz.guoxingwu.coderhotel;

public class UTCClock extends Clock {
    private int beiJingOffset = -8;

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

    public UTCClock() {
        super();
        this.hour += beiJingOffset;
    }
}
