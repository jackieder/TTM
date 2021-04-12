import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonPanel implements ActionListener {

    CardLayout teamLayout;
    JPanel peoplePanel;
    JPanel deck;
    TeamPerson person;
    JButton personButton;
    JComponent personCard;
    JButton goBack;

    public PersonPanel(CardLayout teamLayout, JPanel peoplePanel, JPanel deck, TeamPerson person) {
        this.teamLayout = teamLayout;
        this.peoplePanel = peoplePanel;
        this.deck = deck;
        this.person = person;
    }

    public void addPerson() {
        this.personButton = new JButton(this.person.getTeamPersonName());
        this.personCard = this.person.makePanel();
        this.peoplePanel.add(this.personButton);
        this.peoplePanel.add(this.person.setStatus());

        this.personButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        this.personButton.setHorizontalTextPosition(AbstractButton.CENTER);
        this.personButton.addActionListener(this);

        this.goBack = new JButton("Go Back");
        this.personCard.add(this.goBack);this.goBack.setHorizontalTextPosition(AbstractButton.LEFT);
        this.goBack.setHorizontalTextPosition(AbstractButton.CENTER);
        this.goBack.addActionListener(this);

        this.deck.add(this.personCard);
        this.teamLayout.addLayoutComponent(this.personCard, this.person.getTeamPersonName());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        if (action ==  this.goBack) {
            this.teamLayout.show(this.deck, "base panel");
        }

        if (action == this.personButton) {
            this.teamLayout.show(this.deck, this.person.getTeamPersonName());
        }
    }
}
