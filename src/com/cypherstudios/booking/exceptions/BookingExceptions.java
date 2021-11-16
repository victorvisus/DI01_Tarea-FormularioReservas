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

            default:
                errorMsg = "Error de ejecución";
                break;
        }

        return errorMsg;
    }

}
