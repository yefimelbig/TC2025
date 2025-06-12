package compiler.parser;

import java.util.*;

public class ASTNode {
    private String nodeType;
    private String value;
    private List<ASTNode> children;
    private int line;
    private int column;
    
    public ASTNode(String nodeType, String value, int line, int column) {
        this.nodeType = nodeType;
        this.value = value;
        this.line = line;
        this.column = column;
        this.children = new ArrayList<>();
    }
    
    public ASTNode(String nodeType, String value) {
        this(nodeType, value, 0, 0);
    }
    
    public void addChild(ASTNode child) {
        children.add(child);
    }
    
    // Getters y setters
    public String getNodeType() { return nodeType; }
    public String getValue() { return value; }
    public List<ASTNode> getChildren() { return children; }
    public int getLine() { return line; }
    public int getColumn() { return column; }
    
    // Método para visualizar el árbol
    public void printTree(int indent) {
        String spaces = "  ".repeat(indent);
        System.out.println(spaces + nodeType + (value != null ? " (" + value + ")" : ""));
        for (ASTNode child : children) {
            child.printTree(indent + 1);
        }
    }
    
    @Override
    public String toString() {
        return nodeType + (value != null ? " (" + value + ")" : "");
    }
}