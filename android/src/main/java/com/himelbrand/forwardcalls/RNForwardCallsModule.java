package com.himelbrand.forwardcalls;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;

/**
 * {@link NativeModule} that allows JS to open the default browser
 *  for an url.
 */
public class RNForwardCallsModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public RNForwardCallsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "ForwardCalls";
  }

  @ReactMethod
  public void forwardCalls(String phoneNumber) {
    String uri = "tel:**21*" + Uri.encode(phoneNumber+"#");
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void cancel() {
      String uri = "tel:" + Uri.encode("##21#");
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
    }
}