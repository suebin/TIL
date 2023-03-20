package visitor;

import acceptor.Acceptor;
import java.util.List;

public class PaintKeyword implements Visitor {
    @Override
    public void visit(Acceptor acceptor) {
        String keywordRegex = "(\\babstract\\b|\\bassert\\b|\\bboolean\\b|\\bbreak\\b|"
                + "\\bbyte\\b|\\bcase\\b|\\bcatch\\b|\\bchar\\b|\\bclass\\b|\\bcontinue\\b|"
                + "\\bconst\\b|\\bdefault\\b|\\bdo\\b|\\bdouble\\b|\\belse\\b|\\benum\\b|"
                + "\\bexports\\b|\\bextends\\b|\\bfinal\\b|\\bfinally\\b|\\bfloat\\b|\\bfor\\b|"
                + "\\bif\\b|\\bimplements\\b|\\bimport\\b|\\binstanceof\\b|\\bint\\b|"
                + "\\binterface\\b|\\blong\\b|\\bmodule\\b|\\bnative\\b|\\bnew\\b|\\bpackage\\b|"
                + "\\bprivate\\b|\\bprotected\\b|\\bpublic\\b|\\brequires\\b|\\breturn\\b|"
                + "\\bshort\\b|\\bstatic\\b|\\bstricfp\\b|\\bsuper\\b|\\bswitch\\b|"
                + "\\bsynchronized\\b|\\bthis\\b|\\bthrow\\b|\\bthrows\\b|\\btransient\\b|"
                + "\\btry\\b|\\bvar\\b|\\bvoid\\b|\\bvolatile\\b|\\bwhile\\b)";

        List<String> fileContents = acceptor.getFileContents();

        int index = 0;
        for (String line : fileContents) {
            fileContents.set(index++, (line.replaceAll(keywordRegex,
                    "<font color='blue'>$0</font>")));
        }
        acceptor.setFileContents(fileContents);
    }
}
