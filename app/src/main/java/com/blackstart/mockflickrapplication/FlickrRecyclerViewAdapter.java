package com.blackstart.mockflickrapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrRecyclerViewAdapter.FlickrImageViewHolder> {
    private static final String TAG = "FlickrRecyclerViewAdapt";
    private List<Photo> mPhotosList;
    private Context mContext;

    public FlickrRecyclerViewAdapter(Context context, List<Photo> photosList) {
        mContext = context;
        mPhotosList = photosList;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called by the layout manager when it needs a new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse, parent, false);
        return new FlickrImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder holder, int position) {
        // Called by the layout manager when it wants new data in an existing row

        if(mPhotosList == null || mPhotosList.size() == 0 ){
            holder.thumbnail.setImageResource(R.drawable.outline_image_black_48dp);
            holder.title.setText(R.string.search_no_matches_text);
        } else{
            Photo photoItem = mPhotosList.get(position);
            Log.d(TAG, "onBindViewHolder: " + photoItem.getTitle() + " --> " + position);
            Picasso.get().load(photoItem.getImage())
                    .error(R.drawable.outline_image_black_48dp)
                    .placeholder(R.drawable.outline_image_black_48dp)
                    .into(holder.thumbnail);

            holder.title.setText(photoItem.getTitle());
        }


    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((mPhotosList != null) && (mPhotosList.size() !=0) ? mPhotosList.size() : 1);
    }

    void loadNewData(List<Photo> newPhotos) {
        mPhotosList = newPhotos;
        notifyDataSetChanged();
    }

    public Photo getPhoto(int position) {
        return ((mPhotosList != null) && (mPhotosList.size() !=0) ? mPhotosList.get(position) : null);
    }

    static class FlickrImageViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "FlickrImageViewHolder";
        ImageView thumbnail = null;
        TextView title = null;

        public FlickrImageViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "FlickrImageViewHolder: starts");
            this.thumbnail = (ImageView) itemView.findViewById(R.id.thumbNailView);
            this.title = (TextView) itemView.findViewById(R.id.nailTitle);
        }
    }
}