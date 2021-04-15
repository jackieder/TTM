import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BulletinCanvas implements ActionListener {
  JScrollPane scrollPane;
  JPanel panel;
  JPanel basePanel;
  JPanel pendingTitle;
  JPanel notesTitle;
  JPanel pendingPanel;
  JPanel notesPanel;
  JButton newNote;

  CardLayout layout;


  final String BASEPANEL = "base panel";

  public BulletinCanvas(String text) {
    this.layout = new CardLayout();
    this.panel = new JPanel(this.layout);

    // Set up basepanel, pending panel, notes panel
    this.basePanel = new JPanel();
    this.basePanel.setLayout(new GridLayout(2, 1));
    this.pendingPanel = new JPanel(new GridLayout(6, 1));
    this.notesPanel = new JPanel(new GridLayout(6, 1));
    this.pendingTitle = new JPanel(new BorderLayout());
    this.notesTitle = new JPanel(new GridLayout(1, 2));

    // Make pending notes panel
    JLabel pending = new JLabel("Notes Pending for Approval");
    pending.setHorizontalAlignment(JLabel.LEFT);
    pending.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
    this.pendingTitle.add(pending);
    this.pendingPanel.add(this.pendingTitle);
    ColumnNames col1 = new ColumnNames(true);
    this.pendingPanel.add(col1.makeColumns());


    // Make team notes panel
    JLabel teamNotes = new JLabel("Team Notes");
    teamNotes.setHorizontalAlignment(SwingConstants.LEFT);
    teamNotes.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
    this.notesTitle.add(teamNotes);
    this.newNote = new JButton("Create New Note");
    this.newNote.addActionListener(this);
    this.notesTitle.add(this.newNote);
    this.notesPanel.add(this.notesTitle);
    ColumnNames col2 = new ColumnNames(false);
    this.notesPanel.add(col2.makeColumns());

    // Add basepanel to panel, cardlayout
    this.basePanel.add(this.pendingPanel);
    this.basePanel.add(this.notesPanel);
    this.panel.add(this.basePanel);
    this.layout.addLayoutComponent(this.basePanel, BASEPANEL);

    this.addNotes();
  }

  public void addNotes(){
    Note printer = new Note("printer",  "there's no more paper in the printer",
            "Jack L.",  "04/12/21");
    NotePanel note1 = new NotePanel(printer, this, false);
    this.notesPanel.add(note1.getNotePanel());

    Note party = new Note("party",  "let's have a party",
            "Jack L.",  "04/12/21");
    NotePanel note2 = new NotePanel(party, this, true);
    this.pendingPanel.add(note2.getNotePanel());
  }

  public JPanel makeBulletinPanel() {
    return this.panel;

  }


  public CardLayout getLayout(){
    return this.layout;
  }

  public JPanel getBasePanel() {
    return this.basePanel;
  }

  public JPanel getNotesPanel() {
    return this.notesPanel;
  }

  public JPanel getPendingPanel() {
    return this.pendingPanel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object action = e.getSource();

    if (action == this.newNote) {
      CreateNote newNote = new CreateNote(this);
      this.layout.show(this.panel, "newNote");
    }
  }
}
