package lanternclan.prototype;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextReader {
    private static final String MAIN_PATH = "/Users/faryal/Desktop/";

//    private MainActivity mainActivity;
//
//    // Constructor
//    public TextReader(MainActivity activity) {
//
//        // Save instance of main class for future use
//        mainActivity = activity;
//
//        // Call method in MainActivity
//        mainActivity.release();
//
//    }
    private static File getDataFile(){
        return new File("data.csv");
    }

    public static ArrayList<String> readCode(Context context) throws FileNotFoundException {



        //String filename = "data.txt";
        String id, name;
        ArrayList<String> ingredients = new ArrayList<String>();
        ArrayList<String> results= new ArrayList<String>();


        try {
            String row;
            InputStream raw = context.getAssets().open("data.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(raw, "UTF-8"));
            reader.readLine();
            while((row = reader.readLine()) != null) {
                String[] data = row.split(",");

                for(int i = 1; i < data.length; i++) {
                    System.out.println("===> " + data[i]);
                    results.add(data[i]);
                }
            }


            //reader.readLine();
            //String contents = reader.readLine();
            //System.out.println(contents);
            reader.close();
//            String path = context.getFilesDir().getAbsolutePath() + File.separator;
//            File dir = new File(path+"data.csv");
//            Scanner file = new Scanner(dir);
//            while(file.hasNextLine()){
//                String aLine = file.nextLine();
//                System.out.println(aLine);
//            }


            //System.out.println("In TextReader.java");
            /*DataInputStream s = new DataInputStream(getAssets().open(String.format(filename)));
            Scanner file = new Scanner(s);
            while(file.hasNextLine()){
                String aLine = file.nextLine();
                System.out.println(aLine);
            }
            //System.out.println("In TextReader.java");

            file.nextLine(); //skip first line
            String readLine = file.nextLine();
            System.out.println(readLine);
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
            }*/
            //results.addAll(data);

            System.out.println("reached");

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;

    }

    public static ArrayList<String> readData(){
        String id_new, name_new;
        ArrayList<String> ingredients_new = new ArrayList<String>();
        ArrayList<String> results_new = new ArrayList<String>();

        id_new = "1ABC";
        name_new = "Ginzing Cream";
        ingredients_new.add("Caffeine");
        ingredients_new.add("Glycerin");
        ingredients_new.add("Caprylic");

        results_new.add(id_new);
        results_new.add(name_new);
        results_new.addAll(ingredients_new);

        return results_new;

    }

//    public static void main(String[] args) {
//        try {
//            System.out.println(readCode("1ABC", "data.txt").toString());
//
//        }
//        catch (FileNotFoundException e) { System.out.println("File not found!!"); }
//    }
}