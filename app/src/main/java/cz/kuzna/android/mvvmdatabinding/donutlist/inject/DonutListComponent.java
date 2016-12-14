package cz.kuzna.android.mvvmdatabinding.donutlist.inject;

import cz.kuzna.android.core.inject.ComponentBuilder;
import cz.kuzna.android.core.inject.D2Component;
import cz.kuzna.android.core.inject.scope.ActivityScope;
import cz.kuzna.android.mvvmdatabinding.donutlist.ui.DonutListActivity;
import dagger.Subcomponent;

/**
 * @author Radek Kuznik
 */
@ActivityScope
@Subcomponent(
        modules = DonutListModule.class
)
public interface DonutListComponent extends D2Component<DonutListActivity> {

    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<DonutListModule, DonutListComponent> {
    }
}