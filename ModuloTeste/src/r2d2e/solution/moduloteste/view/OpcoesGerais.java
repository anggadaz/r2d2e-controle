/*
 * OpcoesGerais.java
 *
 * Created on 08/04/2010, 11:34:27
 */
package r2d2e.solution.moduloteste.view;

import java.awt.CardLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import r2d2e.solution.moduloteste.domain.ConfigGerais;
import r2d2e.solution.moduloteste.handler.ControlModeHandler;
import r2d2e.solution.moduloteste.handler.SUtil;

/**
 *
 * @author demetrios
 */
public class OpcoesGerais extends javax.swing.JDialog {

    private final static String CARD_CONFIGURACAO = "card_configuracao";
    private final static String CARD_CALIBRACAO = "card_calibracao";
    private final static String CARD_SERVIDOR = "card_servidor";

    private NovoFrame novoFrame;
    private boolean modificado = false;

    /** Creates new form OpcoesGerais */
    public OpcoesGerais(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        URL imgURL = getClass().getResource("/r2d2e/solution/moduloteste/view/resources/r2d2e.jpg");

        setIconImage(new ImageIcon(imgURL).getImage());
        setLocationRelativeTo(parent);

        novoFrame = (NovoFrame) parent;

        changeCard(CARD_CONFIGURACAO);
        getConfig();
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
        panelConfiguracao = new javax.swing.JPanel();
        rbTanque1 = new javax.swing.JRadioButton();
        rbTanque2 = new javax.swing.JRadioButton();
        cbCascata = new javax.swing.JCheckBox();
        cbSeguidorReferencia = new javax.swing.JCheckBox();
        panelCalibracao = new javax.swing.JPanel();
        labelTanque1 = new javax.swing.JLabel();
        textTanque1 = new javax.swing.JFormattedTextField();
        labelTanque2 = new javax.swing.JLabel();
        textTanque2 = new javax.swing.JFormattedTextField();
        cbCalibracaoInicial = new javax.swing.JCheckBox();
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

        panelConfiguracao.setBackground(new java.awt.Color(0, 0, 0));
        panelConfiguracao.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.panelConfiguracao.border.title"))); // NOI18N
        panelConfiguracao.setMaximumSize(new java.awt.Dimension(217, 149));
        panelConfiguracao.setOpaque(false);
        panelConfiguracao.setPreferredSize(new java.awt.Dimension(217, 149));

        buttonGroup1.add(rbTanque1);
        rbTanque1.setSelected(true);
        rbTanque1.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.rbTanque1.text")); // NOI18N
        rbTanque1.setToolTipText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.rbTanque1.toolTipText")); // NOI18N
        rbTanque1.setOpaque(false);

        buttonGroup1.add(rbTanque2);
        rbTanque2.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.rbTanque2.text")); // NOI18N
        rbTanque2.setOpaque(false);
        rbTanque2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbTanque2ItemStateChanged(evt);
            }
        });

        buttonGroup2.add(cbCascata);
        cbCascata.setSelected(true);
        cbCascata.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.cbCascata.text")); // NOI18N
        cbCascata.setEnabled(false);
        cbCascata.setOpaque(false);

        buttonGroup2.add(cbSeguidorReferencia);
        cbSeguidorReferencia.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.cbSeguidorReferencia.text")); // NOI18N
        cbSeguidorReferencia.setEnabled(false);
        cbSeguidorReferencia.setOpaque(false);
        cbSeguidorReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeguidorReferenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConfiguracaoLayout = new javax.swing.GroupLayout(panelConfiguracao);
        panelConfiguracao.setLayout(panelConfiguracaoLayout);
        panelConfiguracaoLayout.setHorizontalGroup(
            panelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracaoLayout.createSequentialGroup()
                .addGroup(panelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConfiguracaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbTanque1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(rbTanque2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfiguracaoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(cbCascata, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfiguracaoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(cbSeguidorReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelConfiguracaoLayout.setVerticalGroup(
            panelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracaoLayout.createSequentialGroup()
                .addComponent(rbTanque1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbTanque2)
                .addGap(3, 3, 3)
                .addComponent(cbCascata)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(cbSeguidorReferencia))
        );

        panelCard.add(panelConfiguracao, "card_configuracao");

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

        cbCalibracaoInicial.setSelected(true);
        cbCalibracaoInicial.setText(org.openide.util.NbBundle.getMessage(OpcoesGerais.class, "OpcoesGerais.cbCalibracaoInicial.text")); // NOI18N

        javax.swing.GroupLayout panelCalibracaoLayout = new javax.swing.GroupLayout(panelCalibracao);
        panelCalibracao.setLayout(panelCalibracaoLayout);
        panelCalibracaoLayout.setHorizontalGroup(
            panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCalibracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbCalibracaoInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addGroup(panelCalibracaoLayout.createSequentialGroup()
                        .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTanque1)
                            .addComponent(labelTanque2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCalibracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTanque2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(textTanque1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(cbCalibracaoInicial)
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
                .addComponent(textIP, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelServidorLayout.setVerticalGroup(
            panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelIP, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
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
                .addContainerGap(55, Short.MAX_VALUE))
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
                        .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
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
                            .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_buttonFecharActionPerformed

    public void getConfig() {
        
        switch(ControlModeHandler.configGerais.CONTROLE) {
            case 0:
                rbTanque1.setSelected(true);
                break;
            case 1:
                rbTanque2.setSelected(true);
                cbCascata.setSelected(false);
                break;
            case 2:
                rbTanque2.setSelected(true);
                cbCascata.setSelected(true);
                break;
            case 3:
                rbTanque2.setSelected(true);
                cbSeguidorReferencia.setSelected(true);
                break;
        }
        
        double cal1 = ControlModeHandler.configGerais.getCalibration(ConfigGerais.C_TANQUE1);
        double cal2 = ControlModeHandler.configGerais.getCalibration(ConfigGerais.C_TANQUE2);
        
        boolean init = ControlModeHandler.configGerais.CAL_INICIAL;

        String ip = ControlModeHandler.configGerais.SERVIDOR;

        textTanque1.setText(Double.toString(cal1));
        textTanque2.setText(Double.toString(cal2));
        
        cbCalibracaoInicial.setSelected(init);

        textIP.setText(ip);
    }
    
    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        save();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfActionPerformed
        changeCard(CARD_CONFIGURACAO);
    }//GEN-LAST:event_buttonConfActionPerformed

    private void buttonCalibracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalibracaoActionPerformed
        changeCard(CARD_CALIBRACAO);
    }//GEN-LAST:event_buttonCalibracaoActionPerformed

    private void buttonServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonServidorActionPerformed
        changeCard(CARD_SERVIDOR);
    }//GEN-LAST:event_buttonServidorActionPerformed

    private void rbTanque2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbTanque2ItemStateChanged
        cbCascata.setEnabled(rbTanque2.isSelected());
        cbSeguidorReferencia.setEnabled(rbTanque2.isSelected());
    }//GEN-LAST:event_rbTanque2ItemStateChanged

    private void cbSeguidorReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeguidorReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSeguidorReferenciaActionPerformed

    void save() {
        String cal1 = textTanque1.getText();
        String cal2 = textTanque2.getText();

        String ip = textIP.getText();

        cal1 = SUtil.fixNumber(cal1);
        cal2 = SUtil.fixNumber(cal2);

        ControlModeHandler.configGerais.CAL_INICIAL = cbCalibracaoInicial.isSelected();
        ControlModeHandler.configGerais.setCalibration(ConfigGerais.C_TANQUE1, Double.parseDouble(cal1));
        ControlModeHandler.configGerais.setCalibration(ConfigGerais.C_TANQUE2, Double.parseDouble(cal2));
        ControlModeHandler.configGerais.SERVIDOR = ip;

        boolean modificado = false;

        if(rbTanque1.isSelected()) {
            modificado = (ControlModeHandler.configGerais.CONTROLE != ConfigGerais.C_TANQUE1);
            ControlModeHandler.configGerais.CONTROLE = ConfigGerais.C_TANQUE1;
            novoFrame.changeCardConf(NovoFrame.CARD_CONF_CONTROLE);
        } else if(cbCascata.isSelected()) {
            modificado = (ControlModeHandler.configGerais.CONTROLE != ConfigGerais.C_TANQUE_CASCATA);
            ControlModeHandler.configGerais.CONTROLE = ConfigGerais.C_TANQUE_CASCATA;
            novoFrame.changeCardConf(NovoFrame.CARD_CONF_CONTROLE_CASCATA);
        } else if(cbSeguidorReferencia.isSelected()){
            ControlModeHandler.configGerais.CONTROLE = ConfigGerais.TANQUE_SEGUIDOR;
            novoFrame.changeCardConf(NovoFrame.CARD_CONF_CONTROLE_SEGUIDOR);
        } else{
            modificado = (ControlModeHandler.configGerais.CONTROLE != ConfigGerais.C_TANQUE2);
            ControlModeHandler.configGerais.CONTROLE = ConfigGerais.C_TANQUE2;
            novoFrame.changeCardConf(NovoFrame.CARD_CONF_CONTROLE);
        }

        ControlModeHandler.atualizaOpcoes();

        if(modificado) {
            ControlModeHandler.initChart();
        }
    }

    private void changeCard(String card) {
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
    private javax.swing.JCheckBox cbCalibracaoInicial;
    private javax.swing.JCheckBox cbCascata;
    private javax.swing.JCheckBox cbSeguidorReferencia;
    private javax.swing.JLabel labelIP;
    private javax.swing.JLabel labelTanque1;
    private javax.swing.JLabel labelTanque2;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCalibracao;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelConfiguracao;
    private javax.swing.JPanel panelServidor;
    private javax.swing.JRadioButton rbTanque1;
    private javax.swing.JRadioButton rbTanque2;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextField textIP;
    private javax.swing.JFormattedTextField textTanque1;
    private javax.swing.JFormattedTextField textTanque2;
    // End of variables declaration//GEN-END:variables

}
