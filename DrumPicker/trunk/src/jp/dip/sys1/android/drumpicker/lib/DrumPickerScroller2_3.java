package jp.dip.sys1.android.drumpicker.lib;

import android.content.Context;
import android.widget.OverScroller;

class DrumPickerScroller2_3 extends OverScroller implements IDrumPickerScroller{
	public DrumPickerScroller2_3(Context context){
		super(context);
	}
	@Override
	public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
		super.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
	}
}