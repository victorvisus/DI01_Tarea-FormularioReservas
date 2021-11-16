package com.cypherstudios.booking.model;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class Meeting extends Booking {

    private final String eventType = "Banquete";

    private int days;
    private char hostel; //valores 'Y' para si, 'N' para no
    private HostelBooking rooms;

    /* Constructores */
    public Meeting(Date reservation, int attendees, String typeCuisine,
            int days, char hostel, int numDays, int numRooms) {
        super(reservation, attendees, typeCuisine);

        this.days = days;
        this.hostel = hostel;

        if (hostel == 'Y') {
            HostelBooking rooms = new HostelBooking(numDays, numRooms);

            this.rooms = rooms;
        }
    }

    /* Getter and Setters */
    public String getEventType() {
        return eventType;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public char getHostel() {
        return hostel;
    }

    public void setHostel(char hostel) {
        this.hostel = hostel;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de Evento: " + eventType
                + "\nNº de Jornadas: " + days
                + "\n¿Necesita hotel? " + hostel;
    }

    @Override
    public int compareTo(Booking b) {
        throw new UnsupportedOperationException("Método compareTo no implementado."); //To change body of generated methods, choose Tools | Templates.
    }
}
