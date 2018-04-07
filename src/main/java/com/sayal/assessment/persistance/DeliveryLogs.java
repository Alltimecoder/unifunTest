package com.sayal.assessment.persistance;


import javax.persistence.*;
import java.util.Date;

/*databse object for saving data to database using repository*/

@Entity
public class DeliveryLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false,unique = true)
    private String msisdns;


    @Column
    private Date sentTime;

    @Column
    private String text;

    @Column
    private String deliveryTime;

    @Column
    private String deliveryReport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsisdns() {
        return msisdns;
    }

    public void setMsisdns(String msisdns) {
        this.msisdns = msisdns;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryReport() {
        return deliveryReport;
    }

    public void setDeliveryReport(String deliveryReport) {
        this.deliveryReport = deliveryReport;
    }
}
