package com.lamusoft.zenmom_pregnancy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @noinspection deprecation
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private final int count;

    // Constructor
    public PagerAdapter(@NonNull FragmentManager fm, int count) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.count = count;
    }

    // Return the fragment for a specific position
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return switch (position) {
            case 0 -> new Weeks1to8();
            case 1 -> new Weeks9to12();
            case 2 -> new Weeks13to16();
            case 3 -> new Weeks17to20();
            case 4 -> new Weeks21to24();
            case 5 -> new Weeks25to28();
            case 6 -> new Weeks29to32();
            case 7 -> new Weeks33to36();
            case 8 -> new Weeks37to40();
            default -> throw new IllegalStateException("Unexpected value: " + position);
        };
    }

    // Return the total number of fragments
    @Override
    public int getCount() {
        return count;
    }

    // Set the title for each page
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return switch (position) {
            case 0 -> "Weeks 1-8";
            case 1 -> "Weeks 9-12";
            case 2 -> "Weeks 13-16";
            case 3 -> "Weeks 17-20";
            case 4 -> "Weeks 21-24";
            case 5 -> "Weeks 25-28";
            case 6 -> "Weeks 29-32";
            case 7 -> "Weeks 33-36";
            case 8 -> "Weeks 37-40";
            default -> null;
        };
    }
}
