package demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ProfilePanel extends AbstractPanel implements ActionListener {

    // This is a profile panel, 'default constructor' is a method that makes a panel
    protected JButton b2;
    public JComponent makeProfilePanel(String text) {
        // Create the profile panel with the name of the person whose profile it is
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(filler);

        // Create button panel for change status button
        // Currently: creating a status panel to handle changes, current status
        JPanel buttonPanel = new JPanel(false);

        b2 = new JButton("Change Status");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        buttonPanel.add(b2);

        // Add button panel to profile panel
        panel.add(buttonPanel);

        return panel;
    }
    public void actionPerformed(ActionEvent e) {

    }
}
