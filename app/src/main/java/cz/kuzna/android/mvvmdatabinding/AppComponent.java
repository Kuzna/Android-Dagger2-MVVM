package cz.kuzna.android.mvvmdatabinding;

import javax.inject.Singleton;

import cz.kuzna.android.mvvmdatabinding.shared.inject.BindingModule;
import cz.kuzna.android.mvvmdatabinding.shared.rest.inject.RestModule;
import cz.kuzna.android.mvvmdatabinding.shared.toast.inject.ToastModule;
import dagger.Component;

/**
 * @author Radek Kuznik
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                RestModule.class,
                ToastModule.class,
                BindingModule.class
        }
)
public interface AppComponent {
    MvvmDataBindingApplication inject(MvvmDataBindingApplication application);
}
