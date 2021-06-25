package com.bahirbet.org.bahirbet;

public class User {

    private String phoneNumber;
    private String betCouponCode;
    private String totalOdd;
    private String betAmount;
    private String possibleWin;

    public User(String phoneNumber, String betCouponCode, String totalOdd, String betAmount, String possibleWin) {
        this.phoneNumber = phoneNumber;
        this.betCouponCode = betCouponCode;
        this.totalOdd = totalOdd;
        this.betAmount = betAmount;
        this.possibleWin = possibleWin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBetCouponCode() {
        return betCouponCode;
    }

    public void setBetCouponCode(String betCouponCode) {
        this.betCouponCode = betCouponCode;
    }

    public String getTotalOdd() {
        return totalOdd;
    }

    public void setTotalOdd(String totalOdd) {
        this.totalOdd = totalOdd;
    }

    public String getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(String betAmount) {
        this.betAmount = betAmount;
    }

    public String getPossibleWin() {
        return possibleWin;
    }

    public void setPossibleWin(String possibleWin) {
        this.possibleWin = possibleWin;
    }
}
