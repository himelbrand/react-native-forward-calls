# React Native Forward Calls
Native call forwarding in React Native (no support for IOS at the moment)
Welcome!
this project is not yet complete,
for all ready parts see documentation below.
(docs are not complete, feel free to improve them)

### Still missing
- this project have no support for IOS what so ever, since I don't own a mac 
- custom forwards (the MMI code sent as a parameter to the function)
- some of the MMI codes for Android
if you would like to contribute to this project or suggest more future features you're welcome to so via an issue or pull request.

### IOS support
right now this package does not support IOS, so any one that wants to help and contribute the IOS support is more than welcome to do so after contacting me to verify (so you won't do the work for nothing in case it's already under construction)

## Realease notes
 version 1.1.0
   * added support for custom MMI codes call forwards and cancellation 
    

## Installation

```bash
npm install react-native-forward-calls --save
```
npm page - https://www.npmjs.com/package/react-native-forward-calls
## Add permissions
* In `AndroidManifest.xml` add:
```xml

<uses-permission android:name="android.permission.CALL_PHONE" />
```
## Project setup and initialization auto
```bash
react-native link
```
## Project setup and initialization manually 

* In `android/settings.gradle`

```gradle
...
include ':react-native-forward-calls', ':app'
project(':react-native-forward-calls').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-forward-calls/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    /* YOUR DEPENDENCIES HERE */
    compile project(':react-native-forward-calls') // <--- add this
}

```

* Register Module (in MainApplication.java)

```java
import com.himelbrand.forwardcalls.RNForwardCallsPackage;  // <--- import

public class MainActivity extends ReactActivity {
  ......

  @Override
  protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new RNForwardCallsPackage() // <--- Add this
      );
  }

  ......

}
```


## Usage

#### Import

```javascript
import ForwardCalls from 'react-native-forward-calls'
```

#### Forward calls 

```javascript
ForwardCalls.unconditionalForwarding('123456789')//Forward all calls unconditionally to the number 123456789
ForwardCalls.forwardCallsIfBusy('123456789')//Forward calls if busy to the number 123456789
ForwardCalls.forwardCallsIfNotAnswered('123456789')//Forward calls if not answered to the number 123456789
ForwardCalls.forwardCallsIfOutOfReach('123456789')//Forward calls if out of reach to the number 123456789
ForwardCalls.allConditionalForwarding('123456789')//All conditional forwarding activated to the number 123456789
ForwardCalls.customCodeForwarding('*72','123456789')//All calls forwarding activated to the number 123456789, north america code
```

#### Cancel call forwarding

```javascript
ForwardCalls.cancelUnconditional()
ForwardCalls.cancelIfBusy()
ForwardCalls.cancelIfNotAnswered()
ForwardCalls.cancelIfOutOfReach()
ForwardCalls.cancelAllConditional()
ForwardCalls.cancelCustomForward('*73') //String parameter of cancellation code  
```

