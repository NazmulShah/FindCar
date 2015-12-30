package com.example.user.findcar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by User on 12/30/2015.
 */
public class ParkCarActivity extends Activity{

    Button tagposition,takephoto;
    TextView textpark;

    int TAKE_PHOTO_CODE = 0;
    public static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkcar);
        textpark=(TextView)findViewById(R.id.tv_parkcar);

        tagposition=(Button)findViewById(R.id.bt_tagposition);
        takephoto=(Button)findViewById(R.id.bt_tagphoto);


        takephoto();


    }
  /**********Take a Photo************/
    private void takephoto() {

        //here,we are making a folder named picFolder to store pics taken by the camera using this application
        final String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/picFolder/";
        File newdir = new File(dir);
        newdir.mkdirs();

        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //count ++;
                String file = dir + count +".jpg";
                File newfile = new File(file);
                try{
                    newfile.createNewFile();
                }catch (Exception e){
                    e.printStackTrace();
                }

                Uri outputFileUri = Uri.fromFile(newfile);
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,outputFileUri);
                startActivityForResult(cameraIntent,TAKE_PHOTO_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== TAKE_PHOTO_CODE && resultCode == RESULT_OK){
            Log.e("CameraDemo","Pic saved");
            Toast.makeText(getApplicationContext(),"Successfully Taken",Toast.LENGTH_LONG).show();
        }
    }
}
