
package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoquqi.adapter.viewPagerAdapter;
import com.example.hoquqi.model.ChosoeTabs;
import com.example.hoquqi.model.SharedPreferencesManager;
import com.example.hoquqi.model.userApp;
import com.google.android.material.tabs.TabLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    /*create object for xml*/
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageView imgMenu, search;
    DrawerLayout myDraw;
    TextView call_me, txtuName, txtExit, txtfreeMoshaver, txtMoarefiDustan,
            txtSingUpMoshaver, txtListMoshaveran,txtSoalatShafahi;

    /*9.type boolean for method setTab*/
    public static boolean flag_home, flag_family, flag_mohajerat, flag_maliaty = false;
    public static String Transaction_type;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Get object from xml file*/
        call_me=findViewById(R.id.txt_call_me);
        search = findViewById(R.id.img_search);
        txtListMoshaveran = findViewById(R.id.txt_list_moshaverin);
        txtExit = findViewById(R.id.txt_exit);
        txtuName = findViewById(R.id.username);
        txtSingUpMoshaver = findViewById(R.id.txt_sing_up_moshaver);
        txtMoarefiDustan = findViewById(R.id.txt_moarefi_dustan);
        txtfreeMoshaver = findViewById(R.id.txt_free_moshavere);
        txtSoalatShafahi=findViewById(R.id.txt_soalat_shafahi);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);


        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFrg(new FrgHome(), "اصلی");
        adapter.addFrg(new FrgAyamidanid(), "آیا میدانید های حقوقی");
        adapter.addFrg(new FrgKhanevade(), "خانواده");
        adapter.addFrg(new FrgMohajerat(), "مهاجرت");
        adapter.addFrg(new FrgMaliati(), "مالیاتی");
        adapter.addFrg(new FrgNahvekar(), "نحوه کار");
        viewPager.setAdapter(adapter);

        if (tabLayout.getSelectedTabPosition() == 0) {
            Transaction_type = ChosoeTabs.getChooseTabhome();
        } else if (tabLayout.getSelectedTabPosition() == 2) {
            Transaction_type = ChosoeTabs.getChooseTab_khanevade();
        } else if (tabLayout.getSelectedTabPosition() == 1) {
            Transaction_type = ChosoeTabs.getChooseTab_ayamidanid();
        } else if (tabLayout.getSelectedTabPosition() == 3) {
            Transaction_type = ChosoeTabs.getChooseTab_mohajerat();
        } else if (tabLayout.getSelectedTabPosition() == 4) {
            Transaction_type = ChosoeTabs.getChooseTab_maliati();
        } else if (tabLayout.getSelectedTabPosition() == 5) {
            Transaction_type = ChosoeTabs.getChooseTab_nahvekar();
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        //==============open draw=============================
        imgMenu = findViewById(R.id.img_menu);
        myDraw = findViewById(R.id.myDraw);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDraw.openDrawer(Gravity.RIGHT);
            }
        });

        /*1.open free moshaver and mailTo */
        txtfreeMoshaver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/html");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Fatemm97@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
                startActivity(Intent.createChooser(intent, "Send Email"));
                myDraw.closeDrawers();
            }
        });
        /*2.open moarefi dustan and send SMS*/
        txtMoarefiDustan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "اپلیکیشن مشاوره حقوقی رایگان...");
                startActivity(intent);
                myDraw.closeDrawers();
            }
        });
        /*5.open Activity search and search text or user*/
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivitySearch.class));
            }
        });

        /*4.open sing up moshaver and add moshaver*/
        txtSingUpMoshaver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivitySingupMoshavere.class));
                myDraw.closeDrawers();
            }
        });

       /*6.set user name from drawer header*/
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("TITLE", MODE_PRIVATE);
        String StoredValue = myPrefs.getString("title", null);
        txtuName.setText(StoredValue);

        /*7.save Exit when user wanted logout from system*/
        txtExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exit = "exit";
                SharedPreferences userDetails = getApplicationContext().getSharedPreferences("Exit", MODE_PRIVATE);
                SharedPreferences.Editor edit = userDetails.edit();
                edit.putString("exit", exit);
                edit.apply();
                finish();
                userApp user = new userApp();
                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(MainActivity.this);
                user = sharedPreferencesManager.get_shared_preferences();
                user.setFirst_time_run(true);
                sharedPreferencesManager.set_false_first_time(user);
            }
        });

        /*8.open list moshaveran*/
        txtListMoshaveran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityListmoshaveran.class));
                myDraw.closeDrawers();
            }
        });
        /*open list soalat*/
        txtSoalatShafahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivitySoalat.class));
                myDraw.closeDrawers();
            }
        });
        call_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,about.class));
            }
        });
    }
    /*9.methid to show tabs when you selected from serch items*/
    public void setTab() {
        if (flag_home) {
            viewPager.setCurrentItem(0);
            flag_home = false;
            flag_family = false;
            flag_mohajerat = false;
            flag_maliaty = false;
        }
        if (flag_family) {
            viewPager.setCurrentItem(2);
            flag_home = false;
            flag_family = false;
            flag_mohajerat = false;
            flag_maliaty = false;
        }
        if (flag_mohajerat) {
            viewPager.setCurrentItem(3);
            flag_home = false;
            flag_family = false;
            flag_mohajerat = false;
            flag_maliaty = false;
        }
        if (flag_maliaty) {
            viewPager.setCurrentItem(4);
            flag_home = false;
            flag_family = false;
            flag_mohajerat = false;
            flag_maliaty = false;
        }
    }

    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    /*10.when you back from searc this method is calling*/
    @Override
    protected void onResume() {
        super.onResume();
        setTab();

    }
}
