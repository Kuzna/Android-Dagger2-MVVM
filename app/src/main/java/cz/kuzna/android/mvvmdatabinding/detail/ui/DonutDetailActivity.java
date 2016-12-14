package cz.kuzna.android.mvvmdatabinding.detail.ui;

import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;
import cz.kuzna.android.core.inject.ComponentBuilderContainer;
import cz.kuzna.android.mvvmdatabinding.R;
import cz.kuzna.android.mvvmdatabinding.databinding.ActivityDonutDetailBinding;
import cz.kuzna.android.mvvmdatabinding.detail.inject.DonutDetailComponent;
import cz.kuzna.android.mvvmdatabinding.detail.inject.DonutDetailModule;
import cz.kuzna.android.mvvmdatabinding.shared.inject.D2MvvmActivity;

/**
 * @author Radek Kuznik
 */
public class DonutDetailActivity extends D2MvvmActivity<ActivityDonutDetailBinding, DonutDetailViewModel> {

    public static final String EXTRA_DONUT_ID = "ext_donut_id";

    private int donutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAndBindContentView(R.layout.activity_donut_detail);

        if(getIntent() != null && getIntent().hasExtra(EXTRA_DONUT_ID)) {
            donutId = getIntent().getIntExtra(EXTRA_DONUT_ID, -1);
        }
    }

    @Override
    protected void setupComponent(ComponentBuilderContainer componentBuilder) {
        ((DonutDetailComponent.Builder) componentBuilder.getComponentBuilder(this.getClass()))
                .module(new DonutDetailModule())
                .build()
                .injectMembers(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getViewModel().loadData(donutId);
    }

    @OnClick(R.id.btn_order_now)
    public void onClickOrderNow(final View view) {
        getViewModel().clickedOrderNow(donutId);
    }
}
