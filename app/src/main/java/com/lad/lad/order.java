package com.lad.lad;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import java.io.FileNotFoundException;
import java.net.URL;

public class order extends AppCompatActivity {

    Bitmap thumbnail;
    File pic1,pic2;
    EditText address, subject, emailtext;
    protected static final int CAMERA_PIC_REQUEST = 0;
    int count=1;


   /* ImageView Image;
    Bitmap bm;
    CameraPhoto cameraPhoto;
    GalleryPhoto galleryPhoto;
    String photoPath;
    String sResponse = null;
    URL url;

    final int GALLERY_REQUEST = 25320; */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView Image = (ImageView) findViewById(R.id.imageView2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final EditText name = (EditText) findViewById(R.id.partyname);
        address = (EditText) findViewById(R.id.city);
        Button attach = (Button) findViewById(R.id.ord);


        attach.setOnClickListener(new View.OnClickListener() {

                //startActivityForResult(galleryPhoto.openGalleryIntent(), GALLERY_REQUEST);

                @Override
                public void onClick(View arg0){
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });


       /* galleryPhoto = new GalleryPhoto(getApplicationContext());*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"lunkarbangalore@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Order");
                i.putExtra(Intent.EXTRA_TEXT,"Order by " +name.getText().toString()+" "+address.getText().toString()+" Page "+count);
                count++;
                //Log.d("URI@!@#!#!@##!", Uri.fromFile(pic).toString() + "   " + pic.exists());
                i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(pic1));


                i.setType("image/png");
                startActivity(Intent.createChooser(i,"Sending your order"));

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            thumbnail = (Bitmap) data.getExtras().get("data");
            ImageView image = (ImageView) findViewById(R.id.imageView2);
            image.setImageBitmap(thumbnail);


            try {
                File root = Environment.getExternalStorageDirectory();
                if (root.canWrite()){
                    pic1 = new File(root, "pic.png");
                    FileOutputStream out = new FileOutputStream(pic1);
                    thumbnail.compress(Bitmap.CompressFormat.PNG, 100, out);
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                Log.e("BROKEN", "Could not write file " + e.getMessage());
            }

        }
    }







}