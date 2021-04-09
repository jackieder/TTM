import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ProfileCanvas extends JComponent{
  // This is a profile panel, 'default constructor' is a method that makes a panel
  public JPanel panel;
  public JLabel name;
  protected JComponent status;
  public JLabel hours;
  JLabel hoursWorked;
  JPanel hoursPanel;
  Status s;
  //GridLayout layout = new GridLayout(2, 1);

  public ProfileCanvas(String text) {
    this.panel = new JPanel(false);
    this.name = new JLabel(text);
    this.name.setHorizontalAlignment(JLabel.CENTER);
    String nameFont = this.name.getFont().getFontName();
    this.name.setFont(new Font(nameFont, Font.BOLD, 30));
    //this.panel.setLayout(layout);
    this.panel.setLayout(new GridLayout(3, 1));
    this.panel.add(this.name);

    // Add hours worked today label
    this.hoursPanel = new JPanel(false);
    this.hoursPanel.setLayout(new GridLayout(2, 1));
    this.hours = new JLabel("Hours Worked Today");
    this.hours.setHorizontalAlignment(JLabel.CENTER);
    String hoursFont = this.hours.getFont().getFontName();
    this.hours.setFont(new Font(hoursFont, Font.BOLD, 24));
    this.hoursPanel.add(this.hours, BorderLayout.NORTH);

    // Add hours worked today
    this.hoursWorked = new JLabel("3:46");
    String hoursWorkedFont = this.hours.getFont().getFontName();
    this.hoursWorked.setFont(new Font(hoursWorkedFont, Font.BOLD, 18));
    this.hoursWorked.setHorizontalAlignment(JLabel.CENTER);
    this.hoursPanel.add(this.hoursWorked, BorderLayout.SOUTH);


    // Create button panel for change status button
    // Currently: creating a status panel to handle changes, current status
    this.s = new Status();
    this.status = this.s.makeStatus();
    this.panel.add(this.hoursPanel);
    this.panel.add(this.status);
  }

  public JComponent makeProfileCanvas() {
    return this.panel;
  }

  public String selfStatus() {
    return this.s.getStatus();
  }


}
