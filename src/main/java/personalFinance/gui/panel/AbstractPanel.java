package personalFinance.gui.panel;

import personalFinance.gui.MainFrame;
import personalFinance.gui.Refresh;

import javax.swing.*;

public abstract class AbstractPanel extends JPanel implements Refresh {

    protected final MainFrame frame;

    public AbstractPanel(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }

    protected abstract void init();
}
