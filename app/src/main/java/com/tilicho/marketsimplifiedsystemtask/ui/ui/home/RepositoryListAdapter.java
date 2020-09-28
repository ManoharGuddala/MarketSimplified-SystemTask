package com.tilicho.marketsimplifiedsystemtask.ui.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tilicho.marketsimplifiedsystemtask.R;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.PublicRepository;
import com.tilicho.marketsimplifiedsystemtask.databinding.RowLayoutBinding;
import com.tilicho.marketsimplifiedsystemtask.ui.RepositoriesActivity;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.dashboard.DetailsFragment;

public class RepositoryListAdapter extends PagedListAdapter<PublicRepository, RepositoryListAdapter.MyViewHolder> {

    Activity activity;

    protected RepositoryListAdapter(Activity activity) {
        super(PublicRepository.DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RowLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_layout, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.binding.setModel(getItem(position));
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RowLayoutBinding binding;

        MyViewHolder(RowLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle =  new Bundle();
                    bundle.putParcelable("REPO", binding.getModel());
                    DetailsFragment fragment = new DetailsFragment();
                    fragment.setArguments(bundle);
                    ((RepositoriesActivity)RepositoryListAdapter.this.activity).pushFragment(new DetailsFragment(), bundle, DetailsFragment.TAG, true);
                }
            });
        }

    }

}
