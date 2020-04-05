package Mxstar.Symbol;


//1 import Mxstar.IR.Func;
import Mxstar.ErrorProcessor.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FuncSymbol extends TypeSymbol{
    public String name;
    public Location location;
    public VarType returnType;
    public List<VarType> parameterTypes;
    public List<String> parameterNames;
    public SymbolTable funtionSymbolTable;

    public HashSet<VarSymbol> usedGlobalVariables;
    public boolean Global;

    public HashSet<FuncSymbol> visited;

    public FuncSymbol() {
        this.parameterNames = new LinkedList<>();
        this.parameterTypes = new LinkedList<>();
        this.usedGlobalVariables = new HashSet<>();
        this.visited = new HashSet<>();
    }
    public FuncSymbol(Location nlocation,String nname,VarType nreturnType) {
        name = nname;
        location = nlocation;
        returnType = nreturnType;
        this.parameterNames = new LinkedList<>();
        this.parameterTypes = new LinkedList<>();
        this.usedGlobalVariables = new HashSet<>();
        this.visited = new HashSet<>();
    }



}