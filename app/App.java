package app;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.exception.Stringexceptions;

public class App extends JFrame implements ActionListener {
    private static final long serialVersionUID = 31828377563718273L;
    private static Random rd = new Random();
    private static JTextArea number = new JTextArea("Enter a number");
    private static JTextArea text = new JTextArea();
    private static JButton button = new JButton("Guess!");
    private static JButton quit = new JButton("Quit game");
    private static JButton section = new JButton("Change bounds");
    private static int ans;
    private static int t = 10,ub=0,lb=1000;
    private static boolean set = false;

    public App() {
        super("Number Guessing Game");
        ans = rd.nextInt();
        ans=map(ans);
        number.setBounds(40, 40, 200, 20);
        button.setBounds(260, 40, 100, 20);
        text.setBounds(40, 110, 200, 200);
        quit.setBounds(50, 320, 125, 25);
        section.setBounds(185, 320, 145, 25);
        text.setText("--- READ ME FIRST ---\nYou have 10 times to try.\nThe range is [0,1000).");
        text.setEditable(false);
        this.setLayout(null);
        this.setBounds(200, 200, 400, 400);
        this.add(number);
        this.add(button);
        this.add(text);
        this.add(quit);
        this.add(section);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(-1);
            }
        });
        button.addActionListener(this);
        quit.addActionListener(this);
        section.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int inputnum = 0;
        String input = number.getText();
        if (e.getSource() == button) {
            inputnum = strint(input);
            if (inputnum < ans) {
                text.setText("Blah! Too small!\n" + "Remaining tries: " + t);
            } else {
                if (inputnum == ans) {
                    text.setText("Yeah! You win!\n" + "Remaining tries: " + t);
                    return;
                } else {
                    text.setText("Hey there! Too big.\n" + "Remaining tries: " + t);
                }
            }
            if (t == 0) {
                text.setText("Oh no! You lose! Please try again.");
            }
            t--;
        }
        else if (e.getSource() == quit) {
            int option = JOptionPane.showOptionDialog(this, "Are you sure you want to quit?", "Confirmation", 0, 0, null, null, null);
            if(option != 0)
            {
                return;
            }
            System.exit(0);
        }
        else if (e.getSource() == section) {
            if(set) {
//                JOptionPane.showMessageDialog(this,"Already set!");
            }
            String opt = JOptionPane.showInputDialog(this,"Enter your desired upper bound.");
            int option = strint(opt);
            ub = option;
            opt = JOptionPane.showInputDialog(this,"Enter you desired lower bound.");
            option = strint(opt);
            lb=option;
            JOptionPane.showMessageDialog(this,"Bounds successfully set!");
            set = true;
        }
    }

    public static int map(int n) {
        if(n>ub)
        {
            n-=ub;
        }
        else if(n<lb)
        {
            n+=lb;
        }
        return n;
    }
    public static int strint(String n) {
        int r = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) < '0' || n.charAt(i) > '9') {
                text.setText("Input ");
            }
            r += n.charAt(i) - '0';
            r *= 10;
        }
        return r / 10;
    }

    public static void main(String[] args) {
        new App();
    }
}
