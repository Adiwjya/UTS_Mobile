package com.example.uts_adi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity2 extends BaseAdapter {
    Context x;
    String kode[];
    String nama[];
    String stn[];
    String hb[];
    String hj[];
    String diskon[];
    LayoutInflater y;

    public MainActivity2(Context x, String kode[], String nama[], String stn[], String hb[], String hj[], String diskon[]){
        this.x = x;
        this.kode = kode;
        this.nama = nama;
        this.stn = stn;
        this.hb = hb;
        this.hj = hj;
        this.diskon = diskon;

        y = (LayoutInflater.from(x));
    }


    @Override
    public int getCount() {
        return kode.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = y.inflate(R.layout.activity_main2,null);
        TextView kode1=(TextView) convertView.findViewById(R.id.kode);
        TextView nama1=(TextView) convertView.findViewById(R.id.nama);
        TextView stn1=(TextView) convertView.findViewById(R.id.satuan);
        TextView hb1=(TextView) convertView.findViewById(R.id.hb);
        TextView hj1=(TextView) convertView.findViewById(R.id.hj);
        TextView diskon1=(TextView) convertView.findViewById(R.id.diskon);
        kode1.setText(kode[position]);
        nama1.setText(nama[position]);
        stn1.setText(stn[position]);
        hb1.setText(hb[position]);
        hj1.setText(hj[position]);
        diskon1.setText(diskon[position]);
        return convertView;
    }
}
