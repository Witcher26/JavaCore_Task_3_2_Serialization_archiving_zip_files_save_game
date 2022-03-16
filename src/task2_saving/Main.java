package task2_saving;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "C://Users//Asus//Desktop//JavaCore//Games//saveGames";

        GameProgress[] games = {
                new GameProgress(100, 6, 1, 5.0),
                new GameProgress(50, 3, 5, 10.0),
                new GameProgress(75, 9, 16, 19.0)
        };

        games[0].saveGame(path, "save1");
        games[1].saveGame(path, "save2");
        games[2].saveGame(path, "save3");

        String pathZip = "C://Users//Asus//Desktop//JavaCore//Games//saveGames//Zip_Files.zip";
        String[] objects = {"C://Users//Asus//Desktop//JavaCore//Games//saveGames//save1.dat",
                "C://Users//Asus//Desktop//JavaCore//Games//saveGames//save2.dat",
                "C://Users//Asus//Desktop//JavaCore//Games//saveGames//save3.dat"};

        GameProgress.zipFiles3(pathZip, objects);

        for (String object : objects) {
            File myFile = new File(object);
            myFile.delete();
        }
    }
}
