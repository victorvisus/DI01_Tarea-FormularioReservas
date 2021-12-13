package com.cypherstudios.booking.dao;

import com.cypherstudios.booking.exceptions.BookingExceptions;
import com.cypherstudios.booking.model.*;
import com.cypherstudios.booking.view.BookingDialog;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class BookingDAO {

    /**
     * Constructor
     */
    public BookingDAO() {
    }

    /**
     * ********************************************** GUARDAR RESERVAS
     * *************************************************************************
     */
    /**
     * Guarda en el ArrayList la reserva, que manda a gestionar al método
     * actionBtnSaveBooking
     *
     * @param bookingWindow
     * @param publicBookingList
     * @return
     */
    public BookingsArrayList saveBooking(BookingDialog bookingWindow, BookingsArrayList publicBookingList) {
        try {
            publicBookingList.attach(actionBtnSaveBooking(bookingWindow));

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

            //Establece valores por defecto en el formulario
            cleanForm(bookingWindow);
        } else {
            throw new BookingExceptions(2);
        }

        return reservation;
    }

    /**
     * ********************************************** LISTAR RESERVAS
     * *************************************************************************
     */
    public void tableBookinList(JTable jtBookingList, BookingsArrayList publicBookingList) {

        DefaultTableModel bookingTable = new DefaultTableModel();
        jtBookingList.setModel(bookingTable);

        try {
            existBooking(publicBookingList); //Evalua que el arralist no este vacio

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

            for (int x = 0; x < publicBookingList.bookingCount(); x++) {

                //Agregamos al modelo una fila
                bookingTable.addRow(fila);

                /* Instancia el objeto Booking del que va a extraer los datos
                para mostrarlos en las columnas de la fila, en la tabla */
                Booking getBooking = (Booking) publicBookingList.getBooking(x);

                //Manda a rellenar las columnas de la fila
                fillColumns(bookingTable, x, getBooking);

            }
        } catch (BookingExceptions ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Listar Reservas de evento", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * ********************************************** MÉTODOS AUXILIARIES
     * *************************************************************************
     */
    /**
     * Limpia los campos del formulario una vez realizada la reserva
     *
     * @param bookingWindow
     */
    private void cleanForm(BookingDialog bookingWindow) {
        bookingWindow.txtCustomerName.setText(null);
        bookingWindow.cbEventType.setSelectedIndex(0);
        bookingWindow.cbTypeCuisine.setSelectedIndex(0);
        bookingWindow.rbtnHostingNo.setSelected(false);
        bookingWindow.rbtnHostingYes.setSelected(false);
    }

    /**
     * Extrae los atributos del objeto para mostrarlos en la tabla
     *
     * @param bookingTable : El modelo de la tabla
     * @param x : int la posición del bucle for en la que se encuentra
     * @param getBooking : el objeto Booking reserva
     * @throws BookingExceptions : si el objeto no pertenece a ninguno de los
     * tres tipos existentes lanza un error
     */
    private void fillColumns(DefaultTableModel bookingTable, int x, Booking getBooking) throws BookingExceptions {
        //Extrae los datos "básico" de la reserva
        bookingTable.setValueAt(getBooking.getCustomerName(), x, 1);
        bookingTable.setValueAt(getBooking.getReservationString(), x, 2);
        bookingTable.setValueAt(getBooking.getAttendees(), x, 3);
        bookingTable.setValueAt(getBooking.getTypeCuisine(), x, 4);

        // Evalua de que tipo de reserva es el objeto Booking
        switch (valueBookingType(getBooking)) {
            case 1:
                bookingTable.setValueAt(((Workshop) getBooking).getEventType(), x, 0);

                bookingTable.setValueAt(1, x, 5);
                bookingTable.setValueAt(0, x, 6);
                bookingTable.setValueAt(0, x, 7);
                break;
            case 2:
                bookingTable.setValueAt(((Banquet) getBooking).getEventType(), x, 0);

                bookingTable.setValueAt(1, x, 5);
                bookingTable.setValueAt(0, x, 6);
                bookingTable.setValueAt(0, x, 7);
                break;
            case 3:
                bookingTable.setValueAt(((Meeting) getBooking).getEventType(), x, 0);

                bookingTable.setValueAt(((Meeting) getBooking).getJourneys(), x, 5);
                bookingTable.setValueAt(((Meeting) getBooking).getHostingRoom().getNumRooms(), x, 6);
                bookingTable.setValueAt(((Meeting) getBooking).getHostingRoom().getNumDays(), x, 7);
                break;
            default:
                //throw new BookingExceptions(7);

                for (int z = 0; z < bookingTable.getColumnCount(); z++) {
                    bookingTable.setValueAt("error", x, z);
                }
                break;
        }
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

    /**
     * Evalua el tipo de evento, dependiendo de si es Banquete, Jornada o
     * Congreso devuelve un valor u otro, para el switch
     *
     * @param getBooking : Objeto reserva Booking
     * @return valor case
     */
    private int valueBookingType(Booking getBooking) throws BookingExceptions {
        if (getBooking instanceof Workshop) {
            return 1;
        } else if (getBooking instanceof Banquet) {
            return 2;
        } else if (getBooking instanceof Meeting) {
            return 3;
        } else {
            throw new BookingExceptions(7);
            //return 0;
        }
    }
}
