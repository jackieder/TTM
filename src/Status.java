import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Status extends JPanel implements ActionListener {
  JButton changeStatus;
  JPanel statusPanel;
  String status;
  JLabel setStatus;
  JPanel cards;
  JPanel buttonPanel;
  JButton available;
  JButton busy;
  JButton away;
  JButton outOfOffice;
  final static String BUTTONPANEL = "Status Buttons";
  final static String STATUSPANEL = "Change Status";
  CardLayout layout;


  // Create button panel for change status button
  // Currently: creating a status panel to handle changes, current status

  public Status() {

    // Create Layout
    this.layout = new CardLayout();
    // Create main status panel
    this.statusPanel = new JPanel(false);
    this.buttonPanel = new JPanel(false);

    this.statusPanel.setLayout(new GridLayout(2, 1));
    this.buttonPanel.setLayout(new GridLayout(4, 1));

    this.cards = new JPanel(false);
    this.cards.setLayout(this.layout);

    // Create, set status
    this.status = "Available";
    this.setStatus = new JLabel(this.status);
    this.setStatus.setHorizontalAlignment(JLabel.CENTER);

    // Create change status button
    this.changeStatus = new JButton("Change Status");
    this.available = new JButton("Available");
    this.busy = new JButton("Busy");
    this.away = new JButton("Away");
    this.outOfOffice = new JButton("Out of Office");

    // Add button, status to panel
    this.statusPanel.add(this.setStatus, BorderLayout.NORTH);
    this.statusPanel.add(this.changeStatus, BorderLayout.SOUTH);

    // Add action listener to button
    this.makeButtons();


    this.cards.add(this.statusPanel);
    this.cards.add(this.buttonPanel);

    this.layout.addLayoutComponent(this.statusPanel, STATUSPANEL);
    this.layout.addLayoutComponent(this.buttonPanel, BUTTONPANEL);



  }

  public void makeButtons() {

    this.changeStatus.setVerticalTextPosition(AbstractButton.BOTTOM);
    this.changeStatus.setHorizontalTextPosition(AbstractButton.CENTER);
    this.changeStatus.setMnemonic(KeyEvent.VK_M);
    this.changeStatus.addActionListener(this);
    this.statusPanel.add(this.changeStatus);

    this.available.setVerticalTextPosition(AbstractButton.BOTTOM);
    this.available.setHorizontalTextPosition(AbstractButton.CENTER);
    this.available.addActionListener(this);
    this.buttonPanel.add(this.available);

    this.busy.setVerticalTextPosition(AbstractButton.BOTTOM);
    this.busy.setHorizontalTextPosition(AbstractButton.CENTER);
    this.busy.addActionListener(this);
    this.buttonPanel.add(this.busy);

    this.away.setVerticalTextPosition(AbstractButton.BOTTOM);
    this.away.setHorizontalTextPosition(AbstractButton.CENTER);
    this.away.addActionListener(this);
    this.buttonPanel.add(this.away);

    this.outOfOffice.setVerticalTextPosition(AbstractButton.BOTTOM);
    this.outOfOffice.setHorizontalTextPosition(AbstractButton.CENTER);
    this.outOfOffice.addActionListener(this);
    this.buttonPanel.add(this.outOfOffice);
  }

  public void resetStatus(String text){
    this.setStatus.setText(text);
  }

  //Placeholder
  public void actionPerformed(ActionEvent e) {
    Object action = e.getSource();

    if(action == this.changeStatus) {
      this.layout.show(this.cards, BUTTONPANEL);
    }

    if(action == this.available) {
      this.status = "Available";
      this.resetStatus(this.status);
      this.layout.show(this.cards, STATUSPANEL);
    }

    if(action == this.busy) {
      this.status = "Busy";
      this.resetStatus(this.status);
      this.layout.show(this.cards, STATUSPANEL);
    }

    if(action == this.away) {
      this.status = "Away";
      this.resetStatus(this.status);
      this.layout.show(this.cards, STATUSPANEL);
    }

    if(action == this.outOfOffice) {
      this.status = "Out of Office";
      this.resetStatus(this.status);
      this.layout.show(this.cards, STATUSPANEL);
    }

  }

  public JComponent makeStatus() {
    return this.cards;
  }

}
