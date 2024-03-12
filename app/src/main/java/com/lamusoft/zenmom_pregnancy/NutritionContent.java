package com.lamusoft.zenmom_pregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

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
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Display the pop-up on disclaimer button click
        LinearLayout layoutV = findViewById(R.id.layout);
        ImageView disc = findViewById(R.id.disclaimerBtn);
        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp.createPopUp(getApplicationContext(), layoutV);
            }
        });
    }

    private void ImageLoadingStart() {

        ImageView vagetableImage = findViewById(R.id.vagetableImage);
        String url1 = "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/vegetables-fresh-bio-vegetable-basket_127032-1802.jpg?raw=true";
        loadImage(vagetableImage, url1);

        ImageView snackIdeaImage = findViewById(R.id.snackIdeaImage);
        String url2 = "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/snack_ideas.jpg?raw=true";
        loadImage(snackIdeaImage, url2);

        ImageView eatingImage = findViewById(R.id.eatingImage);
        String url3 = "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/eating.jpg?raw=true";
        loadImage(eatingImage, url3);

        ImageView foodstoavoidImage = findViewById(R.id.foodstoavoidImage);
        String url4 = "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/foods_to_avoid.png?raw=true";
        loadImage(foodstoavoidImage, url4);

        ImageView beautyImage = findViewById(R.id.beautyImage);
        String url5 = "https://github.com/rakibul-islam-mehedi/ZenMom-Image/blob/main/beauty_care.jpg?raw=true";
        loadImage(beautyImage, url5);
    }

    private  void loadImage(ImageView imageV, String url){

        if (imageV !=null ){
            Picasso.get().load(url).resize(480, 360).placeholder(R.drawable.placeholder).error(R.drawable.internet_error).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).networkPolicy(NetworkPolicy.NO_CACHE)
                    .into(imageV);
        } else {
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clear the static title variable to avoid memory leaks
        title = null;
    }
}
