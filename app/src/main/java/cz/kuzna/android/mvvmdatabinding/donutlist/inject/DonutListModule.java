package cz.kuzna.android.mvvmdatabinding.donutlist.inject;

import android.app.Activity;

import java.lang.ref.WeakReference;

import cz.kuzna.android.core.inject.D2Module;
import cz.kuzna.android.core.inject.scope.ActivityScope;
import cz.kuzna.android.mvvmdatabinding.donutlist.ui.DonutListActivity;
import cz.kuzna.android.mvvmdatabinding.donutlist.ui.DonutListViewModel;
import cz.kuzna.android.mvvmdatabinding.donutlist.ui.DonutsAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * @author Radek Kuznik
 */
@Module
public class DonutListModule implements D2Module {

    private WeakReference<Activity> activity;

    public DonutListModule(Activity activity) {
        this.activity = new WeakReference<Activity>(activity);
    }

    @Provides
    @ActivityScope
    DonutsAdapter adapter() {
        return new DonutsAdapter();
    }

    @Provides
    @ActivityScope
    DonutListViewModel viewModel(final DonutsAdapter adapter) {
        return new DonutListViewModel(activity.get(), adapter);
    }
}
