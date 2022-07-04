package personalFinance.gui.handler;

import personalFinance.gui.MainFrame;
import personalFinance.gui.panel.StatisticsPanel;
import personalFinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class ChartHandler extends Handler {

    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case HandlerCode.TYPE -> {
                ((StatisticsPanel)frame.getRightPanel()).nextType();
            }
        }
        super.actionPerformed(e);
    }
}
