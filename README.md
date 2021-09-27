# PaymentSDK

## Usage

### Init in application class

```kotlin
  override fun onCreate() {
        super.onCreate()
        PaymentService.initialize(applicationContext)
    }
```

### Use payload from notification

```kotlin
  val payload = mutableMapOf<String, Any>()
  try {
      PaymentService.openPayment(payload)
  } catch (t: Throwable) {
      print(t.message)
  }
```

### Use url from notification payload

```kotlin
  try {
      PaymentService.openPayment(url)
  } catch (t: Throwable) {
      print(t.message)
  }
```
### Use default browser

```swift
  PaymentService.defaultBrowser = true
```
default value ```false```

### Error

```kotlin
class InvalidateURLError(override val message: String?): Throwable()

class InvalidateUserInfoError(override val message: String?): Throwable()
```
