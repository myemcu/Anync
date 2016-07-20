package com.myemcu.anync;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 5s后，显示Done
    public void btn_Go1(View v) {
        new Job1Task().execute();
    }

    public void btn_Go2(View v) {

    }

    public void btn_Go3(View v) {

    }

    class Job1Task extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(5000); // 5s延时
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        // 上面5s后要执行的事
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            TextView info = (TextView) findViewById(R.id.txt);
            info.setText("Done");
        }
    }
}
