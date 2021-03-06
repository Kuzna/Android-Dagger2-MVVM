package cz.kuzna.android.mvvmdatabinding.detail.inject;

import cz.kuzna.android.core.inject.ComponentBuilder;
import cz.kuzna.android.core.inject.D2Component;
import cz.kuzna.android.core.inject.scope.ActivityScope;
import cz.kuzna.android.mvvmdatabinding.detail.ui.DonutDetailActivity;
import cz.kuzna.android.mvvmdatabinding.order.inject.OrderModule;
import dagger.Subcomponent;

/**
 * @author Radek Kuznik
 */
@ActivityScope
@Subcomponent(
        modules = { DonutDetailModule.class, OrderModule.class }
)
public interface DonutDetailComponent extends D2Component<DonutDetailActivity> {

    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<DonutDetailModule, DonutDetailComponent> {
    }
}