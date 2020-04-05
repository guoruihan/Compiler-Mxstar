package Mxstar.Ast;

import Mxstar.ErrorProcessor.Location;

public abstract class AstNode {
    public Location location = null;
    public abstract void accept(AstVisitor visitor);
}