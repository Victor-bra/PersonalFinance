package personalFinance.gui;

import personalFinance.gui.handler.MainToolBarHandler;
import personalFinance.gui.handler.MainWindowHandler;
import personalFinance.gui.menu.MainMenu;
import personalFinance.gui.panel.LeftPanel;
import personalFinance.gui.panel.OverviewPanel;
import personalFinance.gui.panel.RightPanel;
import personalFinance.gui.toolbar.MainToolBar;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private final GridBagConstraints constraints;
    private final MainMenu mb;
    private final LeftPanel leftPanel;
    private RightPanel rightPanel;
    private final MainToolBar tb;

    public MainFrame() {
        super(Text.get("PROGRAM_NAME"));

        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mb = new MainMenu(this);
        setJMenuBar(mb);

        setLayout(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        tb = new MainToolBar(new MainToolBarHandler(this));
        add(tb, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        leftPanel = new LeftPanel(this);
        add(leftPanel, constraints);

        setRightPanel(new OverviewPanel(this));

        pack();
        setLocationRelativeTo(null);

        addWindowListener(new MainWindowHandler());
    }

    public void setRightPanel(RightPanel panel) {
        if (rightPanel != null) remove(rightPanel);
        constraints.gridy = 1;
        constraints.gridx = 1;
        rightPanel = panel;
        panel.setBorder(Style.BORDER_PANEL);
        add(rightPanel, constraints);
        pack();
    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        tb.refresh();
        leftPanel.refresh();
        rightPanel.refresh();
        pack();
    }

    public MainMenu getMenu() {
        return mb;
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }
}
