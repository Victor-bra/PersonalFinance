package personalFinance.gui.panel;

import personalFinance.gui.MainFrame;
import personalFinance.model.Currency;
import personalFinance.model.Statistics;
import personalFinance.saveLoad.SaveData;
import personalFinance.settings.Format;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public final class LeftPanel extends AbstractPanel {

    public LeftPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(Style.BORDER_LEFT_PANEL);
        JLabel headerBC = new JLabel(Text.get("BALANCE_CURRENCIES"));
        headerBC.setFont(Style.FONT_LABEL_HEADER);
        headerBC.setIcon(Style.ICON_LEFT_PANEL_BALANCE_CURRENCIES);
        headerBC.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headerBC);

        addBalanceCurrencies();

        add(Box.createVerticalStrut(Style.PADDING_PANEL_BIG));
        JLabel headerB = new JLabel(Text.get("BALANCE"));
        headerB.setFont(Style.FONT_LABEL_HEADER);
        headerB.setIcon(Style.ICON_LEFT_PANEL_BALANCE);
        headerB.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headerB);
        addBalance();
    }

    private void addBalanceCurrencies() {
        for (Currency currency : SaveData.getInstance().getEnableCurrencies()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));
            add(new PanelBalanceCurrency(currency, Statistics.getBalanceCurrency(currency)));
        }
    }

    private void addBalance() {
        for (Currency currency : SaveData.getInstance().getEnableCurrencies()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));
            add(new PanelBalanceCurrency(currency, Statistics.getBalance(currency)));
        }
    }

    private class PanelBalanceCurrency extends JPanel {

        public PanelBalanceCurrency(Currency currency, double amount) {
            super();
            setLayout(new BorderLayout());
            setBackground(Style.COLOR_LEFT_PANEL_BALANCE);
            setBorder(Style.BORDER_PANEL);

            JLabel currencyLabel1 = new JLabel(currency.getTitle());
            JLabel amountLabel1 = new JLabel(Format.amount(amount, currency));

            currencyLabel1.setFont(Style.FONT_LABEL_LEFT_PANEL_CURRENCY);
            amountLabel1.setFont(Style.FONT_LABEL_LEFT_PANEL_AMOUNT);

            add(currencyLabel1, BorderLayout.WEST);
            add(Box.createRigidArea(Style.DIMENSION_PADDING_PANEL));
            add(amountLabel1, BorderLayout.EAST);
        }
    }

}
