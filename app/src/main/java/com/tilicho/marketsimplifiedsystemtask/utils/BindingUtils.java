package com.tilicho.marketsimplifiedsystemtask.utils;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tilicho.marketsimplifiedsystemtask.R;

import static android.content.ContentValues.TAG;

public final class BindingUtils {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        try{
            /*Glide.with(context).load(url).placeholder(R.mipmap.splash_image).listener(new RequestListener() {
                @Override
                public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
                    // Log the GlideException here (locally or with a remote logging framework):
                    Log.e(TAG, "Load failed", e);

                    // You can also log the individual causes:
                    for (Throwable t : e.getSuppressed()) {
                        Log.e(TAG, "Caused by", t);
                    }
                    // Or, to log all root causes locally, you can use the built in helper method:

                    return false;
                }

                @Override
                public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache, boolean isFirstResource) {
                    // Log successes here or use DataSource to keep track of cache hits and misses.
                    Log.d(TAG, "sdhbvb");
                    return false; // Allow calling onResourceReady on the Target.
                }

            }).into(imageView);*/
        } catch (Exception e){
            Log.d("Exception", e.toString());
        }
    }

}
