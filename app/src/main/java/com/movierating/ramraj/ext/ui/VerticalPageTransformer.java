package com.movierating.ramraj.ext.ui;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by ramraj on 4/26/17.
 */

public class VerticalPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {
            // This page is way off-screen to the left
            page.setAlpha(0);
        } else if (position <= 1) {
            page.setAlpha(1);

            // Counteract the default slide transition
            page.setTranslationX(page.getWidth() * -position);

            // set Y position to swipe in from top
            float yPosition = position * page.getHeight();
            page.setTranslationY(yPosition);
        } else {
            // This page is way off screen to the right
            page.setAlpha(0);
        }
    }
}
