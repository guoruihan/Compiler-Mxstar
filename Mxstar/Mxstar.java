package Mxstar;

import Mxstar.Ast.AstProgram;
import Mxstar.FrontEnd.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Mxstar.ErrorProcessor.*;
import Parser.*;
import Mxstar.Symbol.GlobalSymbolTable;
import org.antlr.v4.runtime.tree.xpath.XPathLexerErrorListener;

import java.io.*;

import static java.lang.System.exit;

public class Mxstar {

    public static void main(String args[]) throws IOException {
        //parseArgs(args);
        compile();
        exit(0);
    }
    public static void compile() throws IOException{
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        /*String path = "C:\\Users\\86186\\Desktop\\Cp\\src\\Mxstar\\file.in";
        FileReader fr = new FileReader(path);
        BufferedReader is = new BufferedReader(fr);*/
        //InputStream is = Config.in;
//        FileInputStream is = new FileInputStream("program.txt");
        ANTLRInputStream ais = new ANTLRInputStream(is);
        MxstarLexer mstarLexer = new MxstarLexer(ais);
        CommonTokenStream tokens = new CommonTokenStream(mstarLexer);
        MxstarParser parser = new MxstarParser(tokens);


        CompileErrorListener errorListener = new CompileErrorListener();
        mstarLexer.removeErrorListeners();
        mstarLexer.addErrorListener(new ParserErrorListener(errorListener));

        if (errorListener.hasError()) {

            errorListener.printTo(System.err);
            exit(1);
        }
        ParserErrorListener parserErrorListener = new ParserErrorListener(errorListener);
        parser.removeErrorListeners();
        parser.addErrorListener(parserErrorListener);

        ParseTree parseTree = parser.program();

        if (errorListener.hasError()) {

            errorListener.printTo(System.err);
            exit(1);
        }


        AstBuild astBuilder = new AstBuild(errorListener);
        astBuilder.visit(parseTree);

        if(errorListener.hasError()) {
            errorListener.printTo(System.err);
            exit(1);
        }

        AstProgram astProgram = astBuilder.getAstProgram();

        SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder(errorListener);

        symbolTableBuilder.visit(astProgram);

        if(errorListener.hasError()) {
            errorListener.printTo(System.err);
            exit(1);
        }

        GlobalSymbolTable globalSymbolTable = symbolTableBuilder.globalSymbolTable;

        SemanticChecker semanticChecker = new SemanticChecker(errorListener, globalSymbolTable);
        semanticChecker.visit(astProgram);

        if(errorListener.hasError()) {
            errorListener.printTo(System.err);
            exit(1);
        }
    }
}