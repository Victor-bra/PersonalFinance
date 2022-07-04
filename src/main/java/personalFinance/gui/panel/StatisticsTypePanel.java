package personalFinance.gui.panel;

import personalFinance.gui.MainButton;
import personalFinance.gui.MainFrame;
import personalFinance.gui.handler.ChartHandler;
import personalFinance.settings.HandlerCode;
import personalFinance.settings.Text;

public final class StatisticsTypePanel extends AbstractPanel{

    private final String title;

    public StatisticsTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = Text.get(title);
        init();
    }

    @Override
    protected void init() {
        MainButton type = new MainButton(title, new ChartHandler(frame), HandlerCode.TYPE);
        add(type);
    }
}
