package cz.kuzna.android.mvvmdatabinding;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Radek Kuznik
 */
@Module
public class AppModule {

    private final MvvmDataBindingApplication application;
    private final Context context;

    public AppModule(final MvvmDataBindingApplication application) {
        this.application = application;
        this.context = application.getApplicationContext();
    }

    @Provides
    @Singleton
    Application provideApplication () {
        return this.application;
    }

    @Provides
    @Singleton
    Context provideContext () {
        return this.context;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return application.getResources();
    }
}
