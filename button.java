import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class second extends JFrame implements ActionListener 
{
    private JLabel label;

    public second() {
        super("Button App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        label = new JLabel("Press a button");
        add(label);

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonLabel = ((JButton) e.getSource()).getText();
        label.setText("Button '" + buttonLabel + "' was pressed");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            second app = new second();
            app.setVisible(true);
        });
    }
}
