package com.rarnu.slidedemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
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

public class SlidingPaneFragment extends BaseFragment implements
		OnItemClickListener {

	private SlidingPaneLayout mSlidingLayout;
	private ListView mList;
	private TextView mContent;

	public SlidingPaneFragment(String tagText) {
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
		mSlidingLayout = (SlidingPaneLayout) innerView
				.findViewById(R.id.sliding_pane_layout);

		mList = (ListView) innerView.findViewById(R.id.left_pane);
		mContent = (TextView) innerView.findViewById(R.id.content_text);
		mList.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, Shakespeare.TITLES));
		mList.setOnItemClickListener(this);
		mSlidingLayout.setSliderFadeColor(Color.TRANSPARENT);
	}

	@Override
	public void initEvents() {

	}

	@Override
	public void initLogic() {

	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_slidingpane;
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
		mSlidingLayout.openPane();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		mContent.setText(Shakespeare.DIALOGUE[position]);
		getActivity().getActionBar().setTitle(Shakespeare.TITLES[position]);
		mSlidingLayout.closePane();
	}

	@Override
	public Bundle getFragmentState() {
		Bundle bn = new Bundle();
		bn.putBoolean("opened", mSlidingLayout.isOpen());
		return bn;
	}

}
