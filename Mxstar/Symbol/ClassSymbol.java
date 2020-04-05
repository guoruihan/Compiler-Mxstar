package Mxstar.Symbol;

import Mxstar.ErrorProcessor.*;

public class ClassSymbol extends TypeSymbol{
    public String name;
    public Location location;
    public SymbolTable symbolTable;
    ClassSymbol(){
    }
    public ClassSymbol(String nname,Location nlocation,SymbolTable nsymbolTable){
        name = nname;
        location = nlocation;
        symbolTable = nsymbolTable;
    }
}