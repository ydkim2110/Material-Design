package com.example.anti2110.materialdesign.pickers;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anti2110.materialdesign.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView datePickerText;
    private AppCompatButton datePickerBtn;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private DatePickerDialog finalPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        datePickerText = findViewById(R.id.date_textview_id);
        datePickerBtn = findViewById(R.id.dateBtn_id);

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();

                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentYear = calendar.get(Calendar.YEAR);

                datePickerDialog = DatePickerDialog.newInstance(DatePickerActivity.this,
                        currentYear, currentMonth, currentDay);

                datePickerDialog.setAccentColor(getResources().getColor(R.color.colorDatePicker));

                datePickerDialog.setTitle("날짜를 선택하세요.");

                datePickerDialog.setOkText("set");

                datePickerDialog.setCancelText("do not set");

                datePickerDialog.setThemeDark(false);

                datePickerDialog.dismissOnPause(false);

                datePickerDialog.showYearPickerFirst(false);

                datePickerDialog.show(getFragmentManager(), "datePickerID");

                datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(DatePickerActivity.this, "Cancel!!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        finalPicker = (DatePickerDialog) getFragmentManager().findFragmentByTag("datePickerID");

        if(finalPicker != null) finalPicker.setOnDateSetListener(this);

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        String date = "You picked the following date: " + dayOfMonth + "/" + monthOfYear + "/" + year;
        datePickerText.setText(date);

    }

}
