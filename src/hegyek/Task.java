package hegyek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {

    List<Entity> mountains = new ArrayList<Entity>();
    FileManager fmObj = new FileManager();

    public void fileRead(String fileName) {
        mountains = fmObj.fileReader(fileName);
    }

    public Integer howManyMountains() {
        return mountains.size();
    }

    public Double mountainsAvarageHeight() {
        double piece = mountains.size();
        double total = 0;

        for (Entity mountain : mountains) {

            total += mountain.getHeight();
        }
        return (double) Math.round((total / piece * 100) / 1) / 100;
    }

    public void highestMountain() {
        int highestMountainHeight = 0;
        for (Entity mountain : mountains) {
            if (mountain.getHeight() > highestMountainHeight) {
                highestMountainHeight = mountain.getHeight();
            }
        }
        for (Entity mountain : mountains) {
            if (mountain.getHeight().equals(highestMountainHeight)) {
                System.out.println("A legmagasabb hegycsúcs adatai: ");
                System.out.println("Név " + mountain.getMountainPeakName());
                System.out.println("Hegység: " + mountain.getMountains());
                System.out.println("Magasság: " + mountain.getHeight() + " m");
            }
        }
    }

    public void isThereHigherMountainInBorzsony() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Kérem adjon meg egy magasságot: ");
            Integer height = Integer.parseInt(br.readLine());
            for (Entity mountain : mountains) {
                if (mountain.getMountains().equalsIgnoreCase("Börzsöny")) {
                    if (mountain.getHeight() > height) {
                        System.out.println(height + "m-nél van nagyobb hegycsúcs Börzsönyben!");
                        break;
                    } else {
                        System.out.println(height + "m-nél nincs nagyobb hegycsúcs Börzsönyben!");
                        break;
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void higherThen3000Feet() {
        double exchange = 3.280839895;
        int piece = 0;
        for (Entity mountain : mountains) {
            if (mountain.getHeight() > 3000 / exchange) {
                piece++;
            }
        }
        System.out.println("3000 lábnál magasabb hegycsúcsok száma: " + piece);
    }

    public void mountainsStatistics() {
        List<String> mountainStatistic = new ArrayList<String>();
        boolean isThereMountain = false;

        for (int i = 0; i < mountains.size(); i++) {
            for (String s : mountainStatistic) {
                if (mountains.get(i).getMountains().equals(s)) {
                    isThereMountain = true;
                }
            }
            if (isThereMountain == false) {
                mountainStatistic.add(mountains.get(i).getMountains());
            }
            isThereMountain = false;
        }
        int mountainNumber = 0;
        for (String s : mountainStatistic) {
            for (int i = 0; i < mountains.size(); i++) {
                if (mountains.get(i).getMountains().equals(s)) {
                    mountainNumber++;
                }
            }
            System.out.println(s + " " + mountainNumber + " db");
            mountainNumber = 0;
        }
    }

    public void fileWriteOut() {
        fmObj.fileWriteOut(mountains);
    }

}
