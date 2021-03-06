package personalFinance.gui.panel;

import personalFinance.gui.EnableEditDelete;
import personalFinance.gui.MainFrame;
import personalFinance.gui.Refresh;
import personalFinance.gui.table.TableDate;
import personalFinance.gui.toolbar.AbstractToolBar;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;

public abstract class RightPanel extends AbstractPanel {

    protected TableDate td;

    private String title;
    private ImageIcon icon;
    private JPanel[] panels;

    public RightPanel(MainFrame frame, TableDate td, String title, ImageIcon icon, JPanel[] panels) {
        super(frame);
        this.td = td;
        this.title = title;
        this.icon = icon;
        this.panels = panels;
        init();
    }

    public RightPanel(MainFrame frame, TableDate td, String title, ImageIcon icon, AbstractToolBar tb) {
        this(frame, td, title, icon, new JPanel[]{tb});
    }

    public RightPanel(MainFrame frame, TableDate td, String title, ImageIcon icon) {
        this(frame, td, title, icon, new JPanel[]{});
    }

    protected void setPanels(JPanel[] panels) {
        this.panels = panels;
    }

    @Override
    public void refresh() {
        super.refresh();
        if (td != null)
            td.refresh();
        for (JPanel panel : panels) {
            if (panel instanceof Refresh)
                ((Refresh) panel).refresh();
        }
    }

    private void enableEditDelete() {
        for (JPanel panel : panels) {
            if (panel instanceof EnableEditDelete)
                ((EnableEditDelete) panel).setEnableEditDelete(false);
        }
        frame.getMenu().setEnableEditDelete(false);

        if (td != null) {
            if (td.getSelectedRow() != -1) {
                for (JPanel panel : panels) {
                    if (panel instanceof EnableEditDelete)
                        ((EnableEditDelete) panel).setEnableEditDelete(true);
                }
                frame.getMenu().setEnableEditDelete(true);
            }
        }
    }

    @Override
    protected final void init() {
        enableEditDelete();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel header = new JLabel(Text.get(title));
        header.setFont(Style.FONT_LABEL_HEADER);
        header.setIcon(icon);
        header.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(header);

        if (panels.length == 0)
            add(Box.createVerticalStrut(Style.PADDING_PANEL_EMPTY));

        for (JPanel panel : panels) {
            add(panel);
            add(Box.createVerticalStrut(Style.PADDING_PANEL));
        }

        if (td != null) {
            JScrollPane scroll = new JScrollPane(td);
            add(scroll);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            ListSelectionModel selectionModel = td.getSelectionModel();
            selectionModel.addListSelectionListener(e -> enableEditDelete());
        }
    }

    public TableDate getTableDate(){
        return td;
    }
}
