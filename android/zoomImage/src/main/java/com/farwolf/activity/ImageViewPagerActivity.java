package com.farwolf.activity;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.farwolf.adapter.HDImageViewAdapter;
import com.farwolf.base.TitleActivityBase;
import com.farwolf.zoomImage.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity
public class ImageViewPagerActivity extends TitleActivityBase {

    public ViewPager viewPager;
    @ViewById
    public TextView position;

    private HDImageViewAdapter mViewAdapter;

    @Override
    public int getViewId() {
        return R.layout.imageviewpager_activity;
    }

    @Override
    public void init() {

    }


    @AfterViews
    public void initImageViewPagerActivity(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        mViewAdapter = new HDImageViewAdapter(this);
        viewPager.setAdapter(mViewAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int p, float positionOffset, int positionOffsetPixels) {
                position.setText((p+1)+"/"+mViewAdapter.getCount());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        this.initData();
    }



    private void initData() {

        List<Uri> data = new ArrayList<>();
//        data.add(Uri.parse(IMAGE_1));
       List<String>list= getIntent().getStringArrayListExtra("list");
       int index= getIntent().getIntExtra("index",0);
        for(String q:list){
            data.add(Uri.parse(q));
        }
        mViewAdapter.addUris(data);
        viewPager.setCurrentItem(index);

    }
}
