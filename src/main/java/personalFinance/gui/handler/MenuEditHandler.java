package personalFinance.gui.handler;

import personalFinance.gui.MainFrame;
import personalFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuEditHandler extends Handler {

    public MenuEditHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FunctionsHandler handler = frame.getRightPanel().getTableDate().getFunctionHandler();
        switch (e.getActionCommand()) {
            case HandlerCode.MENU_EDIT_ADD -> {
                handler.add();
            }
            case HandlerCode.MENU_EDIT_EDIT -> {
                handler.edit();
            }
            case HandlerCode.MENU_EDIT_DELETE -> {
                handler.delete();
            }
        }
        super.actionPerformed(e);
    }
}
