package com.example.onlinepostoffice.mine;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlinepostoffice.DbHelper;
import com.example.onlinepostoffice.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MineFragment extends Fragment {

    private MineViewModel mViewModel;

    TextView txt_user_name, txt_user_tel, txt_user_integrate, txt_user_bank_card;
    Button btn_edit_data;
    ImageView iv_head;

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LayoutInflater lf = requireActivity().getLayoutInflater();
        View view = lf.inflate(R.layout.mine_fragment, container, false);

        txt_user_name = (TextView) view.findViewById(R.id.txt_user_name);
        txt_user_tel = (TextView) view.findViewById(R.id.txt_user_tel);
        txt_user_integrate = (TextView) view.findViewById(R.id.txt_user_integration);
        txt_user_bank_card = (TextView) view.findViewById(R.id.txt_bank_cark);
        btn_edit_data = (Button) view.findViewById(R.id.btn_edit_data);
        iv_head = (ImageView) view.findViewById(R.id.iv_head);

//        String id = null;
////        DbHelper dbHelper = new DbHelper(MineFragment.this, "db_post", null, 1);
////        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        DbHelper dbHelper = new DbHelper(MineFragment.this, "db_post", 1);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("select * from tb_user where id=?", new String[]{id});
//        cursor.moveToNext();
//        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
//        @SuppressLint("Range") String tel = cursor.getString(cursor.getColumnIndex("tel"));
//        @SuppressLint("Range") String integral = cursor.getString(cursor.getColumnIndex("integral"));
//
//        txt_user_name.setText(name);
//        txt_user_tel.setText(tel);
//        txt_user_integrate.setText(integral);

        final String path = "http://www.mengnalidou.cn/img/head_portrait.jpg";
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    int code = conn.getResponseCode();
                    Log.d("code", "run:"+code);
                    if (code == 200) {
                        InputStream in = conn.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(in);
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = bitmap;
                        handler.sendMessage(msg);
                    }
                    else {
                        Message msg = new Message();
                        msg.what = 2;
                        handler.sendMessage(msg);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.d("catch", "run:");
                    e.printStackTrace();
                    Message msg = new Message();
                    msg.what = 2;
                    handler.sendMessage(msg);
                }
            }
        };

        return view;
    }

    private Handler handler = new Handler() {
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.d("msg.what", "run:" + msg.what);
            if (msg.what == 1) {
                Bitmap bitmap = (Bitmap) msg.obj;
                iv_head.setImageBitmap(bitmap);
            }
            else if (msg.what == 2) {
//                Toast.makeText(MineFragment.this, "显示图片错误", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MineViewModel.class);
        // TODO: Use the ViewModel
    }

}