package pedro.gouveia.cm_assignment1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    private ActivityResultLauncher<Intent> launcher;
    private Animal selectedAnimal;

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
                    selectedAnimal = (Animal)spin.getSelectedItem();
                    Log.d("test", selectedAnimal.toString());
                    txtName.setText(selectedAnimal.getName());
                    txtOwner.setText(selectedAnimal.getOwner());
                    txtAge.setText(selectedAnimal.getAge()+"");

                    imgAnimal.setImageResource(getResources().getIdentifier(selectedAnimal.getFixedName(), "drawable", getPackageName()));
                }
                public void onNothingSelected(AdapterView<?> parent) {} // empty
            });
        }

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            Bundle dataBundle = data.getExtras();

                            String name = dataBundle.get("name").toString();

                            String owner = dataBundle.get("owner").toString();

                            String age = dataBundle.get("age").toString();

                            if(age.equals("")){
                                selectedAnimal.setAge(0);
                                txtAge.setText(0+"");
                            } else {
                                selectedAnimal.setAge(Integer.parseInt(age));
                            }

                            txtName.setText(name);
                            txtOwner.setText(owner);

                            selectedAnimal.setName(name);
                            selectedAnimal.setOwner(owner);
                        }
                    }
                }
        );

    }

    public void goToActivity(View view) {

        Intent intent = new Intent(this, Activity2.class);

        launcher.launch(intent);
    }

    private void getAnimals(){
        this.animalsArray = new ArrayList<Animal>();

        String[] animals = getResources().getStringArray(R.array.animals);

        for (String strAnimal : animals ) {
            String[] stringArray = strAnimal.split("/");

            Animal animal = new Animal(stringArray[0], stringArray[1], Integer.parseInt(stringArray[2]), stringArray[3]);

            this.animalsArray.add(animal);
        }

    }
}