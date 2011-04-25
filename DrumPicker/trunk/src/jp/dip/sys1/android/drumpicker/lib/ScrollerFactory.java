package jp.dip.sys1.android.drumpicker.lib;

import java.lang.reflect.Field;

import android.content.Context;
import android.util.Log;
import android.widget.ScrollView;

public class ScrollerFactory {
	private final static String TAG = ScrollerFactory.class.getSimpleName();
	private final static String SCROLLER="android.widget.Scroller";
	private final static String DRUM_SCROLLER = "jp.dip.sys1.android.drumpicker.lib.DrumPickerScroller";
	private final static String OVER_SCROLLER="android.widget.OverScroller";
	private final static String DRUM_SCROLLER2_3 = "jp.dip.sys1.android.drumpicker.lib.DrumPickerScroller2_3";
	
	public static IDrumPickerScroller create(ScrollView scrollView, Context context){
		IDrumPickerScroller result = null;
		Field[] fields = ScrollView.class.getDeclaredFields();
		String name = null;
		String clazz = null;
		for(Field field : fields){
			Log.d(TAG, field.getType().getName() + "="+ field.getName());
			if(field.getType().getName().equals(SCROLLER)){
				//Log.d(TAG,"find! declared name is " +field.getName());
				name = field.getName();
				clazz = DRUM_SCROLLER;
				break;
			}
			else if(field.getType().getName().equals(OVER_SCROLLER)){
				name = field.getName();
				clazz = DRUM_SCROLLER2_3;
				break;
			}
		}
		if(name != null){
			try {
				Field scroller = ScrollView.class.getDeclaredField(name);
				scroller.setAccessible(true);
				result = (IDrumPickerScroller)Class.forName(clazz).getConstructor(Context.class).newInstance(context);
				scroller.set(scrollView, result);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Faild overwrite." );
			}
		}
		else{
			throw new RuntimeException("DrumPicker is not supported in this device or OS." );
		}
		return result;
	}
}
