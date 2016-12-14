package cz.kuzna.android.mvvmdatabinding.order.inject;

import cz.kuzna.android.core.inject.scope.ActivityScope;
import cz.kuzna.android.mvvmdatabinding.order.dataaccess.OrderRestApi;
import cz.kuzna.android.mvvmdatabinding.order.dataaccess.OrderRestService;
import cz.kuzna.android.mvvmdatabinding.order.platform.OrderController;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Radek Kuznik
 */
@Module
public class OrderModule {

    @Provides
    @ActivityScope
    public OrderController provideController(final OrderRestService restService) {
        return new OrderController(restService);
    }

    @Provides
    @ActivityScope
    public OrderRestApi provideRestApi(final Retrofit retrofit) {
        return retrofit.create(OrderRestApi.class);
    }

    @Provides
    @ActivityScope
    public OrderRestService provideRestService(final OrderRestApi restApi) {
        return new OrderRestService(restApi);
    }
}
