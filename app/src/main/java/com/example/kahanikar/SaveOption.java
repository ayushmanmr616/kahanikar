package com.example.kahanikar;


import android.content.Context;
import android.media.MediaScannerConnection;
import android.support.design.widget.TabItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import android.support.design.widget.TabItem;


public class SaveOption extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onselect1(View view){
            TabItem tabItem = findViewById(R.id.tabFiles);
        try{
            File testFile = new File(this.getExternalFilesDir(null) , "TestFile.txt");
            if(!testFile.exists()){
                testFile.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(testFile , true));
                writer.write("this is a text file");
                writer.close();
                MediaScannerConnection.scanFile(this , new String[]{testFile.toString()},null , null);

            }

        }
        catch (IOException e){
            Log.e("ReadWriteFile" , "Unable to write to the testFile.txt file.");

        }
        Log.v("ReadWriteFile" , "Write to the testFile.txt file.");
    }
    public void onReadFromFileButtonClick(View view){
        String textToDisplay = "";
        TextView FileContentTextView = findViewById(R.id.tv_file_content);
        File testFile = new File(this.getExternalFilesDir(null) , "TestFile.txt");
        if(testFile == null){
            FileContentTextView.setText(textToDisplay);
            return;
        }
        StringBuilder stringBuilder  = new StringBuilder();
        BufferedReader reader = null;
        try{
            new BufferedReader(new FileReader(testFile));
            String line;
            while((line = reader.readLine()) != null){
                textToDisplay += line.toString();
                textToDisplay += '\n';

            }
            reader.close();
        }
        catch (Exception e){
            Log.e("ReadWriteFile" , "Unable to write testFile.txt file");
        }
        Log.v("ReadWriteFile" , "Read from testFile.txt file");

        FileContentTextView.setText(textToDisplay);
    }
}
