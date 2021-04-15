import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

public class CreateNote implements ActionListener {
    BulletinCanvas bulletin;
    JPanel textPanel;
    JPanel deck;
    JPanel postButtons;
    Note note;
    NotePanel newNote;
    CardLayout layout;

    JPanel postNote;
    JPanel discardNote;

    JButton post;
    JButton discard;

    JButton postYes;
    JButton postGoBack;

    JButton discardYes;
    JButton discardGoBack;

    JTextField title;
    JTextArea content;

    private static final String DATE_FORMATTER= "MM/dd/yy";

    public CreateNote(BulletinCanvas bulletin) {
        this.bulletin = bulletin;
        this.deck = this.bulletin.makeBulletinPanel();
        this.layout = this.bulletin.getLayout();
        this.textPanel = new JPanel(new BorderLayout());

        this.makeNotePanel();
        this.makePostNote();
        this.makeDiscardNote();

    }

    public void makeNotePanel() {
        this.title = new JTextField("Note Title");
        this.content = new JTextArea("Type your note here . . .");

        this.textPanel.add(title, BorderLayout.PAGE_START);
        this.textPanel.add(content, BorderLayout.CENTER);
        this.makeButtons();

        this.deck.add(this.textPanel);
        this.layout.addLayoutComponent(this.textPanel, "newNote");

    }

    public void makeButtons() {
        this.post = new JButton("Post");
        this.post.setHorizontalTextPosition(AbstractButton.CENTER);
        this.post.addActionListener(this);

        this.discard = new JButton("Discard");
        this.discard.setHorizontalTextPosition(AbstractButton.CENTER);
        this.discard.addActionListener(this);

        this.postButtons = new JPanel(new GridLayout(1, 2));

        this.postButtons.add(this.post);
        this.postButtons.add(this.discard);
        this.textPanel.add(this.postButtons, BorderLayout.PAGE_END);

    }

    public void makePostNote(){
        this.postNote = new JPanel(new GridLayout(2, 1));
        JLabel message = new JLabel("Are you sure you want to post this note?");
        this.postNote.add(message);

        this.postYes = new JButton("Post");
        this.postYes.setHorizontalTextPosition(AbstractButton.CENTER);
        this.postYes.addActionListener(this);

        this.postGoBack = new JButton("Go Back");
        this.postGoBack.setHorizontalTextPosition(AbstractButton.CENTER);
        this.postGoBack.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(this.postYes);
        buttonPanel.add(this.postGoBack);
        this.postNote.add(buttonPanel);

        this.deck.add(this.postNote);
        this.layout.addLayoutComponent(this.postNote, "Post?");


    }

    public void makeDiscardNote(){
        this.discardNote = new JPanel(new GridLayout(2, 1));
        JLabel message = new JLabel("Are you sure you want to discard this note?");
        this.discardNote.add(message);

        this.discardYes = new JButton("Discard");
        this.discardYes.setHorizontalTextPosition(AbstractButton.CENTER);
        this.discardYes.addActionListener(this);

        this.discardGoBack = new JButton("Go Back");
        this.discardGoBack.setHorizontalTextPosition(AbstractButton.CENTER);
        this.discardGoBack.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(this.discardYes);
        buttonPanel.add(this.discardGoBack);
        this.discardNote.add(buttonPanel);

        this.deck.add(this.discardNote);
        this.layout.addLayoutComponent(this.discardNote, "Discard?");


    }

    public void createNewNote() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();

        if (action == this.post || action == this.discardGoBack) {
            this.layout.show(this.deck, "Post?");
        }

        if (action == this.postYes) {
            String noteTitle = this.title.getText();
            String noteContent = this.content.getText();
            String author = "James S.";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
            String date = java.time.LocalDateTime.now().format(formatter);
            this.note = new Note(noteTitle, noteContent, author, date);
            NotePanel newNote = new NotePanel(this.note, this.bulletin, false);
            this.bulletin.getNotesPanel().add(newNote.getNotePanel());
            this.layout.show(this.deck, "base panel");
        }

        if (action == this.postGoBack) {
            this.layout.show(this.deck, "base panel");
        }

        if (action == this.discard) {
            this.layout.show(this.deck, "Discard?");
        }

        if (action == this.discardYes) {
            this.layout.show(this.deck, "base panel");
        }

    }
}
