import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class OnlineReservationSystem extends JFrame {
    private Map<String, String> users;
    private Map<String, Reservation> reservations;
    private JPanel registerPanel;
    private JPanel loginPanel;
    private JPanel reservationPanel;
    private JPanel cancellationPanel;
    private JMenuBar menuBar;

    private JTextField newUsernameField;
    private JPasswordField newPasswordField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField trainNumberField;
    private JTextField classTypeField;
    private JTextField dateField;
    private JTextField sourceField;
    private JTextField destinationField;
    private JTextField pnrField;

    public OnlineReservationSystem() {
        users = new HashMap<>();
        reservations = new HashMap<>();

        setTitle("Online Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createRegisterPanel();
        createLoginPanel();
        createReservationPanel();
        createCancellationPanel();
        createMenuBar();

        showRegisterPanel();
    }

    private void showRegisterPanel() {
        setContentPane(registerPanel);
        setSize(600, 400);
        setJMenuBar(null);
        revalidate();
        repaint();
    }

    private void showLoginPanel() {
        setContentPane(loginPanel);
        setSize(600, 400);
        setJMenuBar(null);
        revalidate();
        repaint();
    }

    private void showReservationPanel() {
        setContentPane(reservationPanel);
        setSize(600, 400);
        setJMenuBar(menuBar);
        revalidate();
        repaint();
    }

    private void showCancellationPanel() {
        setContentPane(cancellationPanel);
        setSize(600, 400);
        setJMenuBar(menuBar);
        revalidate();
        repaint();
    }

    private void createRegisterPanel() {
        registerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
    
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(usernameLabel, gbc);
    
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridy = 1;
        registerPanel.add(passwordLabel, gbc);
    
        newUsernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        registerPanel.add(newUsernameField, gbc);
    
        newPasswordField = new JPasswordField(20);
        gbc.gridy = 1;
        registerPanel.add(newPasswordField, gbc);
    
        JButton registerButton = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        registerPanel.add(registerButton, gbc);
    
        JButton exitButton = new JButton("Exit");
        gbc.gridy = 3;
        registerPanel.add(exitButton, gbc);
    
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = newUsernameField.getText();
                String password = new String(newPasswordField.getPassword());
    
                if (users.containsKey(username)) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    users.put(username, password);
                    JOptionPane.showMessageDialog(null, "Registration successful! You can now login with your new credentials.", "Registration", JOptionPane.INFORMATION_MESSAGE);
                    newUsernameField.setText("");
                    newPasswordField.setText("");
                    showLoginPanel();
                }
            }
        });
    
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createLoginPanel() {
        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
    
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(usernameLabel, gbc);
    
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridy = 1;
        loginPanel.add(passwordLabel, gbc);
    
        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        loginPanel.add(usernameField, gbc);
    
        passwordField = new JPasswordField(20);
        gbc.gridy = 1;
        loginPanel.add(passwordField, gbc);
    
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);
    
        JButton exitButton = new JButton("Exit");
        gbc.gridy = 3;
        loginPanel.add(exitButton, gbc);
    
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
    
                if (users.containsKey(username) && users.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!", "Login", JOptionPane.INFORMATION_MESSAGE);
                    showReservationPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    

    private void createReservationPanel() {
        reservationPanel = new JPanel(new GridLayout(9, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel trainNumberLabel = new JLabel("Train Number:");
        trainNumberField = new JTextField();
        JLabel classTypeLabel = new JLabel("Class Type:");
        classTypeField = new JTextField();
        JLabel dateLabel = new JLabel("Date of Journey:");
        dateField = new JTextField();
        JLabel sourceLabel = new JLabel("Source:");
        sourceField = new JTextField();
        JLabel destinationLabel = new JLabel("Destination:");
        destinationField = new JTextField();
        JButton reserveButton = new JButton("Reserve");
        JButton exitButton = new JButton("Exit");

        reservationPanel.add(nameLabel);
        reservationPanel.add(nameField);
        reservationPanel.add(trainNumberLabel);
        reservationPanel.add(trainNumberField);
        reservationPanel.add(classTypeLabel);
        reservationPanel.add(classTypeField);
        reservationPanel.add(dateLabel);
        reservationPanel.add(dateField);
        reservationPanel.add(sourceLabel);
        reservationPanel.add(sourceField);
        reservationPanel.add(destinationLabel);
        reservationPanel.add(destinationField);
        reservationPanel.add(new JLabel());
        reservationPanel.add(reserveButton);
        reservationPanel.add(new JLabel());
        reservationPanel.add(exitButton);

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int trainNumber = Integer.parseInt(trainNumberField.getText());
                String classType = classTypeField.getText();
                String date = dateField.getText();
                String source = sourceField.getText();
                String destination = destinationField.getText();

                String pnr = generatePNR();
                Reservation reservation = new Reservation(name, trainNumber, classType, date, source, destination);
                reservations.put(pnr, reservation);

                JOptionPane.showMessageDialog(null, "Reservation successful! Your PNR number is " + pnr, "Reservation", JOptionPane.INFORMATION_MESSAGE);
                clearReservationFields();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createCancellationPanel() {
        cancellationPanel = new JPanel(new GridLayout(4, 2));

        JLabel pnrLabel = new JLabel("PNR Number:");
        pnrField = new JTextField();
        JButton cancelButton = new JButton("Cancel Reservation");
        JButton exitButton = new JButton("Exit");

        cancellationPanel.add(pnrLabel);
        cancellationPanel.add(pnrField);
        cancellationPanel.add(new JLabel());
        cancellationPanel.add(cancelButton);
        cancellationPanel.add(new JLabel());
        cancellationPanel.add(exitButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pnr = pnrField.getText();

                if (reservations.containsKey(pnr)) {
                    Reservation reservation = reservations.get(pnr);
                    JOptionPane.showMessageDialog(null, "Reservation details:\n" + reservation, "Reservation Details", JOptionPane.INFORMATION_MESSAGE);

                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this reservation?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        reservations.remove(pnr);
                        JOptionPane.showMessageDialog(null, "Reservation successfully canceled!", "Cancellation", JOptionPane.INFORMATION_MESSAGE);
                        pnrField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid PNR number. Please try again.", "Cancellation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        JMenu reservationMenu = new JMenu("Reservation");
        JMenuItem makeReservationItem = new JMenuItem("Make a Reservation");
        reservationMenu.add(makeReservationItem);
        makeReservationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showReservationPanel();
            }
        });

        JMenu cancellationMenu = new JMenu("Cancellation");
        JMenuItem cancelReservationItem = new JMenuItem("Cancel a Reservation");
        cancellationMenu.add(cancelReservationItem);
        cancelReservationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCancellationPanel();
            }
        });

        menuBar.add(reservationMenu);
        menuBar.add(cancellationMenu);
    }

    private String generatePNR() {
        return "PNR" + System.currentTimeMillis();
    }

    private void clearReservationFields() {
        nameField.setText("");
        trainNumberField.setText("");
        classTypeField.setText("");
        dateField.setText("");
        sourceField.setText("");
        destinationField.setText("");
    }

    private class Reservation {
        private String name;
        private int trainNumber;
        private String classType;
        private String date;
        private String source;
        private String destination;

        public Reservation(String name, int trainNumber, String classType, String date, String source, String destination) {
            this.name = name;
            this.trainNumber = trainNumber;
            this.classType = classType;
            this.date = date;
            this.source = source;
            this.destination = destination;
        }

        @Override
        public String toString() {
            return "Name: " + name +
                    "\nTrain Number: " + trainNumber +
                    "\nClass Type: " + classType +
                    "\nDate: " + date +
                    "\nSource: " + source +
                    "\nDestination: " + destination;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OnlineReservationSystem().setVisible(true);
            }
        });
    }
}
