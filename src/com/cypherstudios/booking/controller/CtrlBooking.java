package com.cypherstudios.booking.controller;

import com.cypherstudios.booking.app.CypherBookingSystem;
import com.cypherstudios.booking.view.BookingForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class CtrlBooking implements ActionListener {

    private final BookingForm bookingWindow = new BookingForm();

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

    public void runBooking() {
        bookingWindow.setVisible(true);

        bookingWindow.setTitle("Reserva de espacio");
        bookingWindow.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* Acciones para botones y opciones de menú */
        if (e.getSource() == bookingWindow.navItemExit) {
            //Cierra la aplicación
            System.exit(0);
        }
        if (e.getSource() == bookingWindow.btnReturn || e.getSource() == bookingWindow.navItemReturn) {
            bookingWindow.dispose();

            CypherBookingSystem.goBooking.appRun();
        }
        if (e.getSource() == bookingWindow.btnSaveBooking || e.getSource() == bookingWindow.navItemSaveBooking) {
            JOptionPane.showMessageDialog(null, "Código no implementado todavía", "Reserva de espacio", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == bookingWindow.navItemBookingList) {
            JOptionPane.showMessageDialog(null, "Código no implementado todavía", "Reserva de espacio", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
