package cz.kuzna.android.mvvmdatabinding.shared.inject;

import cz.kuzna.android.core.inject.ComponentBuilder;
import cz.kuzna.android.core.inject.InjectKey;
import cz.kuzna.android.mvvmdatabinding.detail.inject.DonutDetailComponent;
import cz.kuzna.android.mvvmdatabinding.detail.ui.DonutDetailActivity;
import cz.kuzna.android.mvvmdatabinding.donutlist.inject.DonutListComponent;
import cz.kuzna.android.mvvmdatabinding.donutlist.ui.DonutListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Radek Kuznik
 */
@Module(
        subcomponents = {
                DonutListComponent.class,
                DonutDetailComponent.class
        })
public abstract class BindingModule {

    @Binds
    @IntoMap
    @InjectKey(DonutListActivity.class)
    public abstract ComponentBuilder donutListActivityComponentBuilder(DonutListComponent.Builder builder);

    @Binds
    @IntoMap
    @InjectKey(DonutDetailActivity.class)
    public abstract ComponentBuilder donutDetailActivityComponentBuilder(DonutDetailComponent.Builder builder);
}
