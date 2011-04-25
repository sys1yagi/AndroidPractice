package jp.dip.sys1.android.drumpicker;

import java.util.Calendar;

import jp.dip.sys1.android.drumpicker.lib.DateDrumPicker;
import jp.dip.sys1.android.drumpicker.lib.TimeDrumPicker;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class DrumPickerActivity extends Activity {
	private final static String TAG = DrumPickerActivity.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final String TIME_FORMAT = "%02d" + getString(R.string.hour) + "%02d"
				+ getString(R.string.minitue);
		final String DATE_FORMAT = "%04d"
			+getString(R.string.year)
			+"%02d"
			+getString(R.string.month)
			+"%02d"
			+getString(R.string.day)
			;

		Calendar calendar = Calendar.getInstance();
		final int year = calendar.get(Calendar.YEAR);
		final int month = calendar.get(Calendar.MONDAY);
		final int day = calendar.get(Calendar.DAY_OF_MONTH);
		final int hour = calendar.get(Calendar.HOUR_OF_DAY);
		final int minitue = calendar.get(Calendar.MINUTE);
		setContentView(R.layout.main);
		final TextView time = (TextView) findViewById(R.id.time);
		time.setText(String.format(TIME_FORMAT, hour, minitue));
		final TimeDrumPicker tPicker = (TimeDrumPicker) findViewById(R.id.timepicker);
		tPicker.setHour(hour);
		tPicker.setMinitue(minitue);
		tPicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				time.setText(String.format(TIME_FORMAT, hourOfDay, minute));
			}
		});

		final TextView date = (TextView) findViewById(R.id.date);
		date.setText(String.format(DATE_FORMAT, year, month, day));
		final DateDrumPicker dPicker = (DateDrumPicker) findViewById(R.id.datepicker);
		
		dPicker.setOnDateChangedListener(new OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				date.setText(String.format(DATE_FORMAT, year, monthOfYear,
						dayOfMonth));
			}
		});

		findViewById(R.id.button).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				tPicker.setMinitue(tPicker.getMinitue() + 1);
			}
		});
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dPicker.setYear(year);
				dPicker.setMonth(month);
				dPicker.setDay(day);
				
				tPicker.setHour(hour);
				tPicker.setMinitue(minitue);
				
			}
		});
	}
}