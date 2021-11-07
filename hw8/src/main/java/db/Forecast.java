package db;

import java.util.Date;

public class Forecast {

    private int id;

    private String city;

    private Date date;

    private String info;

    private double minTemp;

    private double maxTemp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Forecast(int id, String city, Date date, String info, double minTemp, double maxTemp) {
        this.id = id;
        this.city = city;
        this.date = date;
        this.info = info;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[#");
        builder.append(this.id);
        builder.append("] ");
        builder.append(this.city);
        builder.append(" ");
        builder.append(this.date);
        builder.append(": t = ");
        builder.append(this.minTemp);
        builder.append(" - ");
        builder.append(this.maxTemp);
        builder.append(" [");
        builder.append(this.info);
        builder.append("]");
        return builder.toString();
    }
}
