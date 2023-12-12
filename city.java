import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class first 
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Info Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel streetLabel = new JLabel("Street:");
        JTextField streetField = new JTextField();
        JLabel cityLabel = new JLabel("City:");
        JTextField cityField = new JTextField();
        JLabel pincodeLabel = new JLabel("Pin Code:");
        JTextField pincodeField = new JTextField();

        JButton myInfoButton = new JButton("MyInfo");
        myInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String street = streetField.getText();
                String city = cityField.getText();
                String pincode = pincodeField.getText();

                JLabel infoLabel = new JLabel("Name: " + name + "\nStreet: " + street + "\nCity: " + city + "\nPin Code: " + pincode);
                infoLabel.setFont(new Font("Arial", Font.ITALIC, 32));

                JFrame infoFrame = new JFrame("My Info");
                infoFrame.setLayout(new FlowLayout());
                infoFrame.add(infoLabel);
                infoFrame.pack();
                infoFrame.setVisible(true);
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(streetLabel);
        frame.add(streetField);
        frame.add(cityLabel);
        frame.add(cityField);
        frame.add(pincodeLabel);
        frame.add(pincodeField);
        frame.add(myInfoButton);

        frame.setVisible(true);
    }
}
