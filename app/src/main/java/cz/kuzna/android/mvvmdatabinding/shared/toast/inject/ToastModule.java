package cz.kuzna.android.mvvmdatabinding.shared.toast.inject;

import android.content.Context;

import javax.inject.Singleton;

import cz.kuzna.android.mvvmdatabinding.shared.toast.platform.ToastController;
import dagger.Module;
import dagger.Provides;

/**
 * @author Radek Kuznik
 */
@Module
public class ToastModule {

    @Provides
    @Singleton
    ToastController provideRetrofit(Context context){
        return new ToastController(context);
    }
}
