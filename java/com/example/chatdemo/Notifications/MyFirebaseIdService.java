//package com.example.chatdemo.Notifications;
//
////import android.app.Service;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.util.Log;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.iid.FirebaseInstanceId;
//import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
////import com.google.firebase.iid.FirebaseInstanceIdService;
//
//public class MyFirebaseIdService extends FirebaseInstanceIdInternal {
//
//    @Override
//    public void onTokenRefresh() {
//        super.onTokenRefresh();
//        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//
//        String refreshToken = FirebaseInstanceId.getInstance().getToken();
//        if (firebaseUser != null){
//            updateToken(refreshToken);
//        }
//    }
//
//    private void updateToken(String refreshToken) {
//        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Tokens");
//        Token token = new Token(refreshToken);
//        reference.child(firebaseUser.getUid()).setValue(token);
//    }
//    private static final String TAG = "InstanceIdService";
//
//    /**
//     * Called if InstanceID token is updated. This may occur if the security of
//     * the previous token had been compromised. This call is initiated by the
//     * InstanceID provider.
//     */
//    // [START refresh_token]
//    @Override
//    public void onNewToken(String token) { //Added onNewToken method
//        // Get updated InstanceID token.
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        Log.d(TAG, "Refreshed token: " + refreshedToken);
//
//        // Broadcast refreshed token
//        Intent i = new Intent("com.evollu.react.fcm.FCMRefreshToken");
//        Bundle bundle = new Bundle();
//        bundle.putString("token", refreshedToken);
//        i.putExtras(bundle);
//
//        final Intent message = i;
//
//        Handler handler = new Handler(Looper.getMainLooper());
//        handler.post(new Runnable() {
//            public void run() {
//                // Construct and load our normal React JS code bundle
//                ReactInstanceManager mReactInstanceManager = ((ReactApplication) getApplication()).getReactNativeHost().getReactInstanceManager();
//                ReactContext context = mReactInstanceManager.getCurrentReactContext();
//                // If it's constructed, send a notification
//                if (context != null) {
//                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(message);
//                } else {
//                    // Otherwise wait for construction, then send the notification
//                    mReactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
//                        public void onReactContextInitialized(ReactContext context) {
//                            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(message);
//                        }
//                    });
//                    if (!mReactInstanceManager.hasStartedCreatingInitialContext()) {
//                        // Construct it in the background
//                        mReactInstanceManager.createReactContextInBackground();
//                    }
//                }
//            }
//        });
//    }
//}
