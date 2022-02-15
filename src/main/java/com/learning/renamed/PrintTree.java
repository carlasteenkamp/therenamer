package com.learning.renamed;

import java.io.File;
import java.io.IOException;

public class PrintTree {
    static void printTree(int depth, File file)
    {
        StringBuilder indent = new StringBuilder();
        String name = file.getName();

        indent.append(".".repeat(Math.max(0, depth)));

        //Pretty print for directories
        if (file.isDirectory()) {
            System.out.println(indent + "|");
            if(isPrintName(name)){
                System.out.println(indent + "*" + file.getName() + "*");
            }
        }
        //Print file name
        else if(isPrintName(name)) {
            System.out.println(indent + file.getName());
        }
        //Recurse children
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File value : files)
            {
                printTree(depth + 4, value);
            }
        }
    }

    //Exclude some file names
    static boolean isPrintName(String name){
        if (name.charAt(0) == '.') {
            return false;
        }
        return !name.contains("svn");
    }

}
