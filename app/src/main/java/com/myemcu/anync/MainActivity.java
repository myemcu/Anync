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
        new Job2Task().execute(3);
    }

    public void btn_Go3(View v) {
        new Job3Task().execute(6);
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
            info.setText("DoneGo1");
        }
    }

    class Job2Task extends AsyncTask<Integer, Void, Void> {

        @Override
        protected Void doInBackground(Integer... params) {

            try {
                Thread.sleep(params[0]*1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            TextView info = (TextView) findViewById(R.id.txt);
            info.setText("DoneGo2");
        }
    }

    class Job3Task extends AsyncTask <Integer, Integer, Void> {

        private TextView info;

        public Job3Task() { // 构造方法
            info = (TextView) findViewById(R.id.txt);
        }

        @Override
        protected Void doInBackground(Integer... params) {

            for (int i=0; i<params[0]; i++) {
                publishProgress(i); // 呼叫第111行的onProgressUpdate()秒更方法
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            info.setText("DoneGo3");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            info.setText(String.valueOf(values[0]));
        }
    }
}
