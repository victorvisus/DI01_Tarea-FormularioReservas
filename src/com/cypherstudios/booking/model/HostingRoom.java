package com.cypherstudios.booking.model;

import com.cypherstudios.booking.exceptions.BookingExceptions;

/**
 *
 * @author Victor
 */
class HostingRoom {

    private int numDays;
    private int numRooms;

    /* Constructores */
    public HostingRoom(int numDays, int numRooms) {

        this.numDays = numDays;
        this.numRooms = numRooms;
    }

    /* Getter and Setters */
    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    /* Método toString */
    @Override
    public String toString() {
        return "\nDAtos de reserva de Habitaciones"
                + "\nNº de días: " + numDays
                + "\nNº de habitaciones: " + numRooms;
    }

    public static void evaluateData(int numDays, int numRooms) throws BookingExceptions {
        if (numDays == 0 || numRooms == 0) {
            throw new BookingExceptions(1);
        }
    }
}