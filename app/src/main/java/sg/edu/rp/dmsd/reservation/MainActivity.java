package sg.edu.rp.dmsd.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    EditText name;
    EditText mobile;
    EditText size;
    CheckBox smoke;
    Button confirm;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        dp.init(2019,5,1,null);
        tp = findViewById(R.id.timePicker);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(0);
        name = findViewById(R.id.editTextName);
        mobile = findViewById(R.id.editTextMobile);
        size = findViewById(R.id.editTextSize);
        smoke = findViewById(R.id.checkBoxSmoke);
        confirm = findViewById(R.id.buttonConfirm);
        reset = findViewById(R.id.buttonReset);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smoker = "Non-smoking Table";
                if (smoke.isChecked()) {
                    smoker = "Smoking table";
                }
                String min = tp.getCurrentMinute().toString();
                if (tp.getCurrentMinute().toString().length() == 1) {
                    min = "0" + tp.getCurrentMinute();
                }
                String toast = "Name: " + name.getText().toString()
                        + "\nMobile: " + mobile.getText().toString()
                        + "\nSize: " + size.getText().toString()
                        + "\nDate: " + dp.getDayOfMonth() + "/" + (dp.getMonth()+1) + "/" + dp.getYear()
                        + "\nTime:" + tp.getCurrentHour() + ":" + min
                        + "\nSmoking Table:" + smoker;

                Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_LONG).show();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                mobile.setText("");
                size.setText("");
                dp.init(2019,5,1,null);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(0);
                smoke.setChecked(false);
            }
        });
    }
}
