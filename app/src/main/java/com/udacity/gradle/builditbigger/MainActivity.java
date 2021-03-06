package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.izzy.displayjokeslibrary.JokesActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.loading_indicator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getJoke(View view) {
        EndpointsAsyncTask.getInstance(new OnRetrieveJokeListener() {
            @Override
            public void onRetrieveJokeStart() {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onRetrieveJokeFinish(@Nullable String result) {
                progressBar.setVisibility(View.GONE);

                if (TextUtils.isEmpty(result)) {
                    Toast.makeText(MainActivity.this, R.string.your_error_string, Toast.LENGTH_SHORT).show();
                    return;
                }
                launchJokeActivity(result);

            }
        });

    }


    private void launchJokeActivity(String result) {

    final Intent intent = new Intent(MainActivity.this, JokesActivity.class);
        intent.putExtra(JokesActivity.JOKE_KEY, result);
        startActivity(intent);
    }


}
