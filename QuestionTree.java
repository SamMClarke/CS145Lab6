/** 
 * QuestionTree.java
 * @Author: Sam Clarke, JeongGyu Tak, Nick Ivancovich
 * @Date: 240306
 * @Class: CS&145
 * @Assignment: LAB#6
 * @Purpose: Using recursion for TreeNodes 
 */
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Represents a binary tree structure used for a simple question-based game.
 */
public class QuestionTree {
    private QuestionNode overallRoot;
    private UserInterface ui;
    private int gamesPlayed = 0;
    private int gamesWon = 0;

    /**
     * Constructs a QuestionTree object with the given UserInterface.
     *
     * @param ui the UserInterface object to interact with the user
     * @throws IllegalArgumentException if the ui parameter is null
     */
    public QuestionTree(UserInterface ui) {
        if (ui == null) {
            throw new IllegalArgumentException("UI parameter is null");
        }
        overallRoot = new QuestionNode("computer");
        this.ui = ui;
    }

    /**
     * Initiates the game starting from the root node.
     */
    public void play() {
        play(overallRoot);
    }

    /**
     * Conducts a single round of the game starting from the specified node.
     * If the node is a leaf node, it prompts the user with a question, 
     * and if it's an interior node, it recursively traverses the tree based on user responses.
     *
     * @param root the node from which the game round begins
     */
    private void play(QuestionNode root) {
        if (root.yes == null && root.no == null) { // Leaf Node
            // Base case
            gamesPlayed++;
            ui.print("Would your object happen to be " + root.data + "?");
            if (ui.nextBoolean()) {
                // Win
                gamesWon++;
                ui.println("I win!");
            } else {
                // Lose
                ui.print("I lose. What is your object?");
                String object = ui.nextLine();
                ui.print("Type a yes/no question to distinguish your item from " + root.data + ":");
                String question = ui.nextLine();
                ui.print("And what is the answer for your object?");
                if (ui.nextBoolean()) {
                    root.yes = new QuestionNode(object);
                    root.no = new QuestionNode(root.data);
                } else {
                    root.no = new QuestionNode(object);
                    root.yes = new QuestionNode(root.data);
                }
                root.data = question;
            }
        } else {
            // Recursive case
            ui.print(root.data);
            if (ui.nextBoolean()) {
                play(root.yes);
            } else {
                play(root.no);
            }
        }
    }

    /**
     * Saves the current game state to the provided PrintStream.
     *
     * @param output the PrintStream to save the game state to
     * @throws IllegalArgumentException if the output parameter is null
     */
    public void save(PrintStream output) {
        if (output == null) {
            throw new IllegalArgumentException("Output parameter is null");
        }
        save(output, overallRoot);
    }

    /**
     * Saves the current state of the question tree to the provided PrintStream.
     * 
     * @param output the PrintStream to save the state to
     * @param root   the root node of the current subtree
     */
    private void save(PrintStream output, QuestionNode root) {
        if (root.yes == null && root.no == null) {
            // Base case: Leaf Node
            output.println("A:" + root.data);
        } else {
            // Recursive case: Interior Node
            output.println("Q:" + root.data);
            save(output, root.yes);
            save(output, root.no);
        }
    }


    /**
     * Loads a previously saved game state from the provided Scanner.
     *
     * @param input the Scanner to load the game state from
     * @throws IllegalArgumentException if the input parameter is null
     */
    public void load(Scanner input) {
        if (input == null) {
            throw new IllegalArgumentException("Input parameter is null");
        }
        overallRoot = loadHelper(input);
    }
    
    /**
     * Helper method to recursively load a question tree from the provided Scanner.
     *
     * @param input the Scanner containing the serialized question tree data
     * @return the root node of the loaded question tree
     */
    private QuestionNode loadHelper(Scanner input) {
        QuestionNode root;
        if (!input.hasNextLine()) {
            return null;
        }
        String nextLine = input.nextLine();
        if (nextLine.charAt(0) == 'Q') {
            // Interior Node: Load question and its child nodes
            root = new QuestionNode(nextLine.substring(2));
            root.yes = loadHelper(input);
            root.no = loadHelper(input);
        } else {
            // Leaf Node: Load answer
            root = new QuestionNode(nextLine.substring(2));
        }
        return root;
    }


    /**
     * Returns the total number of games played.
     *
     * @return the total number of games played
     */
    public int totalGames() {
        return gamesPlayed;
    }

    /**
     * Returns the number of games won.
     *
     * @return the number of games won
     */
    public int gamesWon() {
        return gamesWon;
    }
}
