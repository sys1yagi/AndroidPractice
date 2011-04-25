package jp.dip.sys1.android.drumpicker.lib;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Util {
	public static float getDisplayScale(Context context) {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		return dm.scaledDensity;
	}
}
