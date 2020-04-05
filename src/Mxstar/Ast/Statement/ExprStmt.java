package Mxstar.Ast.Statement;
import Mxstar.Ast.Expr.*;

import Mxstar.Ast.*;
import Mxstar.ErrorProcessor.Location;

public class ExprStmt extends Stmt {
    public Expr expression;

    public ExprStmt() {
        expression = null;
    }
    public ExprStmt (Expr expression){
        this.expression = expression;
    }
    public  ExprStmt(Location nlocation, Expr nexpr){
        location = nlocation;
        expression = nexpr;
    }

    public void accept(AstVisitor visitor) {
        visitor.visit(this);
    }
}