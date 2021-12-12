package com.cypherstudios.booking.dao;

import com.cypherstudios.booking.exceptions.BookingExceptions;
import com.cypherstudios.booking.model.Banquet;
import com.cypherstudios.booking.model.Booking;
import com.cypherstudios.booking.model.Meeting;
import com.cypherstudios.booking.model.Workshop;
import com.cypherstudios.booking.view.BookingDialog;
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

    /**
     * Constructor
     *
     * @param publicBookingList
     */
    public BookingDAO() {
        //  this.publicBookingList = publicBookingList;
    }

    /**
     * Guarda en el ArrayList la reserva, que manda a gestionar al método
     * actionBtnSaveBooking
     *
     * @param bookingWindow
     * @param reservation
     */
    public BookingsArrayList saveBooking(BookingDialog bookingWindow, BookingsArrayList publicBookingList) {

//        System.out.println("\nMétodo: saveBooking" + "\nANTES de entrar al try/catch\n");
//        for (Booking b : publicBookingList) {
//            System.out.println(b.toString());
//        }
        try {
            //Booking reservation = null;

            publicBookingList.attach(actionBtnSaveBooking(bookingWindow));

//            System.out.println("\n\nMétodo: saveBooking" + "\nDESPUÉS de entrar al try/catch\n");
//            for (int i = 0; i < publicBookingList.bookingCount(); i++) {
//                System.out.println(publicBookingList.getBooking(i).toString());
//            }
        } catch (BookingExceptions ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Reserva de evento", JOptionPane.ERROR_MESSAGE);
        }
        return publicBookingList;
    }

    /**
     * Recoge los datos del formulario para crear la reserva
     *
     * Este método lo podría dividir en 3:
     * <ul>
     * <li>El primero evalua el tipo de objeto necesario para el evento.
     * Dependiendo del resultado llama a un método u a otro</li>
     * <li>Otro método si la reserva es un "Congreso"</li>
     * <li>Otro método si la reserva es un "Banquete" o una "Jornada"</li>
     * </ul>
     *
     * @param bookingWindow
     * @param reservation
     * @return
     * @throws BookingExceptions
     */
    private Booking actionBtnSaveBooking(BookingDialog bookingWindow) throws BookingExceptions {

        Booking reservation = null;

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
//            System.out.println(reservation.getCustomerName());

            reservation.setReservation((Date) bookingWindow.dateReservation.getValue());
//            System.out.println(reservation.getReservation());

            reservation.setAttendees((int) bookingWindow.spAttendees.getValue());
//            System.out.println(reservation.getAttendees());

            reservation.setTypeCuisine((String) bookingWindow.cbTypeCuisine.getSelectedItem());
//            System.out.println(reservation.getTypeCuisine());

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
    public void tableBookinList(JTable jtBookingList, BookingsArrayList publicBookingList) {

        /* Creo objetos de ejemplo */
//        System.out.println("Añadido Victor - Workshop");
//        publicBookingList.attach(new Workshop("Victor", new Date(), 5, "Bufé"));
//        System.out.println("Añadido Jeny - Banquet");
//        publicBookingList.attach(new Banquet("Jeny", new Date(), 7, "Carta"));
//        System.out.println("Añadido Angel - Workshop");
//        publicBookingList.attach(new Workshop("Angel", new Date(), 15, "No precisa"));
//        System.out.println("Añadido Luis - Meeting");
//        publicBookingList.attach(new Meeting("Luis", new Date(), 20, "No precisa", 5, 'Y', 3, 2));
//        System.out.println("Has entrado al metodo");
        /**
         * Evalua que el arralist no este vacio
         */
        DefaultTableModel bookingTable = new DefaultTableModel();
        jtBookingList.setModel(bookingTable);

        try {
            existBooking(publicBookingList);

            bookingTable.addColumn("Tipo");//0
            bookingTable.addColumn("Nombre");//1
            bookingTable.addColumn("Fecha");//2
            bookingTable.addColumn("Asistentes");//3
            bookingTable.addColumn("Tipo Cocina");//4
            bookingTable.addColumn("Nº Jornadas");//5
            // OJO, tiene que acceder al objeto HostingRoom rooms
            bookingTable.addColumn("Nº Habitaciones");//6
            bookingTable.addColumn("Nº de Noches");//7

            int numColumns = bookingTable.getColumnCount();
            for (int y = 0; y < numColumns; y++) {
                jtBookingList.getColumnModel().getColumn(y).setPreferredWidth(20);
            }

            Object[] fila = new Object[numColumns];
            //System.out.println(publicBookingList.bookingCount());
            for (int x = 0; x < publicBookingList.bookingCount(); x++) {

                //Agregamos al modelo los resultados
                bookingTable.addRow(fila);

                Booking getBooking = (Booking) publicBookingList.getBooking(x);

                int numRow = x;
                if (getBooking instanceof Workshop) {
                    bookingTable.setValueAt(((Workshop) getBooking).getEventType(), numRow, 0);

                    bookingTable.setValueAt(((Workshop) getBooking).getCustomerName(), numRow, 1);
                    bookingTable.setValueAt(((Workshop) getBooking).getReservationString(), numRow, 2);
                    bookingTable.setValueAt(((Workshop) getBooking).getAttendees(), numRow, 3);
                    bookingTable.setValueAt(((Workshop) getBooking).getTypeCuisine(), numRow, 4);

                    bookingTable.setValueAt("No", x, 5);
                    bookingTable.setValueAt("No", x, 6);
                    bookingTable.setValueAt("No", x, 7);
                }
                if (getBooking instanceof Banquet) {
                    bookingTable.setValueAt(((Banquet) getBooking).getEventType(), numRow, 0);

                    bookingTable.setValueAt(((Banquet) getBooking).getCustomerName(), numRow, 1);
                    bookingTable.setValueAt(((Banquet) getBooking).getReservationString(), numRow, 2);
                    bookingTable.setValueAt(((Banquet) getBooking).getAttendees(), numRow, 3);
                    bookingTable.setValueAt(((Banquet) getBooking).getTypeCuisine(), numRow, 4);

                    bookingTable.setValueAt("No", numRow, 5);
                    bookingTable.setValueAt("No", numRow, 6);
                    bookingTable.setValueAt("No", numRow, 7);
                }
                if (getBooking instanceof Meeting) {
                    bookingTable.setValueAt(((Meeting) getBooking).getEventType(), numRow, 0);

                    bookingTable.setValueAt(((Meeting) getBooking).getCustomerName(), numRow, 1);
                    bookingTable.setValueAt(((Meeting) getBooking).getReservationString(), numRow, 2);
                    bookingTable.setValueAt(((Meeting) getBooking).getAttendees(), numRow, 3);
                    bookingTable.setValueAt(((Meeting) getBooking).getTypeCuisine(), numRow, 4);

                    bookingTable.setValueAt(((Meeting) getBooking).getJourneys(), numRow, 5);
                    bookingTable.setValueAt(((Meeting) getBooking).getHostingRoom().getNumRooms(), numRow, 6);
                    bookingTable.setValueAt(((Meeting) getBooking).getHostingRoom().getNumDays(), numRow, 7);
                }

            }
        } catch (BookingExceptions ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Listar Reservas de evento", JOptionPane.ERROR_MESSAGE);
        }

        //return publicBookingList;
    }

    /* *************************************************** COMPROBACIONES **** */
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

    /**
     * Comprueba que la reserva no sea nula
     *
     * @return
     * @throws BookingExceptions
     */
    private boolean validReservation(Booking reservation) throws BookingExceptions {

        if (reservation == null) {
            throw new BookingExceptions(6);
        } else if (reservation != null) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba que el ArrayList de reservas no este vacio
     *
     * @return
     * @throws BookingExceptions
     */
    private boolean existBooking(BookingsArrayList publicBookingList) throws BookingExceptions {

        if (publicBookingList.bookingCount() == 0) {
            throw new BookingExceptions(5);
        } else if (publicBookingList.bookingCount() != 0) {
            return true;
        }
        return false;
    }

}
