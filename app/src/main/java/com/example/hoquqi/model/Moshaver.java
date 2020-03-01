package com.example.hoquqi.model;

public class Moshaver {

    /*1.model fields*/
    private int mid;
    private String mName;
    private String mPass;
    private String mMail;
    private String mPhone;
    private String mSabegheh;
    private String mMadrak;
    private String mrotbeh;
    private String mAdress;
    private String mRezomeh;
    private String mImage;

    /*2. constructors */
    public Moshaver() {
    }
    public Moshaver(int mid, String mName, String mPass, String mMail, String mPhone,
                    String mSabegheh, String mMadrak, String mrotbeh, String mAdress,
                    String mRezomeh, String mImage) {
        this.mid = mid;
        this.mName = mName;
        this.mPass = mPass;
        this.mMail = mMail;
        this.mPhone = mPhone;
        this.mSabegheh = mSabegheh;
        this.mMadrak = mMadrak;
        this.mrotbeh = mrotbeh;
        this.mAdress = mAdress;
        this.mRezomeh = mRezomeh;
        this.mImage = mImage;
    }
    public Moshaver(String mName) {
        this.mName = mName;
    }

    /*3.get and set*/
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPass() {
        return mPass;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }

    public String getmMail() {
        return mMail;
    }

    public void setmMail(String mMail) {
        this.mMail = mMail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmSabegheh() {
        return mSabegheh;
    }

    public void setmSabegheh(String mSabegheh) {
        this.mSabegheh = mSabegheh;
    }

    public String getmMadrak() {
        return mMadrak;
    }

    public void setmMadrak(String mMadrak) {
        this.mMadrak = mMadrak;
    }

    public String getMrotbeh() {
        return mrotbeh;
    }

    public void setMrotbeh(String mrotbeh) {
        this.mrotbeh = mrotbeh;
    }

    public String getmAdress() {
        return mAdress;
    }

    public void setmAdress(String mAdress) {
        this.mAdress = mAdress;
    }

    public String getmRezomeh() {
        return mRezomeh;
    }

    public void setmRezomeh(String mRezomeh) {
        this.mRezomeh = mRezomeh;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
