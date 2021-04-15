import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotePanel implements ActionListener {

    Note note;
    JPanel deck;
    JPanel notePanel;
    JPanel titlePanel;
    JPanel approval;
    Boolean status;
    CardLayout layout;
    JButton read;
    JButton goBack;
    JButton approve;
    JButton deny;
    BulletinCanvas bulletin;

    JPanel noteViewCard;
    JPanel approveCard;
    JPanel denyCard;
    JPanel approvePanel;
    JPanel denyPanel;
    JButton approveYes;
    JButton approveNo;
    JButton denyYes;
    JButton denyNo;

    public NotePanel(Note note, BulletinCanvas bulletin, Boolean pending) {
        this.bulletin = bulletin;
        this.status = pending;
        if (this.status == false) {
            this.notePanel = new JPanel(new GridLayout(1, 4));
        } else {
            this.notePanel = new JPanel(new GridLayout(1, 5));
        }
        this.note = note;
        this.titlePanel = new JPanel(new GridLayout(1, 2));
        this.deck = bulletin.makeBulletinPanel();
        this.status = pending;
        this.layout = bulletin.getLayout();
        this.approval = new JPanel(new GridLayout(1, 2));

        this.approve = new JButton("Post");
        Color green = new Color(119, 211, 83);
        this.approve.setBackground(green);
        this.approve.setOpaque(true);
        this.approve.setBorderPainted(false);
        this.approve.addActionListener(this);
        this.deny = new JButton("Deny");
        Color red = new Color(249, 95, 98);
        this.deny.setBackground(red);
        this.deny.setOpaque(true);
        this.deny.setBorderPainted(false);
        this.deny.addActionListener(this);

        this.makeNotePanel();
        this.makeNoteView();
    }

    public void makeTitlePanel() {
        this.read = new JButton("Read");
        this.read.setHorizontalTextPosition(AbstractButton.LEFT);
        JLabel noteTitle = new JLabel(this.note.getTitle());
        noteTitle.setHorizontalAlignment(JLabel.LEFT);
        this.read.addActionListener(this);
        this.titlePanel.add(noteTitle);
        this.titlePanel.add(this.read);
        this.notePanel.add(this.titlePanel);
    }

    public void makeNotePanel() {
        this.makeTitlePanel();
        JLabel author = new JLabel(this.note.getAuthor());
        JLabel date = new JLabel(this.note.getDate());
        author.setHorizontalAlignment(JLabel.CENTER);
        date.setHorizontalAlignment(JLabel.CENTER);
        this.notePanel.add(date);
        this.notePanel.add(author);

        if (this.status == true) {
            this.approval.add(this.approve);
            this.approval.add(this.deny);
            this.notePanel.add(this.approval);
        }

    }

    public void makeNoteView() {
        this.noteViewCard = new JPanel(new BorderLayout());
        JLabel noteContent = new JLabel(this.note.getContent());
        noteContent.setHorizontalAlignment(JLabel.CENTER);
        this.noteViewCard.add(noteContent, BorderLayout.CENTER);
        this.goBack = new JButton("Go Back");
        this.goBack.addActionListener(this);
        this.goBack.setHorizontalTextPosition(AbstractButton.CENTER);
        this.noteViewCard.add(this.goBack, BorderLayout.PAGE_END);

        this.deck.add(this.noteViewCard);
        this.layout.addLayoutComponent(this.noteViewCard, this.note.getTitle());

    }

    public void approveCard() {
        this.approveCard = new JPanel(new BorderLayout());
        this.approvePanel = new JPanel(new GridLayout(1, 2));
        JLabel message = new JLabel("Are you sure you want to post this note?");
        message.setHorizontalAlignment(JLabel.CENTER);

        this.approveYes = new JButton("Yes");
        this.approveYes.addActionListener(this);
        this.approveYes.setHorizontalTextPosition(AbstractButton.CENTER);

        this.approveNo = new JButton("No");
        this.approveNo.addActionListener(this);
        this.approveNo.setHorizontalTextPosition(AbstractButton.CENTER);

        this.approvePanel.add(this.approveYes);
        this.approvePanel.add(this.approveNo);

        this.approveCard.add(message, BorderLayout.CENTER);
        this.approveCard.add(this.approvePanel, BorderLayout.PAGE_END);

        this.deck.add(this.approveCard);
        this.layout.addLayoutComponent(this.approveCard, this.note.getTitle()+"Approve");
    }

    public void denyCard() {
        this.denyCard = new JPanel(new BorderLayout());
        this.denyPanel = new JPanel(new GridLayout(1, 2));
        JLabel message = new JLabel("Are you sure you want to deny this note?" + "\n" +
                "This will delete the note.");
        message.setHorizontalAlignment(JLabel.CENTER);

        this.denyYes = new JButton("Yes");
        this.denyYes.addActionListener(this);
        this.denyYes.setHorizontalTextPosition(AbstractButton.CENTER);

        this.denyNo = new JButton("No");
        this.denyNo.addActionListener(this);
        this.denyNo.setHorizontalTextPosition(AbstractButton.CENTER);

        this.denyPanel.add(this.denyYes);
        this.denyPanel.add(this.denyNo);

        this.denyCard.add(message, BorderLayout.CENTER);
        this.denyCard.add(this.denyPanel, BorderLayout.PAGE_END);

        this.deck.add(this.denyCard);
        this.layout.addLayoutComponent(this.denyCard, this.note.getTitle()+"Deny");
    }


    public JPanel getNotePanel(){
        return this.notePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        if (action == this.read) {
            this.layout.show(this.deck, this.note.getTitle());
        }

        if (action == this.goBack) {
            this.layout.show(this.deck,"base panel");
        }

        if (action == this.approve) {
            this.approveCard();
            this.layout.show(this.deck, this.note.getTitle()+"Approve");
        }

        if (action == this.approveYes) {
            this.bulletin.getPendingPanel().remove(this.getNotePanel());
            NotePanel changed = new NotePanel(this.note, this.bulletin, false);
            this.bulletin.getNotesPanel().add(changed.getNotePanel());
            this.layout.show(this.deck,"base panel");
        }

        if (action == this.approveNo) {
            this.layout.show(this.deck, this.note.getTitle());
        }

        if (action == this.deny) {
            this.denyCard();
            this.layout.show(this.deck, this.note.getTitle()+"Deny");

        }

        if (action == this.denyYes) {
            this.bulletin.getPendingPanel().remove(this.getNotePanel());
            this.layout.show(this.deck,"base panel");
        }

        if (action == this.denyNo) {
            this.layout.show(this.deck, this.note.getTitle());
        }

    }
}
