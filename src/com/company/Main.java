package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File directory = new File("Games");
        if (directory.mkdir());
        StringBuilder builder = new StringBuilder("Создан каталог \"Games\"\n");

        String baseDirPath = "Games";
        String[] directoryInGames = {"/src", "/res", "/savegames", "/temp", "/src/main", "/src/test", "/res/drawables", "/res/vectors", "/res/icons"};
        String[] fileNamesMain = {"Main.java", "Utils.java"};
        String[] fileNamesTemp = {"temp.txt"};

        for (int i = 0; i < directoryInGames.length; i++) {
            String fullPath = baseDirPath + directoryInGames[i];
            File dir = new File(fullPath);
            String message = "";
            if (dir.mkdir()) {
                message = "Создан каталог \"" + fullPath + "\"";
            } else {
                message = "Ошибка создания каталога \"" + fullPath + "\"";
            }
            System.out.println(message);
            builder.append(message + "\n");
        }

        String fullDirectoryMainPath = baseDirPath + directoryInGames[4];
        for (int i = 0; i < fileNamesMain.length; i++) {
            String message = "";
            String fullFileMainName = fullDirectoryMainPath + "/" + fileNamesMain[i];
            File myFile = new File(fullFileMainName);
            try {
                if (myFile.createNewFile())
                    message = "Создан файл \"" + fullFileMainName + "\"";
            } catch (IOException ex) {
                message = ex.getMessage();
            } finally {
                System.out.println(message);
                builder.append(message + "\n");
            }
        }

        String fullDirectoryTempPath = baseDirPath + directoryInGames[3];
        for (int i = 0; i < fileNamesTemp.length; i++) {
            String message = "";
            String fullFileTempName = fullDirectoryTempPath + "/" + fileNamesTemp[i];
            File myFile = new File(fullFileTempName);
            try {
                if (myFile.createNewFile())
                    message = "Создан файл \"" + fullFileTempName + "\"";
            } catch (IOException ex) {
                message = ex.getMessage();
            } finally {
                System.out.println(message);
                builder.append(message + "\n");
            }
        }

        String text = builder.toString();
        try (FileWriter writer = new FileWriter("Games/temp/temp.txt", false)) {
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}