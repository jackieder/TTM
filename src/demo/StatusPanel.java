package demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class StatusPanel implements ActionListener {

    // This is a status panel
    protected JButton b2;
    protected JLabel status;
    public JComponent makeStatusPanel(String text) {

        // Create button panel for change status button, set layout
        JPanel buttonPanel = new JPanel(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        // Set status
        status = new JLabel(text);
        buttonPanel.add(status);

        // Change status button
        b2 = new JButton("Change Status");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        buttonPanel.add(b2);

        // need to plan how to do menu: overlay possible

        return buttonPanel;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
