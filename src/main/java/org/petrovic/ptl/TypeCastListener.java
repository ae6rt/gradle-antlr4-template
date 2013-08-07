package org.petrovic.ptl;

import org.carpediem.JavaBaseListener;
import org.carpediem.JavaParser;

public class TypeCastListener extends JavaBaseListener {

    @Override
    public void enterCastExpression(JavaParser.CastExpressionContext ctx) {
        int line = ctx.getStart().getLine();
        int characterPositionInLine = ctx.getStart().getCharPositionInLine();
        System.out.printf("Cast near line:column %d:%d\n", line, characterPositionInLine);
    }

}
