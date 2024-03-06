/** 
 * QuestionNode.java
 * @Author: Sam Clarke, JeongGyu Tak, Nick Ivancovich
 * @Date: 240306
 * @Class: CS&145
 * @Assignment: LAB#6
 * @Purpose: Using recursion for TreeNodes 
 */

/**
 * Represents a node in a binary tree used for a simple question-based game.
 */
public class QuestionNode {
    public String data; // The data stored in this node.
    public QuestionNode yes; // Reference to the node representing a "yes" answer.
    public QuestionNode no; // Reference to the node representing a "no" answer.

    /**
     * Constructs a QuestionNode with the given data and null references to child
     * nodes.
     *
     * @param data the data to be stored in this node
     */
    public QuestionNode(String data) {
        this(data, null, null);
    }

    /**
     * Constructs a QuestionNode with the given data and references to child nodes.
     *
     * @param data the data to be stored in this node
     * @param yes  reference to the node representing a "yes" answer
     * @param no   reference to the node representing a "no" answer
     */
    public QuestionNode(String data, QuestionNode yes, QuestionNode no) {
        this.data = data;
        this.yes = yes;
        this.no = no;
    }
}
