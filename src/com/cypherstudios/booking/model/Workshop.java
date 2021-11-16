package com.cypherstudios.booking.model;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class Workshop extends Booking {

    private final String eventType = "Jornada";

    public Workshop(Date reservation, int attendees, String typeCuisine) {
        super(reservation, attendees, typeCuisine);
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de Evento: " + eventType;
    }

    @Override
    public int compareTo(Booking b) {
        throw new UnsupportedOperationException("Método compareTo no implementado."); //To change body of generated methods, choose Tools | Templates.
    }

}
