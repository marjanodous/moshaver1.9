package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hoquqi.adapter.AdapterSoalat;
import com.example.hoquqi.model.Soal;

import java.util.ArrayList;

public class ActivitySoalat extends AppCompatActivity {
    /*create object for xml*/
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    /*array type of model soal*/
    ArrayList<Soal> soalArrayList ;
    /*objet type of AdapterSoal*/
    AdapterSoalat adapterSoalat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soalat);

        /* Get object from xml file*/
        recyclerView = findViewById(R.id.recycler_view_soalat);
        /*calling method to set items for arraylist */
        setTextSoal();
        /* calling method to set RecyclerAdapter */
        setupRecyclerAdapter(soalArrayList);
    }

    /* method for set value to list */
    public ArrayList<Soal>  setTextSoal(){
        soalArrayList = new ArrayList<>();
        soalArrayList.add(new Soal("سلام ایا کارت هدیه بانکی که از طرف شرکت به کارمندان" +
                "داده شود شامل معافیت مالیاتی ماده 91 قانون مالیاتهای مستقیم در خصوص معافیت مزایای غیر نقدی میشود؟"));
        soalArrayList.add(new Soal("سلام آیا کسب و کار الکترونیک،نظیر سایتهایفروش شامل مالیات و مالیات بر ارزش افزوده میشوند؟" +
                " اگر بلی چه کالاها و زمینه هایی شامل میشوند؟منبع کسب اطباعات در این زمینه کجاست؟ با تشکر فراوان"));
        soalArrayList.add(new Soal("از سال 92 مدرک مهندسی خود را در قبال مبلغی پول جهت رتبه بندی در اختیار شرکتی با مسئولیت محدود قرار دادم و %5 سهام به نامم شد." +
                " با فوت صاحب شرکت و عدم اقدام وراث، ااره مالیات بدلیل بدهیهای شرکت مذکور،" +
                " در اسفند ماه 94 اقدام به انسداد حساب بانکیم نمود." +
                " لطفا ارائه طریق فرمایید و سوال اینکه وکالتم را در شهرستان گچساران میپذیرد؟"));
        soalArrayList.add(new Soal("مغازه فروختم 700 میلیون مالیات این چقدره؟"));
        soalArrayList.add(new Soal("با سلام من برج یازده سال 94 تا برج یازده سال 95 در مغازه فعالیت داشتم و متاسفانه اطلاعی از قوانین مالیاتی نداشتم و اظهارنامه پرنکردم آیا من شامل جرایم مالیاتی میشم و مبلغش چقدره با تشکر"));
        soalArrayList.add(new Soal("با سلام آیا راهی هست که من دادخواست تامین خواسته برای توقیف اموال منقول همسرم را بگیرم ولی حالا به همسرم ابلاغ نشود؟" +
                "فقط میخوام نتواند اموالشو در غیاب من به نام کسی بکند. سپاسگذار میشم راهنماییم کنید"));
        soalArrayList.add(new Soal("سلام شوهرم منو کتک میزند این دفعه پرده گوشم سوراخ شده" +
                " رفتم پزشکی قانونی ولی نمیخوام طلاق بگیرم میخوام یه کاری کنم که دیگه نتونه منو بزند"));
        soalArrayList.add(new Soal("زنی که در خانه همسرش زندگی میکنداما مرد عرصه را بر او تنگ کرده و" +
                " هیچگونه وجه  نقدی در اختیارش قرار نمیدهدچطور باید برای نفقه اقدام نماید"));
        soalArrayList.add(new Soal("شوهرم مرا مجبور به بخشیدن مهریه ام کرده است. " +
                "کلیه مراحل قانونی انجام شده است آیا در حال حاضر میتوانم از دست ایشان شکایت کنم؟ "));
        soalArrayList.add(new Soal("با توجه به شرایط سختی که در خانهبوجود آمده درخواست راهنمایی دارم، پدر من بازنشسته آموزش و پرورش میباشد و با توجه به حقوقی که میگیره نمیتونه نیازهایمان را مهیا بکنه و همیشه میگه پول ندارم و از کجا بیارم " +
                "و از جایی دیگر نه اجازه کار کردن به ما میده و نه حتی اجازه میده ازدواج کنیم. میشه لطفا راهنمایی کنید که در این وضعیت چکاری میتوانیم بکنیم؟" +
                "ما سه تا دختریم تو خونه. تحصیل رده و سن هامون بالا رفته.نمیدونم منتظر چیه و اصلا چرا اینکارو میکنه." +
                "از طرفی چون پدرم فرزند ارشد خانواده اش است و آبرو داره دنبال راه حلی هستم که نه غرورشو بشکنه نه خودمون تباه بشیم. راستی گفتگو و صحبت به جایی نرسید:("));
        soalArrayList.add(new Soal("یازدهم"));
        soalArrayList.add(new Soal("دوازدهم"));
        soalArrayList.add(new Soal("سیزدهم"));
        soalArrayList.add(new Soal("چهاردهم"));
        soalArrayList.add(new Soal("پانزدهم"));
        soalArrayList.add(new Soal("شونزدهم"));
        soalArrayList.add(new Soal("هفدهم"));
        soalArrayList.add(new Soal("هجدهم"));
        soalArrayList.add(new Soal("نوزدهم"));
        soalArrayList.add(new Soal("بیستم"));

        return soalArrayList;
    }

    /*4.method get array parametr and set from RecyclerAdapter*/
    private void setupRecyclerAdapter(ArrayList<Soal> list) {
        adapterSoalat = new AdapterSoalat(this, list);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapterSoalat);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
