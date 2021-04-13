import javax.swing.*;
import java.awt.*;

public class ColumnNames {
    JPanel columns;
    public ColumnNames(Boolean pending) {
        this.columns = new JPanel(new GridLayout(1, 5));

        JLabel title = new JLabel("Title");
        title.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        title.setHorizontalAlignment(JLabel.CENTER);


        JLabel date = new JLabel("Date");
        date.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        date.setHorizontalAlignment(JLabel.CENTER);

        JLabel by = new JLabel("By");
        by.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
        by.setHorizontalAlignment(JLabel.CENTER);

        this.columns.add(title);
        this.columns.add(date);
        this.columns.add(by);

        if (pending == true) {
            JLabel status = new JLabel("Status");
            status.setFont(new Font("Helvetica Neue", Font.BOLD, 12));
            status.setHorizontalAlignment(JLabel.CENTER);
            this.columns.add(status);
        }

    }

    public JPanel makeColumns() {
        return this.columns;
    }
}
