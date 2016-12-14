package cz.kuzna.android.mvvmdatabinding.shared.inject;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import cz.kuzna.android.core.inject.ComponentBuilderContainer;
import cz.kuzna.android.core.mvvm.MvvmActivity;
import cz.kuzna.android.core.mvvm.MvvmViewModel;
import cz.kuzna.android.mvvmdatabinding.MvvmDataBindingApplication;

/**
 * @author Radek Kuznik
 */
public abstract class D2MvvmActivity<DB extends ViewDataBinding, MV extends MvvmViewModel> extends MvvmActivity<DB, MV> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupComponent(MvvmDataBindingApplication.get(this));
    }

    protected abstract void setupComponent(final ComponentBuilderContainer componentBuilder);

    @Inject
    public void setViewModel(MV presenter) {
        super.setViewModel(presenter);
    }
}
