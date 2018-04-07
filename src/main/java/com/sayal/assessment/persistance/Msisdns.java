package com.sayal.assessment.persistance;

import javax.persistence.*;

/*database object representing database table and its columns*/

@Entity
public class Msisdns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(nullable = false,unique = true)
    private String msisdns;

    @Column
    private String log;

    @Column
    private String extras;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getMsisdns() {
        return msisdns;
    }

    public void setMsisdns(String msisdns) {
        this.msisdns = msisdns;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
}
