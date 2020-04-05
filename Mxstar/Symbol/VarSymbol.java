package Mxstar.Symbol;



//import Mxstar.IR.Operand.VirReg;
import Mxstar.ErrorProcessor.Location;

public class VarSymbol extends TypeSymbol{
    public String name;
    public VarType variableType;
    public Location location;

    public boolean isClassField;//what's this
    public boolean isGlobalVariable;//what's this
//  public VirReg virReg;


    public VarSymbol() {
        name = null;
        variableType = null;
        location = null;
    }
    public VarSymbol(String name, VarType variableType, Location location, boolean isClassField, boolean isGlobalVariable) {
 //2 public VarSymbol(String name, VarType variableType, Location location) {
        this.name = name;
        this.variableType = variableType;
        this.location = location;
        this.isClassField = isClassField;
        this.isGlobalVariable = isGlobalVariable;
    }

}