package cz.kuzna.android.mvvmdatabinding.detail.inject;

import android.content.Context;

import cz.kuzna.android.core.inject.D2Module;
import cz.kuzna.android.core.inject.scope.ActivityScope;
import cz.kuzna.android.mvvmdatabinding.detail.ui.DonutDetailViewModel;
import cz.kuzna.android.mvvmdatabinding.order.platform.OrderController;
import cz.kuzna.android.mvvmdatabinding.shared.toast.platform.ToastController;
import dagger.Module;
import dagger.Provides;

/**
 * @author Radek Kuznik
 */
@Module
public class DonutDetailModule implements D2Module {

    @Provides
    @ActivityScope
    DonutDetailViewModel viewModel(final Context context, final OrderController orderController,
                                   final ToastController toastController) {
        return new DonutDetailViewModel(context, orderController, toastController);
    }
}
