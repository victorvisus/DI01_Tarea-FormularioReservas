package com.cypherstudios.booking.controller;

import com.cypherstudios.booking.model.Booking;
import com.cypherstudios.booking.view.appIni;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class CtrlInit implements ActionListener {

    //protected final Init appInit = new Init();
    protected final appIni appInit = new appIni();

    protected static ArrayList<Booking> publicBookingList = new ArrayList();

    /**
     * Constructor "vacio" de la clase, en el cual se inician las "escuchas" a
     * los botones del panel
     */
    public CtrlInit() {
        /* Listener para opciones de menú */
//        this.appInit.navItemBooking.addActionListener(this);
//        this.appInit.navItemBookingList.addActionListener(this);
//        this.appInit.navItemExit.addActionListener(this);

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
     * Sobreescribe el método actionPerformed, de la clase abstacta que
     * implementa, con el código que interesa para el JFrame de la app
     */
    @Override
    public void actionPerformed(ActionEvent e) {
//        /* Acciones para botones y opciones de menú */
//        if (e.getSource() == appInit.btnExit || e.getSource() == appInit.navItemExit) {
//            //Cierra la aplicación
//            System.exit(0);
//        }
//        // Inicia el sistema de booking
//        if (e.getSource() == appInit.btnBooking || e.getSource() == appInit.navItemBooking) {
//            //Crea una instancia del controller del JDialog de reservas: CtrlBooking
//            CtrlBooking openBooking = new CtrlBooking();
//            //Lanza el JDialog
//            openBooking.runBooking();
//
//        }
//        // Abre el panel donde se listan las reservas "guardadas"
//        if (e.getSource() == appInit.btnBookingList || e.getSource() == appInit.navItemBookingList) {
//            //Crea una instancia del controller CtrflBookingList
//            CtrlBookingList openList = new CtrlBookingList();
//            //Iniciar el JDialog BookingList
//            openList.runListWindow();
//        }
    }

}
