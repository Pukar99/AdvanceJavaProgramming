package tradeo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Tradeo extends JFrame {
    private JTextField txtDate, txtSymbol, txtQuantity, txtPrice;
    private JButton btnSave;
    private JRadioButton rbBuy, rbSell;
    private ButtonGroup bgType;

    public Tradeo() {
        createUI();
    }

    private void createUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Date:"));
        txtDate = new JTextField(10);
        add(txtDate);

        add(new JLabel("Stock Symbol:"));
        txtSymbol = new JTextField(5);
        add(txtSymbol);

        add(new JLabel("Quantity:"));
        txtQuantity = new JTextField(5);
        add(txtQuantity);

        add(new JLabel("Price:"));
        txtPrice = new JTextField(5);
        add(txtPrice);

        rbBuy = new JRadioButton("Buy");
        rbSell = new JRadioButton("Sell");
        bgType = new ButtonGroup();
        bgType.add(rbBuy);
        bgType.add(rbSell);
        add(rbBuy);
        add(rbSell);

        btnSave = new JButton("Save Entry");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveEntry();
            }
        });
        add(btnSave);

        pack();
        setVisible(true);
    }

    private void saveEntry() {
        String tradeType = rbBuy.isSelected() ? "Buy" : "Sell";
        String data = String.join(", ",
            txtDate.getText(),
            txtSymbol.getText(),
            tradeType,
            txtQuantity.getText(),
            txtPrice.getText()
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("trades.txt", true))) {
            writer.write(data);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Entry Saved!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving entry.");
        }
    }

    public static void main(String[] args) {
        new Tradeo();
    }
}
