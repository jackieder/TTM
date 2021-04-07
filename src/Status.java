import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Status extends JPanel implements ActionListener {
  JButton changeStatus;
  JPanel statusPanel;
  ActionListener listener;
  // Create button panel for change status button
  // Currently: creating a status panel to handle changes, current status

  public Status() {
    this.statusPanel = new JPanel(false);
    this.changeStatus = new JButton("Change Status");
    changeStatus.setVerticalTextPosition(AbstractButton.BOTTOM);
    changeStatus.setHorizontalTextPosition(AbstractButton.CENTER);
    changeStatus.setMnemonic(KeyEvent.VK_M);
    statusPanel.add(changeStatus);

    changeStatus.addActionListener(this.listener);
  }

  //Placeholder
  public void actionPerformed(ActionEvent e) {
       JPanel statusChange = new JPanel(false);
       JButton available = new JButton("Available");
       JButton busy = new JButton("Busy");
       JButton away = new JButton("Away");
       JButton outOfOffice = new JButton("Out of Office");

    available.setVerticalTextPosition(AbstractButton.BOTTOM);
    available.setHorizontalTextPosition(AbstractButton.CENTER);
    statusPanel.add(available);

    busy.setVerticalTextPosition(AbstractButton.BOTTOM);
    busy.setHorizontalTextPosition(AbstractButton.CENTER);
    statusPanel.add(busy);

    away.setVerticalTextPosition(AbstractButton.BOTTOM);
    away.setHorizontalTextPosition(AbstractButton.CENTER);
    statusPanel.add(away);

    outOfOffice.setVerticalTextPosition(AbstractButton.BOTTOM);
    outOfOffice.setHorizontalTextPosition(AbstractButton.CENTER);
    statusPanel.add(outOfOffice);


  }

}
