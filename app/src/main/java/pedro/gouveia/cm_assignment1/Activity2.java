package pedro.gouveia.cm_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Intent intent = getIntent();
        String textOwner = intent.getStringExtra(MainActivity.EXTRA_TEXT1);
        String textNome = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        int numberIdade = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

        TextView activity2Dono, activity2Nome, activity2Idade;

        activity2Dono = (TextView) findViewById(R.id.activity2Dono);
        activity2Nome = (TextView) findViewById(R.id.activity2Nome);
        activity2Idade = (TextView) findViewById(R.id.activity2Idade);

        activity2Dono.setText(textOwner);
        activity2Nome.setText(textNome);
        activity2Idade.setText(""+numberIdade);

    }

    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}