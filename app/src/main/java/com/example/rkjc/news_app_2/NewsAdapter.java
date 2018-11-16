package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tricialuz on 11/9/18.
 */

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder> {
    ArrayList<NewsItem> itemList;
    Context mContext;

    public class NewsItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public TextView url;
        public TextView publishedAt;
        public TextView author;
        public TextView urlToImage;

        public NewsItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            url = itemView.findViewById(R.id.url);
            publishedAt = itemView.findViewById(R.id.publishedAt);
            author = itemView.findViewById(R.id.author);
            urlToImage = itemView.findViewById(R.id.urlToImage);

        }

        void bind(final int newsIndex) {
            title.setText(itemList.get(newsIndex).getTitle());
            description.setText(itemList.get(newsIndex).getDescription());
            url.setText(itemList.get(newsIndex).getUrl());
            publishedAt.setText(itemList.get(newsIndex).getpublishedAt());
            author.setText(itemList.get(newsIndex).getAuthor());
            urlToImage.setText(itemList.get(newsIndex).getUrlToImage());

            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url.getText().toString()));
                    mContext.startActivity(intent);
                }
            });
        }
    }

    /* Overloaded NewsAdapter Constructor */
    public NewsAdapter(ArrayList<NewsItem> itemList, Context mContext) {
        this.itemList = itemList;
        this.mContext = mContext;
    }

    public NewsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean toParent = false;
        View view = inflater.inflate(R.layout.news_item, parent, toParent);
        NewsItemViewHolder viewHolder = new NewsItemViewHolder(view);

        return viewHolder;
    }

    public void onBindViewHolder(NewsAdapter.NewsItemViewHolder holder, int position) {
        holder.bind(position);
    }

    public int getItemCount() {
        return itemList.size();
    }
}
