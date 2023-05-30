package org.hotal.hotelmanagement.util;

import java.util.Date;

public class HotelReservation {

    private Date checkInDate;
    private Date checkOutDate;
    private int totalPrice;

    public HotelReservation(Date checkInDate, Date checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = calculateTotalPrice();
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private int calculateTotalPrice() {
        // 宿泊日数に応じた金額を計算する処理を記述する
        return 0;
    }

}
