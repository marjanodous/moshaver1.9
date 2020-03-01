package com.example.hoquqi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoquqi.adapter.ItemAdapter;
import com.example.hoquqi.model.Item;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FrgAyamidanid extends Fragment {

    /*create object for xml*/
    RecyclerView rv;
    List<Item> item = new ArrayList<>();

    public static FrgAyamidanid newInstance() {
        return new FrgAyamidanid();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*1.create view*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ayamidanid, null);

        /* Get object from xml file*/
        rv = rootView.findViewById(R.id.recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        /*2.calling method to set array value*/
        setItem();

        /*3.set to adapter*/
        rv.setAdapter(new ItemAdapter(item, getActivity()));

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /*method to set items array*/
    public void setItem() {
        item.add(new Item("در پرونده های مهـم، متهم باید وکیل داشته باشد و در صورتی که وکیل معرفی نکند دادگاه برای او وکیل تسخیری تعیین میکند "));
        item.add(new Item("در صورتی که متهم توانایی انتخاب وکیل را نداشته باشد، میتواند از دادگاه درخواست تعیین وکیل مجانی نماید؟"));
        item.add(new Item("گر مردی هر چند با اجازه دادگاه ازدواج مجدد نماید لطمهای به حق همسر اول که ناشی از عقد نکاح و شرطی که به نفع او شده وارد نمیکند و زن می تواند برای مطلقه کردن خود با حفظ حقوق خود به دادگاه مراجعه نماید  "));
        item.add(new Item("اگر شوهر فوت کند و دیهای به ورثه برسد با توجه به اینکه مهریه جزء دین ممتاز است همسر میتواند قبل از تقسیم دیه، مهریه خود را از دیه مطالبه كند."));
        item.add(new Item( "اگر طلاق به علت عدم تمکین و اطاعت زوجه از همسرش صادر شده باشد در زمان عده نفقهای به زن تعلق نمیگیرد مگر آنکه در تمکين شوهر قرار گیرد."));
        item.add(new Item("نفقه زمان حال از طریق شکایت کیفری قابل مطالبه است و نفقه زمان گذشته از طریق ارائه دادخواست حقوقی قابل مطالبه است."));
        item.add(new Item("تمکین به معنای اطاعت زن از شوهر در ادای وظایف زوجیت، حسن معاشرت و سکونت در منزل شوهر مباشد."));
        item.add(new Item("چنانچه پدر یا مادری که حضانت طفل بر عهده وی است به بیماری لاعلاج و واگیردار دچار شود حق حضانت ساقط میشود مگر اینکه شخص بتواند در این خصوص پرستار بگیرد."));
        item.add(new Item("فرزند دختر تا 9 سال قمری و فرزند پسرتا 15 سال قمری تحت حضانت والدین خود هستند."));
    }

    @Override
    public String toString() {
        return "FrgAyamidanid";
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(CalligraphyContextWrapper.wrap(context));
    }


}
