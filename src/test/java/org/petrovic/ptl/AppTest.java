package org.petrovic.ptl;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.carpediem.LabeledExprBaseVisitor;
import org.carpediem.LabeledExprLexer;
import org.carpediem.LabeledExprListener;
import org.carpediem.LabeledExprParser;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class AppTest {

    LabeledExprLexer lexer;
    CommonTokenStream tokenStream;
    LabeledExprParser parser;
    ParseTree tree;

    // This method is run before each method annotated with @Test below
    @Before
    public void setup() throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/t.expr");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(resourceAsStream);
        lexer = new LabeledExprLexer(antlrInputStream);
        tokenStream = new CommonTokenStream(lexer);
        parser = new LabeledExprParser(tokenStream);
        tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void testListener() throws IOException {
        ParseTreeWalker walker = new ParseTreeWalker();
        MyLabeledExpressionListener listener = new MyLabeledExpressionListener(parser);
        walker.walk(listener, tree);
    }

    @Test
    public void testVisitor() throws IOException {
        MyVisitor visitor = new MyVisitor();
        visitor.visit(tree);
    }

    class MyLabeledExpressionListener implements LabeledExprListener {

        final Parser parser;

        MyLabeledExpressionListener(Parser parser) {
            this.parser = parser;
        }

        @Override
        public void enterId(LabeledExprParser.IdContext ctx) {
            System.out.printf("enterId: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitId(LabeledExprParser.IdContext ctx) {
            System.out.printf("exitId: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void enterAssign(LabeledExprParser.AssignContext ctx) {
            System.out.printf("enterAssign: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitAssign(LabeledExprParser.AssignContext ctx) {
            System.out.printf("exitAssign: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void enterProg(LabeledExprParser.ProgContext ctx) {
            System.out.printf("enterProg: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitProg(LabeledExprParser.ProgContext ctx) {
            System.out.printf("exitProg: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void enterBlank(LabeledExprParser.BlankContext ctx) {
            System.out.printf("enterBlank: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitBlank(LabeledExprParser.BlankContext ctx) {
            System.out.printf("exitBlank: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void enterPrintExpr(LabeledExprParser.PrintExprContext ctx) {
            System.out.printf("enterPrintExpr: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
            System.out.printf("exitPrintExpr: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void enterInt(LabeledExprParser.IntContext ctx) {
            System.out.printf("enterInt: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitInt(LabeledExprParser.IntContext ctx) {
            System.out.printf("exitInt: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void enterAddSub(LabeledExprParser.AddSubContext ctx) {
            System.out.printf("enterAdd: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitAddSub(LabeledExprParser.AddSubContext ctx) {
            System.out.printf("exitAdd: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void enterParens(LabeledExprParser.ParensContext ctx) {
            System.out.printf("enterParens: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitParens(LabeledExprParser.ParensContext ctx) {
            System.out.printf("exitParens: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void enterMulDiv(LabeledExprParser.MulDivContext ctx) {
            System.out.printf("enterMulDiv: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitMulDiv(LabeledExprParser.MulDivContext ctx) {
            System.out.printf("exitMulDiv: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void visitTerminal(TerminalNode node) {
            System.out.printf("visitTerminal: %s\n", node.toStringTree(parser));
        }

        @Override
        public void visitErrorNode(ErrorNode node) {
            System.out.printf("visitErrorNode: %s\n", node.toStringTree(parser));
        }

        @Override
        public void enterEveryRule(ParserRuleContext ctx) {
            System.out.printf("enterEveryRule: %s\n", ctx.toInfoString(parser));
        }

        @Override
        public void exitEveryRule(ParserRuleContext ctx) {
            System.out.printf("exitEveryRule: %s\n", ctx.toInfoString(parser));
        }
    }

    class MyVisitor extends LabeledExprBaseVisitor<Integer> {

        @Override
        public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
            System.out.println("hello mulDiv visit");
            // visit or not depending on biz logic
            // visit MulDiv children, for example
            return visitChildren(ctx);
        }

    }
}
