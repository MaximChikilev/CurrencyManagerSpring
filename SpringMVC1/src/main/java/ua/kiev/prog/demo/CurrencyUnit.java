package ua.kiev.prog.demo;


import javax.persistence.*;
import java.util.Date;

@Entity
public class CurrencyUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_unit_id")
    private int id;
    @Column(name = "exchange_date")
    private Date exchangedate;
    private String cc;
    private String txt;
    private double rate;

    public CurrencyUnit() {
    }

    public CurrencyUnit(String cc, String txt, double rate) {
        this.cc = cc;
        this.txt = txt;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "dao.dao.CurrencyUnitDao.entity.CurrencyUnit{" +
                "exchangedate='" + exchangedate + '\'' +
                ", cc='" + cc + '\'' +
                ", txt='" + txt + '\'' +
                ", rate=" + rate +
                '}';
    }

    public Date getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(Date exchangedate) {
        this.exchangedate = exchangedate;
    }
}
