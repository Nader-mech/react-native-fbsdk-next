/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.reactnative.androidsdk;

import androidx.annotation.Nullable;

import com.facebook.FacebookSdk;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a {@link NativeModule} that allows JS to use SDK settings in Facebook Android SDK.
 */
@ReactModule(name = FBSettingsModule.NAME)
public class FBSettingsModule extends BaseJavaModule {

    public static final String NAME = "FBSettings";

    public FBSettingsModule() {}

    @Override
    public String getName() {
        return NAME;
    }

    /**
     * Sets data processing options with country and state
     * @param options list of the options
     * @param country code of the country
     * @param state code of the state
     */
    @ReactMethod
    public void setDataProcessingOptions(ReadableArray options, int country, int state) {
        List<String> opts = Utility.reactArrayToStringList(options);
        String[] optsArray = opts.toArray(new String[0]);
        FacebookSdk.setDataProcessingOptions(optsArray, country, state);
    }

    /**
     * Initialize the sdk
     * [FB SDK Best Practices for GDPR Compliance](https://developers.facebook.com/docs/app-events/gdpr-compliance/)
     */
    @ReactMethod
    public static void initializeSDK() {
        FacebookSdk.fullyInitialize();
    }

    /**
     * Set app id
     * @param appID app id
     */
    @ReactMethod
    public static void setAppID(String appID) {
        FacebookSdk.setApplicationId(appID);
    }
    /**
     * Set Logging For The user
     * @param enabled enabled
     */
    @ReactMethod
    public static void setAutoLogAppEventsEnabled(Boolean enabled) {
        FacebookSdk.setAutoLogAppEventsEnabled(enabled);
    }
    /**
     * Set The Collection enabling for idfa,adid
     * @param enabled enabled
     */
    @ReactMethod
    public static void setAdvertiserIDCollectionEnabled(Boolean enabled) {
        FacebookSdk.setAdvertiserIDCollectionEnabled(enabled);
    }

}
