import javax.swing.*;

public class BulletinCanvas extends AbstractCanvas {


  public BulletinCanvas(String text) {
    super(text);
  }

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
    return panel;
  }
}
