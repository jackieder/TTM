import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ProfileCanvas extends AbstractCanvas{
  // This is a profile panel, 'default constructor' is a method that makes a panel
  protected Status status;

  public ProfileCanvas(String text) {
    super(text);

    // Create button panel for change status button
    // Currently: creating a status panel to handle changes, current status
    this.status = new Status();
    this.panel.add(status);
  }


}
