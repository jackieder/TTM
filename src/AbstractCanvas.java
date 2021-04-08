import javax.swing.*;
import java.awt.*;

public abstract class AbstractCanvas extends JPanel{
  public JPanel panel;
  public JLabel filler;
  CardLayout layout;

  public AbstractCanvas(String text) {
    this.layout = new CardLayout();
    this.panel = new JPanel(false);
    this.panel.setLayout(this.layout);
    this.filler = new JLabel(text);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(filler);


  }

  public JComponent makePanel() {
    return this.panel;
  }

}
