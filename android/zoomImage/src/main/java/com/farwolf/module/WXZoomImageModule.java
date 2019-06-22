package com.farwolf.module;

import android.content.Intent;

import com.alibaba.fastjson.JSONArray;
import com.farwolf.activity.ImageViewPagerActivity_;
import com.farwolf.weex.annotation.WeexModule;
import com.farwolf.weex.base.WXModuleBase;
import com.taobao.weex.annotation.JSMethod;

import java.util.ArrayList;
import java.util.Map;

@WeexModule(name="zoomImage")
public class WXZoomImageModule extends WXModuleBase {


    @JSMethod
    public void show(Map p)
    {
        JSONArray l=(JSONArray)p.get("list");
        ArrayList<String>temp=new  ArrayList<String>();
        for(int i=0;i<l.size();i++){
            temp.add(l.getString(i));
        }
        int index=0;
        if(p.containsKey("index"))
            index= Integer.parseInt(p.get("index")+"");
        Intent in=new Intent(getContext(),ImageViewPagerActivity_.class);
        in.putStringArrayListExtra("list",temp);
        in.putExtra("index",index);
        getActivity().startActivity(in);
        getActivity().overridePendingTransition(0, 0);
    }


}
