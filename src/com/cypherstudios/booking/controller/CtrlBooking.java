package com.cypherstudios.booking.controller;

import com.cypherstudios.booking.exceptions.BookingExceptions;
import com.cypherstudios.booking.model.*;
import com.cypherstudios.booking.view.BookingDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase controlador para el JDialog que se encarga de solicitar los datos
 * necesarios para realizar la reserva.
 *
 * <ul><strong>Atributos de la Class HEREDADOS:</strong>
 * <li>ArrayList de Objetos "Reserva" donde se almacenaran las reservas
 * realizadas</li>
 * <li>appInit: Instancia de la clase JFrame Init</li>
 * </ul>
 *
 * <ul><strong>Atributos de la Class PROPIOS:</strong>
 * <li>bookingWindow: instancia del JDialog BookingDialog</li>
 * <li>Objeto Reserva --> Todos los necesarios para completar la reserva</li>
 * </ul>
 *
 * @author Victor
 */
public class CtrlBooking extends CtrlInit implements ActionListener {

    private final BookingDialog bookingWindow = new BookingDialog(appInit, true);

    private Booking reservation;

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
     */
    public void runBooking() {
        bookingWindow.setVisible(true);
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
            JOptionPane.showMessageDialog(null, "Código no implementado todavía", "Reserva de espacio", JOptionPane.INFORMATION_MESSAGE);

            //1º Valida el formulairo

            /*
            0. Los campos numero de dias y numero de habitaciones, estarán deshabilitados
            Si detecta que el valor del campo eventType es Meeting los avilitará.
            1. Llama al método que recogerá todos los datos del formulario y
            comprueba que estan todos completos, si no es asi lanza una exception
            2. Evalua el valor del atributo eventType para instanciar un objeto
            de un tipo u otro: (Banquet; Workshop o Meeting)
            - Si el objeto es de tipo Meeting evalua si el valor de hosting es Y o N
            - Si es Y abré el JDialog HostingDialog donde recoge los valores para el objeto de tipo HostingRoom
            y crear el objeto HostingRoom para añadirlo como atributo del objeto Meeting
            3. Crea el objeto correspondiente y lo devuelve, para añadirlo al ArraList
             */
            publicBookingList.add(actionBtnSaveBooking(reservation));
            //Una vez hecha la reserva que limie el formulario
            limpiaForm();
        }
        if (e.getSource() == bookingWindow.navItemBookingList) {
            //JOptionPane.showMessageDialog(null, "Código no implementado todavía", "Reserva de espacio", JOptionPane.INFORMATION_MESSAGE);

            //Crea una instancia del controller CtrflBookingList
            CtrlBookingList openList = new CtrlBookingList();
            //Iniciar el JDialog BookingList
            openList.runListWindow();
        }
    }

    //MÉTODO PARA EXTRAER LOS DVALORES DEL FORMULARIOÇ
    //Spinner --> http://amanuva.blogspot.com/2016/02/010-uso-de-spinner-java-y-netbeans.html
    //Spinner Date --> https://es.stackoverflow.com/questions/213746/como-sacar-un-localdate-de-un-jspinner-que-tiene-un-date
    private Booking actionBtnSaveBooking(Booking reservation) {

        //Manda a comprobar que el tipo de reserva sea "Congreso"
        if (dataEvaluate(bookingWindow.cbEventType, "Congreso")) {
            reservation = new Meeting();

            reservation.setReservation((Date) bookingWindow.dateReservation.getValue());
            reservation.setAttendees((int) bookingWindow.spAttendees.getValue());
            reservation.setTypeCuisine((String) bookingWindow.cbTypeCuisine.getSelectedItem());

            if (bookingWindow.rbtnHostingYes.isSelected()) {
                reservation.setHosting('Y');
            } else if (bookingWindow.rbtnHostingNo.isSelected()) {
                reservation.setHosting('N');
            }
        }

        return reservation;
    }

    private boolean dataEvaluate(JComboBox cb, String evType) {
        String tipo = (String) cb.getSelectedItem();

        if (tipo == evType) {
            return true;
        }

        return false;
    }

    /**
     * Valida el formulario de registro. Llama a los distintos métodos y les
     * pasa los datos necesarios para cada una de las validaciones
     *
     * Para validar campos duplicados recogo el error que lanza la BBDD, esta
     * operación se encuentra en el bloque try/catch del método de control
     *
     * @throws BinainException : lanza un mensaje dependiendo del tipo de error
     */
    /*
    private void validaForm() throws BinainException {

        String pass = new String(appRegistro.txtPassword.getPassword());
        String passConf = new String(appRegistro.txtPasswordConf.getPassword());

        //Validaciones
        validaciones.valCorreo(appRegistro.txtEmail.getText());
        validaciones.valPassword(pass, passConf);
        validaciones.valTipoUser(appRegistro.rbtnArtista, appRegistro.rbtnSala);

        //Validar los campos que no pueden estar vacios
        ArrayList<JTextField> campos = new ArrayList<>();
        campos.add(appRegistro.txtNickName);
        campos.add(appRegistro.txtLocalidad);
        if (appRegistro.rbtnArtista.isSelected()) {
            campos.add(appRegistro.txtNombreArtista);
        } else if (appRegistro.rbtnSala.isSelected()) {
            campos.add(appRegistro.txtNombreSala);
        }
        validaciones.valCamposNull(campos);
    }
     */
 /*
        private void limpiaForm() {
        bookingWindow.txtNickName.setText(null);
        bookingWindow.txtEmail.setText(null);
        bookingWindow.txtPassword.setText(null);
        bookingWindow.txtPasswordConf.setText(null);

        bookingWindow.txtNombre.setText(null);
        bookingWindow.txtApellido.setText(null);
        bookingWindow.txtDireccion.setText(null);
        bookingWindow.txtLocalidad.setText(null);

        bookingWindow.rbtnArtista.setSelected(false);
        bookingWindow.rbtnSala.setSelected(false);
    }
     */
    /**
     * Comprueba que los campos enviados en el ArrayList no estén vacíos.
     *
     * @param campos : ArraList que incluye los campos del formulario que no
     * queremos que estén vacíos
     * @throws BinainException
     */
    public static void valCamposNull(ArrayList<JTextField> campos) throws BookingExceptions {
        /*Estaria bien que el campo que este vacio lo pinte de alguna manera, pero
        después al hacer focus deberia volver a su color original */
        for (JTextField aux : campos) {
            if (aux.getText().isEmpty()) {
                throw new BookingExceptions(2);
            }
        }

    }

    private void limpiaForm() {
        JOptionPane.showMessageDialog(null, "Código no implementado todavía, tiene que limpiar el formulario",
                "Reserva de evento", JOptionPane.INFORMATION_MESSAGE);
    }
}
