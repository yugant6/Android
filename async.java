package edu.kiet.www.exampleasync;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button b1;
    ImageView i;
    String url = "https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Flag_of_India.svg/1024px-Flag_of_India.svg.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = findViewById(R.id.imageView2);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncExample ast = new AsyncExample();
                ast.execute(url);
            }
        });
    }
    public class AsyncExample extends AsyncTask<String, Void, Bitmap> {

        protected void onPreExecute() {

            super.onPreExecute();
            Toast.makeText(MainActivity.this, "downloading image", Toast.LENGTH_LONG).show();

        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap b1 =null;
            try{
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                b1 = BitmapFactory.decodeStream(inputStream);
            }catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
            return b1;
        }
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap!=null) {
                i.setImageBitmap(bitmap);
                Toast.makeText(MainActivity.this, "downloading completed", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(MainActivity.this, "image not downloading", Toast.LENGTH_LONG).show();
            }


        }
    }
}
