package com.cypherstudios.booking.dao;

import com.cypherstudios.booking.model.Booking;
import java.util.ArrayList;


/**
 *
 * @author Victor
 */
public class BookingsArrayList {

    //Inicializa un atributo con el ArrayList
    private ArrayList<Booking> publicBookingList;

    public BookingsArrayList() {
        publicBookingList = new ArrayList<>();
    }

    public void attach(Booking re) {
        publicBookingList.add(re);
    }

    public Booking getBooking(int pos) {
        return publicBookingList.get(pos);
    }

    public int bookingCount() {
        return publicBookingList.size();
    }


}
