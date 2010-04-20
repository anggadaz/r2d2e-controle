/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OpcoesGerais.java
 *
 * Created on 08/04/2010, 11:34:27
 */
package r2d2e.solution.moduloteste.view;

import java.awt.CardLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import r2d2e.solution.moduloteste.domain.AlgController;
import r2d2e.solution.moduloteste.domain.Quanser;

/**
 *
 * @author demetrios
 */
public class OpcoesGerais extends javax.swing.JDialog {

    private final static String CARD_CONFIGURACAO = "card_configuracao";
    private final static String CARD_CALIBRACAO = "card_calibracao";
    private final static String CARD_SERVIDOR = "card_servidor";

    /** Creates new form OpcoesGerais */
    public OpcoesGerais(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        URL imgURL = getClass().getResource("/r2d2e/solution/moduloteste/view/resources/r2d2e.jpg");

        setIconImage(new ImageIcon(imgURL).getImage());
        setLocationRelativeTo(parent);

        double cal1 = Quanser.getCALIBRATION1();
        double cal2 = Quanser.getCALIBRATION2();

        String ip = Quanser.getIP_QUANSER();

        textTanque1.setText(Double.toString(cal1));
        textTanque2.setText(Double.toString(cal2));
        
        textIP.setText(ip);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonSalvar = new javax.swing.JButton();
        buttonFechar = new javax.swing.JButton();
        panelCard = new javax.swing.JPanel();
        configControle = new r2d2e.solution.moduloteste.view.ConfigControle();
        panelCalibracao = new javax.swing.JPanel();
        labelTanque1 = new javax.swing.JLabel();
        textTanque1 = new javax.swing.JFormattedTextField();
        labelTanque2 = new javax.swing.JLabel();
        textTanque2 = new javax.swing.JFormattedTextField();
        chkCalibracaoInicial = new javax.swing.JCheckBox();
        panelServidor = new javax.swing.JPanel();
        textIP = new javax.swing.JTextField();
        labelIP = new javax.swing.JLabel();
        panelButton = new javax.swing.JPanel();
        buttonConf = new javax.swing.JButton();
        buttonCalibracao = new javax.swing.JButton();
        buttonServidor = new javax.swing.JButton();
        separator = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.title")); // NOI18N
        setModal(true);
        setResizable(false);

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/save.png"))); // NOI18N
        buttonSalvar.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.buttonSalvar.text")); // NOI18N
        buttonSalvar.setToolTipText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.buttonSalvar.toolTipText")); // NOI18N
        buttonSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonSalvar.setContentAreaFilled(false);
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/cancelar.png"))); // NOI18N
        buttonFechar.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.buttonFechar.text")); // NOI18N
        buttonFechar.setToolTipText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.buttonFechar.toolTipText")); // NOI18N
        buttonFechar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonFechar.setContentAreaFilled(false);
        buttonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharActionPerformed(evt);
            }
        });

        panelCard.setLayout(new java.awt.CardLayout());
        panelCard.add(configControle, "card_configuracao");

        panelCalibracao.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.panelCalibracao.border.title"))); // NOI18N

        labelTanque1.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.labelTanque1.text")); // NOI18N

        textTanque1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        textTanque1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTanque1.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.textTanque1.text")); // NOI18N
        textTanque1.setToolTipText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.textTanque1.toolTipText")); // NOI18N

        labelTanque2.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.labelTanque2.text")); // NOI18N

        textTanque2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        textTanque2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTanque2.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.textTanque2.text")); // NOI18N
        textTanque2.setToolTipText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.textTanque2.toolTipText")); // NOI18N

        chkCalibracaoInicial.setSelected(true);
        chkCalibracaoInicial.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.chkCalibracaoInicial.text")); // NOI18N

        javax.swing.GroupLayout panelCalibracaoLayout = new javax.swing.GroupLayout(panelCalibracao);
        panelCalibracao.setLayout(panelCalibracaoLayout);
        panelCalibracaoLayout.setHorizontalGroup(
            panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCalibracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chkCalibracaoInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addGroup(panelCalibracaoLayout.createSequentialGroup()
                        .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTanque1)
                            .addComponent(labelTanque2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTanque2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(textTanque1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelCalibracaoLayout.setVerticalGroup(
            panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalibracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTanque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTanque1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTanque2)
                    .addComponent(textTanque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(chkCalibracaoInicial)
                .addContainerGap())
        );

        panelCard.add(panelCalibracao, "card_calibracao");

        panelServidor.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.panelServidor.border.title"))); // NOI18N

        textIP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textIP.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.textIP.text")); // NOI18N

        labelIP.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.labelIP.text")); // NOI18N

        javax.swing.GroupLayout panelServidorLayout = new javax.swing.GroupLayout(panelServidor);
        panelServidor.setLayout(panelServidorLayout);
        panelServidorLayout.setHorizontalGroup(
            panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textIP, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelServidorLayout.setVerticalGroup(
            panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelIP, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        panelCard.add(panelServidor, "card_servidor");

        buttonConf.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.buttonConf.text")); // NOI18N
        buttonConf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonConf.setContentAreaFilled(false);
        buttonConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfActionPerformed(evt);
            }
        });

        buttonCalibracao.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.buttonCalibracao.text")); // NOI18N
        buttonCalibracao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonCalibracao.setContentAreaFilled(false);
        buttonCalibracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalibracaoActionPerformed(evt);
            }
        });

        buttonServidor.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.buttonServidor.text")); // NOI18N
        buttonServidor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonServidor.setContentAreaFilled(false);
        buttonServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServidorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonConf, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
            .addComponent(buttonCalibracao, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
            .addComponent(buttonServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(buttonConf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCalibracao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_buttonFecharActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        // TODO add your handling code here:
        
        String cal1 = textTanque1.getText();
        String cal2 = textTanque2.getText();
        String ip = textIP.getText();

        cal1 = fixNumber(cal1);
        cal2 = fixNumber(cal2);

        Quanser.setCALIBRATION1(Double.parseDouble(cal1));
        Quanser.setCALIBRATION2(Double.parseDouble(cal2));
        Quanser.setIP_QUANSER(ip);

        AlgController.CONTROLAR_TANQUE = configControle.getSelectedControl();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfActionPerformed
        // TODO add your handling code here:
        changeCard(CARD_CONFIGURACAO);
    }//GEN-LAST:event_buttonConfActionPerformed

    private void buttonCalibracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalibracaoActionPerformed
        // TODO add your handling code here:
        changeCard(CARD_CALIBRACAO);
    }//GEN-LAST:event_buttonCalibracaoActionPerformed

    private void buttonServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonServidorActionPerformed
        // TODO add your handling code here:
        changeCard(CARD_SERVIDOR);
    }//GEN-LAST:event_buttonServidorActionPerformed
    private String fixNumber(String numb) {
        return numb.replace(",", ".");
    }

    private void changeCard(String card){
        CardLayout cardLayout = (CardLayout) panelCard.getLayout();
        cardLayout.show(panelCard, card);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                OpcoesGerais dialog = new OpcoesGerais(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalibracao;
    private javax.swing.JButton buttonConf;
    private javax.swing.JButton buttonFechar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JButton buttonServidor;
    private javax.swing.JCheckBox chkCalibracaoInicial;
    private r2d2e.solution.moduloteste.view.ConfigControle configControle;
    private javax.swing.JLabel labelIP;
    private javax.swing.JLabel labelTanque1;
    private javax.swing.JLabel labelTanque2;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCalibracao;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelServidor;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField textIP;
    private javax.swing.JFormattedTextField textTanque1;
    private javax.swing.JFormattedTextField textTanque2;
    // End of variables declaration//GEN-END:variables
}
