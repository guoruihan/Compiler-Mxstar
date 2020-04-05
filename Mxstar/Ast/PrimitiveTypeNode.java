package Mxstar.Ast;

import Mxstar.ErrorProcessor.Location;

public class PrimitiveTypeNode extends Type{
    public String name;

    public PrimitiveTypeNode () {
        name = null;
    }
    public PrimitiveTypeNode (String nname, Location nlocation) {
        name = nname;
        location = nlocation;
    }
    public PrimitiveTypeNode (String name) {
        this.name = name;
    }

    public void accept(AstVisitor visitor) {
        visitor.visit(this);
    }
}