package org.petrovic.ptl;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.carpediem.JavaLexer;
import org.carpediem.JavaParser;

import java.io.FileInputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        FileInputStream sourceCode = new FileInputStream(args[0]);

        ANTLRInputStream input = new ANTLRInputStream(sourceCode);
        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TypeCastListener(), tree);
    }
}
