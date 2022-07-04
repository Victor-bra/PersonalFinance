package personalFinance.gui.dialog;

import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import personalFinance.exception.ModelException;
import personalFinance.gui.MainButton;
import personalFinance.gui.MainFrame;
import personalFinance.gui.handler.AddEditDialogHandler;
import personalFinance.model.Common;
import personalFinance.settings.HandlerCode;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AddEditDialog extends JDialog {

    private final MainFrame frame;
    protected Common c;

    protected LinkedHashMap<String, JComponent> components = new LinkedHashMap<>();
    protected LinkedHashMap<String, ImageIcon> icons = new LinkedHashMap<>();
    protected LinkedHashMap<String, Object> values = new LinkedHashMap<>();

    public AddEditDialog(MainFrame frame) {
        super(frame, Text.get("ADD"), true);
        this.frame = frame;
        addWindowListener(new AddEditDialogHandler(frame, this));
        setResizable(false);
    }

    public Common getCommon() {
        return c;
    }

    public void setCommon(Common c) {
        this.c = c;
    }

    public final void showDialog() {
        setDialog();
        setVisible(true);
    }

    public final void closeDialog() {
        setVisible(false);
        this.c = null;
        components.clear();
        icons.clear();
        values.clear();
        dispose();
    }

    public boolean isAdd() {
        return c == null;
    }

    abstract protected void init();

    abstract protected void setValues();

    abstract public Common getCommonFromForm() throws ModelException;

    private void setDialog() {
        init();
        if (isAdd()) {
            setTitle(Text.get("ADD"));
            setIconImage(Style.ICON_ADD.getImage());
        } else {
            setValues();
            setTitle(Text.get("EDIT"));
            setIconImage(Style.ICON_EDIT.getImage());
        }
        getContentPane().removeAll();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        ((JPanel) getContentPane()).setBorder(Style.BORDER_DIALOG);
        for (Map.Entry<String, JComponent> entry : components.entrySet()) {
            String key = entry.getKey();
            JLabel label = new JLabel(Text.get(key));
            label.setIcon(icons.get(key));
            label.setFont(Style.FONT_DIALOG_LABEL);

            JComponent component = entry.getValue();
            if (component instanceof JTextField) {
                component.setPreferredSize(Style.DIMENSION_DIALOG_TEXT_FIELD_SIZE);
                if (values.containsKey(key)) ((JTextField) component).setText("" + values.get(key));
            } else if (component instanceof JComboBox) {
                if (values.containsKey(key)) ((JComboBox) component).setSelectedItem(values.get(key));
            } else if (component instanceof JDatePickerImpl) {
                if (values.containsKey(key))
                    ((UtilDateModel) ((JDatePickerImpl) component).getModel()).setValue((Date) values.get(key));
            }

            component.addKeyListener(new AddEditDialogHandler(frame, this));

            component.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add(label);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));
            add(component);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));
        }

        MainButton ok = new MainButton(Text.get("ADD"), Style.ICON_OK, new AddEditDialogHandler(frame, this), HandlerCode.ADD);
        if (!isAdd()) {
            ok.setActionCommand(HandlerCode.EDIT);
            ok.setText(Text.get("EDIT"));
        }

        MainButton cancel = new MainButton(Text.get("FC_CANCEL"), Style.ICON_CANCEL, new AddEditDialogHandler(frame, this), HandlerCode.CANCEL);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new BorderLayout());
        panelButton.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        panelButton.add(ok, BorderLayout.WEST);
        panelButton.add(Box.createRigidArea(Style.DIMENSION_DIALOG_PADDING_BUTTON), BorderLayout.CENTER);
        panelButton.add(cancel, BorderLayout.EAST);

        add(panelButton);
        pack();
        setLocationRelativeTo(null);
    }

    protected class CommonComboBox extends JComboBox {

        public CommonComboBox(Object[] objs) {
            super(objs);
            setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    DefaultListCellRenderer renderer =
                            (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    Common c = (Common) value;
                    if (c != null) renderer.setText(c.getValueFormCombobox());
                    return renderer;
                }
            });
        }
    }
}