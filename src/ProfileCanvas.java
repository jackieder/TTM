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
  //GridLayout layout = new GridLayout(2, 1);

  public ProfileCanvas(String text) {
    this.panel = new JPanel(false);
    this.name = new JLabel(text);
    this.name.setHorizontalAlignment(JLabel.CENTER);
    //this.panel.setLayout(layout);
    this.panel.setLayout(new GridLayout(2, 1));
    this.panel.add(this.name);


    // Create button panel for change status button
    // Currently: creating a status panel to handle changes, current status
    Status s = new Status();
    this.status = s.makeStatus();

    this.panel.add(this.status);
  }

  public JComponent makeProfileCanvas() {
    return this.panel;
  }


}
