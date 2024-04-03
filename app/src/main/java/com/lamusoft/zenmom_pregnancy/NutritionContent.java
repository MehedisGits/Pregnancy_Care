package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

public class NutritionContent extends AppCompatActivity {

    // Static variable to hold the title
    public static String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(NutritionContent.this, R.color.white));

        // Retrieve the layout resource ID from the intent
        int layout = getIntent().getIntExtra("layout", 0);

        // Set the content view based on the layout resource ID
        setContentView(layout);

        //Load Images
        ImageLoadingStart();

        // Set the title
        TextView heading = findViewById(R.id.toolHeading);
        heading.setText(title);

        // Back button click listener
        ImageView back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            /**
             * @noinspection deprecation
             */
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Display the pop-up on disclaimer button click
        LinearLayout layoutV = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(v -> PopUp.createPopUp(getApplicationContext(), layoutV));
    }

    private void ImageLoadingStart() {
        loadImage(findViewById(R.id.vagetableImage), "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/vegetables-fresh-bio-vegetable-basket_127032-1802.jpg?raw=true");
        loadImage(findViewById(R.id.snackIdeaImage), "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/snack_ideas.jpg?raw=true");
        loadImage(findViewById(R.id.eatingImage), "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/eating.jpg?raw=true");
        loadImage(findViewById(R.id.foodstoavoidImage), "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/foods_to_avoid.png?raw=true");
        loadImage(findViewById(R.id.beautyImage), "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/beauty_care.jpg?raw=true");
    }

    private void loadImage(ImageView imageView, String url) {
        if (imageView != null) {
            Glide.with(this)
                    .load(url)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.internet_error)
                    .into(imageView);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clear the static title variable to avoid memory leaks
        title = null;
    }
}
