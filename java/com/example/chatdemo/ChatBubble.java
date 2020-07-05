package com.example.chatdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.graphics.PixelFormat;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.view.Gravity.START;

public class ChatBubble extends AppCompatActivity {
//    private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION = 2084;
//    private Context mContext;
//    private WindowManager mWindowManager;
//    private BubbleActionListener mListener;
//    private View mBubbleView;
//    // mới thêm
//    private int lastAction;
//    private int initialX;
//    private int initialY;
//    private float initialTouchX;
//    private float initialTouchY;
////Drag and move chat head using user's touch action.
//    ImageView chatHeadImage = (ImageView) mBubbleView.findViewById(R.id.image_bubble);
//
//    WindowManager.LayoutParams params;
//
//    chatHeadImage.setOnTouchListener(new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//
//                    //remember the initial position.
//                    initialX = params.x;
//                    initialY = params.y;
//
//                    //get the touch location
//                    initialTouchX = event.getRawX();
//                    initialTouchY = event.getRawY();
//
//                    lastAction = event.getAction();
//                    return true;
//                case MotionEvent.ACTION_UP:
//                    //As we implemented on touch listener with ACTION_MOVE,
//                    //we have to check if the previous action was ACTION_DOWN
//                    //to identify if the user clicked the view or not.
//                    if (lastAction == MotionEvent.ACTION_DOWN) {
//                        //Open the chat conversation click.
//                        Intent intent = new Intent(ChatHeadService.this, ChatActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
//
//                        //close the service and remove the chat heads
//                        stopSelf();
//                    }
//                    lastAction = event.getAction();
//                    return true;
//                case MotionEvent.ACTION_MOVE:
//                    //Calculate the X and Y coordinates of the view.
//                    params.x = initialX + (int) (event.getRawX() - initialTouchX);
//                    params.y = initialY + (int) (event.getRawY() - initialTouchY);
//
//                    //Update the layout with new X & Y coordinate
//                    mWindowManager.updateViewLayout(mChatHeadView, params);
//                    lastAction = event.getAction();
//                    return true;
//            }
//            return false;
//        }
//    });
//
//
//            float lastAction =-1;
//        float initialX = 0;
//        float initialY =0;
//        float initialTouchX = 0f;
//        float initialTouchY = 0f;
//        public void initBubbleChat() {
//            WindowManager.LayoutParams params;
//            mBubbleView =
//                    LayoutInflater.from(mContext).inflate(R.layout.chatbubble, null);
//            //Create Layout param
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                params = new WindowManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
//
//
//            } else {
//                params = new WindowManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_PHONE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
//
//            }
//
//            //Specify position bubble
//            params.gravity = Gravity.TOP| Gravity.START;
//            //Initially view will be added to top-left corner
//            params.x = 0;
//            params.y = 0;
//
//            //Add bubble view to window
//            mWindowManager.addView(mBubbleView, params);
//            initListener(params);
//        }
//    public void removeBubbleChat(){
//        //Remove chat head
//        mWindowManager.removeView(mBubbleView);
//    }
//    private void checkBubbleChat(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
//            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"));
//            startActivityForResult(intent, CODE_DRAW_OVER_OTHER_APP_PERMISSION);
//        } else initBubbleChat();
////        else onActivityResult(113,1,this.intent);
//    }
//    @SuppressLint("MissingSuperCall")
//    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        if (requestCode == CODE_DRAW_OVER_OTHER_APP_PERMISSION) {
//
//            //Check if the permission is granted or not.
//            if (resultCode == Activity.RESULT_OK) {
//                Intent intent = new Intent(this, ChatHeadService.class);
//                startService(intent);
//            } else { //Permission is not available
//                Toast.makeText(this, "Draw over other app permission not available. Closing the application", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }
//    private void initListener(WindowManager.LayoutParams params) {
//        Display display = mWindowManager.getDefaultDisplay();
//        int screenWith = display.getWidth();
//
//        //implement click listener
////        mBubbleView.setOnClickListener {
////            //TODO  do something
////        }
//        mBubbleView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        //implement touch listener
//        mBubbleView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(mBubbleView.onTouchEvent(motionEvent))
//                    return true;
//                switch(motionEvent.getAction()){
//                    case MotionEvent.ACTION_DOWN:{
//                        initialX = params.x;
//                        initialY = params.y;
//
//                        initialTouchX = motionEvent.getRawX();
//                        initialTouchY = motionEvent.getRawY();
//                        lastAction = motionEvent.getAction();
//                        break;
//                    }
//                    case MotionEvent.ACTION_UP:{
//                        if (lastAction == MotionEvent.ACTION_DOWN) {
//                            // todo show control button
//                        }
//
//                        lastAction = motionEvent.getAction();
//                        if (params.x < screenWith / 2) {
//                            while (params.x > 0) {
//                                params.x -= 10;
//                                mWindowManager.updateViewLayout(mBubbleView, params);
//                            }
//                        } else {
//                            while (params.x < screenWith) {
//                                params.x += 10;
//                                mWindowManager.updateViewLayout(mBubbleView, params);
//                            }
//                        }
//                        break;}
//
//                    case MotionEvent.ACTION_MOVE:{
//                        params.x = (int) (initialX + (motionEvent.getRawX() - initialTouchX));
//                        params.y = (int) (initialY + (motionEvent.getRawY() - initialTouchY));
//                        mWindowManager.updateViewLayout(mBubbleView, params);
//                        lastAction = motionEvent.getAction();
//                        break;}
//                }
//                return false;
//            }
//        });
//
//        }
//
//
//

    }
