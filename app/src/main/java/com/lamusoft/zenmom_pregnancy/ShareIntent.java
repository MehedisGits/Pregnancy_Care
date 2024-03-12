package com.lamusoft.zenmom_pregnancy;

import android.content.Context;
import android.content.Intent;

public class ShareIntent {
    public static void shareApp(Context context) {
        String message = context.getString(R.string.shareMessage);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);

        shareIntent.setType("text/plain");

        String url = "https://play.google.com/store/apps/details?id=com.lamusoft.zenmom_pregnancy";

        shareIntent.putExtra(Intent.EXTRA_TEXT, message + url);

        context.startActivity(Intent.createChooser(shareIntent, "Share Via"));
    }
}
