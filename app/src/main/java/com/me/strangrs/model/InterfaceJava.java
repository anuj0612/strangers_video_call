package com.me.strangrs.model;

import android.webkit.JavascriptInterface;
import com.me.strangrs.activities.CallActivity;

public class InterfaceJava {

    CallActivity callActivity;

    //public InterfaceJava(CallActivity callActivity) {
       // this.callActivity = callActivity;
   // }

    public void onPeerConnected(){
        callActivity.onPeerConnected();
    }

}