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
      Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
  }
```

### Use url from notification payload

```kotlin
  try {
      PaymentService.openPayment(urlEditText.text.toString())
  } catch (t: Throwable) {
      Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
  }
```
### Use custom default browser

```swift
  PaymentService.defaultBrowser = true
```
default value ```false```

### Error

```kotlin
class InvalidateURLError(override val message: String?): Throwable()

class InvalidateUserInfoError(override val message: String?): Throwable()
```
