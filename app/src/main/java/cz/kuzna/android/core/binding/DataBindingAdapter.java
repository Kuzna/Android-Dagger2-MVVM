package cz.kuzna.android.core.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * @author Radek Kuznik
 */

public class DataBindingAdapter {

    @BindingAdapter("android:src")
    public static void setImageUri(ImageView view, String imageUri) {
        if (imageUri == null) {
            view.setImageURI(null);
        } else {
            view.setImageURI(Uri.parse(imageUri));
        }
    }

    @BindingAdapter("android:src")
    public static void setImageUri(ImageView view, Uri imageUri) {
        view.setImageURI(imageUri);
    }

    @BindingAdapter("android:src")
    public static void setImageDrawable(ImageView view, Drawable drawable) {
        view.setImageDrawable(drawable);
    }

    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, @DrawableRes int resource){
        imageView.setImageResource(resource);
    }
}
