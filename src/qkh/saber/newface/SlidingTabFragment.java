package qkh.saber.newface;

import saber.qkh.newweather.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ab.view.sliding.AbSlidingTabView;
/**
 * 	活动标签碎片
 *
 *			
 *			
 */
public class SlidingTabFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.sliding_tab, null);
		AbSlidingTabView mAbSlidingTabView = (AbSlidingTabView) view
				.findViewById(R.id.mAbSlidingTabView);

		// 如果里面的页面列表不能下载原因：
		// Fragment里面用的AbTaskQueue,由于有多个tab，顺序下载有延迟，还没下载好就被缓存了�?�改成用AbTaskPool，就ok了�??
		// 或�?�setOffscreenPageLimit(0)

		// 缓存数量
//		mAbSlidingTabView.getViewPager().setOffscreenPageLimit(1);

//		Fragment1 page1 = new Fragment1();
//		Fragment1 page2 = new Fragment1();
//		Fragment1 page3 = new Fragment1();
//		Fragment1 page4 = new Fragment1();
//		Fragment1 page5 = new Fragment1();

//		List<Fragment> mFragments = new ArrayList<Fragment>();
//		mFragments.add(page1);
//		mFragments.add(page2);
//		mFragments.add(page3);
//		mFragments.add(page4);
//		mFragments.add(page5);
//		List<String> tabTexts = new ArrayList<String>();
//		tabTexts.add("推荐");
//		tabTexts.add("排行");
//		tabTexts.add("游戏中心");
//		tabTexts.add("专题栏目");
//		tabTexts.add("咖啡�?");
//		// 设置样式
//		mAbSlidingTabView.setTabTextColor(Color.BLACK);
//		mAbSlidingTabView.setTabSelectColor(Color.rgb(30, 168, 131));
//		mAbSlidingTabView.setTabBackgroundResource(R.drawable.tab_bg);
//		mAbSlidingTabView.setTabLayoutBackgroundResource(R.drawable.slide_top);
		// 演示增加�?�?
	//	mAbSlidingTabView.addItemViews(tabTexts, mFragments);

		// 演示增加�?�?
		// mAbSlidingTabView.addItemView("咖啡�?", page5);

//		mAbSlidingTabView.setTabPadding(20, 8, 20, 8);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

}
