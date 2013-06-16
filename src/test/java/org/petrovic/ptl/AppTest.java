package org.petrovic.ptl;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class AppTest {
    @Test
    public void testApp() throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/t.dot");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(resourceAsStream);
        org.carpediem.DOTLexer dotLexer = new org.carpediem.DOTLexer(antlrInputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(dotLexer);
        org.carpediem.DOTParser parser = new org.carpediem.DOTParser(tokenStream);
        ParseTree tree = parser.graph();
        System.out.println(tree.toStringTree(parser));
    }
}
