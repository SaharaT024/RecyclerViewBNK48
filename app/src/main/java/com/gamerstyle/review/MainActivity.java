package com.gamerstyle.review;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    //ham_s
    private  String[] mDrawerTitle = {"BNK48"};
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ListView mListView;


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


    //ham_e

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

            mDrawerLayout = findViewById(R.id.drawer_layout);
            actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                    mDrawerLayout,
                    R.string.open_drawer,
                    R.string.close_drawer);
            mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            mListView = findViewById(R.id.drawer);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
                    android.R.layout.simple_list_item_1,mDrawerTitle );
            mListView.setAdapter(adapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String itemValue = (String) mListView.getItemAtPosition(position);

                    mDrawerLayout.closeDrawers();
                    Toast.makeText(getApplicationContext(),
                            "Position :" + position + "  ListItem : " + itemValue, Toast.LENGTH_SHORT)
                            .show();
                }
            });

    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()) {
            case R.id.mnuNew:
                Toast.makeText(this, "New!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnuHelp:
                Toast.makeText(this, "Help!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //menu

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.cher, "CHERPRANG", "Date of birth :2 May 1996\n" +
                "Height :160 cm\n" +
                "Province :Bangkok\n" +
                "Like :-\n" +
                "Blood Group :B\n" +
                "Hobby :กิน, นอน, เล่นเกม, ฟังเพลง, Cosplay"));
        mExampleList.add(new ExampleItem(R.drawable.pun, "PUN", "Date of birth :9 Nov 2000\n" +
                "Height :166 cm\n" +
                "Province :Bangkok\n" +
                "Like :Fashion\n" +
                "Blood Group :A\n" +
                "Hobby :ฟังเพลง, เล่นมือถือ"));
        mExampleList.add(new ExampleItem(R.drawable.orn, "ORN", "Date of birth :3 Feb 1997\n" +
                "Height :164 cm\n" +
                "Province :Bangkok\n" +
                "Like :แมว, แมวน้ำ, แฟชั่น, เครื่องสำอาง\n" +
                "Blood Group :O\n" +
                "Hobby :นอน, อ่านหนังสือ, เล่นกับแมว"));
        mExampleList.add(new ExampleItem(R.drawable.music, "MUSIC", "Date of birth :24 Feb 2001\n" +
                "Height :158 cm\n" +
                "Province :Bangkok\n" +
                "Like :อะไรก็ได้นิ่มๆ\n" +
                "Blood Group :B\n" +
                "Hobby :Cosplay, Game"));
        mExampleList.add(new ExampleItem(R.drawable.kai, "KAIMOOK", "Date of birth :27 Aug 1997\n" +
                "Height :153 cm\n" +
                "Province :Bangkok\n" +
                "Like :แมว\n" +
                "Blood Group :O\n" +
                "Hobby :เข้าครัว, เย็บผ้า"));
        mExampleList.add(new ExampleItem(R.drawable.pupe, "PUPE", "Date of birth :18 Jan 1998\n" +
                "Height :160 cm\n" +
                "Province :Chiang Rai\n" +
                "Like :ผ้มห่ม, สีชมพู, โดเรม่อน\n" +
                "Blood Group :B\n" +
                "Hobby :เล่นเกม, ดูอนิเมะ, ฟังเพลง. นอน"));
        mExampleList.add(new ExampleItem(R.drawable.kaew, "KAEW", "Date of birth :31 Mar 1994\n" +
                "Height :156 cm\n" +
                "Province :Chonburi\n" +
                "Like :เครื่องสำอาง, น้ำหอม\n" +
                "Blood Group :B\n" +
                "Hobby :เล่นเปียโน, นอน, เดินเล่น"));
        mExampleList.add(new ExampleItem(R.drawable.kate, "KATE", "Date of birth :9 Jun 2001\n" +
                "Height :162 cm\n" +
                "Province :Phayao\n" +
                "Like :gudetama, ตุ๊กตา\n" +
                "Blood Group :B\n" +
                "Hobby :ชิว"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("Example Item", mExampleList.get(position));

                startActivity(intent);
            }
        });
    }
}