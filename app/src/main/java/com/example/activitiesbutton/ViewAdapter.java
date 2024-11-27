package com.example.activitiesbutton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.activitiesbutton.fragments.CICTArticle;
import com.example.activitiesbutton.fragments.Profile;
import com.example.activitiesbutton.fragments.TCUArticle;

public class ViewAdapter extends FragmentStateAdapter {
    public ViewAdapter(@NonNull TabFragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TCUArticle();
            case 1:
                return new CICTArticle();
            case 2:
                return new Profile();
            default:
                return new TCUArticle();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
