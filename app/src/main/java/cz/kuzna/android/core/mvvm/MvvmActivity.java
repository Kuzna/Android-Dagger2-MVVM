package cz.kuzna.android.core.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import cz.kuzna.android.mvvmdatabinding.BR;

/**
 * @author Radek Kuznik
 */

public class MvvmActivity<DB extends ViewDataBinding, MV extends MvvmViewModel> extends AppCompatActivity {

    /** Local variables */
    private final String tag;
    private MV viewModel;
    private DB binding;

    public MvvmActivity() {
        this.tag = getClass().getSimpleName() + ": ";
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    protected String log(final String message) {
        return tag + message;
    }

    public MV getViewModel() {
        return viewModel;
    }

    public void setViewModel(MV viewModel) {
        this.viewModel = viewModel;
    }

    public DB getBinding() {
        return binding;
    }

    protected final void setAndBindContentView(@LayoutRes int layoutResId) {
        if(viewModel == null) {
            throw new IllegalStateException("viewModel must not be null and should be injected via activityComponent().inject(this)");
        }
        binding = DataBindingUtil.setContentView(this, layoutResId);
        binding.setVariable(BR.vm, getViewModel());
    }
}