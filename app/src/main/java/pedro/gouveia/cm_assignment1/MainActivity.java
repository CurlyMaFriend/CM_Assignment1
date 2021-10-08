package pedro.gouveia.cm_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT1 = "com.example.application.example.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.application.example.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivity(View view) {

        TextView txtName, txtOwner, txtAge;
        String conteudoNome, conteudoOwner;
        int conteudoAge;

        txtName = (TextView) findViewById(R.id.txtName);
        txtOwner = (TextView) findViewById(R.id.txtOwner);
        txtAge = (TextView) findViewById(R.id.txtAge);

        conteudoNome = txtName.getText().toString();
        conteudoOwner = txtOwner.getText().toString();
        conteudoAge = Integer.parseInt(txtAge.getText().toString());

        Intent intent = new Intent(this, Activity2.class);

        intent.putExtra(EXTRA_TEXT1, conteudoOwner);
        intent.putExtra(EXTRA_TEXT2, conteudoNome);
        intent.putExtra(EXTRA_NUMBER, conteudoAge);

        startActivity(intent);
    }
}