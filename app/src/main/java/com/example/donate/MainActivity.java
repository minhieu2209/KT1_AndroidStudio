package com.example.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.donate.model.SpinnerAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private int[] img = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6};
    private TextView tname, tcity, tdate, ttime, tdonate;
    private EditText ename, ecity, edate, etime, edonate;
    private Button btadd, btupdate;
    private RadioGroup radioGroup;
    private RadioButton rbmale, rbfemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        spinner = findViewById(R.id.spimg);
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this);
        spinner.setAdapter(spinnerAdapter);
        tname = findViewById(R.id.tname);
        tcity = findViewById(R.id.tcity);
        tdate = findViewById(R.id.tdate);
        ttime = findViewById(R.id.ttime);
        tdonate = findViewById(R.id.tdonate);
        ename = findViewById(R.id.ename);
        ecity = findViewById(R.id.ecity);
        edate = findViewById(R.id.edate);
        etime = findViewById(R.id.etime);
        edonate = findViewById(R.id.edonata);

    }
}