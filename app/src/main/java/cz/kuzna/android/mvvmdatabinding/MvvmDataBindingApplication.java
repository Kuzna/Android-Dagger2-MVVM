package cz.kuzna.android.mvvmdatabinding;

import android.app.Application;
import android.content.Context;

import java.util.Map;

import javax.inject.Inject;

import cz.kuzna.android.core.inject.ComponentBuilder;
import cz.kuzna.android.core.inject.ComponentBuilderContainer;
import timber.log.Timber;

/**
 * @author Radek Kuznik
 */
public class MvvmDataBindingApplication extends Application implements ComponentBuilderContainer {

    @Inject
    Map<Class<?>, ComponentBuilder> componentBuilders;

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        initComponents();
    }

    public void initComponents() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public static MvvmDataBindingApplication get(Context context) {
        return (MvvmDataBindingApplication) context.getApplicationContext();
    }

    @Override
    public ComponentBuilder getComponentBuilder(Class<?> clazz) {
        return componentBuilders.get(clazz);
    }
}
