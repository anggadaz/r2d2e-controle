package r2d2e.solution.moduloteste.view;

import java.awt.CardLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import r2d2e.solution.moduloteste.domain.UpdateWater;
import r2d2e.solution.moduloteste.handler.MainFrameHandler;

/**
 *
 * @author Rivaldo Jr
 */
public class NovoFrame extends javax.swing.JFrame {

    private MainFrameHandler mainFrameHandler;
    public static final String CARD_CONF_TESTE = "cardConfTeste";
    public static final String CARD_CONF_CONTROLE = "cardConfControle";

    public static final String CARD_MAIN_TESTE = "cardMainTeste";
    public static final String CARD_MAIN_CONTROLE = "cardMainControle";

    public NovoFrame() {
        initComponents();
        mainFrameHandler = new MainFrameHandler(this);
        mainFrameHandler.enterTestMode();

        URL imgURL = getClass().getResource("/r2d2e/solution/moduloteste/view/resources/r2d2e.jpg");
        setIconImage(new ImageIcon(imgURL).getImage());

        setLocationRelativeTo(null);

        Splash.getInstance().finalizaSplash();
    }

    private static void SkinInitialize() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        try { /*SubstanceBusinessLookAndFeel()*/
            UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
        } catch (Exception e) {
            System.out.println("Substance Raven Graphite failed to initialize");
        }
    }

    public JButton getButtonIniciarTeste() {
        return buttonIniciar;
    }

    public JButton getButtonNovoCiclo() {
        return buttonNovoCiclo;
    }

    public JButton getButtonPararTeste() {
        return buttonParar;
    }

    public TestePanel getTestePanel1() {
        return testePanel;
    }

    public ConfTeste getConfTeste1() {
        return confTeste;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public TanquePanel getTanquePanel() {
        return tanquePanel;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new r2d2e.solution.moduloteste.view.BackgroundPanel();
        toolbarPanel = new javax.swing.JPanel();
        buttonIniciar = new javax.swing.JButton();
        buttonNovoCiclo = new javax.swing.JButton();
        buttonParar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        buttonOpcoesGrafico = new javax.swing.JButton();
        buttonOpcoesGeral = new javax.swing.JButton();
        tanquePanel = new r2d2e.solution.moduloteste.view.TanquePanel();
        mainPanel = new javax.swing.JPanel();
        testePanel = new r2d2e.solution.moduloteste.view.TestePanel();
        controlPanel = new r2d2e.solution.moduloteste.view.ControlPanel();
        opcoesPanel = new javax.swing.JPanel();
        confTeste = new r2d2e.solution.moduloteste.view.ConfTeste();
        confControle = new r2d2e.solution.moduloteste.view.ConfControle();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuTeste = new javax.swing.JCheckBoxMenuItem();
        menuControle = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.title")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        toolbarPanel.setOpaque(false);

        buttonIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/play_1.png"))); // NOI18N
        buttonIniciar.setToolTipText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonIniciar.toolTipText")); // NOI18N
        buttonIniciar.setBorder(null);
        buttonIniciar.setBorderPainted(false);
        buttonIniciar.setContentAreaFilled(false);
        buttonIniciar.setFocusable(false);
        buttonIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonIniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIniciarActionPerformed(evt);
            }
        });

        buttonNovoCiclo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/play-repeat.png"))); // NOI18N
        buttonNovoCiclo.setToolTipText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonNovoCiclo.toolTipText")); // NOI18N
        buttonNovoCiclo.setBorder(null);
        buttonNovoCiclo.setBorderPainted(false);
        buttonNovoCiclo.setContentAreaFilled(false);
        buttonNovoCiclo.setEnabled(false);
        buttonNovoCiclo.setFocusable(false);
        buttonNovoCiclo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonNovoCiclo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonNovoCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoCicloActionPerformed(evt);
            }
        });

        buttonParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/play-stop.png"))); // NOI18N
        buttonParar.setToolTipText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonParar.toolTipText")); // NOI18N
        buttonParar.setBorder(null);
        buttonParar.setBorderPainted(false);
        buttonParar.setContentAreaFilled(false);
        buttonParar.setEnabled(false);
        buttonParar.setFocusable(false);
        buttonParar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonParar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPararActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonOpcoesGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/statics-2.png"))); // NOI18N
        buttonOpcoesGrafico.setToolTipText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonOpcoesGrafico.toolTipText")); // NOI18N
        buttonOpcoesGrafico.setBorder(null);
        buttonOpcoesGrafico.setBorderPainted(false);
        buttonOpcoesGrafico.setContentAreaFilled(false);
        buttonOpcoesGrafico.setFocusable(false);
        buttonOpcoesGrafico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonOpcoesGrafico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonOpcoesGeral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/tools.png"))); // NOI18N
        buttonOpcoesGeral.setToolTipText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonOpcoesGeral.toolTipText")); // NOI18N
        buttonOpcoesGeral.setBorder(null);
        buttonOpcoesGeral.setBorderPainted(false);
        buttonOpcoesGeral.setContentAreaFilled(false);
        buttonOpcoesGeral.setFocusable(false);
        buttonOpcoesGeral.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonOpcoesGeral.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonOpcoesGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpcoesGeralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toolbarPanelLayout = new javax.swing.GroupLayout(toolbarPanel);
        toolbarPanel.setLayout(toolbarPanelLayout);
        toolbarPanelLayout.setHorizontalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonIniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonNovoCiclo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonParar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonOpcoesGrafico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonOpcoesGeral)
                .addContainerGap(756, Short.MAX_VALUE))
        );
        toolbarPanelLayout.setVerticalGroup(
            toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolbarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonOpcoesGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonOpcoesGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonParar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonNovoCiclo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        buttonIniciar.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonIniciarTeste.AccessibleContext.accessibleDescription")); // NOI18N
        buttonNovoCiclo.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonNovoCiclo.AccessibleContext.accessibleDescription")); // NOI18N
        buttonParar.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonPararTeste.AccessibleContext.accessibleDescription")); // NOI18N
        buttonOpcoesGrafico.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonOpcoesGrafico.AccessibleContext.accessibleDescription")); // NOI18N
        buttonOpcoesGeral.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.buttonOpcoesGeral.AccessibleContext.accessibleDescription")); // NOI18N

        tanquePanel.setOpaque(false);

        javax.swing.GroupLayout tanquePanelLayout = new javax.swing.GroupLayout(tanquePanel);
        tanquePanel.setLayout(tanquePanelLayout);
        tanquePanelLayout.setHorizontalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        tanquePanelLayout.setVerticalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.CardLayout());
        mainPanel.add(testePanel, "cardMainTeste");
        mainPanel.add(controlPanel, "cardMainControle");

        opcoesPanel.setOpaque(false);
        opcoesPanel.setLayout(new java.awt.CardLayout());

        confTeste.setOpaque(false);
        opcoesPanel.add(confTeste, "cardConfTeste");

        confControle.setOpaque(false);
        opcoesPanel.add(confControle, "cardConfControle");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tanquePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcoesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 707, Short.MAX_VALUE))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(toolbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanquePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opcoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jMenu1.setText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.jMenu1.text")); // NOI18N

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/close.png"))); // NOI18N
        menuSair.setText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.menuSair.text")); // NOI18N
        jMenu1.add(menuSair);

        menuBar.add(jMenu1);

        jMenu2.setText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.jMenu2.text")); // NOI18N

        menuTeste.setSelected(true);
        menuTeste.setText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.menuTeste.text")); // NOI18N
        menuTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTesteActionPerformed(evt);
            }
        });
        jMenu2.add(menuTeste);

        menuControle.setText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.menuControle.text")); // NOI18N
        menuControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuControleActionPerformed(evt);
            }
        });
        jMenu2.add(menuControle);

        menuBar.add(jMenu2);

        jMenu3.setText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.jMenu3.text")); // NOI18N

        itemSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/r2d2e20X20.jpg"))); // NOI18N
        itemSobre.setText(org.openide.util.NbBundle.getMessage(NovoFrame.class, "NovoFrame.itemSobre.text")); // NOI18N
        itemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSobreActionPerformed(evt);
            }
        });
        jMenu3.add(itemSobre);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSobreActionPerformed
        About about = new About(this, true);
        about.setLocationRelativeTo(this);
        about.setVisible(true);
    }//GEN-LAST:event_itemSobreActionPerformed

    private void buttonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIniciarActionPerformed
        mainFrameHandler.play();
    }//GEN-LAST:event_buttonIniciarActionPerformed

    private void buttonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPararActionPerformed
        mainFrameHandler.stop();
    }//GEN-LAST:event_buttonPararActionPerformed

    private void buttonNovoCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoCicloActionPerformed
        mainFrameHandler.cycle();
    }//GEN-LAST:event_buttonNovoCicloActionPerformed

    private void menuTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTesteActionPerformed
        menuTeste.setSelected(true);
        menuControle.setSelected(false);
        mainFrameHandler.enterTestMode();
    }//GEN-LAST:event_menuTesteActionPerformed

    private void menuControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuControleActionPerformed
        menuControle.setSelected(true);
        menuTeste.setSelected(false);
        mainFrameHandler.enterControlMode();
    }//GEN-LAST:event_menuControleActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        mainFrameHandler.closeConnection();
    }//GEN-LAST:event_formWindowClosing

    private void buttonOpcoesGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpcoesGeralActionPerformed
        // TODO add your handling code here:
        mainFrameHandler.initOpcoesGerais();
    }//GEN-LAST:event_buttonOpcoesGeralActionPerformed

    public void changeCardConf(String card) {
        CardLayout layout = (CardLayout) opcoesPanel.getLayout();
        layout.show(opcoesPanel, card);
    }

    public void changeCardMain(String card) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, card);
    }

    public ConfControle getConfControle() {
        return confControle;
    }

    public void setConfControle(ConfControle confControle) {
        this.confControle = confControle;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Splash.getInstance().inicializaSplash();
                SkinInitialize();
                new NovoFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private r2d2e.solution.moduloteste.view.BackgroundPanel backgroundPanel;
    private javax.swing.JButton buttonIniciar;
    private javax.swing.JButton buttonNovoCiclo;
    private javax.swing.JButton buttonOpcoesGeral;
    private javax.swing.JButton buttonOpcoesGrafico;
    private javax.swing.JButton buttonParar;
    private r2d2e.solution.moduloteste.view.ConfControle confControle;
    private r2d2e.solution.moduloteste.view.ConfTeste confTeste;
    private r2d2e.solution.moduloteste.view.ControlPanel controlPanel;
    private javax.swing.JMenuItem itemSobre;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JCheckBoxMenuItem menuControle;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JCheckBoxMenuItem menuTeste;
    private javax.swing.JPanel opcoesPanel;
    private r2d2e.solution.moduloteste.view.TanquePanel tanquePanel;
    private r2d2e.solution.moduloteste.view.TestePanel testePanel;
    private javax.swing.JPanel toolbarPanel;
    // End of variables declaration//GEN-END:variables
}
