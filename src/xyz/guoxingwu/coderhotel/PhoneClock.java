package xyz.guoxingwu.coderhotel;

import javafx.scene.layout.StackPane;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


// ����servantʹ�ñ���ʱ����е��� ����Ա���ʱ����Ϊ��׼ʱ����л���
// PhoneClock��HotelClockʹ�ù۲���ģʽ PhoneClockΪ�۲���� HotelClockΪ�۲���
public class PhoneClock extends Clock {
    private String place;
    private int beiJingOffset;
    private List<HotelClock> observerClocks = new ArrayList<HotelClock>();

    public PhoneClock(int second, int minute, int hour) {
        super(second, minute, hour);
        this.place = "����";
        this.beiJingOffset = 0;
    }

    public PhoneClock() {
        this.place = "����";
        this.beiJingOffset = 0;
    }

    public boolean setTime() throws IOException {
        String customizedTime;
        String[] parsedTime = null;
        System.out.println("input the time in the form of hh-mm-ss");
        System.out.print("your time: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        if((customizedTime=in.readLine())!=null){
            parsedTime = customizedTime.split("-");
        }
        int hour,minute,second;
        assert parsedTime != null;
        hour = Integer.parseInt(parsedTime[0]);
        minute = Integer.parseInt(parsedTime[1]);
        second = Integer.parseInt(parsedTime[2]);
        if(hour<0||minute<0||minute>60||second<0||second>60){
            System.out.println("time format wrong");
            return false;
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        return true;
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
        if (place.equals("����")) beiJingOffset = 0;
        else if (place.equals("�׶�")) beiJingOffset = -8;
        else if (place.equals("Ī˹��")) beiJingOffset = -4;
        else if (place.equals("Ϥ��")) beiJingOffset = 2;
        else if (place.equals("ŦԼ")) beiJingOffset = -13;
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
                System.out.println(hotelClock.getPlace() + ": the clock is accurate");
                System.out.println(hotelClock.getPlace() + ": the current time is " + hotelClock.getTime());
                System.out.println("Phone: the current time is " + getTime());
                System.out.println();
            }
        }
    }
}
