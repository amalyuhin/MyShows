package com.amalyuhin.myshows.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amalyuhin.myshows.R;
import com.amalyuhin.myshows.api.model.Episode;
import com.amalyuhin.myshows.api.model.Show;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by amalyuhin on 08.12.2014.
 */
public class EpisodesRecyclerViewAdapter extends RecyclerView.Adapter<EpisodesRecyclerViewAdapter.ViewHolder> {

    private List<Episode> episodes;

    public final ImageLoader imageLoader = ImageLoader.getInstance();
    private DisplayImageOptions imageOptions;

    public EpisodesRecyclerViewAdapter(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.show_item_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Episode episode = episodes.get(i);
        Show show = episode.getShow();

        imageLoader.displayImage(show.getImageUrl(), viewHolder.showCover, imageOptions);
        viewHolder.showTitle.setText(show.getTitleString());
        viewHolder.episodeTitle.setText(episode.getTitle());
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView showCover;
        private TextView showTitle;
        private TextView episodeTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            showCover = (ImageView) itemView.findViewById(R.id.show_cover);
            showTitle = (TextView) itemView.findViewById(R.id.show_title);
            episodeTitle = (TextView) itemView.findViewById(R.id.episode_title);
        }
    }
}
