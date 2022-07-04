package personalFinance.gui.toolbar;

import personalFinance.gui.MainButton;
import personalFinance.gui.Refresh;
import personalFinance.gui.handler.Handler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class AbstractToolBar extends JPanel implements Refresh {

    private final Handler handler;

    public AbstractToolBar(EmptyBorder border, Handler handler) {
        super();
        this.handler = handler;
        setBorder(border);
    }

    protected abstract void init();

    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon) {
        MainButton button = new MainButton(title, icon, handler, action);
        if (topIcon) {
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        } else {
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
        add(button);
        return button;
    }

    public void refresh() {
        removeAll();
        init();
    }
}
