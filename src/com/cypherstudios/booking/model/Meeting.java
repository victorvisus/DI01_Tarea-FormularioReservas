package com.cypherstudios.booking.model;

import com.cypherstudios.booking.exceptions.BookingExceptions;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Meeting extends Booking {

    private final String eventType = "Congreso";

    private int journeys;
    private char hosting; //valores 'Y' para si, 'N' para no
    private HostingRoom rooms;

    /* Constructores */
    public Meeting() {
        super();
    }

    /**
     * Constructor de la clase
     *
     * Llama al constructor de la clase padre Booking, pasándole los atributos
     * necesarios, además de asignar los valores a los atributos propios de la
     * clase, evaluando si este tipo de clase precisa de alojamiento (hosting) o
     * no, en caso afirmativo (hosting == 'Y') instancia el objeto que almacena
     * los datos del alojamiento, enviándole a través de su constructor los
     * atributos para ello.
     *
     * @param reservation
     * @param attendees
     * @param typeCuisine
     * @param journeys
     * @param hosting
     * @param numDays
     * @param numRooms
     */
    public Meeting(Date reservation, int attendees, String typeCuisine, int journeys, char hosting, int numDays, int numRooms) {
        super(reservation, attendees, typeCuisine);

        this.journeys = journeys;
        this.hosting = hosting;

        if (hosting == 'Y') {
            try {
                HostingRoom.evaluateRoomsData(numDays, numRooms); // Evalua que tenemos los datos

                HostingRoom rooms = new HostingRoom(numDays, numRooms);

                this.rooms = rooms;
            } catch (BookingExceptions ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Error al establecer la puntuación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /* Getter and Setters */
    public String getEventType() {
        return eventType;
    }

    public int getDays() {
        return journeys;
    }

    public void setDays(int days) {
        this.journeys = days;
    }

    public char getHosting() {
        return hosting;
    }

    public void setHosting(char hosting) {
        this.hosting = hosting;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de Evento: " + eventType
                + "\nNº de Jornadas: " + journeys
                + "\n¿Necesita hotel? " + hosting;
    }

    @Override
    public int compareTo(Booking b) {
        throw new UnsupportedOperationException("Método compareTo no implementado."); //To change body of generated methods, choose Tools | Templates.
    }
}
