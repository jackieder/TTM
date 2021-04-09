import javax.swing.*;
import java.awt.*;

public class TeamPerson extends JComponent {
    JLabel name;
    JPanel panel;
    JPanel hoursPanel;
    JLabel hours;
    JLabel hoursWorked;
    JLabel setStatus;
    String status;

    public TeamPerson(String name, String hours, String status) {
        this.status = status;
        this.panel = new JPanel(false);
        this.name = new JLabel(name);
        this.name.setHorizontalAlignment(JLabel.CENTER);
        String nameFont = this.name.getFont().getFontName();
        this.name.setFont(new Font(nameFont, Font.BOLD, 30));
//        //this.panel.setLayout(layout);
        this.panel.setLayout(new GridLayout(3, 1));
        this.panel.add(this.name);

        // Add hours worked today label
        this.hoursPanel = new JPanel(false);
        this.hoursPanel.setLayout(new GridLayout(2, 1));
        this.hours = new JLabel("Hours Worked Today");
        this.hours.setHorizontalAlignment(JLabel.CENTER);
        String hoursFont = this.hours.getFont().getFontName();
        this.hours.setFont(new Font(hoursFont, Font.BOLD, 24));

        // Add hours worked today number
        this.hoursWorked = new JLabel(hours);
        this.hoursWorked.setHorizontalAlignment(JLabel.CENTER);
        String hoursWorkedFont = this.hours.getFont().getFontName();
        this.hoursWorked.setFont(new Font(hoursWorkedFont, Font.BOLD, 18));
        this.hoursPanel.add(this.hoursWorked, BorderLayout.SOUTH);

        // Add to hours panel
        this.hoursPanel.add(this.hours, BorderLayout.NORTH);
        this.hoursPanel.add(this.hoursWorked, BorderLayout.SOUTH);
        this.panel.add(this.hoursPanel);
    }

    public JComponent makePanel() {
        return this.panel;
    }


    public JLabel setStatus() {
        this.setStatus = new JLabel(this.status);
        this.setStatus.setHorizontalAlignment(JLabel.CENTER);

        if (this.status == "Available") {
            Color available = new Color(119, 211, 83);
            this.setStatus.setBackground(available);
            this.setStatus.setOpaque(true);
        }

        if (this.status == "Busy") {
            Color busy = new Color(255, 186, 92);
            this.setStatus.setBackground(busy);
            this.setStatus.setOpaque(true);
        }

        if (this.status == "Away") {
            Color away = new Color(249, 95, 98);
            this.setStatus.setBackground(away);
            this.setStatus.setOpaque(true);
        }

        if (this.status == "Out of Office") {
            Color oof = new Color(150, 159, 170);
            this.setStatus.setBackground(oof);
            this.setStatus.setOpaque(true);
        }

        return this.setStatus;
    }
}
