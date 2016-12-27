package item;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-7-15
 * Time: 14:18:23
 * To change this template use File | Settings | File Templates.
 */
public class Stock {
    private double yesterdayPrice; //昨天开盘价
    private double todayPrice;//今天开盘价
    private double newPrice; // 当前价
    private String name;         //    股票名称
    private String id;     //  股票代号

    public Stock(double yesterdayPrice, double todayPrice, String name, String id) {
        this.yesterdayPrice = yesterdayPrice;
        this.todayPrice = todayPrice;
        this.name = name;
        this.id = id;
        this.newPrice=todayPrice;
    }

    public double getYesterdayPrice() {
        return yesterdayPrice;
    }

    public void setYesterdayPrice(double yesterdayPrice) {
        this.yesterdayPrice = yesterdayPrice;
    }

    public double getTodayPrice() {
        return todayPrice;
    }

    public void setTodayPrice(double todayPrice) {
        this.todayPrice = todayPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
     public String toString() {
        return this.name+"  :  "+this.newPrice;
    }
}
