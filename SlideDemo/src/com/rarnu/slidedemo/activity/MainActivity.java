package com.rarnu.slidedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.rarnu.slidedemo.R;
import com.rarnu.utils.UIUtils;

public class MainActivity extends Activity implements OnClickListener {

	Button btnDrawer, btnSlidePane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		UIUtils.initDisplayMetrics(this, getWindowManager(), false);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnDrawer = (Button) findViewById(R.id.btnDrawer);
		btnSlidePane = (Button) findViewById(R.id.btnSlidePane);
		btnDrawer.setOnClickListener(this);
		btnSlidePane.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnDrawer:
			startActivity(new Intent(this, DrawerActivity.class));
			break;
		case R.id.btnSlidePane:
			startActivity(new Intent(this, SlidingPaneActivity.class));
			break;
		}
	}

}
