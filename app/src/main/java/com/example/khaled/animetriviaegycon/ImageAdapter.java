package com.example.khaled.animetriviaegycon;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static com.google.android.gms.internal.zzng.fa;

/**
 * Created by Khaled on 12/8/2016.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    private Integer[] mThumbIds = new Integer[24];

    private String name;
    private String url;

    private DatabaseReference ref= FirebaseDatabase.getInstance().getReference("anime");

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public void setName (String Name){name=Name;}

    public void setUrl(String Url){url=Url;}

    public String getName(){return name;}

    public String getUrl(){ return url;}

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        String loc = Integer.toString(position);

        ref.orderByKey().equalTo(loc).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String animename = dataSnapshot.getChildren().iterator().next().child("0").getValue().toString();
                String animeurl= dataSnapshot.getChildren().iterator().next().child("1").getValue().toString();
                setName(animename);
                setUrl(animeurl);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ref=FirebaseDatabase.getInstance().getReference("anime");

        Log.e("what we got", loc + name + url);

        final ImageView imageView;

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setId(R.id.);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(imageView.isPressed()){
                        imageView.setPressed(false);
                    }
                }
            });

        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext)
                .load(url)
                .into(imageView);

        return imageView;
    }
}



//new DownloadImageTask(imageView).execute("https://firebasestorage.googleapis.com/v0/b/egycontrivia.appspot.com/o/Ao%20Haru%20Ride.jpg?alt=media&token=8a5362f3-66cb-4407-b1ae-ab387c71d4b6");
//new DownloadFile().execute("https://firebasestorage.googleapis.com/v0/b/egycontrivia.appspot.com/o/Ao%20Haru%20Ride.jpg?alt=media&token=8a5362f3-66cb-4407-b1ae-ab387c71d4b6");
// references to our images
    /*private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }*/
/*
    class DownloadFile extends AsyncTask<String,Integer,Long> {
        String strFolderName;

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Long doInBackground(String... aurl) {
            int count;
            try {
                URL url = new URL((String) aurl[0]);
                URLConnection conexion = url.openConnection();
                conexion.connect();
                String targetFileName="Ao Haru Ride"+".jpg";//Change name and subname
                int lenghtOfFile = conexion.getContentLength();
                String PATH = Environment.getExternalStorageDirectory()+ "/"+"images"+"/";
                File folder = new File(PATH);
                if(!folder.exists()){
                    folder.mkdir();//If there is no folder it will be created.
                }
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new FileOutputStream(PATH+targetFileName);
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress ((int)(total*100/lenghtOfFile));
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {}
            return null;
        }
        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
        }
    }
*/

