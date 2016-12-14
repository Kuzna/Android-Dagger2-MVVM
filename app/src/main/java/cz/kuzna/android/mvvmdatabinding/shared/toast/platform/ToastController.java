package cz.kuzna.android.mvvmdatabinding.shared.toast.platform;

import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * @author Radek Kuznik
 */

public class ToastController {

    private WeakReference<Context> context;

    public ToastController(Context context) {
        this.context = new WeakReference<Context>(context);
    }

    public void showShortToast(String text) {
        Toast.makeText(this.context.get(), text, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String text) {
        Toast.makeText(this.context.get(), text, Toast.LENGTH_LONG).show();
    }
}
