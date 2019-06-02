package windows.games.number_guess;

import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NumberGuess extends JFrame implements ActionListener
{
    private Random rd=new Random();
    private JTextArea number=new JTextArea("Enter a number");
    private JTextArea text=new JTextArea();
    private JButton button=new JButton("Guess!");
    private int ans;
    private int t=18;
    public NumberGuess()
    {
        super("Number Guessing Game");
        ans=rd.nextInt()%1000;
        number.setBounds(40, 40, 200, 20);
        button.setBounds(260, 40, 100, 20);
        text.setBounds(40, 110, 200, 200);
        text.setText("--- READ ME FIRST ---\nYou have 18 times to try.\nThe range is [0,1000].");
        this.setLayout(null);
        this.setBounds(200, 200, 400, 400);
        this.add(number);
        this.add(button);
        this.add(text);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(-1);
            }
        });
        button.addActionListener(this);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int inputnum=0;
        String input=number.getText();
        if(e.getSource()==button)
        {
            inputnum=strint(input);
            if(inputnum<ans)
            {
                text.setText("Blah! Too small!\n"+"Remaining tries: "+t);
            }
            else
            {
                if(inputnum==ans)
                {
                    text.setText("Yeah! You win!\n"+"Remaining tries: "+t);
                    return;
                }
                else
                {
                    text.setText("Hey there! Too big.\n"+"Remaining tries: "+t);
                }
            }
            t--;
            if(t==0)
            {
                text.setText("Oh no! You lose! Please try again.");
            }
        }
    }
    public int strint(String n)
    {
        int r=0;
        for(int i=0;i<n.length();i++)
        {
            r+=n.charAt(i)-'0';
            r*=10;
        }
        return r/10;
    }
    public static void main(String[] args)
    {
        new NumberGuess();
    }
}