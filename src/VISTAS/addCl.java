/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import MODELO.ah4;
import MODELO.ah4DAORelacional;
import img.TextPrompt;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class addCl extends javax.swing.JFrame {

    /**
     * Creates new form addCl
     */
    public addCl() {
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt tfU = new TextPrompt("Nombre:",nomcli);
        TextPrompt tfc = new TextPrompt("NIT: ",nitcli);
        TextPrompt tfa = new TextPrompt("Correo: ",corcli);
        sexo.add(mas);
        sexo.add(fem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomcli = new javax.swing.JTextField();
        corcli = new javax.swing.JTextField();
        nitcli = new javax.swing.JTextField();
        mas = new javax.swing.JRadioButton();
        fem = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(224, 245, 244));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 36)); // NOI18N
        jLabel1.setText("Crear Cliente");

        nomcli.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        nomcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomcliKeyTyped(evt);
            }
        });

        corcli.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        corcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                corcliKeyTyped(evt);
            }
        });

        nitcli.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        nitcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nitcliActionPerformed(evt);
            }
        });
        nitcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nitcliKeyTyped(evt);
            }
        });

        mas.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        mas.setText("Masculino");
        mas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masMouseClicked(evt);
            }
        });

        fem.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        fem.setText("Femenino");
        fem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                femMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarSesion.png"))); // NOI18N
        jButton26.setBorder(null);
        jButton26.setBorderPainted(false);
        jButton26.setContentAreaFilled(false);
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarSesion.png"))); // NOI18N
        jButton26.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarSesion.png"))); // NOI18N
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(corcli, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nitcli, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(nomcli, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(mas)
                        .addGap(18, 18, 18)
                        .addComponent(fem))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton26)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(nomcli, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nitcli, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(corcli, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mas)
                    .addComponent(fem))
                .addGap(52, 52, 52)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton26)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(nomcli.getText().isEmpty()||nitcli.getText().isEmpty()||corcli.getText().isEmpty()
                ||(mas.isSelected()==false &&fem.isSelected()==false)){
            
            JOptionPane.showMessageDialog(null, "DEBE LLENAR Y/O SELECCIONAR TODOS LOS CAMPOS");
                Color ca = new Color(255,160,160);
            if(nomcli.getText().equals("")){
                nomcli.setBackground(ca);
            }
            if(nitcli.getText().equals("")){
                nitcli.setBackground(ca);
            }
            if(corcli.getText().equals("")){
                corcli.setBackground(ca);
            }
            if(mas.isSelected()==false && fem.isSelected() == false){
                mas.setForeground(Color.red);
                fem.setForeground(Color.red);
            }
        }else{
            enviarDatos();
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nomcliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomcliKeyTyped
        nomcli.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_nomcliKeyTyped

    private void nitcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nitcliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nitcliActionPerformed

    private void nitcliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitcliKeyTyped
        nitcli.setBackground(new Color (255,255,255)); 
    }//GEN-LAST:event_nitcliKeyTyped

    private void corcliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_corcliKeyTyped
        corcli.setBackground(new Color (255,255,255));
    }//GEN-LAST:event_corcliKeyTyped

    private void masMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masMouseClicked
        mas.setForeground(Color.BLACK);
        fem.setForeground(Color.BLACK);
    }//GEN-LAST:event_masMouseClicked

    private void femMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_femMouseClicked
        mas.setForeground(Color.BLACK);
        fem.setForeground(Color.BLACK);
    }//GEN-LAST:event_femMouseClicked

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        principal pr = new principal();
        pr.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton26ActionPerformed

    
    public void enviarDatos(){
        if(mas.isSelected()==true){
            ah4 ah = new ah4(nomcli.getText(),Integer.parseInt(nitcli.getText()),corcli.getText(),"M");
            ah4DAORelacional ad = new ah4DAORelacional();
            ad.crearClientes(ah);
            principal pr = new principal();
            pr.setVisible(true);
            dispose();
        }else if(fem.isSelected()==true){
            ah4 ah = new ah4(nomcli.getText(),Integer.parseInt(nitcli.getText()),corcli.getText(),"F");
            ah4DAORelacional ad = new ah4DAORelacional();
            ad.crearClientes(ah);
            principal pr = new principal();
            pr.setVisible(true);
            dispose();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addCl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField corcli;
    private javax.swing.JRadioButton fem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton26;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton mas;
    private javax.swing.JTextField nitcli;
    private javax.swing.JTextField nomcli;
    private javax.swing.ButtonGroup sexo;
    // End of variables declaration//GEN-END:variables
}