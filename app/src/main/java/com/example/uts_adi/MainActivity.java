package com.example.uts_adi;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uts_adi.MainActivity2;
import com.example.uts_adi.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static String dbname="ksir.db";
    EditText kode,nama, stn, hb, hj, diskon;
    ListView jisi;
    Button save,delete,update, clear;
    SQLiteDatabase db;
    String kk,nn, ss, hhb, hhj, dd = null;
    Integer hh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kode = findViewById(R.id.kode);
        nama = findViewById(R.id.nama);
        stn = findViewById(R.id.satuan);
        hb = findViewById(R.id.hb);
        hj =findViewById(R.id.hj);
        diskon =findViewById(R.id.diskon);
        clear = findViewById(R.id.cancel);
        save = findViewById(R.id.save);
        jisi = findViewById(R.id.isi);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);


        kode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                kk = kode.getText().toString();
                if (kk.length() > 0 ){
                    clear.setEnabled(true);
                    db= openOrCreateDatabase(dbname, MODE_PRIVATE, null);
                    Cursor c = db.rawQuery("select * from barang where kode = '"+kk+"'",null);

                    if (c.getCount()>0){

                            

//                        save.setEnabled(false);
//                        delete.setEnabled(true);
//                        update.setEnabled(true);
                        db.close();
                    }else{
                        db.close();
                    }
                }else{
                    save.setEnabled(true);
                    delete.setEnabled(false);
                    update.setEnabled(false);
                    clear.setEnabled(false);
                }
            }
        });
        nama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                nn = nama.getText().toString();
                if (nn.length()>0){
                    clear.setEnabled(true);
                }else{
                    clear.setEnabled(false);
                }
            }
        });
        stn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ss = stn.getText().toString();
                if (ss.length()>0){
                    clear.setEnabled(true);
                }else{
                    clear.setEnabled(false);
                }
            }
        });
        hb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                hhb = hb.getText().toString();
                if (hhb.length()>0){
                    clear.setEnabled(true);
                }else{
                    clear.setEnabled(false);
                }
            }
        });
        hj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                hhj = hj.getText().toString();
                if (hhj.length()>0){
                    clear.setEnabled(true);
                }else{
                    clear.setEnabled(false);
                }
            }
        });
        diskon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                dd = diskon.getText().toString();
                if (dd.length()>0){
                    clear.setEnabled(true);
                }else{
                    clear.setEnabled(false);
                }
            }
        });


        jisi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                kk = ((TextView)view.findViewById(R.id.kode)).getText().toString();
                nn = ((TextView)view.findViewById(R.id.nama)).getText().toString();
                ss = ((TextView)view.findViewById(R.id.satuan)).getText().toString();
                hhb = ((TextView)view.findViewById(R.id.hb)).getText().toString();
                hhj = ((TextView)view.findViewById(R.id.hj)).getText().toString();
                dd = ((TextView)view.findViewById(R.id.diskon)).getText().toString();

                kode.setText(kk);
                nama.setText(nn);
                stn.setText(ss);
                hb.setText(hhb);
                hj.setText(hhj);
                diskon.setText(dd);

                save.setEnabled(false);
                delete.setEnabled(true);
                update.setEnabled(true);
                clear.setEnabled(true);
            }
        });




