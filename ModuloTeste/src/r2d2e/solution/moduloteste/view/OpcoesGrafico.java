/*
 * OpcoesGerais.java
 *
 * Created on 08/04/2010, 11:34:27
 */
package r2d2e.solution.moduloteste.view;

import java.awt.CardLayout;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.ListModel;

/**
 *
 * @author Rivaldo
 */
public class OpcoesGrafico extends javax.swing.JDialog {

    private final static String CARD_LAYOUT = "card_layout";
    private final static String CARD_CONFIGURACAO = "card_configuracao";
    private final static String CARD_JANELA = "card_janela";

    ImageIcon janela1 = new ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/janela1.png"));
    ImageIcon janela2 = new ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/janela2.png"));
    ImageIcon janela3 = new ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/janela3.png"));

    /** Creates new form OpcoesGerais */
    public OpcoesGrafico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        URL imgURL = getClass().getResource("/r2d2e/solution/moduloteste/view/resources/r2d2e.jpg");

        setIconImage(new ImageIcon(imgURL).getImage());
        setLocationRelativeTo(parent);

        changeCard(CARD_LAYOUT);
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
        buttonSalvar = new javax.swing.JButton();
        buttonFechar = new javax.swing.JButton();
        panelCard = new javax.swing.JPanel();
        panelJanela = new javax.swing.JPanel();
        cbNivel = new javax.swing.JCheckBox();
        cbSinal = new javax.swing.JCheckBox();
        cbAcao = new javax.swing.JCheckBox();
        panelConfiguracao = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        panelLayout = new javax.swing.JPanel();
        buttonLayout1 = new javax.swing.JButton();
        rbModo1 = new javax.swing.JRadioButton();
        rbModo2 = new javax.swing.JRadioButton();
        rbModo3 = new javax.swing.JRadioButton();
        panelButton = new javax.swing.JPanel();
        buttonLayout = new javax.swing.JButton();
        buttonConf = new javax.swing.JButton();
        buttonJanela = new javax.swing.JButton();
        separator = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.title")); // NOI18N
        setModal(true);
        setResizable(false);

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/save.png"))); // NOI18N
        buttonSalvar.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGerais.buttonSalvar.text")); // NOI18N
        buttonSalvar.setToolTipText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGerais.buttonSalvar.toolTipText")); // NOI18N
        buttonSalvar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonSalvar.setContentAreaFilled(false);
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/cancelar.png"))); // NOI18N
        buttonFechar.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGerais.buttonFechar.text")); // NOI18N
        buttonFechar.setToolTipText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGerais.buttonFechar.toolTipText")); // NOI18N
        buttonFechar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonFechar.setContentAreaFilled(false);
        buttonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFecharActionPerformed(evt);
            }
        });

        panelCard.setLayout(new java.awt.CardLayout());

        panelJanela.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.panelJanela.border.title"))); // NOI18N

        cbNivel.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.cbNivel.text")); // NOI18N

        cbSinal.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.cbSinal.text")); // NOI18N

        cbAcao.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.cbAcao.text")); // NOI18N

        javax.swing.GroupLayout panelJanelaLayout = new javax.swing.GroupLayout(panelJanela);
        panelJanela.setLayout(panelJanelaLayout);
        panelJanelaLayout.setHorizontalGroup(
            panelJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJanelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNivel)
                    .addComponent(cbSinal)
                    .addComponent(cbAcao))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        panelJanelaLayout.setVerticalGroup(
            panelJanelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJanelaLayout.createSequentialGroup()
                .addComponent(cbNivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAcao)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        panelCard.add(panelJanela, "card_janela");

        panelConfiguracao.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.panelConfiguracao.border.title"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gráfico Nível x Tempo", "Gráfico Sinal de Controle", "Gráfico Ação de Controle" }));

        jLabel1.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.jLabel1.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.jLabel2.text")); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gráfico Nível x Tempo", "Gráfico Sinal de Controle", "Gráfico Ação de Controle" }));

        jLabel3.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.jLabel3.text")); // NOI18N

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gráfico Nível x Tempo", "Gráfico Sinal de Controle", "Gráfico Ação de Controle" }));

        javax.swing.GroupLayout panelConfiguracaoLayout = new javax.swing.GroupLayout(panelConfiguracao);
        panelConfiguracao.setLayout(panelConfiguracaoLayout);
        panelConfiguracaoLayout.setHorizontalGroup(
            panelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConfiguracaoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelConfiguracaoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelConfiguracaoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        panelConfiguracaoLayout.setVerticalGroup(
            panelConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracaoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCard.add(panelConfiguracao, "card_configuracao");

        panelLayout.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.panelLayout.border.title"))); // NOI18N

        buttonLayout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/janela3.png"))); // NOI18N
        buttonLayout1.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.buttonLayout1.text")); // NOI18N
        buttonLayout1.setBorder(null);
        buttonLayout1.setBorderPainted(false);
        buttonLayout1.setContentAreaFilled(false);

        buttonGroup1.add(rbModo1);
        rbModo1.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.rbModo1.text")); // NOI18N
        rbModo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbModo1ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbModo2);
        rbModo2.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.rbModo2.text")); // NOI18N
        rbModo2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbModo2ItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbModo3);
        rbModo3.setSelected(true);
        rbModo3.setText(org.openide.util.NbBundle.getMessage(OpcoesGrafico.class, "OpcoesGrafico.rbModo3.text")); // NOI18N
        rbModo3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbModo3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelLayoutLayout = new javax.swing.GroupLayout(panelLayout);
        panelLayout.setLayout(panelLayoutLayout);
        panelLayoutLayout.setHorizontalGroup(
            panelLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayoutLayout.createSequentialGroup()
                .addGroup(panelLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbModo1)
                    .addComponent(rbModo2)
                    .addComponent(rbModo3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(buttonLayout1)
                .addContainerGap())
        );
        panelLayoutLayout.setVerticalGroup(
            panelLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayoutLayout.createSequentialGroup()
                .addGroup(panelLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayoutLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbModo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbModo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbModo3))
                    .addComponent(buttonLayout1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelCard.add(panelLayout, "card_layout");

        buttonLayout.setText("Layout");
        buttonLayout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonLayout.setContentAreaFilled(false);
        buttonLayout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLayoutActionPerformed(evt);
            }
        });

        buttonConf.setText("Configuração");
        buttonConf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonConf.setContentAreaFilled(false);
        buttonConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfActionPerformed(evt);
            }
        });

        buttonJanela.setText("Janela Extra");
        buttonJanela.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonJanela.setContentAreaFilled(false);
        buttonJanela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJanelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonLayout, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
            .addComponent(buttonConf, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
            .addComponent(buttonJanela, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(buttonLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonConf, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonJanela, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
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
                        .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
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
                            .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
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

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonLayoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLayoutActionPerformed
        changeCard(CARD_LAYOUT);
    }//GEN-LAST:event_buttonLayoutActionPerformed

    private void buttonConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfActionPerformed
        changeCard(CARD_CONFIGURACAO);
    }//GEN-LAST:event_buttonConfActionPerformed

    private void buttonJanelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJanelaActionPerformed
        changeCard(CARD_JANELA);
    }//GEN-LAST:event_buttonJanelaActionPerformed

    private void rbModo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbModo1ItemStateChanged
        buttonLayout1.setIcon(janela1);
    }//GEN-LAST:event_rbModo1ItemStateChanged

    private void rbModo2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbModo2ItemStateChanged
        buttonLayout1.setIcon(janela2);
    }//GEN-LAST:event_rbModo2ItemStateChanged

    private void rbModo3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbModo3ItemStateChanged
        buttonLayout1.setIcon(janela3);

    }//GEN-LAST:event_rbModo3ItemStateChanged

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
    private javax.swing.JButton buttonConf;
    private javax.swing.JButton buttonFechar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonJanela;
    private javax.swing.JButton buttonLayout;
    private javax.swing.JButton buttonLayout1;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JCheckBox cbAcao;
    private javax.swing.JCheckBox cbNivel;
    private javax.swing.JCheckBox cbSinal;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCard;
    private javax.swing.JPanel panelConfiguracao;
    private javax.swing.JPanel panelJanela;
    private javax.swing.JPanel panelLayout;
    private javax.swing.JRadioButton rbModo1;
    private javax.swing.JRadioButton rbModo2;
    private javax.swing.JRadioButton rbModo3;
    private javax.swing.JSeparator separator;
    // End of variables declaration//GEN-END:variables

}
