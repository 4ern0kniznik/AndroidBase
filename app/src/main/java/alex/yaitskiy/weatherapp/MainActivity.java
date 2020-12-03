package alex.yaitskiy.weatherapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);
        final Button button = findViewById(R.id.button);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Resources r = getResources();
                String user = r.getString(R.string.city, s);
                TextView textView = findViewById(R.id.textView);

                if (editText.getText().toString().isEmpty()) {
                    textView.setText("");
                } else {
                    textView.setText(user);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources r = getResources();
                String city = editText.getText().toString();
                TextView textWelcom = findViewById(R.id.city);

                if (city.isEmpty()) {
                    city = r.getString(R.string.default_city);
                }
                textWelcom.setText(city);
                editText.setText("");
            }
        });

        ///TextView textView = findViewById(R.id.textView);
    }
}
