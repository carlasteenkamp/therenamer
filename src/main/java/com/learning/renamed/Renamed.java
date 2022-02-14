package com.learning.renamed;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Renamed
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("c:\\Users\\carla.steenkamp\\renameFiles\\one.java");

        File rename = new File("c:\\Users\\<yourUsername>\\renameFiles\\two.java");

        boolean flag = file.renameTo(rename);

        if (flag)
        {
            Files.move(Path.of("c:\\Users\\<yourUsername>\\renameFiles\\two.java"), rename.toPath().resolveSibling(
                    "c:\\Users\\<yourUsername>\\completedRenameFiles\\two.java"));
            System.out.println("File Successfully Renamed and moved");
        }
        else
        {
            System.out.println("Operation Failed");
        }
    }
}