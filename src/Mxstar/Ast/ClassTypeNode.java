package Mxstar.Ast;

import Mxstar.ErrorProcessor.Location;

public class ClassTypeNode extends Type{
    public String name;

    public ClassTypeNode() {
        name = null;
    }
    public ClassTypeNode(String name) {
        this.name = name;
    }
    public ClassTypeNode(String name, Location nlocation) {
        this.name = name;
        this.location = nlocation;
    }

    public void accept(AstVisitor visitor) {
        visitor.visit(this);
    }
}
