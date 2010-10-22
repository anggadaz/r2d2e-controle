package br.ufrn.controle.fuzzycontroller.view.retractable;

import br.ufrn.siga.component.retractable.RetractablePanelContainer;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComponent;

/**
 *
 * @author Demetrios
 */
public class FuzzyRetractable extends RetractablePanelContainer {

    public FuzzyRetractable(JComponent parent) {
        super(parent);

        parent.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                validate();
            }

        });
    }

}
