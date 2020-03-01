package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hoquqi.adapter.AdapterSearch;
import com.example.hoquqi.dataBase.Database;
import com.example.hoquqi.model.Moshaver;

import java.util.ArrayList;

public class ActivitySearch extends AppCompatActivity {

    /*create object for xml*/
    ListView listViewSearch;
    EditText edtNameSearch;
    TextView txtResult;
    ImageView imgClear;

    public ArrayList<Moshaver> ArrayListSearch, ArrayListSearchUser;
    AdapterSearch adapter;
    public ArrayList<Moshaver> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        /* Get object from xml file*/
        listViewSearch = findViewById(R.id.listView_search);
        edtNameSearch = findViewById(R.id.edt_name_search);
        txtResult = findViewById(R.id.result_search);
        imgClear = findViewById(R.id.imgsearch_clear);

        /*calling method to set items for arraylist defualt*/
        setItemList();


        /*2.clear text Search*/
        imgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNameSearch.setText("");
            }
        });

        /*3.checked edit text when user typing*/
        edtNameSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                /*4. when text the length > 3 char*/
                String text = edtNameSearch.getText().toString().trim();
                if (text.length() >= 3) {
                    /*calling method set item Search*/
                    serchArray(text);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                String text = edtNameSearch.getText().toString().trim();
                /* 5.if text is empty show list empty*/
                if (text.equals("")) {
                    txtResult.setText("نتیجه جستجو");
                    ArrayListSearchUser = new ArrayList<>();
                    setItemListSearch();
                }
            }
        });
    }

    /*6.method show list user searched */
    public void setItemListSearch() {
        adapter = new AdapterSearch(ActivitySearch.this, R.layout.searchitem, ArrayListSearchUser);
        listViewSearch.setAdapter(adapter);
    }

    /*7.method for set value to list defualt*/
    public void setItemList() {
        ArrayListSearch = new ArrayList<>();
        ArrayListSearch.add(new Moshaver("قانون اساسی جمهوری اسلامی ایران"));
        ArrayListSearch.add(new Moshaver("تاریخچه"));
        ArrayListSearch.add(new Moshaver("قضا در قانون اساسی"));
        ArrayListSearch.add(new Moshaver("قوه مجریه"));
        ArrayListSearch.add(new Moshaver("نمایندگان"));//FrgHome
        ArrayListSearch.add(new Moshaver("صلاحیت های دادگاه خانواده"));
        ArrayListSearch.add(new Moshaver("لزوم تشکیل دادگاه خانواده"));
        ArrayListSearch.add(new Moshaver("تشریفات رسیدگی در دادگاه خانواده"));
        ArrayListSearch.add(new Moshaver("حضور قاضی زن در دادگاه خانواده"));
        ArrayListSearch.add(new Moshaver("شرایط قضات دادگاه خانواده"));
        ArrayListSearch.add(new Moshaver("مراکز مشاوره خانواده"));
        ArrayListSearch.add(new Moshaver("حمایت های قانونی از افراد بی بضاعت"));//خانواده
        ArrayListSearch.add(new Moshaver("مهاجرت"));//مهاجرت
        ArrayListSearch.add(new Moshaver("جرائم مالیاتی چیست؟"));//مالیاتی
        ArrayListSearch.add(new Moshaver("انواع جرائم مالیاتی"));
        String m;
        list = Database.getdataMoshaver(getApplicationContext());
        for (int i = 0; i < list.size(); i++) {
            m = list.get(i).getmName();
            ArrayListSearch.add(new Moshaver(m));
        }
    }

    /*8. when name is equal whit list item defult*/
    public void serchArray(String name) {
        ArrayListSearchUser = new ArrayList<>();
        String sname = name;
        boolean flag = false;
        for (Moshaver item : ArrayListSearch) {
            String model = item.getmName();
            if (model.contains(sname)) {
                flag = true;
                /*add equal item to list Search*/
                ArrayListSearchUser.add(new Moshaver(model));
                /*calling method to show list Search*/
                setItemListSearch();
                txtResult.setText("نتیجه جستجو");
            } else if (flag == false) {
                /*set empty item to listsearch*/
                ArrayListSearchUser = new ArrayList<>();
                setItemListSearch();
                txtResult.setText("موردی یافت نشد");
            }
        }
    }
}
