package com.rarnu.slidedemo.activity;

import android.app.Fragment;
import android.view.MenuItem;

import com.rarnu.devlib.base.BaseActivity;
import com.rarnu.slidedemo.R;
import com.rarnu.slidedemo.Tags;
import com.rarnu.slidedemo.fragment.SlidingPaneFragment;

public class SlidingPaneActivity extends BaseActivity {

	SlidingPaneFragment fragment = new SlidingPaneFragment(Tags.TAG_SLIDEPANE);

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
			if (!fragment.getFragmentState().getBoolean("opened")) {
				fragment.setNewArguments(null);
				return true;
			}
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
