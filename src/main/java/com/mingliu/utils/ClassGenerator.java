package com.mingliu.utils;

import java.io.FileWriter;

public class ClassGenerator {
    public void generate(String jsonFileName, String packageName) {
        JsonParseHelper jsonParseHelper = new JsonParseHelper();
        String classcontent = jsonParseHelper.generateClass(jsonFileName);
        classcontent = "package " + packageName + ";" + "\n" + classcontent;
        String className = jsonParseHelper.getGenerateName(jsonFileName) + ".java";

        try {

            String packagePath = packageName.replaceAll("\\.", "/");
            System.out.println("current dir:" + System.getProperty("user.dir"));
            String outputPath = System.getProperty("user.dir") + "/src/main/java/" + packagePath + "/" + className;
            // Creates a Writer using FileWriter
            FileWriter output = new FileWriter(outputPath);

            // Writes the program to file
            output.write(classcontent);
            System.out.println("Data is written to the file.");

            // Closes the writer
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public static void main(String[] args) {
        String jsonFileName = "/Users/mingliu/course/jike/appiumLearn/src/main/resources/pages/SearchPage.json";
        String packageName = "com.mingliu.page";
        new ClassGenerator().generate(jsonFileName, packageName);
    }
}
