package pedro.gouveia.cm_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView txtFieldOwner, txtFieldName, txtFieldAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        txtFieldOwner = (TextView) findViewById(R.id.txtOwner);
        txtFieldName = (TextView) findViewById(R.id.txtName);
        txtFieldAge = (TextView) findViewById(R.id.txtAge);
    }

    public void returnMain(View view) {

        Intent intent = new Intent(String.valueOf(this));
        intent.putExtra("name", txtFieldName.getText());
        intent.putExtra("owner", txtFieldOwner.getText());
        intent.putExtra("age", txtFieldAge.getText());
        setResult(RESULT_OK, intent);
        finish();
    }
}