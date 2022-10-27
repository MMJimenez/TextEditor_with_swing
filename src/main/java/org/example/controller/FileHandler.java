package org.example.controller;

import java.io.*;

public class FileHandler {

    public static File savedFile;

    private Boolean isFilePath(String filePath) {
        var file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }

    private Boolean isDirPath(String filePath) {
        var file = new File(filePath);
        return file.exists() && file.isDirectory();
    }

    public String readFileTextOrVoid(String path) {
        if (!isFilePath(path)) return "";

        StringBuilder text = new StringBuilder();
        try {
            var bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
        return text.toString();
    }

    public void createFileFromText(String path, String text) {
        var file = new File(path);
        try {
            if (file.createNewFile()) {
                var bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(text);
                bufferedWriter.close();
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo");
        }
    }

}