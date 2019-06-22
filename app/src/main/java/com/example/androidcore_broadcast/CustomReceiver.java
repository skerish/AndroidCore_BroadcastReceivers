package com.example.androidcore_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    public static  final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    //When a broadcast receiver intercepts a broadcast that it's registered for,
    // the Intent is delivered to the receiver's onReceive() method.
    @Override
    public void onReceive(Context context, Intent intent) {

        String intentAction = intent.getAction();
        int count = intent.getIntExtra(MainActivity.key, -1);

        if(intentAction != null){
            String toastMsg = "Unknown intent Action!";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMsg = "Power Connected.";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMsg = "Power Disconnected!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMsg = "Custom Broadcast Received with value " + count;
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    int state = intent.getIntExtra("state", -1);
                    switch(state) {
                        case(0):
                            toastMsg = "Headset Unplugged";
                            break;
                        case(1):
                            toastMsg = "Headset plugged";
                            break;
                    }
            }
            Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT).show();
        }
    }

}
