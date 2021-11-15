/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cypherstudios.booking.controller;

import com.cypherstudios.booking.view.BookingList;
import java.awt.event.ActionEvent;

/**
 *
 * @author Victor
 */
public class CtrlBookingList extends CtrlInit {

    private final BookingList bookingListWindows = new BookingList(appInit, true);

    public CtrlBookingList() {
        /* Listener para opciones de menú */
        this.bookingListWindows.navItemReturn.addActionListener(this);
        this.bookingListWindows.navItemExit.addActionListener(this);

        /* Listener para botones */
        this.bookingListWindows.btnReturn.addActionListener(this);
    }

    /**
     * Lanza la ventana de dialogo
     */
    public void runListWindow() {
        bookingListWindows.setVisible(true);
    }

    /**
     * Sobreescribe el método actionPerformed con el código que interesa para el
     * JDialog donde se piden datos para realizar la reserva, de la clase padre
     * CtrlInit de la que hereda, que a su vez sobreescribe el método de la
     * clase abstracta que implementa
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* Acciones para botones y opciones de menú */
        if (e.getSource() == bookingListWindows.navItemExit) {
            //Cierra la aplicación
            System.exit(0);
        }
        if (e.getSource() == bookingListWindows.btnReturn || e.getSource() == bookingListWindows.navItemReturn) {
            //Cierra el JDialog y vuelve a al JFrame principal
            this.bookingListWindows.setVisible(false);
        }
    }
}
