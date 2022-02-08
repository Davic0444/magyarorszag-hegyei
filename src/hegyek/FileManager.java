package hegyek;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManager {

    private static String header = "";
    List<Entity> mountains = new ArrayList<>();

    public List<Entity> fileReader(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
            header = br.readLine();
            while (br.ready()) {
                String row = br.readLine();
                String[] rowData = row.split(";");
                Entity newEntity = new Entity(
                        rowData[0],
                        rowData[1],
                        Integer.parseInt(rowData[2]));
                mountains.add(newEntity);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mountains;
    }

    public void fileWriteOut(List<Entity> mountains) {
        double exchange = 3.280839895;
        Map<String, Double> bukkPeek = new HashMap<String, Double>();
        for (Entity mountain : mountains) {
            if (mountain.getMountains().equalsIgnoreCase("Bükk-vidék")) {
                if (!bukkPeek.equals(mountain.getMountainPeakName())) {
                    bukkPeek.put(mountain.getMountainPeakName(), mountain.getHeight() * exchange);
                }
            }
        }

        try {
            FileOutputStream fs = new FileOutputStream("bukk-videk.txt");
            OutputStreamWriter out = new OutputStreamWriter(fs, "UTF-8");
            out.write("Hegycsúcs neve;Magasság láb");
            out.write("\n");
            for (Map.Entry<String, Double> stringDoubleEntry : bukkPeek.entrySet()) {
                out.write(stringDoubleEntry.getKey() + ";" + Math.round(stringDoubleEntry.getValue() * 10d) / 10d);
                out.write("\n");
            }

            out.close();
            fs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
