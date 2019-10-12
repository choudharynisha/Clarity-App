package lanternclan.prototype;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class TextReader
{
    public static ArrayList<String> readCode(String find, String filename) throws FileNotFoundException{
        //String filename = "data.csv";
        String id, name;
        ArrayList<String> ingredients = new ArrayList<String>();
        ArrayList<String> results = new ArrayList<String>();
        try{
            Scanner file = new Scanner(new File (filename));

            file.nextLine(); //skip first line
            String readLine = file.nextLine();
            String[] tokens = readLine.split(",");

            id = tokens[0];
            name = tokens[1];

            for(int i = 2; i < tokens.length; i++){
                ingredients.add(tokens[i]);
            }

            if(id.equals(find)) {
                results.add(id);
                results.add(name);
                results.addAll(ingredients);
            }

            System.out.println("reached");
        }
        catch (FileNotFoundException e) { System.out.println("File not found!!"); }
        return results;

    }

//    public static void main(String[] args){
//        try {
//            System.out.println(readCode("1ABC", "data.csv").toString());
//
//        }
//        catch (FileNotFoundException e) { System.out.println("File not found!!"); }
//    }
}
