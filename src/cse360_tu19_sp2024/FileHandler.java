package cse360_tu19_sp2024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileHandler {
    
	// Save file with filename
    public void save(String fileName, HashMap<String, String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (HashMap.Entry<String, String> entry : data.entrySet()) {
                String line = entry.getKey() + ": " + entry.getValue();
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Open file and read lines
    public ArrayList<String> read(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    
    // Parse
    public HashMap<String, String> parse(String fileName) {
    	HashMap<String, String> information = new HashMap<String, String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(": ");
                information.put(splitLine[0], splitLine[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return information;
    }
    
    // Get Attribute
    public String getAttr(String fileName, String attr) {
    	HashMap<String, String> information = this.parse(fileName);
    	return information.get(attr);
    }

    // Update attribute attr to value, or create it if it does not exist
    public void updateAttr(String fileName, String attr, String value) {
    	HashMap<String, String> information = this.parse(fileName);
    	information.put(attr, value);
    	this.save(fileName, information);
    }

    // Update multiple attributes
    public void updateAttrs(String fileName, HashMap<String, String> attr) {
    	HashMap<String, String> information = this.parse(fileName);
    	information.putAll(attr);
    	this.save(fileName, information);
    }
    
    // Remove attribute
    public void removeAttr(String fileName, String attr) {
    	HashMap<String, String> information = this.parse(fileName);
    	information.remove(attr);
    	this.save(fileName, information);
    }
    
    // Remove multiple attributes
    public void removeAttrs(String fileName, String attr[]) {
    	HashMap<String, String> information = this.parse(fileName);
    	for (String a : attr) {
    		information.remove(a);
    	}
    	this.save(fileName, information);
    }

}