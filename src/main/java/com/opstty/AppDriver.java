package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            programDriver.addClass("distinctDistricts", DistinctDistricts.class,
                    "A map/reduce program that returns the distinct districts with trees in a predefined CSV formatting.");

            programDriver.addClass("treeSpecies", Species.class,
                    "A map/reduce program that returns the tree species in a file.");

            programDriver.addClass("treeKindCount", TreeKindCount.class,
                    "A map/reduce program that returns the number of trees by kind.");

            programDriver.addClass("highestTreeByKind", HighestTreeByKind.class,
                    "A map/reduce program that returns the highest tree of each kind.");

            programDriver.addClass("sortedHeight", SortedHeight.class,
                    "A map/reduce program that sorts the height in ascendant order.");

            programDriver.addClass("districtOldestTree", DistrictOldestTree.class,
                    "A map/reduce program that returns the district with the oldest tree.");

            programDriver.addClass("districtMostTrees", DistrictMostTrees.class,
                    "A map/reduce program that returns the district containing he most trees.");


            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
