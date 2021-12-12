package com.cypherstudios.booking.exceptions;

/**
 *
 * @author Victor
 */
public class BookingExceptions extends Exception {

    private int errorCode;

    public BookingExceptions(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    /**
     *
     * @return errorMsg : Mensaje de error, pudiendo ser por los siguientes
     * motivos:
     * <ul>
     * <li>case 1: Congreso - No se han introducido datos referentes al Hotel
     * pero se ha indicado que es necesario.</li>
     * </ul>
     */
    public String getMessage() {
        String errorMsg = "";
        System.out.println(errorCode);

        switch (errorCode) {

            case 1:
                //Registro de nueva reserva:
                errorMsg = "Los datos para realizar la reserva son insuficientes";
                break;
            case 2:
                //Registro de nueva reserva:
                errorMsg = "Error al realizar la reserva";
                break;
            case 3:
                //No se ha seleccionado una opción en el JComboBox
                errorMsg = "Por favor, elije un tipo de evento y de cocina";
                break;
            case 4:
                //No se ha seleccionado una opción en el JComboBox
                errorMsg = "¿Necesitas reservar habitaciones en el hotel?";
                break;
            case 5:
                //No existen reservas
                errorMsg = "No existen reservas";
                break;
            case 6:
                //El objeto reserva es nulo
                errorMsg = "La reservas no es correcta";
                break;
            default:
                errorMsg = "Error de ejecución";
                break;
        }

        return errorMsg;
    }

}
