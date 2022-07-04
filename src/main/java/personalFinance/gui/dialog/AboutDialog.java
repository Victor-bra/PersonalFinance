package personalFinance.gui.dialog;

import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;

public class AboutDialog extends JDialog {

    public AboutDialog() {
        super();
        init();
        setTitle(Text.get("DIALOG_ABOUT_TITLE"));
        setIconImage(Style.ICON_ABOUT.getImage());
        setResizable(false);
    }

    private void init() {
        JEditorPane pane = new JEditorPane("text/html", Text.get("ABOUT"));
        pane.setEditable(false);
        pane.setOpaque(false);

        add(pane);
        pack();
        setLocationRelativeTo(null);
    }
}
