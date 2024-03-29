/*
 * OpcoesGerais.java
 *
 * Created on 08/04/2010, 11:34:27
 */
package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.quanser.Quanser;
import java.awt.CardLayout;

/**
 *
 * @author demetrios
 */
public class OpcoesGerais extends javax.swing.JDialog {

    private final static String CARD_CONFIGURACAO = "card_configuracao";
    private final static String CARD_CALIBRACAO = "card_calibracao";
    private final static String CARD_SERVIDOR = "card_servidor";
    public static boolean calibrationInitial = true;

    private MainView novoFrame;
    private boolean modificado = false;

    /** Creates new form OpcoesGerais */
    public OpcoesGerais(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

//        URL imgURL = getClass().getResource("/r2d2e/solution/moduloteste/view/resources/r2d2e.jpg");
//
//        setIconImage(new ImageIcon(imgURL).getImage());
        setLocationRelativeTo(parent);

        novoFrame = (MainView) parent;

        load();
        
        changeCard(CARD_CONFIGURACAO);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBack = new javax.swing.JPanel();
        buttonSalvar = new javax.swing.JButton();
        buttonFechar = new javax.swing.JButton();
        panelCard = new javax.swing.JPanel();
        panelCalibracao = new javax.swing.JPanel();
        labelTanque1 = new javax.swing.JLabel();
        textTanque1 = new javax.swing.JFormattedTextField();
        labelTanque2 = new javax.swing.JLabel();
        textTanque2 = new javax.swing.JFormattedTextField();
        cbCalibracaoInicial = new javax.swing.JCheckBox();
        panelServidor = new javax.swing.JPanel();
        textIP = new javax.swing.JTextField();
        labelIP = new javax.swing.JLabel();
        labelPort = new javax.swing.JLabel();
        textIPorta = new javax.swing.JTextField();
        panelButton = new javax.swing.JPanel();
        gradientPanel1 = new br.ufrn.siga.component.gradient.GradientPanel();
        buttonServidor = new javax.swing.JButton();
        buttonCalibracao = new javax.swing.JButton();
        separator = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opções Gerais");
        setModal(true);
        setResizable(false);

        panelBack.setBackground(new java.awt.Color(255, 255, 255));

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/save.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.setToolTipText("Salva Alteraçoes");
        buttonSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonSalvar.setContentAreaFilled(false);
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/cancelar.png"))); // NOI18N
        buttonFechar.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.buttonFechar.text")); // NOI18N
        buttonFechar.setToolTipText("Fecha a janela");
        buttonFechar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonFechar.setContentAreaFilled(false);
        buttonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharActionPerformed(evt);
            }
        });

        panelCard.setOpaque(false);
        panelCard.setLayout(new java.awt.CardLayout());

        panelCalibracao.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.panelCalibracao.border.title"))); // NOI18N
        panelCalibracao.setOpaque(false);

        labelTanque1.setText("Tanque 1 :");

        textTanque1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        textTanque1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTanque1.setText("0.00");
        textTanque1.setToolTipText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.textTanque1.toolTipText")); // NOI18N

        labelTanque2.setText("Tanque 2 :");

        textTanque2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        textTanque2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTanque2.setText("0.00");
        textTanque2.setToolTipText("Calibração do tanque 1");

        cbCalibracaoInicial.setSelected(true);
        cbCalibracaoInicial.setText("Calibração Inicial");
        cbCalibracaoInicial.setOpaque(false);

        javax.swing.GroupLayout panelCalibracaoLayout = new javax.swing.GroupLayout(panelCalibracao);
        panelCalibracao.setLayout(panelCalibracaoLayout);
        panelCalibracaoLayout.setHorizontalGroup(
            panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCalibracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbCalibracaoInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addGroup(panelCalibracaoLayout.createSequentialGroup()
                        .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTanque1)
                            .addComponent(labelTanque2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTanque2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(textTanque1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(cbCalibracaoInicial)
                .addContainerGap())
        );

        panelCard.add(panelCalibracao, "card_calibracao");

        panelServidor.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.panelServidor.border.title"))); // NOI18N
        panelServidor.setOpaque(false);

        textIP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textIP.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.textIP.text")); // NOI18N

        labelIP.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.labelIP.text")); // NOI18N

        labelPort.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.labelPort.text")); // NOI18N

        textIPorta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textIPorta.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.textIPorta.text")); // NOI18N

        javax.swing.GroupLayout panelServidorLayout = new javax.swing.GroupLayout(panelServidor);
        panelServidor.setLayout(panelServidorLayout);
        panelServidorLayout.setHorizontalGroup(
            panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServidorLayout.createSequentialGroup()
                        .addComponent(labelIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textIP, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                    .addGroup(panelServidorLayout.createSequentialGroup()
                        .addComponent(labelPort)
                        .addGap(46, 46, 46)
                        .addComponent(textIPorta, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelServidorLayout.setVerticalGroup(
            panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelIP, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPort)
                    .addComponent(textIPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        panelCard.add(panelServidor, "card_servidor");

        panelButton.setOpaque(false);

        gradientPanel1.setColor1(new java.awt.Color(255, 255, 255));
        gradientPanel1.setColor2(new java.awt.Color(119, 166, 110));

        buttonServidor.setBackground(new java.awt.Color(153, 153, 153));
        buttonServidor.setText("Servidor");
        buttonServidor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonServidor.setContentAreaFilled(false);
        buttonServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServidorActionPerformed(evt);
            }
        });

        buttonCalibracao.setBackground(new java.awt.Color(153, 153, 153));
        buttonCalibracao.setText("Calibração");
        buttonCalibracao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonCalibracao.setContentAreaFilled(false);
        buttonCalibracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalibracaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCalibracao, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(buttonServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addContainerGap())
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(buttonCalibracao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelBackLayout = new javax.swing.GroupLayout(panelBack);
        panelBack.setLayout(panelBackLayout);
        panelBackLayout.setHorizontalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGroup(panelBackLayout.createSequentialGroup()
                        .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBackLayout.setVerticalGroup(
            panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addGroup(panelBackLayout.createSequentialGroup()
                        .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_buttonFecharActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        save();
        dispose();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCalibracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalibracaoActionPerformed
        changeCard(CARD_CALIBRACAO);
    }//GEN-LAST:event_buttonCalibracaoActionPerformed

    private void buttonServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonServidorActionPerformed
        changeCard(CARD_SERVIDOR);
    }//GEN-LAST:event_buttonServidorActionPerformed

    private void load(){
        double cal1 = Quanser.getCALIBRATION1();
        double cal2 = Quanser.getCALIBRATION2();
        String ip = Quanser.getIP_QUANSER();
        int port = Quanser.getPORT_QUANSER();


        textTanque1.setText(Double.toString(cal1));
        textTanque2.setText(Double.toString(cal2));
        textIP.setText(ip);
        textIPorta.setText(Integer.toString(port));
        cbCalibracaoInicial.setSelected(calibrationInitial);
    }

    private void save() {
        String cal1 = textTanque1.getText();
        String cal2 = textTanque2.getText();

        String ip = textIP.getText();
        String port = textIPorta.getText();
        
        Quanser.setCALIBRATION1(Double.parseDouble(cal1));
        Quanser.setCALIBRATION2(Double.parseDouble(cal2));
        Quanser.setIP_QUANSER(ip);
        Quanser.setPORT_QUANSER(Integer.parseInt(port));


        calibrationInitial = cbCalibracaoInicial.isSelected();
    }

    private void changeCard(String card) {
        CardLayout cardLayout = (CardLayout) panelCard.getLayout();
        cardLayout.show(panelCard, card);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalibracao;
    private javax.swing.JButton buttonFechar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JButton buttonServidor;
    private javax.swing.JCheckBox cbCalibracaoInicial;
    private br.ufrn.siga.component.gradient.GradientPanel gradientPanel1;
    private javax.swing.JLabel labelIP;
    private javax.swing.JLabel labelPort;
    private javax.swing.JLabel labelTanque1;
    private javax.swing.JLabel labelTanque2;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCalibracao;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelServidor;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField textIP;
    private javax.swing.JTextField textIPorta;
    private javax.swing.JFormattedTextField textTanque1;
    private javax.swing.JFormattedTextField textTanque2;
    // End of variables declaration//GEN-END:variables
}
