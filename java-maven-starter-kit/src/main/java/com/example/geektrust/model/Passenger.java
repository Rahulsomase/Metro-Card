package com.example.geektrust.model;

public class Passenger {

    private String metroCardNumber;
    private Integer balanceInTheMetrocard;
    private Integer journeyCount;

    public Integer getJourneyCount() {
        return journeyCount;
    }
    public Passenger(String metroCardNumber, Integer balanceInTheMetrocard) {
        super();
        this.metroCardNumber = metroCardNumber;
        this.balanceInTheMetrocard = balanceInTheMetrocard;
        this.journeyCount=0;
    }

    public void setJourneyCount(Integer journeyCount) {
        this.journeyCount = journeyCount;
    }
    public String getMetroCardNumber() {
        return metroCardNumber;
    }
    public void setMetroCardNumber(String metroCardNumber) {
        this.metroCardNumber = metroCardNumber;
    }
    public Integer getBalanceInTheMetrocard() {
        return balanceInTheMetrocard;
    }
    public void setBalanceInTheMetrocard(Integer balanceInTheMetrocard) {
        this.balanceInTheMetrocard = balanceInTheMetrocard;
    }
}
