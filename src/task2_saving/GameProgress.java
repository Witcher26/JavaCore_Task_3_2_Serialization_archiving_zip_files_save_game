package task2_saving;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String path, String nameDat) {
        String newPathDirectory = path + "//" + nameDat + ".dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(newPathDirectory, true))) {
            oos.writeObject(this);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles3(String path, String[] obj) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {

            for (int i = 0; i < obj.length; i++) {
                FileInputStream fis = new FileInputStream(obj[i]); // указываем путь к файлу в формате строки для считывания в байтах
                File nameFile = new File(obj[i]);  // промежуточная операция для получения имени файла
                ZipEntry entry = new ZipEntry(nameFile.getName());
                zout.putNextEntry(entry);

                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
                fis.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
