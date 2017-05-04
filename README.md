# React Native Forward Calls
Android's Native call forwarding in React Native

## Installation

```bash
npm install react-native-forward-calls --save
```
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

#### Forward all calls unconditionally (\*\*21\*) 

```javascript
ForwardCalls.forwardCalls('123456789')//will forward all calls to the number 123456789
```

#### Cancel unconditional call forwarding

```javascript
ForwardCalls.cancel()
```


