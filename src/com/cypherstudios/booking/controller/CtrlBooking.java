package com.cypherstudios.booking.controller;

import com.cypherstudios.booking.dao.BookingsArrayList;
import com.cypherstudios.booking.view.BookingDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase controlador para el JDialog que se encarga de solicitar los datos
 * necesarios para realizar la reserva.
 *
 * @author Victor Visús García
 */
public class CtrlBooking extends CtrlInit implements ActionListener {

    private final BookingDialog bookingWindow = new BookingDialog(appInit, true);

    private BookingsArrayList publicBookingList;

    public CtrlBooking() {
        /* Listener para opciones de menú */
        this.bookingWindow.navItemSaveBooking.addActionListener(this);
        this.bookingWindow.navItemBookingList.addActionListener(this);
        this.bookingWindow.navItemReturn.addActionListener(this);
        this.bookingWindow.navItemExit.addActionListener(this);

        /* Listener para botones */
        this.bookingWindow.btnSaveBooking.addActionListener(this);
        this.bookingWindow.btnReturn.addActionListener(this);
    }

    /**
     * Lanza la ventana de dialogo
     *
     * @param publicBookingList : recibe el ArrayList de reservas
     * @return Array
     */
    public BookingsArrayList runBooking(BookingsArrayList publicBookingList) {

        this.publicBookingList = publicBookingList;

        bookingWindow.setVisible(true);

        return publicBookingList;
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
        if (e.getSource() == bookingWindow.navItemExit) {
            //Cierra la aplicación
            System.exit(0);
        }
        if (e.getSource() == bookingWindow.btnReturn || e.getSource() == bookingWindow.navItemReturn) {
            //Cierra el JDialog y vuelve a al JFrame principal
            this.bookingWindow.setVisible(false);
        }
        if (e.getSource() == bookingWindow.btnSaveBooking || e.getSource() == bookingWindow.navItemSaveBooking) {

            //Llama al método que se encarga de realizar la operación
            op.saveBooking(bookingWindow, publicBookingList);

            //Cierro el modal
            this.bookingWindow.setVisible(false);

//            System.out.println("\nDESPUÉS DE GUARDAR LA RESERVA\n");
//            for (int i = 0; i < publicBookingList.bookingCount(); i++) {
//                System.out.println(publicBookingList.getBooking(i));
//            }
        }
        if (e.getSource() == bookingWindow.navItemBookingList) {
            //Crea una instancia del controller CtrflBookingList
            CtrlBookingList openList = new CtrlBookingList();
            //Iniciar el JDialog BookingList
            openList.runListWindow(publicBookingList);

        }
    }
}
