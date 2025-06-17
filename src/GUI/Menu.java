package GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Data.FileIO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.Icon;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Menu() {
        setupFrame();
        setupComponents();
        FileIO.Read();
    }

    private void setupFrame() {
        setTitle("Banking System");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 649, 474);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setForeground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
    }

    private void setupComponents() {
        addTitleLabel();
        addMenuButtons();
        addImage();
    }

    private void addTitleLabel() {
        JLabel lblBankingSystem = new JLabel("Banking System");
        lblBankingSystem.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankingSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblBankingSystem.setBounds(0, 69, 613, 59);
        contentPane.add(lblBankingSystem);
    }

    private void addMenuButtons() {
        addButton("Add Account", 166, e -> openWindow(GUIForm.addaccount));
        addButton("Deposit To Account", 213, e -> openWindow(GUIForm.depositacc));
        addButton("Withdraw From Account", 256, e -> openWindow(GUIForm.withdraw));
        addButton("Display Account List", 300, e -> openWindow(GUIForm.displaylist));
        addButton("Exit", 343, e -> exitApplication());
    }

    private void addButton(String text, int y, ActionListener action) {
        JButton button = new JButton(text);
        button.setBounds(217, y, 194, 33);
        button.addActionListener(action);
        contentPane.add(button);
    }

    private void openWindow(JFrame frame) {
        if (!frame.isVisible()) {
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Already Opened", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void exitApplication() {
        JOptionPane.showMessageDialog(this, "Thanks For Using");
        FileIO.Write();
        System.exit(0);
    }

    private void addImage() {
        JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon(Menu.class.getResource("/img/1.png")));
        lblImage.setBounds(397, 16, 216, 213);
        contentPane.add(lblImage);
    }
}
	
