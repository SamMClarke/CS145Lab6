import java.util.*;

import javax.xml.bind.annotation.W3CDomHandler;

import java.io.*;

public class QuestionTree
{
    private QuestionNode overallRoot;
    private UserInterface ui;
    private int gamesPlayed = 0;
    private int gamesWon = 0;

    public QuestionTree(UserInterface ui)
    {
        overallRoot = new QuestionNode("computer");
        this.ui = ui;
    }

    public void play()
    {
        play(overallRoot);
    }

    private void play(QuestionNode root)
    {
        if (root.yes == null && root.no == null)
        {
            //Base case
            gamesPlayed++;
            ui.print("Would your object happen to be " + root.data + "?");
            if (ui.nextBoolean())
            {
                //Win
                gamesWon++;
                ui.println("I win!");
            }
            else
            {
                //Lose
                ui.print("I lose. What is your object?");
                String object = ui.nextLine();
                ui.print("Type a yes/no question to distinguish your item from " + root.data + ":");
                String question = ui.nextLine();
                ui.print("And what is the answer for your object?");
                if (ui.nextBoolean())
                {
                    root.yes = new QuestionNode(object);
                    root.no = new QuestionNode(root.data);
                }
                else
                {
                    root.no = new QuestionNode(object);
                    root.yes = new QuestionNode(root.data);
                }
                root.data = question;
            }
        }
        else
        {
            //Recursive case
            ui.print(root.data);
            if (ui.nextBoolean())
            {
                play(root.yes);
            }
            else
            {
                play(root.no);
            }
        }
    }

    public void save(PrintStream output)
    {
        save(output, overallRoot);
    }

    private void save(PrintStream output, QuestionNode root)
    {
        if (root.yes == null && root.no == null)
        {
            //Base case
            output.println("A:" + root.data);
        }
        else
        {
            //Recursive case
            output.println("Q:" + root.data);
            save(output, root.yes);
            save(output, root.no);
        }
    }

    public void load(Scanner input)
    {

    }

    public int totalGames()
    {
        return gamesPlayed;
    }

    public int gamesWon()
    {
        return gamesWon;
    }
}