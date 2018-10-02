package com.example.anti2110.materialdesign.pickers;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anti2110.materialdesign.R;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class TimePickerActivity extends AppCompatActivity
    implements TimePickerDialog.OnTimeSetListener{

    private TextView timeText;
    private AppCompatButton timeBtn;
    private Calendar calendar;
    private TimePickerDialog timePickerDialog;
    private TimePickerDialog finalPicker;
    private boolean time24HourMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        timeText = findViewById(R.id.time_textview_id);
        timeBtn = findViewById(R.id.timeBtn_id);
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                int currentMin = calendar.get(Calendar.MINUTE);
                int currentSec = calendar.get(Calendar.SECOND);

                timePickerDialog = TimePickerDialog.newInstance(TimePickerActivity.this,
                        currentHour, currentMin, currentSec, time24HourMode);

                timePickerDialog.setAccentColor(getResources().getColor(R.color.colorTimePicker));

                timePickerDialog.setTitle("Time Picker");

                timePickerDialog.setThemeDark(false);

                timePickerDialog.dismissOnPause(true);

                timePickerDialog.setOkText("저장?");

                timePickerDialog.setCancelText("취소?");

                timePickerDialog.enableSeconds(false);

                timePickerDialog.show(getFragmentManager(), "timePicker");

                timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(TimePickerActivity.this, "Cancel!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        finalPicker = (TimePickerDialog) getFragmentManager().findFragmentByTag("timePicker");

        if(finalPicker != null) finalPicker.setOnTimeSetListener(this);

    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String hour = hourOfDay < 10 ? "0" + hourOfDay : "" + hourOfDay;
        String min = minute < 10 ? "0" + minute : "" + minute;
        String sec = second < 10 ? "0" + second : "" + second;

        String time = "You picked the following time : " + hour + "h " + min + "m " + sec + "s";
        timeText.setText(time);

    }
}
