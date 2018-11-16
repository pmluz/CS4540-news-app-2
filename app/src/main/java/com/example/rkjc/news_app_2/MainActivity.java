package com.example.rkjc.news_app_2;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    private String results;
    private ArrayList<NewsItem> itemList;
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;

    class NewsQueryTask extends  AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void...voids) {
            try {
                results = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildURL());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();

        // Adding news in the itemList
        itemList.add(new NewsItem(
                "Monopoly for Millennials Should Not Pass Go: 5 Things in Pop Culture Today",
                "The classic Monopoly board. In the Monopoly for Millennials edition, Rich Uncle Pennybags is shown wearing mirrored shades and taking a selfie.",
                "https://www.nytimes.com/2018/11/15/arts/monopoly-for-millennials-dumbo-trailer.html",
                "Nov. 15, 2018",
                "Eleanor Stanford",
                "https://static01.nyt.com/images/2018/11/16/arts/16cheatsheet1/merlin_65722625_fcac75fd-33ba-4042-a559-6c3c50af5bda-superJumbo.jpg?quality=90&auto=webp"));

        itemList.add(new NewsItem(
                "Death toll in Northern California wildfire climbs to 48, as grim search continues",
                "The so-called Camp Fire that broke out in Northern California last week is the deadliest in state history.",
                "https://www.nbcnews.com/news/us-news/death-toll-northern-california-wildfire-climbs-48-grim-search-continues-n935656",
                "Nov. 13, 2018",
                "Phil Helsel and Steve Patterson",
                "https://media1.s-nbcnews.com/j/newscms/2018_46/2645456/181113-camp-fire-ac-1007p_a694fc6c92ed2ddcd65527feac79865c.fit-2000w.jpg"));

        itemList.add(new NewsItem(
                "Henley Index: Japanese passport now world's most powerful",
                "World's most powerful passports: Global citizenship and residence advisory firm Henley & Partners has released its quarterly report on the world's most desirable passports. Citizens of Hungary (such as this chap), Slovenia and Malaysia can enjoy seamless travel to 180 destinations.",
                "https://www.cnn.com/travel/article/most-powerful-passport-henley-index-2018/index.html",
                "Oct. 9, 2018",
                "Maureen O'Hare",
                "https://dynaimage.cdn.cnn.com/cnn/q_auto,w_900,c_fill,g_auto,h_506,ar_16:9/http%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F150929124247-travel-moments-passport.jpg"));



        recyclerView = findViewById(R.id.news_recyclerview);
        newsAdapter = new NewsAdapter(itemList, this);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsQueryTask task = new NewsQueryTask();
        task.execute();

    }

    protected void onStart() {
        super.onStart();
    }

    private void searchQuery() {
        URL searchURL = NetworkUtils.buildURL();
        new NewsQueryTask().execute();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.get_news:
                itemList = JsonUtils.parseNews(results);
                newsAdapter.itemList = itemList;
                newsAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
