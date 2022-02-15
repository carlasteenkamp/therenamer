package com.learning.renamed;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Renamed
{
    public static void main(String[] args) throws IOException
    {

        File file = new File("c:\\Users\\<username>\\learning\\Series\\Season\\one.java");
        File fileTwo = new File("c:\\Users\\<username>\\learning\\Series");

        File rename = new File("c:\\Users\\<username>\\learning\\Series\\two.java");


        boolean tvShow = file.getPath().contains("Season");
        boolean movies = file.getPath().contains("Movies");

        if (file.exists())
        {
            PrintTree.printTree(3, fileTwo);
            boolean flag = file.renameTo(rename);
            if (tvShow && flag)
            {
                Files.move(Path.of("c:\\Users\\<username>\\learning\\series\\two.java"),
                        rename.toPath().resolveSibling(
                                "c:\\Users\\<username>\\learning\\completedSeries\\two.java"));
                System.out.println("File Successfully Renamed and moved to series");
            }
            else if (movies && flag)
            {
                Files.move(Path.of("c:\\Users\\<username>\\movies\\two.java"), rename.toPath().resolveSibling(
                        "c:\\Users\\<username>\\completedMovies\\two.java"));
                System.out.println("File Successfully Renamed and moved to movies");
            }
            else
            {
                System.out.println("Operation Failed couldn't be moved");
            }
        }
        else
        {
            System.out.println("Operation Failed");
        }
    }
}