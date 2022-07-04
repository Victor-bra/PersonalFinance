package personalFinance.gui.handler;

import personalFinance.gui.MainFrame;
import personalFinance.settings.HandlerCode;
import personalFinance.settings.Settings;
import personalFinance.settings.Text;

import java.awt.event.ActionEvent;

public class MenuSettingsHandler extends Handler {

    public MenuSettingsHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case HandlerCode.MENU_SETTINGS_LANGUAGE_RUSSIAN -> {
                Settings.setLANGUAGE("ru");
            }
            case HandlerCode.MENU_SETTINGS_LANGUAGE_ENGLISH -> {
                Settings.setLANGUAGE("en");
            }
        }
        Text.init();
        frame.getMenu().refresh();
        super.actionPerformed(e);
    }
}
