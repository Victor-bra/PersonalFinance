package personalFinance.gui.handler;

import personalFinance.gui.MainFrame;
import personalFinance.gui.dialog.AboutDialog;
import personalFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuHelpHandler extends Handler {

    public MenuHelpHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FunctionsHandler handler = frame.getRightPanel().getTableDate().getFunctionHandler();
        switch (e.getActionCommand()) {
            case HandlerCode.MENU_HELP_ABOUT -> {
                new AboutDialog().setVisible(true);
            }
        }
        super.actionPerformed(e);
    }
}
