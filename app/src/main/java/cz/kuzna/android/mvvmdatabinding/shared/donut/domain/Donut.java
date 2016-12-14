package cz.kuzna.android.mvvmdatabinding.shared.donut.domain;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * @author Radek Kuznik
 */
public class Donut {
    public @DrawableRes
    int iconResId;
    public @StringRes
    int nameResId;

    public Donut(@DrawableRes int iconResId, @StringRes int nameResId) {
        this.iconResId = iconResId;
        this.nameResId = nameResId;
    }
}