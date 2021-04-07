import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Status extends JPanel implements ActionListener {
  JButton changeStatus;
  JPanel statusPanel;
  // Create button panel for change status button
  // Currently: creating a status panel to handle changes, current status

  public Status() {
    this.statusPanel = new JPanel(false);
    this.changeStatus = new JButton("Change Status");
    changeStatus.setVerticalTextPosition(AbstractButton.BOTTOM);
    changeStatus.setHorizontalTextPosition(AbstractButton.CENTER);
    changeStatus.setMnemonic(KeyEvent.VK_M);
    statusPanel.add(changeStatus);
  }

  //Placeholder
  public void actionPerformed(ActionEvent e) {

  }

}
