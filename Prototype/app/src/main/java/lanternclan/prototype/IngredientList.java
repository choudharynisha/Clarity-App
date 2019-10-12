package lanternclan.prototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IngredientList extends AppCompatActivity {

    List<String> items;

    TextView tvProduct;
    RecyclerView rvIngredients;
    ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_list);

        tvProduct = findViewById(R.id.tvProduct);
        rvIngredients = findViewById(R.id.rvIngredients);

        items = new ArrayList<>();
        items.add("blah");
        items.add("blah");
        items.add("blah");

        loadItems();

        itemsAdapter = new ItemsAdapter(items);
        rvIngredients.setAdapter(itemsAdapter);
        rvIngredients.setLayoutManager(new LinearLayoutManager(this));
    }


    private File getDataFile() {
        return new File("/src/main/assets/data.csv");
    }

    // This method will load items by reading every line of the data file
    private void loadItems(){
            ArrayList<String> data = new ArrayList<>();

            items = new ArrayList<String>();

            Scanner input = null;
            try {
                input = new Scanner(getDataFile());

                while(input.hasNext())
                {
                    String current = input.nextLine();
                    String[] ingredients = current.split(",");
                    for(int i = 0; i < ingredients.length; i++)
                    {
                        items.add(ingredients[i]);
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }
}
