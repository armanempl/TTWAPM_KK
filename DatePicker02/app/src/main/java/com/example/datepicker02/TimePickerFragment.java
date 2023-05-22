package com.example.datepicker02;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int godzina = c.get(Calendar.HOUR_OF_DAY);
        int minuta = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, godzina, minuta, true);
    }
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time = String.format("%02d:%02d", hourOfDay, minute);
        Toast.makeText(getActivity(), time, Toast.LENGTH_SHORT).show();
    }
}