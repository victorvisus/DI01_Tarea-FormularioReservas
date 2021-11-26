package com.cypherstudios.booking.dao;

import com.cypherstudios.booking.exceptions.BookingExceptions;
import com.cypherstudios.booking.model.Banquet;
import com.cypherstudios.booking.model.Booking;
import com.cypherstudios.booking.model.Meeting;
import com.cypherstudios.booking.model.Workshop;
import com.cypherstudios.booking.view.BookingDialog;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class BookingDAO {

    private ArrayList<Booking> publicBookingList = new ArrayList();

    public BookingDAO(ArrayList<Booking> publicBookingList) {
        this.publicBookingList = publicBookingList;
    }

    /**
     * Guarda en el ArrayList la reserva, que manda a gestionar al método
     * actionBtnSaveBooking
     *
     * @param bookingWindow
     * @param publicBookingList
     * @param reservation
     * @return : devuelve el ArrayList modificado (siempre)
     */
    public ArrayList<Booking> saveBooking(BookingDialog bookingWindow,
            Booking reservation) {

        try {
            this.publicBookingList.add(actionBtnSaveBooking(bookingWindow, reservation));
        } catch (BookingExceptions ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Reserva de evento", JOptionPane.ERROR_MESSAGE);
        }

        return this.publicBookingList;
    }

    /**
     *
     * @param bookingWindow
     * @param reservation
     * @return
     * @throws BookingExceptions
     */
    protected Booking actionBtnSaveBooking(BookingDialog bookingWindow, Booking reservation) throws BookingExceptions {

        //Manda a evaluar que los combo box haya una opción correcta
        dataEvaluate(bookingWindow.cbEventType, (String) bookingWindow.cbEventType.getSelectedItem());
        dataEvaluate(bookingWindow.cbTypeCuisine, (String) bookingWindow.cbTypeCuisine.getSelectedItem());

        //Manda a comprobar que el tipo de reserva sea "Congreso"
        if (dataEvaluate(bookingWindow.cbEventType, "Congreso")) {
            reservation = new Meeting();

            reservation.setCustomerName(bookingWindow.txtCustomerName.getText());
            reservation.setReservation((Date) bookingWindow.dateReservation.getValue());
            reservation.setAttendees((int) bookingWindow.spAttendees.getValue());
            reservation.setTypeCuisine((String) bookingWindow.cbTypeCuisine.getSelectedItem());

            if (reservation instanceof Meeting) {
                ((Meeting) reservation).setJourneys((int) bookingWindow.spJourneys.getValue());

                if (bookingWindow.rbtnHostingYes.isSelected() && !bookingWindow.rbtnHostingNo.isSelected()) {
                    ((Meeting) reservation).setHosting('Y');
                    //Recojo los valores para los datos de HostingRoom

                    int numDays = (int) bookingWindow.numDays.getValue();
                    int numRooms = (int) bookingWindow.numRooms.getValue();

                    ((Meeting) reservation).roomsValues(numDays, numRooms);

                } else if (bookingWindow.rbtnHostingNo.isSelected() && !bookingWindow.rbtnHostingYes.isSelected()) {
                    ((Meeting) reservation).setHosting('N');
                } else {
                    throw new BookingExceptions(4);
                }

            }

            JOptionPane.showMessageDialog(null, "Reserva registrado correctamente",
                    "Reserva de evento", JOptionPane.INFORMATION_MESSAGE);

            System.out.println(reservation.toString());

            //Establece valores por defecto en el formulario
            cleanForm(bookingWindow);
        } else if (dataEvaluate(bookingWindow.cbEventType, "Banquete")) {
            reservation = new Banquet();

            reservation.setCustomerName(bookingWindow.txtCustomerName.getText());
            reservation.setReservation((Date) bookingWindow.dateReservation.getValue());
            reservation.setAttendees((int) bookingWindow.spAttendees.getValue());
            reservation.setTypeCuisine((String) bookingWindow.cbTypeCuisine.getSelectedItem());

            JOptionPane.showMessageDialog(null, "Reserva registrado correctamente",
                    "Reserva de evento", JOptionPane.INFORMATION_MESSAGE);

            System.out.println(reservation.toString());

            //Establece valores por defecto en el formulario
            cleanForm(bookingWindow);
        } else if (dataEvaluate(bookingWindow.cbEventType, "Jornada")) {
            reservation = new Workshop();

            reservation.setCustomerName(bookingWindow.txtCustomerName.getText());
            reservation.setReservation((Date) bookingWindow.dateReservation.getValue());
            reservation.setAttendees((int) bookingWindow.spAttendees.getValue());
            reservation.setTypeCuisine((String) bookingWindow.cbTypeCuisine.getSelectedItem());

            JOptionPane.showMessageDialog(null, "Reserva registrado correctamente",
                    "Reserva de evento", JOptionPane.INFORMATION_MESSAGE);

            System.out.println(reservation.toString());

            //Establece valores por defecto en el formulario
            cleanForm(bookingWindow);
        } else {
            throw new BookingExceptions(2);
        }

        return reservation;
    }

    /**
     * Evalua si el item seleccionado en un JComboBox coincide con el enviado
     * por parámetro
     *
     * @param cb : el componente JComboBox
     * @param evType : String que contiene la cadena válida
     * @return : true o false dependiendo del resultado
     */
    private boolean dataEvaluate(JComboBox cb, String evType) throws BookingExceptions {
        String tipo = (String) cb.getSelectedItem();

        if (tipo == "Elije una opción") {
            throw new BookingExceptions(3);
        } else if (tipo == evType) {
            return true;
        }
        return false;
    }

    private void cleanForm(BookingDialog bookingWindow) {
        //JOptionPane.showMessageDialog(null, "Código no implementado todavía, tiene que limpiar el formulario",
        //  "Reserva de evento", JOptionPane.INFORMATION_MESSAGE);

        bookingWindow.txtCustomerName.setText(null);
        bookingWindow.cbEventType.setSelectedIndex(0);
        bookingWindow.cbTypeCuisine.setSelectedIndex(0);
        bookingWindow.rbtnHostingNo.setSelected(false);
        bookingWindow.rbtnHostingYes.setSelected(false);
    }

    /*
     * ************************************************** LISTAR RESERVAS ***
     */
    public void tableBookinList(JTable jtBookingList) {

        /* Creo objetos de ejemplo */
        System.out.println("Añadido Victor - Workshop");
        this.publicBookingList.add(new Workshop("Victor", new Date(), 5, "Bufé"));
        System.out.println("Añadido Jeny - Banquet");
        this.publicBookingList.add(new Banquet("Jeny", new Date(), 7, "Carta"));
        System.out.println("Añadido Angel - Workshop");
        this.publicBookingList.add(new Workshop("Angel", new Date(), 15, "No precisa"));
        System.out.println("Añadido Luis - Meeting");
        this.publicBookingList.add(new Meeting("Luis", new Date(), 20, "No precisa", 5, 'Y', 3, 2));

        //System.out.println("Has entrado al metodo");
        DefaultTableModel bookingTable = new DefaultTableModel();
        jtBookingList.setModel(bookingTable);

        bookingTable.addColumn("Tipo");
        bookingTable.addColumn("Nombre");
        bookingTable.addColumn("Fecha");
        bookingTable.addColumn("Asistentes");
        bookingTable.addColumn("Tipo Cocina");
        bookingTable.addColumn("Nº Jornadas");
        // OJO, tiene que acceder al objeto HostingRoom rooms
        bookingTable.addColumn("Nº Habitaciones");
        bookingTable.addColumn("Nº de Noches");

        int numColumns = bookingTable.getColumnCount();
        for (int y = 0; y < numColumns; y++) {
            jtBookingList.getColumnModel().getColumn(y).setPreferredWidth(20);
        }

        Object[] ob = null;
        for (int x = 0; x < this.publicBookingList.size(); x++) {

            bookingTable.addRow(ob);

            Booking getBooking = (Booking) publicBookingList.get(x);

            bookingTable.setValueAt(getBooking.getCustomerName(), x, 1);
            bookingTable.setValueAt(getBooking.getReservation(), x, 2);
            bookingTable.setValueAt(getBooking.getAttendees(), x, 3);
            bookingTable.setValueAt(getBooking.getTypeCuisine(), x, 4);

            if (getBooking instanceof Workshop) {
                bookingTable.setValueAt(((Workshop) getBooking).getEventType(), x, 0);
            }
            if (getBooking instanceof Banquet) {
                bookingTable.setValueAt(((Banquet) getBooking).getEventType(), x, 0);
            }
            if (getBooking instanceof Meeting) {
                bookingTable.setValueAt(((Meeting) getBooking).getEventType(), x, 0);
                bookingTable.setValueAt(((Meeting) getBooking).getJourneys(), x, 5);
                bookingTable.setValueAt(((Meeting) getBooking).getHostingRoom().getNumRooms(), x, 6);
                bookingTable.setValueAt(((Meeting) getBooking).getHostingRoom().getNumDays(), x, 7);
            } else {
                bookingTable.setValueAt("No", x, 5);
                bookingTable.setValueAt("No", x, 6);
                bookingTable.setValueAt("No", x, 7);
            }
        }

        if (!this.publicBookingList.isEmpty()) {
            for (Booking b : this.publicBookingList) {
                System.out.println(b.toString());
            }
        } else {
            System.out.println("No existen reservas");
        }
    }

}
