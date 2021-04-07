import javax.swing.*;

public abstract class AbstractCanvas extends JPanel{
  public JPanel panel;
  public JLabel filler;

  public AbstractCanvas(String text) {
    this.panel = new JPanel(false);
    this.filler = new JLabel(text);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(filler);

  }

  //Copy paste them later into an individual class
  public void goBackButton() {
  }

  public void logOutButton() {
  }

  public void bulletinButton() {
  }

  public void teamButton() {
  }

  public void profileButton() {
  }

}
