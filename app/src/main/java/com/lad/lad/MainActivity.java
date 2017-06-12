package com.lad.lad;

import android.app.Activity;
import android.app.Application;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    ImageButton sai,replay,fiem,hella,hero,halonix,ide;
    ProgressDialog mProgressDialog;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sai = (ImageButton) findViewById(R.id.sai);
        sai.setOnClickListener(this);

        replay = (ImageButton) findViewById(R.id.replay);
        replay.setOnClickListener(this);

        fiem = (ImageButton) findViewById(R.id.fiem);
        fiem.setOnClickListener(this);

        hella = (ImageButton) findViewById(R.id.hella);
        hella.setOnClickListener(this);

        hero = (ImageButton) findViewById(R.id.rockman);
        hero.setOnClickListener(this);



        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        halonix = (ImageButton) findViewById(R.id.halonix);
        halonix.setOnClickListener(this);

        ide = (ImageButton) findViewById(R.id.ide);
        ide.setOnClickListener(this);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.group) {
            // Handle the camera action
            Intent i = new Intent(MainActivity.this, Group.class);
            startActivity(i);


        } else if (id == R.id.call) {


            Intent i = new Intent(MainActivity.this, ContactUs.class);
            startActivity(i);


        } else if (id == R.id.team) {


            Intent i = new Intent(MainActivity.this, Team.class);
            startActivity(i);


        } else if (id == R.id.about) {


            Intent i = new Intent(MainActivity.this, AboutUs.class);
            startActivity(i);

        }
        else if (id == R.id.gallery) {


            Intent i = new Intent(MainActivity.this, Gallery.class);
            startActivity(i);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Intent ni = new Intent(MainActivity.this, order.class);
                startActivity(ni);
                break;

            case R.id.sai:
              /*  File fileBrochure = new File(Environment.getExternalStorageDirectory() + "/" + "sai.pdf");
                if (!fileBrochure.exists())
                {
                    CopyAssetsbrochure();
                }
*/
                /** PDF reader code */
               /* File file = new File(Environment.getExternalStorageDirectory() + "/" + "sai.pdf");

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.fromFile(file),"application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try
                {
                    getApplicationContext().startActivity(intent);
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(MainActivity.this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
                }*/

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0BxBNR1HIZB7CVDg0M05QN05NMzQ"));
                startActivity(browserIntent);
                break;

            case R.id.replay:

                File fileBrochure1 = new File(Environment.getExternalStorageDirectory() + "/" + "re.pdf");
                if (!fileBrochure1.exists())
                {
                    CopyAssetsbrochure1();
                }

                /** PDF reader code */
            File file1 = new File(Environment.getExternalStorageDirectory() + "/" + "re.pdf");

                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setDataAndType(Uri.fromFile(file1),"application/pdf");
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try
                {
                    getApplicationContext().startActivity(intent1);
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(MainActivity.this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
                }
                break;




            case R.id.rockman:
              /*  File fileBrochure2 = new File(Environment.getExternalStorageDirectory() + "/" + "hero.pdf");
                if (!fileBrochure2.exists())
                {
                    CopyAssetsbrochure2();
                }

                /** PDF reader code */
                /*File file2 = new File(Environment.getExternalStorageDirectory() + "/" + "hero.pdf");

                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setDataAndType(Uri.fromFile(file2),"application/pdf");
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try
                {
                    getApplicationContext().startActivity(intent2);
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(MainActivity.this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.fiem:
              /*  File fileBrochure3 = new File(Environment.getExternalStorageDirectory() + "/" + "fie.pdf");
                if (!fileBrochure3.exists())
                {
                    CopyAssetsbrochure3();
                }

                /** PDF reader code */
               /* File file3 = new File(Environment.getExternalStorageDirectory() + "/" + "fie.pdf");

                Intent intent3 = new Intent(Intent.ACTION_VIEW);
                intent3.setDataAndType(Uri.fromFile(file3),"application/pdf");
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try
                {
                    getApplicationContext().startActivity(intent3);
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(MainActivity.this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
                }*/

                Intent browserIntent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0BxBNR1HIZB7CM2p1OFZqTWJNQ2s"));
                startActivity(browserIntent4);
                break;

            case R.id.hella:
             /*   File fileBrochure4 = new File(Environment.getExternalStorageDirectory() + "/" + "Compact_Horn.pdf");
                if (!fileBrochure4.exists())
                {
                    CopyAssetsbrochure4();
                }

                /** PDF reader code */
             /*   File file4 = new File(Environment.getExternalStorageDirectory() + "/" + "Compact_Horn.pdf");

                Intent intent4 = new Intent(Intent.ACTION_VIEW);
                intent4.setDataAndType(Uri.fromFile(file4),"application/pdf");
                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try
                {
                    getApplicationContext().startActivity(intent4);
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(MainActivity.this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
                }
                break;*/
                Intent browserIntent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0BxBNR1HIZB7CX1RrNk8xTGFsOHc"));
                startActivity(browserIntent5);
                break;

            case R.id.halonix:
                Intent browserIntent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0BxBNR1HIZB7COWVGOFBTNkhNNE0"));
                startActivity(browserIntent6);
                break;

            case R.id.fiem:
                Intent browserIntent7 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0BxBNR1HIZB7CVlhlbG9oZnlacHM"));
                startActivity(browserIntent7);
                break;


            case R.id.ide:
                Intent browserIntent8 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=0BxBNR1HIZB7CVlhlbG9oZnlacHM"));
                startActivity(browserIntent8);
                break;





        }
    }

//method to write the PDFs file to sd card



    private void CopyAssetsbrochure1() {
        AssetManager assetManager = getAssets();
        String[] files = null;
        try
        {
            files = assetManager.list("");
        }
        catch (IOException e)
        {
            Log.e("tag", e.getMessage());
        }
        for(int i=0; i<files.length; i++)
        {
            String fStr = files[i];
            if(fStr.equalsIgnoreCase("re.pdf"))
            {
                InputStream in = null;
                OutputStream out = null;
                try
                {
                    in = assetManager.open(files[i]);
                    out = new FileOutputStream(Environment.getExternalStorageDirectory() + "/" + files[i]);
                    copyFile(in, out);
                    in.close();
                    in = null;
                    out.flush();
                    out.close();
                    out = null;
                    break;
                }
                catch(Exception e)
                {
                    Log.e("tag", e.getMessage());
                }
            }
        }
    }



    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }



        }





