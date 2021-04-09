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
  JComponent team1Card;
  JComponent team2Card;
  JComponent team3Card;
  JComponent team4Card;

  //Own Profile
  TeamPerson james;

  // Team members
  JButton self;
  JButton team1;
  JButton team2;
  JButton team3;
  JButton team4;

  // Card labels
  final static String BASEPANEL = "base panel";
  final static String SELFPANEL = "self panel";
  final static String TEAM1PANEL = "team1";
  final static String TEAM2PANEL = "team2";
  final static String TEAM3PANEL = "team3";
  final static String TEAM4PANEL = "team4";

  public TeamCanvas(ProfileCanvas p) {
    // Set up panel with card layout
    this.teamLayout = new CardLayout();
    this.panel = new JPanel(false);
    this.panel.setLayout(this.teamLayout);

    // Set up base panel: should have title, people panel
    this.basePanel = new JPanel(false);
    this.basePanel.setLayout(new BorderLayout());

    // Set up title: team availability
    this.title = new JLabel("Team Availability");
    this.title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
    this.title.setHorizontalAlignment(JLabel.CENTER);
    this.basePanel.add(this.title, BorderLayout.PAGE_START);

    // Set up people panel
    this.peoplePanel = new JPanel(false);
    this.peoplePanel.setLayout(new GridLayout(5,2));
    this.basePanel.add(this.peoplePanel, BorderLayout.CENTER);


    // Add required elements
    this.james = new TeamPerson("James S.","3:46", p.selfStatus());
    this.addPeople();
    this.addButtons();


    // Add to team canvas panel
    this.panel.add(this.basePanel);
    this.panel.add(this.selfCard);
    this.panel.add(this.team1Card);
    this.panel.add(this.team2Card);
    this.panel.add(this.team3Card);
    this.panel.add(this.team4Card);

    // Add 'cards' to deck
    this.teamLayout.addLayoutComponent(this.basePanel, BASEPANEL);
    this.teamLayout.addLayoutComponent(this.selfCard, SELFPANEL);
    this.teamLayout.addLayoutComponent(this.team1Card, TEAM1PANEL);
    this.teamLayout.addLayoutComponent(this.team2Card, TEAM2PANEL);
    this.teamLayout.addLayoutComponent(this.team3Card, TEAM3PANEL);
    this.teamLayout.addLayoutComponent(this.team4Card, TEAM4PANEL);


  }

  public void addPeople() {
    // Set up team members
    this.self = new JButton("James S.");
    this.selfCard = this.james.makePanel();
    this.peoplePanel.add(this.self);
    this.peoplePanel.add(this.james.setStatus());

    this.team1 = new JButton("Jake L.");
    TeamPerson team1 = new TeamPerson("Jake L.","1:20", "Busy");
    this.team1Card = team1.makePanel();
    this.peoplePanel.add(this.team1);
    this.peoplePanel.add(team1.setStatus());

    this.team2 = new JButton("John D.");
    TeamPerson team2 = new TeamPerson("John D.","0:00", "Out of Office");
    this.team2Card = team2.makePanel();
    this.peoplePanel.add(this.team2);
    this.peoplePanel.add(team2.setStatus());

    this.team3 = new JButton("Jessica R.");
    TeamPerson team3 = new TeamPerson("Jessica R.","4:54", "Away");
    this.team3Card = team3.makePanel();
    this.peoplePanel.add(this.team3);
    this.peoplePanel.add(team3.setStatus());

    this.team4 = new JButton("Jill M.");
    TeamPerson team4 = new TeamPerson("Jill M.","2:39", "Available");
    this.team4Card = team4.makePanel();
    this.peoplePanel.add(this.team4);
    this.peoplePanel.add(team4.setStatus());

  }


  public void addButtons() {
    // Manager profile
    this.self.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
    this.self.setHorizontalTextPosition(AbstractButton.CENTER);
    this.self.addActionListener(this);

    // Go back button
    this.goBack= new JButton("Go Back");
    this.selfCard.add(goBack);
    this.team1Card.add(goBack);
    this.team2Card.add(goBack);
    this.team3Card.add(goBack);
    this.team4Card.add(goBack);
    this.goBack.setHorizontalTextPosition(AbstractButton.LEFT);
    this.goBack.setHorizontalTextPosition(AbstractButton.CENTER);
    this.goBack.addActionListener(this);

    this.team1.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
    this.team1.setHorizontalTextPosition(AbstractButton.CENTER);
    this.team1.addActionListener(this);

    this.team2.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
    this.team2.setHorizontalTextPosition(AbstractButton.CENTER);
    this.team2.addActionListener(this);

    this.team3.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
    this.team3.setHorizontalTextPosition(AbstractButton.CENTER);
    this.team3.addActionListener(this);

    this.team4.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
    this.team4.setHorizontalTextPosition(AbstractButton.CENTER);
    this.team4.addActionListener(this);


  }



  public JComponent makePanel() {
    return this.panel;
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

    if (action == this.team1) {
      this.teamLayout.show(this.panel, TEAM1PANEL);
    }

    if (action == this.team2) {
      this.teamLayout.show(this.panel, TEAM2PANEL);
    }

    if (action == this.team3) {
      this.teamLayout.show(this.panel, TEAM3PANEL);
    }

    if (action == this.team4) {
      this.teamLayout.show(this.panel, TEAM4PANEL);
    }
  }
}

