package shihoo.wang.coordinatorlayout;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import shihoo.wang.coordinatorlayout.adapter.ItemAdapter;

public class MainActivity extends AppCompatActivity {

    private AppBarLayout appbarlayout;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private ItemAdapter mItemAdapter;
    private LinearLayout ll_course_title;
    private CollapsingToolbarLayout collapsingtoolbarlayout;
    private int collapsingHeight;
    private RelativeLayout rl_toolbar;
    private TextView text_load_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        appbarlayout= (AppBarLayout) findViewById(R.id.appbarlayout);
        ll_course_title = findViewById(R.id.ll_course_title);
        collapsingtoolbarlayout = findViewById(R.id.collapsingtoolbarlayout);
        rl_toolbar = findViewById(R.id.rl_toolbar);
        text_load_play = findViewById(R.id.text_load_play);

        mToolbar.setTitle("江娥啼竹素女愁");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        mDatas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String s = String.format("我是第%d个item", i);
            mDatas.add(s);
        }
        mItemAdapter = new ItemAdapter(this, mDatas);
        mRecyclerView.setAdapter(mItemAdapter);

        appbarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int a = ll_course_title.getHeight();
                int b = mToolbar.getHeight();
                int c = appBarLayout.getHeight();
                int i = (a + b ) - c;
                if(i == verticalOffset){
                    showToolbar();
                }
                if(verticalOffset == 0){
                    hindToolbar();
                }
            }
        });

        text_load_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 右键点击项目-选择新建一个Activity-选择滑动Activity
                startActivity(new Intent(MainActivity.this, ItemListActivity.class));
            }
        });
    }

    private void showToolbar(){

    }

    private void hindToolbar(){

    }
}
