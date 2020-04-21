package com.example.kahanikar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    private View v = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        textSelect t = new textSelect();
        t.onClick(v);
    }
    public CharSequence getTitlePage(int position){
        switch (position){
            case 0:
                return getResources().getText(R.string.file);
            case 1:
                return getResources().getText(R.string.font);
            case 2:
                return getResources().getText(R.string.notebook);
        }
        return null;
    }
    public static class MyEditView extends android.support.v7.widget.AppCompatEditText{
        public MyEditView(Context context , AttributeSet attrs , int defStyle){
            super(context ,attrs , defStyle);
            init();
        }
        public MyEditView(Context context , AttributeSet attrs){
            super(context , attrs);
            init();
        }
        public MyEditView(Context context){
            super(context);
            init();
        }


        private void init(){
            if(!isInEditMode()){
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"font.ttf");
                setTypeface(tf);

            }
        }
    }
    public  class textSelect implements OnClickListener {
        EditText editText = findViewById(R.id.edit_text);
        @Override
        public void onClick(View v) {
            editText.setSelection(editText.getText().length());
            Uri uri =  Uri.parse("https://www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW  , uri);
            startActivity(intent);
        }

        }
    }


