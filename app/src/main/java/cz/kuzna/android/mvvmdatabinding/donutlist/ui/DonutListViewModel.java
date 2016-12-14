package cz.kuzna.android.mvvmdatabinding.donutlist.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import cz.kuzna.android.core.mvvm.BaseViewModel;
import cz.kuzna.android.mvvmdatabinding.detail.ui.DonutDetailActivity;

/**
 * @author Radek Kuznik
 */

public class DonutListViewModel extends BaseViewModel implements DonutViewHolderListener {

//    private NavigatorController navigatorController;

    DonutsAdapter donutsAdapter;
    WeakReference<Activity> activity;

    @Inject
    public DonutListViewModel(final Activity activity, DonutsAdapter donutsAdapter) {
//        this.navigatorController = navigatorController;
        this.donutsAdapter = donutsAdapter;
        this.activity = new WeakReference<Activity>(activity);

        donutsAdapter.setListener(this);
    }

    private void goToDetail(final Activity activity, final int donutId) {
        final Intent intent = new Intent(activity.getApplicationContext(), DonutDetailActivity.class);
        intent.putExtra(DonutDetailActivity.EXTRA_DONUT_ID, donutId);

        activity.startActivity(intent);
    }

    public DonutsAdapter getAdapter() {
        return donutsAdapter;
    }

    @Override
    public void onItemClick(int position, View view) {
        goToDetail(activity.get(), position);
    }

    @Override
    public void onItemLongClick(int position, View view) {
        donutsAdapter.remove(position);
    }
}