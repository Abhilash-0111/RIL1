package com.example.ril1;

import java.util.Date;

public class LogRecord {
    double DFGLP, WFGLP,SHWVLP,MCAP,UGLP,CAP,RLP  , Efficiency,totalloss ;
    String updatername, updateremail ;
    Date time ;

    public LogRecord(double DFGLP, double WFGLP, double SHWVLP, double MCAP, double UGLP, double CAP, double RLP, double efficiency, double totalloss, String updatername, String updateremail, Date time) {
        this.DFGLP = DFGLP;
        this.WFGLP = WFGLP;
        this.SHWVLP = SHWVLP;
        this.MCAP = MCAP;
        this.UGLP = UGLP;
        this.CAP = CAP;
        this.RLP = RLP;
        Efficiency = efficiency;
        this.totalloss = totalloss;
        this.updatername = updatername;
        this.updateremail = updateremail;
        this.time = time;
    }

    public LogRecord(){}

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getDFGLP() {
        return DFGLP;
    }

    public void setDFGLP(double DFGLP) {
        this.DFGLP = DFGLP;
    }

    public double getWFGLP() {
        return WFGLP;
    }

    public void setWFGLP(double WFGLP) {
        this.WFGLP = WFGLP;
    }

    public double getSHWVLP() {
        return SHWVLP;
    }

    public void setSHWVLP(double SHWVLP) {
        this.SHWVLP = SHWVLP;
    }

    public double getMCAP() {
        return MCAP;
    }

    public void setMCAP(double MCAP) {
        this.MCAP = MCAP;
    }

    public double getUGLP() {
        return UGLP;
    }

    public void setUGLP(double UGLP) {
        this.UGLP = UGLP;
    }

    public double getCAP() {
        return CAP;
    }

    public void setCAP(double CAP) {
        this.CAP = CAP;
    }

    public double getRLP() {
        return RLP;
    }

    public void setRLP(double RLP) {
        this.RLP = RLP;
    }

    public double getEfficiency() {
        return Efficiency;
    }

    public void setEfficiency(double efficiency) {
        Efficiency = efficiency;
    }

    public double getTotalloss() {
        return totalloss;
    }

    public void setTotalloss(double totalloss) {
        this.totalloss = totalloss;
    }

    public String getUpdatername() {
        return updatername;
    }

    public void setUpdatername(String updatername) {
        this.updatername = updatername;
    }

    public String getUpdateremail() {
        return updateremail;
    }

    public void setUpdateremail(String updateremail) {
        this.updateremail = updateremail;
    }
}
