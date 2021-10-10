package pedro.gouveia.cm_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT1 = "com.example.application.example.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.application.example.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";
    private ArrayList<Animal> animalsArray;
    private Spinner spinner;
    private TextView txtName, txtOwner, txtAge;
    private ImageView imgAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spnNames);
        this.getAnimals();

        if(this.animalsArray.size() > 0){
            ArrayAdapter<Animal> adapter = new ArrayAdapter<Animal>(this, android.R.layout.simple_spinner_item, this.animalsArray);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> spin, View v, int i, long id) {
                    txtName = findViewById(R.id.txtName);
                    txtOwner = findViewById(R.id.txtOwner);
                    txtAge = findViewById(R.id.txtAge);
                    imgAnimal = findViewById(R.id.imgAnimal);
                    Animal selectedAnimal = (Animal)spin.getSelectedItem();
                    Log.d("test", selectedAnimal.toString());
                    txtName.setText(selectedAnimal.getName());
                    txtOwner.setText(selectedAnimal.getOwner());
                    txtAge.setText(selectedAnimal.getAge()+"");

                    imgAnimal.setImageResource(getResources().getIdentifier(selectedAnimal.getName(), "drawable", getPackageName()));
                }
                public void onNothingSelected(AdapterView<?> parent) {} // empty
            });
        }

    }

    public void goToActivity(View view) {

        TextView txtName, txtOwner, txtAge;
        Spinner spinner;
        String conteudoNome, conteudoOwner;
        int conteudoAge;

        txtName = (TextView) findViewById(R.id.txtName);
        txtOwner = (TextView) findViewById(R.id.txtOwner);
        txtAge = (TextView) findViewById(R.id.txtAge);

        //conteudoNome = txtName.getText().toString();
        //conteudoOwner = txtOwner.getText().toString();
        //conteudoAge = Integer.parseInt(txtAge.getText().toString());

        Intent intent = new Intent(this, Activity2.class);

        //intent.putExtra(EXTRA_TEXT1, conteudoOwner);
        //intent.putExtra(EXTRA_TEXT2, conteudoNome);
        //intent.putExtra(EXTRA_NUMBER, conteudoAge);

        startActivity(intent);
    }

    private void getAnimals(){
        this.animalsArray = new ArrayList<Animal>();

        String[] animals = getResources().getStringArray(R.array.animals);

        for (String strAnimal : animals ) {
            String[] stringArray = strAnimal.split("/");

            Animal animal = new Animal(stringArray[0], stringArray[1], Integer.parseInt(stringArray[2]));

            this.animalsArray.add(animal);
        }

    }
}