//        database masih open saat app dibuka
        db= openOrCreateDatabase(dbname, MODE_PRIVATE, null);
        db.execSQL("create table if not exists barang(kode varchar(20) primary key, nama varchar(100), satuan varchar(10), hb varchar(10), hj varchar(10), diskon varchar(10));");
        Cursor c = db.rawQuery("select * from barang",null);

        String kode11[]=new String[c.getCount()];
        String nama11[]=new String[c.getCount()];
        String satuan11[]=new String[c.getCount()];
        String hb11[]=new String[c.getCount()];
        String hj11[]=new String[c.getCount()];
        String diskon11[]=new String[c.getCount()];
        hh = 1;

        if (c.getCount()>0){
            c.moveToFirst();
            kode11[0]=c.getString(c.getColumnIndex("kode"));
            nama11[0]=c.getString(c.getColumnIndex("nama"));
            satuan11[0]=c.getString(c.getColumnIndex("satuan"));
            hb11[0]=c.getString(c.getColumnIndex("hb"));
            hj11[0]=c.getString(c.getColumnIndex("hj"));
            diskon11[0]=c.getString(c.getColumnIndex("diskon"));
            while (c.moveToNext()){
                kode11[hh]=c.getString(c.getColumnIndex("kode"));
                nama11[hh]=c.getString(c.getColumnIndex("nama"));
                satuan11[hh]=c.getString(c.getColumnIndex("satuan"));
                hb11[hh]=c.getString(c.getColumnIndex("hb"));
                hj11[hh]=c.getString(c.getColumnIndex("hj"));
                diskon11[hh]=c.getString(c.getColumnIndex("diskon"));
                hh = hh+1;
            }
            db.close();
            MainActivity2 yyy = new MainActivity2(getApplicationContext(),kode11,nama11,satuan11,hb11,hj11,diskon11);
            jisi.setAdapter(yyy);

        }else{
            db.close();
            MainActivity2 yyy = new MainActivity2(getApplicationContext(),kode11,nama11,satuan11,hb11,hj11,diskon11);
            jisi.setAdapter(yyy);


        }

        save.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        clear.setOnClickListener(this);

        save.setEnabled(true);
        delete.setEnabled(false);
        update.setEnabled(false);
        clear.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        if (v == save){
            db= openOrCreateDatabase(dbname, MODE_PRIVATE, null);

            kk = kode.getText().toString();
            nn = nama.getText().toString();
            ss = stn.getText().toString();
            hhb = hb.getText().toString();
            hhj = hj.getText().toString();
            dd = diskon.getText().toString();
            Cursor d = db.rawQuery("select * from barang where kode='"+kk+"';",null);
            if (d.getCount()>0){
                Toast.makeText(getApplicationContext(),"Kode Sudah Terdaftar", Toast.LENGTH_LONG).show();
            }else if (kk.length() == 0){
                Toast.makeText(getApplicationContext(),"Kode Harus diisi", Toast.LENGTH_LONG).show();
            }else{
                db.execSQL("insert into barang values('"+kk+"','"+nn+"','"+ss+"','"+hhb+"','"+hhj+"','"+dd+"');");
                Cursor c = db.rawQuery("select * from barang",null);
                String kode11[]=new String[c.getCount()];
                String nama11[]=new String[c.getCount()];
                String satuan11[]=new String[c.getCount()];
                String hb11[]=new String[c.getCount()];
                String hj11[]=new String[c.getCount()];
                String diskon11[]=new String[c.getCount()];
                hh = 1;
                c.moveToFirst();
                kode11[0]=c.getString(c.getColumnIndex("kode"));
                nama11[0]=c.getString(c.getColumnIndex("nama"));
                satuan11[0]=c.getString(c.getColumnIndex("satuan"));
                hb11[0]=c.getString(c.getColumnIndex("hb"));
                hj11[0]=c.getString(c.getColumnIndex("hj"));
                diskon11[0]=c.getString(c.getColumnIndex("diskon"));
                while (c.moveToNext()){
                    kode11[hh]=c.getString(c.getColumnIndex("kode"));
                    nama11[hh]=c.getString(c.getColumnIndex("nama"));
                    satuan11[hh]=c.getString(c.getColumnIndex("satuan"));
                    hb11[hh]=c.getString(c.getColumnIndex("hb"));
                    hj11[hh]=c.getString(c.getColumnIndex("hj"));
                    diskon11[hh]=c.getString(c.getColumnIndex("diskon"));
                    hh = hh+1;
                }
                db.close();
                MainActivity2 yyy = new MainActivity2(getApplicationContext(),kode11,nama11,satuan11,hb11,hj11,diskon11);
                jisi.setAdapter(yyy);
                Toast.makeText(getApplicationContext(),"Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();

                kode.setText(null);
                nama.setText(null);
                stn.setText(null);
                hb.setText(null);
                hj.setText(null);
                diskon.setText(null);

                save.setEnabled(true);
                delete.setEnabled(false);
                update.setEnabled(false);
                clear.setEnabled(false);
            }


        }else if (v == delete){
            db= openOrCreateDatabase(dbname, MODE_PRIVATE, null);
            kk = kode.getText().toString();
            nn = nama.getText().toString();
            ss = stn.getText().toString();
            hhb = hb.getText().toString();
            hhj = hj.getText().toString();
            dd = diskon.getText().toString();
            db.execSQL("delete from barang where kode='"+kk+"';");
            Cursor c = db.rawQuery("select * from barang",null);
            String kode11[]=new String[c.getCount()];
            String nama11[]=new String[c.getCount()];
            String satuan11[]=new String[c.getCount()];
            String hb11[]=new String[c.getCount()];
            String hj11[]=new String[c.getCount()];
            String diskon11[]=new String[c.getCount()];
            hh = 1;

            if (c.getCount()>0){
                c.moveToFirst();
                kode11[0]=c.getString(c.getColumnIndex("kode"));
                nama11[0]=c.getString(c.getColumnIndex("nama"));
                satuan11[0]=c.getString(c.getColumnIndex("satuan"));
                hb11[0]=c.getString(c.getColumnIndex("hb"));
                hj11[0]=c.getString(c.getColumnIndex("hj"));
                diskon11[0]=c.getString(c.getColumnIndex("diskon"));
                while (c.moveToNext()){
                    kode11[hh]=c.getString(c.getColumnIndex("kode"));
                    nama11[hh]=c.getString(c.getColumnIndex("nama"));
                    satuan11[hh]=c.getString(c.getColumnIndex("satuan"));
                    hb11[hh]=c.getString(c.getColumnIndex("hb"));
                    hj11[hh]=c.getString(c.getColumnIndex("hj"));
                    diskon11[hh]=c.getString(c.getColumnIndex("diskon"));
                    hh = hh+1;
                }

                db.close();
                MainActivity2 yyy = new MainActivity2(getApplicationContext(),kode11,nama11,satuan11,hb11,hj11,diskon11);
                jisi.setAdapter(yyy);
                Toast.makeText(getApplicationContext(),"Data Terhapus", Toast.LENGTH_LONG).show();

                kode.setText(null);
                nama.setText(null);
                stn.setText(null);
                hb.setText(null);
                hj.setText(null);
                diskon.setText(null);

                save.setEnabled(true);
                delete.setEnabled(false);
                update.setEnabled(false);
                clear.setEnabled(false);
            }else{
                db.close();
                MainActivity2 yyy = new MainActivity2(getApplicationContext(),kode11,nama11,satuan11,hb11,hj11,diskon11);
                jisi.setAdapter(yyy);
            }

        }else if (v == update){
            db= openOrCreateDatabase(dbname, MODE_PRIVATE, null);
            kk = kode.getText().toString();
            nn = nama.getText().toString();
            ss = stn.getText().toString();
            hhb = hb.getText().toString();
            hhj = hj.getText().toString();
            dd = diskon.getText().toString();
            db.execSQL("update barang set nama = '"+nn+"', satuan = '"+ss+"', hb = '"+hhb+"' , hj = '"+hhj+"', diskon = '"+dd+"' where kode='"+kk+"';");
            Cursor c = db.rawQuery("select * from barang",null);
            String kode11[]=new String[c.getCount()];
            String nama11[]=new String[c.getCount()];
            String satuan11[]=new String[c.getCount()];
            String hb11[]=new String[c.getCount()];
            String hj11[]=new String[c.getCount()];
            String diskon11[]=new String[c.getCount()];
            hh = 1;
            c.moveToFirst();
            kode11[0]=c.getString(c.getColumnIndex("kode"));
            nama11[0]=c.getString(c.getColumnIndex("nama"));
            satuan11[0]=c.getString(c.getColumnIndex("satuan"));
            hb11[0]=c.getString(c.getColumnIndex("hb"));
            hj11[0]=c.getString(c.getColumnIndex("hj"));
            diskon11[0]=c.getString(c.getColumnIndex("diskon"));
            while (c.moveToNext()){
                kode11[hh]=c.getString(c.getColumnIndex("kode"));
                nama11[hh]=c.getString(c.getColumnIndex("nama"));
                satuan11[hh]=c.getString(c.getColumnIndex("satuan"));
                hb11[hh]=c.getString(c.getColumnIndex("hb"));
                hj11[hh]=c.getString(c.getColumnIndex("hj"));
                diskon11[hh]=c.getString(c.getColumnIndex("diskon"));
                hh = hh+1;
            }

            db.close();
            MainActivity2 yyy = new MainActivity2(getApplicationContext(),kode11,nama11,satuan11,hb11,hj11,diskon11);
            jisi.setAdapter(yyy);
            Toast.makeText(getApplicationContext(),"Data terupdate", Toast.LENGTH_LONG).show();
        }else{
            kode.setText(null);
            nama.setText(null);
            stn.setText(null);
            hb.setText(null);
            hj.setText(null);
            diskon.setText(null);

            save.setEnabled(true);
            delete.setEnabled(false);
            update.setEnabled(false);
            clear.setEnabled(false);
        }
    }
}
