import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamCanvas extends JComponent implements ActionListener {

  // Required panels
  public JPanel panel;
  JPanel basePanel;
  JLabel title;
  JButton goBack;
  CardLayout teamLayout;
  JPanel peoplePanel;

  // Set up cards
  JComponent selfCard;


  //Own Profile
  TeamPerson james;

  // Team members
  JButton self;

  // Card labels
  final static String BASEPANEL = "base panel";
  final static String SELFPANEL = "self panel";


  public TeamCanvas(ProfileCanvas p) {
    // Set up panel with card layout
    this.teamLayout = new CardLayout();
    this.panel = new JPanel(false);
    this.panel.setLayout(this.teamLayout);

    // Set up base panel: should have title, people panel
    this.basePanel = new JPanel(false);
    this.basePanel.setLayout(new BorderLayout());
    this.panel.add(this.basePanel);
    this.teamLayout.addLayoutComponent(this.basePanel, BASEPANEL);

    // Set up title: team availability
    this.title = new JLabel("Team Availability");
    this.title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
    this.title.setHorizontalAlignment(JLabel.CENTER);
    this.basePanel.add(this.title, BorderLayout.PAGE_START);

    // Set up people panel
    this.peoplePanel = new JPanel(false);
    GridLayout peopleLayout = new GridLayout(5, 2);
    peopleLayout.setVgap(5);
    this.peoplePanel.setLayout(peopleLayout);
    this.basePanel.add(this.peoplePanel, BorderLayout.CENTER);


    // Add required elements
    this.james = new TeamPerson("James S.","3:46", p.selfStatus());
    this.addPeople();
    this.addButtons();


    // Add to team canvas panel
    this.panel.add(this.selfCard);


    // Add 'cards' to deck
    this.teamLayout.addLayoutComponent(this.selfCard, SELFPANEL);



  }

  public void addPeople() {
    // Set up team members
    this.self = new JButton("James S.");
    this.selfCard = this.james.makePanel();
    this.peoplePanel.add(this.self);
    this.peoplePanel.add(this.james.setStatus());

    TeamPerson team1 = new TeamPerson("Jake L.","1:20", "Busy");
    PersonPanel person1 = new PersonPanel(this, team1);
    person1.addPerson();

    TeamPerson team2 = new TeamPerson("John D.","0:00", "Out of Office");
    PersonPanel person2 = new PersonPanel(this, team2);
    person2.addPerson();

    TeamPerson team3 = new TeamPerson("Jessica R.","4:54", "Away");
    PersonPanel person3 = new PersonPanel(this, team3);
    person3.addPerson();

    TeamPerson team4 = new TeamPerson("Jill M.","2:39", "Available");
    PersonPanel person4 = new PersonPanel(this, team4);
    person4.addPerson();

  }


  public void addButtons() {
    // Manager profile
    this.self.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
    this.self.setHorizontalTextPosition(AbstractButton.CENTER);
    this.self.addActionListener(this);

    // Go back button
    this.goBack= new JButton("Go Back");
    this.selfCard.add(goBack);

    this.goBack.setHorizontalTextPosition(AbstractButton.CENTER);
    this.goBack.addActionListener(this);

  }



  public JPanel makePanel() {
    return this.panel;
  }

  public CardLayout getTeamLayout() {
    return this.teamLayout;
  }

  public JPanel getPeoplePanel() {
    return this.peoplePanel;
  }



  @Override
  public void actionPerformed(ActionEvent e) {
    Object action = e.getSource();

    if (action == this.self) {
      this.teamLayout.show(this.panel, SELFPANEL);
    }

    if (action == this.goBack) {
      this.teamLayout.show(this.panel, BASEPANEL);
    }
  }
}

