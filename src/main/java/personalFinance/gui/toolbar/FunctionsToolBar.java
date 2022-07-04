package personalFinance.gui.toolbar;

import personalFinance.gui.EnableEditDelete;
import personalFinance.gui.MainButton;
import personalFinance.gui.dialog.AddEditDialog;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.handler.Handler;
import personalFinance.settings.HandlerCode;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

public final class FunctionsToolBar extends AbstractToolBar implements EnableEditDelete {

    private MainButton editButton;
    private MainButton deleteButton;

    public FunctionsToolBar(Handler handler) {
        super(Style.BORDER_FUNCTION_TOOLBAR, handler);
        init();
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        editButton.setEnabled(enable);
        deleteButton.setEnabled(enable);
    }

    @Override
    protected void init() {
        addButton(Text.get("ADD"), Style.ICON_ADD, HandlerCode.ADD, false);
        editButton = addButton(Text.get("EDIT"), Style.ICON_EDIT, HandlerCode.EDIT, false);
        deleteButton = addButton(Text.get("DELETE"), Style.ICON_DELETE, HandlerCode.DELETE, false);
    }
}
