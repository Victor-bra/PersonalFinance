package personalFinance.gui.handler;

import personalFinance.gui.MainFrame;
import personalFinance.saveLoad.SaveData;
import personalFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class FilterHandler extends Handler {

    public FilterHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case HandlerCode.LEFT -> {
                SaveData.getInstance().getFilter().prev();
            }
            case HandlerCode.RIGHT -> {
                SaveData.getInstance().getFilter().next();
            }
            case HandlerCode.STEP -> {
                SaveData.getInstance().getFilter().nextPeriod();
            }
        }
        super.actionPerformed(e);
    }
}
