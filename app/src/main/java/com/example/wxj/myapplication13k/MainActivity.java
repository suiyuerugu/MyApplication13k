package com.example.wxj.myapplication13k;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private SimpleAdapter mAdapter;
    private List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.grid_view);
        initdata();
        mAdapter = new SimpleAdapter(this, list, R.layout.gridview_layout, new String[]{"image",
                "price", "content"},new int[]{R.id.image,R.id.tv_price,R.id.tv_content});
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,ShowInfoActivity.class);
                intent.putExtra("image1",(int)list.get(i).get("image"));
                intent.putExtra("price1",(String)list.get(i).get("price"));
                intent.putExtra("content1",(String)list.get(i).get("content"));
                startActivity(intent);
            }
        });
    }

    private void initdata() {
        int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R
                .drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8};
        String[] prices = {"￥159", "￥216", "￥169", "￥199", "￥215", "￥369", "￥309", "￥329"};
        String[] contents = {"裙子秋冬2017新款格子毛呢短裙A字裙格子裙打底裙半身裙女高腰潮",
                "2017秋装新款针织毛衣冬天裙子女韩版长袖套头打底冬季加厚连衣裙",
                "针织秋冬季连衣裙女长袖2017新款修身显瘦加厚圆领中长款裙子潮",
                "毛呢半身裙秋冬中长款裙子女士高腰包臀裙开叉包裙显瘦一步裙中裙",
                "装套装男士三件套商务职业正装西服韩版修身伴郎新郎结婚礼服秋",
                "西服套装男士三件套商务正装职业小西装修身韩版伴郎新郎结婚礼服",
                "花花公子西服套装男西装男士商务休闲职业装修身新郎伴郎结婚礼服",
                "西服套装男士春秋修身三件套新郎婚礼服结婚伴郎西装男职业装正装"};
        list=new ArrayList<>();
        for(int i=0;i<8;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("image",images[i]);
            map.put("price",prices[i]);
            map.put("content",contents[i]);
            list.add(map);
        }
    }
}
