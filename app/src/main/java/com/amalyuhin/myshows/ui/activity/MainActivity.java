package com.amalyuhin.myshows.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.amalyuhin.myshows.R;
import com.amalyuhin.myshows.api.model.Episode;
import com.amalyuhin.myshows.api.model.Show;
import com.amalyuhin.myshows.ui.EpisodesRecyclerViewAdapter;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private EpisodesRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        recyclerView = (RecyclerView) findViewById(R.id.episodes_list);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Show show = new Show();
        show.setTitle("Supernatural");
        show.setRuTitle("Сверхъестественное");
        show.setImageUrl("http://images.tvrage.com/shows/6/5410.jpg");

        Episode e1 = new Episode();
        e1.setTitle("Episode 1");
        e1.setShow(show);
        show.addEpisode(e1);

        Episode e2 = new Episode();
        e2.setTitle("Episode 2");
        e2.setShow(show);
        show.addEpisode(e2);

        adapter = new EpisodesRecyclerViewAdapter(show.getEpisodes());
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
