package com.blackstart.mockflickrapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

public class PhotoDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

       activateToolBar(true);

       Intent intent = getIntent();
       Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);

       if(photo != null){
           TextView photoTitle = findViewById(R.id.photoTitle);
           Resources resources = getResources();

           photoTitle.setText(resources.getString(R.string.photo_title_text, photo.getTitle()));

           TextView photoText = findViewById(R.id.photoText);
           photoText.setText(resources.getString(R.string.photo_tags_text, photo.getTags()));


           TextView photoAuthor = findViewById(R.id.photoAuthor);


           ImageView imageContent = findViewById(R.id.photoImage);
           Picasso.get().load(photo.getLink())
                   .error(R.drawable.outline_image_black_48dp)
                   .placeholder(R.drawable.outline_image_black_48dp)
                   .into(imageContent);
       }
    }

}