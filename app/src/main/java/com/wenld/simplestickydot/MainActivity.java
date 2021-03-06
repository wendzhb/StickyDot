package com.wenld.simplestickydot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView rlvAtyFilter;
    CommonAdapter adapter;
    List<ItemClass> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getActionBar().setTitle("自定义View");
        list.add(new ItemClass(" 自定义小红点_1", Activity_Version_1.class));
        list.add(new ItemClass(" WindowManager_1", Activity_windows.class));
        list.add(new ItemClass(" 组合封装使用__1", Activity_Version_2.class));
        list.add(new ItemClass(" 在列表中的使用", Activity_version_3.class));

        this.rlvAtyFilter = (RecyclerView) findViewById(R.id.rlv_activity_main);

        adapter = new CommonAdapter<ItemClass>(this, R.layout.list_items, list) {
            @Override
            protected void convert(ViewHolder holder, final ItemClass s, final int position) {
                TextView btn = holder.getView(R.id.btn);
                btn.setText(s.name);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (s.className == null)
                            return;
                        Intent intent = new Intent(MainActivity.this, s.className);
                        if (intent != null) {
                            startActivity(intent);
                        }
                    }
                });
                holder.getView(R.id.tv_activity_windows).setVisibility(View.GONE);
            }
        };
        rlvAtyFilter.setLayoutManager(new LinearLayoutManager(this));
        rlvAtyFilter.setAdapter(adapter);
    }

    public class ItemClass {
        public String name;
        public Class className;

        public ItemClass(String name, Class className) {
            this.name = name;
            this.className = className;
        }
    }
}
