package com.rarnu.slidedemo.activity;

import android.app.Fragment;
import android.view.MenuItem;

import com.rarnu.devlib.base.BaseActivity;
import com.rarnu.slidedemo.R;
import com.rarnu.slidedemo.Tags;
import com.rarnu.slidedemo.fragment.DrawerFragment;

public class DrawerActivity extends BaseActivity {

	private DrawerFragment fragment = new DrawerFragment(Tags.TAG_DRAWER);

	@Override
	public int getIcon() {
		return R.drawable.ic_launcher;

	}

	@Override
	public Fragment replaceFragment() {
		return fragment;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			fragment.setNewArguments(null);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
