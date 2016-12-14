package cz.kuzna.android.mvvmdatabinding.donutlist.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import javax.inject.Inject;

import cz.kuzna.android.core.inject.ComponentBuilderContainer;
import cz.kuzna.android.mvvmdatabinding.R;
import cz.kuzna.android.mvvmdatabinding.databinding.ActivityDonutListBinding;
import cz.kuzna.android.mvvmdatabinding.donutlist.inject.DonutListComponent;
import cz.kuzna.android.mvvmdatabinding.donutlist.inject.DonutListModule;
import cz.kuzna.android.mvvmdatabinding.shared.inject.D2MvvmActivity;

/**
 * @author Radek Kuznik
 */
public class DonutListActivity extends D2MvvmActivity<ActivityDonutListBinding, DonutListViewModel> {

    @Inject
    DonutsAdapter donutsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAndBindContentView(R.layout.activity_donut_list);

        getBinding().recyclerView.setHasFixedSize(true);
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getBinding().recyclerView.setAdapter(donutsAdapter);
        getBinding().recyclerView.setItemAnimator(new DefaultItemAnimator());
        getBinding().recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, final int swipeDir) {
                donutsAdapter.remove(viewHolder.getAdapterPosition());
            }
        });

        itemTouchHelper.attachToRecyclerView(getBinding().recyclerView);
    }

    @Override
    protected void setupComponent(ComponentBuilderContainer componentBuilder) {
        ((DonutListComponent.Builder) componentBuilder.getComponentBuilder(this.getClass()))
                .module(new DonutListModule(this))
                .build()
                .injectMembers(this);
    }
}
