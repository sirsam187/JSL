import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class fourth extends JFrame implements ActionListener 
{
    private JTextField textField;
    private double firstOperand, secondOperand, result;
    private String operator;
    
    public fourth() 
    {
        setTitle("Scientific Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            ".", "0", "=", "+",
            "C", "", "", "Back"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        firstOperand = 0;
        secondOperand = 0;
        operator = "";
        result = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            textField.setText(textField.getText() + command);
        } else if ("+-*/".contains(command)) {
            firstOperand = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        } 
        else if ("=".equals(command)) {
            secondOperand = Double.parseDouble(textField.getText());
            calculate();
            operator = "";
        } else if ("C".equals(command)) {
            textField.setText("");
        } else if ("Back".equals(command)) {
            String text = textField.getText();
            if (!text.isEmpty()) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    private void calculate() {
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    textField.setText("Error");
                    return;
                }
                break;
        }
        textField.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            fourth calculator = new fourth();
            calculator.setVisible(true);
        });
    }
}
