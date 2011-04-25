package jp.dip.sys1.android.drumpicker.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TimePicker;

public class TimeDrumPicker extends DrumPicker {
	private final static String TAG = TimeDrumPicker.class.getSimpleName();
	private final static String[] HOUR = { "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "09", "08", "07", "06", "05", "04", "03", "02", "01", "00" };
	private final static String[] TIME = { "59", "58", "57", "56", "55", "54", "53", "52", "51", "50", "49", "48", "47", "46", "45", "44", "43", "42", "41", "40", "39", "38", "37", "36", "35", "34", "33", "32", "31", "30", "29", "28", "27", "26", "25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "09", "08", "07", "06", "05", "04", "03", "02", "01", "00" };

	TimePicker.OnTimeChangedListener mListener = null;
	private int mHour = 0;
	private int mMinitue = 0;

	public TimeDrumPicker(Context context) {
		this(context, null);

	}

	public TimeDrumPicker(Context context, AttributeSet attr) {
		super(context, attr);
		init();

	}
	public int getHour(){
		return mHour;
	}
	public void setHour(int hour){
		if(hour >= 0 && hour < 24){
			setPosition(0, 23-hour);
		}
	}
	public int getMinitue(){
		return mMinitue;
	}
	public void setMinitue(int minitue){
		if(minitue >= 0 && minitue < 60){
			setPosition(1, 59-minitue);
		}
	}
	
	public void init() {
		// onsizeChanged‚Å‚â‚Á‚½‚çH
		addRow(HOUR, 80);
		addRow(TIME, 80);
		
		setPosition(0, 23);
		setPosition(1, 59);
		setOnPostionChangedListener(new OnPositionChangedListener() {
			@Override
			public void onPositionChanged(int itemPos, int pos) {
				switch (itemPos) {
				case 0:
					mHour = Integer.parseInt(HOUR[pos]);
					break;
				case 1:
					mMinitue = Integer.parseInt(TIME[pos]);
					break;
				}
				if (mListener != null) {
					mListener.onTimeChanged(null, mHour, mMinitue);
				}
			}
		});
	}

	public void setOnTimeChangedListener(TimePicker.OnTimeChangedListener listener) {
		mListener = listener;
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int height = (int)(150*Util.getDisplayScale(getContext()));
		int h = MeasureSpec.makeMeasureSpec(MeasureSpec.getMode(heightMeasureSpec), height);
		super.onMeasure(widthMeasureSpec, h);
	}
}
