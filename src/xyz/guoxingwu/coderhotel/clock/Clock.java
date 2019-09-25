package xyz.guoxingwu.coderhotel.clock;


// Clock为酒店时钟和手机时钟的父类 使用模板方法模式
public abstract class Clock {
    protected int second;
    protected int minute;
    protected int hour;

    public Clock(int second, int minute, int hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    public Clock() {
        second = 0;
        minute = 0;
        hour = 13;
    }

    public void timePassOneStep() {
        timeInc();
    }

    public void timePassNStep(int n) {
        int i;
        for (i = 0; i < n; i++) {
            timeInc();
        }
    }

    public String getTime() {
        return (hour + " : " + minute + " : " + second);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    abstract void timeInc();
}
