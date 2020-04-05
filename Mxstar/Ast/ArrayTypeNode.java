package Mxstar.Ast;

import Mxstar.ErrorProcessor.Location;

public class ArrayTypeNode extends Type {
    public Type arraytype = null;
    public int dim;
    public ArrayTypeNode () {
    }
    public ArrayTypeNode (Location nlocation,int ndim) {
        location = nlocation;
        dim = ndim;
    }
    public void accept(AstVisitor visitor) {
        visitor.visit(this);
    }
}