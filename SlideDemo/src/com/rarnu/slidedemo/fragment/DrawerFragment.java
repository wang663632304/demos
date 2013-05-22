package com.rarnu.slidedemo.fragment;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rarnu.devlib.base.BaseFragment;
import com.rarnu.slidedemo.R;
import com.rarnu.slidedemo.Shakespeare;

public class DrawerFragment extends BaseFragment implements DrawerListener,
		OnItemClickListener {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerLeft;
	private TextView mContent;

	public DrawerFragment(String tagText) {
		super(tagText, "");
	}

	@Override
	public int getBarTitle() {
		return R.string.app_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.app_name;
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public void initComponents() {
		mDrawerLayout = (DrawerLayout) innerView
				.findViewById(R.id.drawer_layout);

		mDrawerLeft = (ListView) innerView.findViewById(R.id.left_drawer);
		mContent = (TextView) innerView.findViewById(R.id.content_text);

		mDrawerLayout.setDrawerListener(this);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

		mDrawerLeft.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, Shakespeare.TITLES));
		mDrawerLeft.setOnItemClickListener(this);
	}

	@Override
	public void initEvents() {

	}

	@Override
	public void initLogic() {

	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_drawer;
	}

	@Override
	public String getMainActivityName() {
		return "";
	}

	@Override
	public void initMenu(Menu menu) {

	}

	@Override
	public void onGetNewArguments(Bundle bn) {
		mDrawerLayout.closeDrawer(Gravity.RIGHT);
		mDrawerLayout.openDrawer(Gravity.LEFT);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		mContent.setText(Shakespeare.DIALOGUE[position]);
		getActivity().getActionBar().setTitle(Shakespeare.TITLES[position]);
		mDrawerLayout.closeDrawer(Gravity.LEFT);

	}

	@Override
	public void onDrawerClosed(View arg0) {

	}

	@Override
	public void onDrawerOpened(View arg0) {

	}

	@Override
	public void onDrawerSlide(View arg0, float arg1) {
	}

	@Override
	public void onDrawerStateChanged(int arg0) {

	}

	@Override
	public Bundle getFragmentState() {
		return null;
	}

}
