/**
 * JakobTak
 * 03/04/2024
 * CS145
 * This program plays 20 Questions with the user.
*/


// QuestionNode.java

// Creates a new question node with the string data as the data field.
// public QuestionNode(String data)
// Simply sets this.data to data and the left and right to null.

// Creates a new question node with the string as the data field and the left and right fields as yes and no respectively.
// public QuestionNode(String data, QuestionNode yes, QuestionNode no)
// Simply sets this.data, this.yes, and this.no to their respective fields.


// QuestionTree.java

// Creates a new question tree with a default starting node
// public QuestionTree(UserInterface ui)
// Sets overallroot to a node with the data "computer".
// Saves the ui parameter in a private variable.

//Plays one complete game of 20 Questions with the user
//public void play()
//If both left and right are null, we have a base case (answer has been found)
//Else we recursively call the play method again depending on what the user inputs (yes or no)
//If the base case is met, we check if the computer guessed correctly, and
//add a new question if we lost, otherwise we win and the game ends.

//Saves a question tree to a file.
//public void save(PrintStream output)
//Print the contents of the tree using preorder traversal,
//printing leaf nodes as answers (A:) and the others as questions (Q:).

//Builds a question tree using a file as input
//public void load(Scanner input)
//Recursivly reads through the file and adds nodes using pre order traversal,
//depending on weather the line starts with a (Q:) or a (A:).
//If A: create a leaf node, otherwise create a node with a set yes and no.

//Retruns the total number of games played
//public int totalGames()
//Simply return total games variable.

//Returns the total number of games the computer has won
//public int gamesWon()
//Simply return games won variable.