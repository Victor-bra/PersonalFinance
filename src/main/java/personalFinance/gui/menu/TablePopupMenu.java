package personalFinance.gui.menu;

import personalFinance.gui.Refresh;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.settings.HandlerCode;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;

public class TablePopupMenu extends JPopupMenu implements Refresh {

    private final FunctionsHandler handler;

    public TablePopupMenu(FunctionsHandler handler){
        super();
        this.handler = handler;
        init();
    }

    private void init() {
        JMenuItem editItem = new JMenuItem(Text.get("EDIT"));
        JMenuItem deleteItem = new JMenuItem(Text.get("DELETE"));

        editItem.setActionCommand(HandlerCode.EDIT);
        deleteItem.setActionCommand(HandlerCode.DELETE);

        editItem.addActionListener(handler);
        deleteItem.addActionListener(handler);

        editItem.setIcon(Style.ICON_MENU_POPUP_EDIT);
        deleteItem.setIcon(Style.ICON_MENU_POPUP_DELETE);
        add(editItem);
        add(deleteItem);
    }

    @Override
    public void refresh() {

    }
}
