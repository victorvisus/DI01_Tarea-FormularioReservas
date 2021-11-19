/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cypherstudios.booking.view;

/**
 *
 * @author Victor
 */
public class BookingDialog extends javax.swing.JDialog {

    /**
     * Creates new form BookingDialog
     */
    public BookingDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);

        //Añade los dos radio button a un grupo, para seleccionar uno u otro
        hostingBtnGroup.add(rbtnHostingYes);
        hostingBtnGroup.add(rbtnHostingNo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hostingBtnGroup = new javax.swing.ButtonGroup();
        btnSaveBooking = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbDateReservation = new javax.swing.JLabel();
        lbEventType = new javax.swing.JLabel();
        lbAttendees = new javax.swing.JLabel();
        lbTypeCuisine = new javax.swing.JLabel();
        cbEventType = new javax.swing.JComboBox<>();
        spAttendees = new javax.swing.JSpinner();
        cbTypeCuisine = new javax.swing.JComboBox<>();
        dateReservation = new javax.swing.JSpinner();
        panelHostingRooms = new javax.swing.JPanel();
        lbNumDays = new javax.swing.JLabel();
        lbNumRooms = new javax.swing.JLabel();
        numDays = new javax.swing.JSpinner();
        numRooms = new javax.swing.JSpinner();
        rbtnHostingYes = new javax.swing.JRadioButton();
        lbHosting = new javax.swing.JLabel();
        rbtnHostingNo = new javax.swing.JRadioButton();
        lbJourneys = new javax.swing.JLabel();
        spJourneys = new javax.swing.JSpinner();
        navBar = new javax.swing.JMenuBar();
        navItem = new javax.swing.JMenu();
        navItemSaveBooking = new javax.swing.JMenuItem();
        navItemBookingList = new javax.swing.JMenuItem();
        navItemReturn = new javax.swing.JMenuItem();
        navItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reservas");
        setBackground(new java.awt.Color(255, 255, 255));
        setModal(true);
        setName("BookingDialogModal"); // NOI18N

        btnSaveBooking.setBackground(navBar.getBackground());
        btnSaveBooking.setFont(navBar.getFont());
        btnSaveBooking.setForeground(navBar.getForeground());
        btnSaveBooking.setText("Reservar");
        btnSaveBooking.setToolTipText("Guardar Reserva");
        btnSaveBooking.setBorder(null);
        btnSaveBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSaveBooking.setMargin(new java.awt.Insets(5, 15, 5, 15));
        btnSaveBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBookingActionPerformed(evt);
            }
        });

        btnReturn.setBackground(navBar.getBackground());
        btnReturn.setFont(navBar.getFont());
        btnReturn.setForeground(navBar.getForeground());
        btnReturn.setText("Volver");
        btnReturn.setBorder(btnSaveBooking.getBorder());
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReturn.setMargin(btnSaveBooking.getMargin());
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Introduce los datos de la reserva");

        lbDateReservation.setText("Fecha del evento");

        lbEventType.setText("Tipo de evento");

        lbAttendees.setText("Asistentes");

        lbTypeCuisine.setText("Tipo de Cocina");

        cbEventType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banquete", "Jornada", "Congreso" }));
        cbEventType.setToolTipText("Elije el tipo de evento");
        cbEventType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEventTypeActionPerformed(evt);
            }
        });

        spAttendees.setModel(new javax.swing.SpinnerNumberModel(5, 5, 120, 1));
        spAttendees.setToolTipText("Dinos los asistentes al evento");

        cbTypeCuisine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bufet", "Pedir cita con el chef", "No precisa" }));
        cbTypeCuisine.setToolTipText("Elije el tipo de menú");

        dateReservation.setModel(new javax.swing.SpinnerDateModel());
        dateReservation.setToolTipText("Indica la fecha del evento");
        dateReservation.setEditor(new javax.swing.JSpinner.DateEditor(dateReservation, "dd-MM- yyyy"));

        panelHostingRooms.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Reserva de Habitaciones"));
        panelHostingRooms.setEnabled(false);

        lbNumDays.setText("Nº de Días");
        lbNumDays.setToolTipText("Indica el número de dias");
        lbNumDays.setEnabled(false);

        lbNumRooms.setText("Nº de Habitaciones");
        lbNumRooms.setToolTipText("¿Cuántas habitaciones?");
        lbNumRooms.setEnabled(false);

        numDays.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        numDays.setToolTipText("Indica el número de dias");
        numDays.setEnabled(false);

        numRooms.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        numRooms.setToolTipText("¿Cuántas habitaciones?");
        numRooms.setEnabled(false);

        javax.swing.GroupLayout panelHostingRoomsLayout = new javax.swing.GroupLayout(panelHostingRooms);
        panelHostingRooms.setLayout(panelHostingRoomsLayout);
        panelHostingRoomsLayout.setHorizontalGroup(
            panelHostingRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHostingRoomsLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelHostingRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNumRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNumDays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(panelHostingRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelHostingRoomsLayout.setVerticalGroup(
            panelHostingRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHostingRoomsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelHostingRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumDays)
                    .addComponent(numDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelHostingRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumRooms)
                    .addComponent(numRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        rbtnHostingYes.setText("Si");
        rbtnHostingYes.setToolTipText("¿Necesitas alojamiento?");
        rbtnHostingYes.setEnabled(false);
        rbtnHostingYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnHostingYesActionPerformed(evt);
            }
        });

        lbHosting.setText("Alojamiento");
        lbHosting.setToolTipText("¿Necesitas alojamiento?");
        lbHosting.setEnabled(false);

        rbtnHostingNo.setText("No");
        rbtnHostingNo.setToolTipText("¿Necesitas alojamiento?");
        rbtnHostingNo.setEnabled(false);
        rbtnHostingNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnHostingNoActionPerformed(evt);
            }
        });

        lbJourneys.setText("Nº Jornadas");
        lbJourneys.setEnabled(false);

        spJourneys.setModel(new javax.swing.SpinnerNumberModel(1, 1, 120, 1));
        spJourneys.setToolTipText("Dinos los asistentes al evento");
        spJourneys.setEnabled(false);

        navBar.setBackground(new java.awt.Color(102, 0, 102));
        navBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        navBar.setForeground(new java.awt.Color(255, 255, 255));
        navBar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        navItem.setBackground(navBar.getBackground());
        navItem.setBorder(navBar.getBorder());
        navItem.setForeground(navBar.getForeground());
        navItem.setText("Archivo");
        navItem.setToolTipText("");
        navItem.setFont(navBar.getFont());
        navItem.setNextFocusableComponent(btnSaveBooking);

        navItemSaveBooking.setBackground(navBar.getBackground());
        navItemSaveBooking.setFont(navBar.getFont());
        navItemSaveBooking.setForeground(navBar.getForeground());
        navItemSaveBooking.setText("Guardar Reserva");
        navItemSaveBooking.setToolTipText("Guardar Reserva");
        navItemSaveBooking.setBorder(navBar.getBorder());
        navItem.add(navItemSaveBooking);

        navItemBookingList.setBackground(navBar.getBackground());
        navItemBookingList.setFont(navBar.getFont());
        navItemBookingList.setForeground(navBar.getForeground());
        navItemBookingList.setText("Ver Reservas");
        navItemBookingList.setBorder(navBar.getBorder());
        navItem.add(navItemBookingList);

        navItemReturn.setBackground(navBar.getBackground());
        navItemReturn.setFont(navBar.getFont());
        navItemReturn.setForeground(navBar.getForeground());
        navItemReturn.setText("Volver");
        navItemReturn.setToolTipText("");
        navItemReturn.setBorder(navBar.getBorder());
        navItem.add(navItemReturn);

        navItemExit.setBackground(navBar.getBackground());
        navItemExit.setFont(navBar.getFont());
        navItemExit.setForeground(navBar.getForeground());
        navItemExit.setText("Salir");
        navItemExit.setBorder(navBar.getBorder());
        navItem.add(navItemExit);

        navBar.add(navItem);

        setJMenuBar(navBar);
        navBar.getAccessibleContext().setAccessibleName("navBar");
        navBar.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelHostingRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(btnSaveBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbTypeCuisine)
                                    .addGap(55, 55, 55))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lbDateReservation)
                                    .addGap(45, 45, 45)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbEventType)
                                .addGap(58, 58, 58)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTypeCuisine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateReservation)
                            .addComponent(cbEventType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbAttendees)
                            .addComponent(lbHosting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbJourneys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spAttendees, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbtnHostingYes)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtnHostingNo))
                                    .addComponent(spJourneys, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEventType)
                    .addComponent(cbEventType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbJourneys)
                    .addComponent(spJourneys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbtnHostingYes)
                        .addComponent(lbHosting)
                        .addComponent(rbtnHostingNo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTypeCuisine)
                        .addComponent(cbTypeCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDateReservation)
                    .addComponent(dateReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAttendees)
                    .addComponent(spAttendees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSaveBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelHostingRooms, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveBookingActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReturnActionPerformed

    /**
     * Activa las opciones de Reserva de Habitaciones cuando el radio button
     * esta en SI
     *
     * @param evt
     */
    private void rbtnHostingYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnHostingYesActionPerformed
        // TODO add your handling code here:
        panelHostingRooms.setEnabled(true);
        numDays.setEnabled(true);
        numRooms.setEnabled(true);
        lbNumDays.setEnabled(true);
        lbNumRooms.setEnabled(true);
    }//GEN-LAST:event_rbtnHostingYesActionPerformed
    /**
     * Desactiva las opciones de reserva de habitaciones cuando el radio button
     * esta en NO
     *
     * @param evt
     */
    private void rbtnHostingNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnHostingNoActionPerformed
        // TODO add your handling code here:
        panelHostingRooms.setEnabled(false);
        numDays.setEnabled(false);
        numRooms.setEnabled(false);
        lbNumDays.setEnabled(false);
        lbNumRooms.setEnabled(false);
    }//GEN-LAST:event_rbtnHostingNoActionPerformed

    /**
     * Activa o desactiva la pregunta si se necesita alojamiento, si esta
     * seleccionado congreso lo activa, si no lo desactiva
     *
     * @param evt
     */
    private void cbEventTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEventTypeActionPerformed
        // TODO add your handling code here:
        if (cbEventType.getSelectedItem() == "Congreso") {
            lbHosting.setEnabled(true);
            rbtnHostingNo.setEnabled(true);
            rbtnHostingYes.setEnabled(true);

            lbJourneys.setEnabled(true);
            spJourneys.setEnabled(true);
        } else {
            lbHosting.setEnabled(false);
            rbtnHostingNo.setEnabled(false);
            rbtnHostingYes.setEnabled(false);

            lbJourneys.setEnabled(false);
            spJourneys.setEnabled(false);
        }
    }//GEN-LAST:event_cbEventTypeActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(BookingDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BookingDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BookingDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BookingDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                BookingDialog dialog = new BookingDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnReturn;
    public javax.swing.JButton btnSaveBooking;
    public javax.swing.JComboBox<String> cbEventType;
    public javax.swing.JComboBox<String> cbTypeCuisine;
    public javax.swing.JSpinner dateReservation;
    private javax.swing.ButtonGroup hostingBtnGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbAttendees;
    private javax.swing.JLabel lbDateReservation;
    private javax.swing.JLabel lbEventType;
    private javax.swing.JLabel lbHosting;
    private javax.swing.JLabel lbJourneys;
    private javax.swing.JLabel lbNumDays;
    private javax.swing.JLabel lbNumRooms;
    private javax.swing.JLabel lbTypeCuisine;
    public javax.swing.JMenuBar navBar;
    public javax.swing.JMenu navItem;
    public javax.swing.JMenuItem navItemBookingList;
    public javax.swing.JMenuItem navItemExit;
    public javax.swing.JMenuItem navItemReturn;
    public javax.swing.JMenuItem navItemSaveBooking;
    public javax.swing.JSpinner numDays;
    public javax.swing.JSpinner numRooms;
    private javax.swing.JPanel panelHostingRooms;
    public javax.swing.JRadioButton rbtnHostingNo;
    public javax.swing.JRadioButton rbtnHostingYes;
    public javax.swing.JSpinner spAttendees;
    public javax.swing.JSpinner spJourneys;
    // End of variables declaration//GEN-END:variables
}
