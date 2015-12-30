package com.example.user.findcar;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by User on 12/30/2015.
 */
public class ImagePickActivity extends Activity {

    ImageView imvShowPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagepick);

        imvShowPhoto=(ImageView)findViewById(R.id.iv_photo);

        File imgFile = new  File("/sdcard/Pictures/picFolder/1.jpg");

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());



            imvShowPhoto.setImageBitmap(myBitmap);

        }

        //imvShowPhoto.setImageResource();


    }
}
