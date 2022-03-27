package com.example.myapplication;

public class MonAn {
    private int monanId;
    private String moanname;
    private int avt;
    private String nguyenlieu;
    private String congthuc;
    private String tien;

    public MonAn(int monanId, String moanname, int avt, String nguyenlieu, String congthuc, String tien) {
        this.monanId = monanId;
        this.moanname = moanname;
        this.avt = avt;
        this.nguyenlieu = nguyenlieu;
        this.congthuc = congthuc;
        this.tien = tien;
    }

    public int getMonanId() {
        return monanId;
    }

    public void setMonanId(int monanId) {
        this.monanId = monanId;
    }

    public String getMoanname() {
        return moanname;
    }

    public void setMoanname(String moanname) {
        this.moanname = moanname;
    }

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }

    public String getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }

    public String getCongthuc() {
        return congthuc;
    }

    public void setCongthuc(String congthuc) {
        this.congthuc = congthuc;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }

    @Override
    public String toString() {
        return "MonAn{" +
                "monanId=" + monanId +
                ", moanname='" + moanname + '\'' +
                ", avt=" + avt +
                ", nguyenlieu='" + nguyenlieu + '\'' +
                ", congthuc='" + congthuc + '\'' +
                ", tien='" + tien + '\'' +
                '}';
    }
}
