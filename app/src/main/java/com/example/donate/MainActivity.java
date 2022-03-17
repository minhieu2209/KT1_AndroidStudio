package com.example.donate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.donate.model.Donate;
import com.example.donate.model.DonateAdapter;
import com.example.donate.model.SpinnerAdapter;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private int[] img = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6};
    private EditText ename, ecity, edate, etime, edonate;
    private Button btadd, btupdate;
    private RadioGroup radioGroup;
    private RadioButton rbmale, rbfemale;

    private RecyclerView rview;
    private DonateAdapter adapter;
    private int posCurr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Calendar c = Calendar.getInstance();
        etime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        etime.setText(i + ":" + i1);
                    }
                }, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });
        edate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                        edate.setText(dd + "-" + mm + "-" + yy);
                    }
                },c.get(Calendar.YEAR), c.get(Calendar.MONTH) , c.get(Calendar.DATE));
                datePickerDialog.show();
            }
        });

        adapter = new DonateAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rview.setLayoutManager(manager);
        rview.setAdapter(adapter);

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Donate donate = new Donate();
                int img = Integer.parseInt(spinner.getSelectedItem().toString());
                String name = ename.getText().toString();
                int gender;
                if (rbmale.isChecked()) gender = 1;
                else gender = 0;
                String city = ecity.getText().toString();
                String time = etime.getText().toString();
                String date = edate.getText().toString();
                int money = Integer.parseInt(edonate.getText().toString());
                donate.setName(name);
                donate.setImg_ava(img);
                donate.setGender(gender);
                donate.setCity(city);
                donate.setTime(time);
                donate.setDate(date);
                donate.setDonate(money);
                adapter.add(donate);
            }
        });
    }

    private void initView() {
        spinner = findViewById(R.id.spimg);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this);
        spinner.setAdapter(spinnerAdapter);
        ename = findViewById(R.id.ename);
        ecity = findViewById(R.id.ecity);
        edate = findViewById(R.id.edate);
        etime = findViewById(R.id.etime);
        edonate = findViewById(R.id.edonata);
        btadd = findViewById(R.id.btadd);
        btupdate = findViewById(R.id.btupdate);
        radioGroup = findViewById(R.id.rggender);
        rbmale = findViewById(R.id.rbmale);
        rbfemale = findViewById(R.id.rbfemale);
        rview = findViewById(R.id.rview);

    }
}