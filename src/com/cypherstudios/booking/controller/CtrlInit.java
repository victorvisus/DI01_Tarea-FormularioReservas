package com.cypherstudios.booking.controller;

import com.cypherstudios.booking.view.Init;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class CtrlInit implements ActionListener {

    private final Init appInit = new Init();

    /**
     * Constructor "vacio" de la clase, en el cual se inician las "escuchas" a
     * los botones del panel
     */
    public CtrlInit() {
        /* Listener para opciones de menú */
        this.appInit.navItemBooking.addActionListener(this);
        this.appInit.navItemBookingList.addActionListener(this);
        this.appInit.navItemExit.addActionListener(this);

        /* Listener para botones */
        this.appInit.btnBooking.addActionListener(this);
        this.appInit.btnBookingList.addActionListener(this);
        this.appInit.btnExit.addActionListener(this);
    }

    /**
     * Arranca el panel de inicio
     */
    public void appRun() {
        appInit.setVisible(true);

        appInit.setTitle("CypherBookingSystem");
        appInit.setLocationRelativeTo(null);
    }

    /**
     * Sobreescribe el método actionPerformed de la clase abstacta que
     * implementa
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* Acciones para botones y opciones de menú */
        if (e.getSource() == appInit.btnExit || e.getSource() == appInit.navItemExit) {
            //Cierra la aplicación
            System.exit(0);
        }
        // Inicia el sistema de booking
        if (e.getSource() == appInit.btnBooking || e.getSource() == appInit.navItemBooking) {
            //Crea una instancia del controller CtrlBooking
            CtrlBooking openBooking = new CtrlBooking();

            appInit.dispose(); //Oculta el JFrame de inicio
            //Iniciar el JFrame Booking
            openBooking.runBooking();

        }
        // Abre el panel donde se listan las reservas "guardadas"
        if (e.getSource() == appInit.btnBookingList || e.getSource() == appInit.navItemBookingList) {
            //Crea una instancia del controller CtrflBookingList
            /* Aqui el código */

            //appInit.dispose(); //Oculta el JFrame de inicio
            //Iniciar el JFrame BookingList
            /* Aqui el código */
            JOptionPane.showMessageDialog(null, "Código no implementado todavía", "Reserva de espacio", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
