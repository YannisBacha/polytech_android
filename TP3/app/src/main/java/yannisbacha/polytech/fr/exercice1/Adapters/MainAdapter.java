package yannisbacha.polytech.fr.exercice1.Adapters;

import android.support.v7.widget.RecyclerView;

import yannisbacha.polytech.fr.exercice1.Activities.IRecyclerViewManager;

public abstract class MainAdapter extends RecyclerView.Adapter {
    protected IRecyclerViewManager viewManager;

    @Override
    public int getItemCount() {
        if (viewManager != null) {
            return viewManager.getItemCount();
        }
        return 0;
    }

    public IRecyclerViewManager getViewManager() {
        return viewManager;
    }

    public void setViewManager(IRecyclerViewManager viewManager) {
        this.viewManager = viewManager;
    }
}
