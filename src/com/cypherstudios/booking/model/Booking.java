package com.cypherstudios.booking.model;

import java.util.Date;

/**
 *
 * Clase Booking
 *
 * @author Victor
 */
public abstract class Booking implements Comparable<Booking> {

    //public static final String[] cuisine = new String[]{"Bufé", "Carta", "Pedir cita con el chef", "No precisa"};

    protected Date reservation;
    protected int attendees;
    protected String typeCuisine;

    /* Constructores */
    public Booking() {
    }

    public Booking(Date reservation, int attendees, String typeCuisine) {
        this.reservation = reservation;
        this.attendees = attendees;
        this.typeCuisine = typeCuisine;
    }

    /* Getter and Setters */
    public Date getReservation() {
        return this.reservation;
    }

    public void setReservation(Date reservation) {
        this.reservation = reservation;
    }

    public int getAttendees() {
        return this.attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public String getTypeCuisine() {
        return this.typeCuisine;
    }

    public void setTypeCuisine(String typeCuisine) {
        this.typeCuisine = typeCuisine;
    }

    /* Método toString */
    @Override
    public String toString() {
        return "/**** Booking ****/"
                + "\nFecha: " + reservation
                + "\nAsistentes: " + attendees
                + "\nTipo de cocina: " + typeCuisine;
    }

    /* Método compareTo por si quiero ordenar el las reservas del ArrayList */
    @Override
    public abstract int compareTo(Booking b);
}
