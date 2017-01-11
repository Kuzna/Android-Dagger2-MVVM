package cz.kuzna.android.mvvmdatabinding.detail.ui;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;

import javax.inject.Inject;

import cz.kuzna.android.core.mvvm.BaseViewModel;
import cz.kuzna.android.mvvmdatabinding.R;
import cz.kuzna.android.mvvmdatabinding.order.platform.OrderController;
import cz.kuzna.android.mvvmdatabinding.shared.donut.domain.Donut;
import cz.kuzna.android.mvvmdatabinding.shared.toast.platform.ToastController;
import rx.functions.Action1;

/**
 * @author Radek Kuznik
 */

public class DonutDetailViewModel extends BaseViewModel {

    private final ObservableField<CharSequence> text = new ObservableField<CharSequence>();
    private final ObservableField<Drawable> image = new ObservableField<Drawable>();

    private OrderController orderController;
    private ToastController toastController;
    private Context context;
    private int donutId;

    @Inject
    public DonutDetailViewModel(Context context, final OrderController orderController,
                                final ToastController toastController) {
        this.context = context;
        this.orderController = orderController;
        this.toastController = toastController;
    }

    public void loadData(final int donutId) {

        final Donut donut;

        switch (donutId) {
            case 0:
                donut = new Donut(R.drawable.ic_donut_blue_moon_sprinkle, R.string.blue_moon_sprinkle);
                break;
            case 1:
                donut = new Donut(R.drawable.ic_donut_butter_nut, R.string.butter_nut);
                break;
            case 2:
                donut = new Donut(R.drawable.ic_donut_caviar_strawberry, R.string.caviar_strawberry);
                break;
            case 3:
                donut = new Donut(R.drawable.ic_donut_dark_chocolate_sprinkle, R.string.dark_chocolate_sprinkle);
                break;
            case 4:
                donut = new Donut(R.drawable.ic_donut_green_tea_sprinkle, R.string.green_tea_sprinkle);
                break;
            case 5:
                donut = new Donut(R.drawable.ic_donut_lemon_sprinkle, R.string.lemon_sprinkle);
                break;
            case 6:
                donut = new Donut(R.drawable.ic_donut_maple_iced, R.string.maple_iced);
                break;
            case 7:
                donut = new Donut(R.drawable.ic_donut_raspberry, R.string.raspberry);
                break;
            case 8:
                donut = new Donut(R.drawable.ic_donut_strawberry_sprinkle, R.string.strawberry_sprinkle);
                break;
            case 9:
                donut = new Donut(R.drawable.ic_donut_sugar_pink, R.string.sugar_pink);
                break;
            case 10:
                donut = new Donut(R.drawable.ic_donut_vanilla_iced, R.string.vanilla_iced);
                break;
            case 11:
                donut = new Donut(R.drawable.ic_donut_vanilla_sprinkle, R.string.vanilla_sprinkle);
                break;
            default:
                donut = null;
                break;
        }

        if(donut != null) {
            text.set(context.getString(donut.nameResId));
            image.set(ContextCompat.getDrawable(context, donut.iconResId));
        }
    }

    public void update(final int donutId) {
        this.donutId = donutId;
    }

    public int getDonutId() {
        return this.donutId;
    }

    public void onClickOrderNow(@NonNull final View view) {
        this.orderController.order(donutId).subscribe(new Action1<Boolean>() {
            @Override
            public void call(final Boolean result) {
                if(result == null || !result) {
                    toastController.showLongToast("Order failed");
                } else {
                    toastController.showLongToast("Order was submitted");
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                toastController.showLongToast("Order failed");
            }
        });
    }

    public ObservableField<CharSequence> getText() {
        return text;
    }

    public ObservableField<Drawable> getImage() {
        return image;
    }
}
