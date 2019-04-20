package com.udacity.gradle.builditbigger;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

/**
 * Java interface for {@link EndpointsAsyncTask}
 */

public interface OnRetrieveJokeListener {

    @UiThread
    void onRetrieveJokeStart();

    @UiThread
    void onRetrieveJokeFinish(@Nullable String result);
}
