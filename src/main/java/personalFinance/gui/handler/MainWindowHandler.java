package personalFinance.gui.handler;

import personalFinance.gui.MainFrame;
import personalFinance.gui.dialog.ConfirmDialog;
import personalFinance.saveLoad.SaveData;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindowHandler extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        if (SaveData.getInstance().isSaved())
            System.exit(0);
        else {
            int result = ConfirmDialog.show((MainFrame) e.getWindow(), "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
            if (result == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }
}
