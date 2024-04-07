package xn_Model;


import java.io.*;
import java.util.ArrayList;

public class TextModel {
    private String text;

    public void loadFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            text = content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(File file, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void removeEmptyLines() {
        String[] lines = text.split("\\r?\\n");
        ArrayList<String> nonEmptyLines = new ArrayList<>();

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                nonEmptyLines.add(line);
            }
        }

        text = String.join("\n", nonEmptyLines);
    }
    public String getText() {
        return text;
    }
}