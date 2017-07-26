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
  public void unconditionalForwarding(String phoneNumber) {
    String uri = "tel:**21*" + Uri.encode(phoneNumber+"#");
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void customCodeForwarding(String code,String phoneNumber) {
      String uri = "tel:" + code + Uri.encode(phoneNumber + "#");
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void forwardCallsIfBusy(String phoneNumber) {
    String uri = "tel:**67*" + Uri.encode(phoneNumber+"#");
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void forwardCallsIfNotAnswered (String phoneNumber) {
    String uri = "tel:*61*" + Uri.encode(phoneNumber+"#");
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void forwardCallsIfOutOfReach (String phoneNumber) {
    String uri = "tel:*62*" + Uri.encode(phoneNumber+"#");
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void allConditionalForwarding (String phoneNumber) {
    String uri = "tel:*002*" + Uri.encode(phoneNumber+"#");
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void cancelUnconditional() {
      String uri = "tel:" + Uri.encode("##21#");
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void cancelIfBusy() {
      String uri = "tel:" + Uri.encode("##67#");
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void cancelIfNotAnswered() {
      String uri = "tel:" + Uri.encode("##61#");
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void cancelIfOutOfReach() {
      String uri = "tel:" + Uri.encode("##62#");
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void cancelAllConditional() {
      String uri = "tel:" + Uri.encode("##002#");
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
  }
  @ReactMethod
  public void cancelCustomForward(String code) {
      String uri = "tel:" + Uri.encode(code);
      Intent intent = new Intent(Intent.ACTION_CALL);
      intent.setData(Uri.parse(uri));
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      this.reactContext.startActivity(intent);
  }
}