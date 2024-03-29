

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Main {

    public static class TabbedPaneDemo extends JPanel {


        public TabbedPaneDemo() {
            super(new GridLayout(1, 1));

            JButton b2;
            JButton b3;
            JTabbedPane tabbedPane = new JTabbedPane();


            // Profile Panel
            ProfileCanvas profile = new ProfileCanvas("James S.");
           JComponent p = profile.makeProfileCanvas();
            // Add panel to tab pane
            tabbedPane.addTab(null, null, p, "View Profile");
            JLabel profileTitle = new JLabel("Profile");
            profileTitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
            profileTitle.setPreferredSize(new Dimension(100, 80));
            profileTitle.setHorizontalAlignment(JLabel.CENTER);
            tabbedPane.setTabComponentAt(0, profileTitle);
            tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

            // Teams Pane
            TeamCanvas team = new TeamCanvas(profile);
            JComponent t = team.makePanel();
            tabbedPane.addTab(null, null, t, "View Team");
            JLabel teamTitle = new JLabel("Team");
            teamTitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
            teamTitle.setPreferredSize(new Dimension(100, 80));
            teamTitle.setHorizontalAlignment(JLabel.CENTER);
            tabbedPane.setTabComponentAt(1, teamTitle);
            tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
            tabbedPane.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if(tabbedPane.getSelectedIndex() == 1) {
                        TeamCanvas newTeam = new TeamCanvas(profile);
                        JComponent c = newTeam.makePanel();
                        tabbedPane.setComponentAt(1, c);

                    }
                }
            });
            tabbedPane.setSelectedIndex(1);

            // Bulletin Panel
            JComponent panel3 = makeTextPanel("Bulletin");
            BulletinCanvas bulletin = new BulletinCanvas("b");
            JComponent b = bulletin.makeBulletinPanel();
            tabbedPane.addTab("Bulletin", null, b, "View Bulletin");
            JLabel bulletinTitle = new JLabel("Bulletin");
            bulletinTitle.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
            bulletinTitle.setPreferredSize(new Dimension(100, 80));
            bulletinTitle.setHorizontalAlignment(JLabel.CENTER);
            tabbedPane.setTabComponentAt(2, bulletinTitle);
            tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

            //Add the tabbed pane to this panel.
//            add(buttonPanel);
            add(tabbedPane);

            //The following line enables to use scrolling tabs.
            //tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        }

        protected JComponent makeTextPanel(String text) {
            // This is a sample text panel that came with the demo
            JPanel panel = new JPanel(false);
            JLabel filler = new JLabel(text);
            filler.setHorizontalAlignment(JLabel.CENTER);
            panel.setLayout(new GridLayout(1, 1));
            panel.add(filler);
            return panel;
        }

//    To use an image, not attached but will run with warning anyways

        /**
         * Returns an ImageIcon, or null if the path was invalid.
         */
        protected static ImageIcon createImageIcon(String path) {
            // This is sample code in case we want to use images in our buttons, etc.
            java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }

    }

    /**
     * Create the GUI and show it.  For thread safety, this method should be invoked from the event
     * dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TTM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 500));

        //Add content to the window.
        TabbedPaneDemo tabs = new TabbedPaneDemo();
        frame.add(tabs, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
