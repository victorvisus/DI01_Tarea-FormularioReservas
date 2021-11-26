package com.cypherstudios.booking.controller;

import com.cypherstudios.booking.dao.BookingDAO;
import com.cypherstudios.booking.model.*;
import com.cypherstudios.booking.view.appIni;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class CtrlInit implements ActionListener {

    //Inicializa un atributo con el ArrayList
    protected ArrayList<Booking> publicBookingList = new ArrayList();
    //Instancia un Objeto de la clase que gestiona los datos y le envia el ArrayList
    protected BookingDAO op = new BookingDAO(publicBookingList);

    //protected final Init appInit = new Init();
    protected final appIni appInit = new appIni();

    /**
     * Constructor en el que se inician las "escuchas" a los botones del panel
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

        this.publicBookingList.add(new Workshop("Victor", new Date(), 5, "Bufé"));
        this.publicBookingList.add(new Banquet("Jeny", new Date(), 7, "Carta"));
        this.publicBookingList.add(new Workshop("Angel", new Date(), 15, "No precisa"));
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
        /* Acciones para botones y opciones de menú */
        if (e.getSource() == appInit.btnExit) {
            //Cierra la aplicación
            System.exit(0);
        }
        // Inicia el sistema de booking
        if (e.getSource() == appInit.btnBooking) {
            //Crea una instancia del controller del JDialog de reservas: CtrlBooking
            CtrlBooking openBooking = new CtrlBooking();
            //Lanza el JDialog
            openBooking.runBooking();

        }
        // Abre el panel donde se listan las reservas "guardadas"
        if (e.getSource() == appInit.btnBookingList) {
            //Crea una instancia del controller CtrflBookingList
            CtrlBookingList openList = new CtrlBookingList();
            //Iniciar el JDialog BookingList
            openList.runListWindow();
        }
    }

}
