---
title: Service 
template: two-column
showFooter : false
---
```kotlin
interface AuthService {
    suspend fun signUp(email: Email, password: Password): SignUpResult
    suspend fun signIn(email: Email, password: Password): SignInResult
    fun signOff()
}
```

```kotlin
class AuthFireBaseService : AuthService {
    private val auth: FirebaseAuth = Firebase.auth
    private val userService: UserService = FireStoreUserService()
}
```

<!-- column -->

```kotlin
override suspend fun signUp(email: Email, password: Password): SignUpResult {
    return try {
        val result = auth.createUserWithEmailAndPassword(email.value, password.value)
            .await().user ?: return SignUpResult.Failure.General
        val verifiedEmail = result.email?.let { Email(it) }
            ?: return SignUpResult.Failure.General
        val user = UserId(result.uid)
        val signUpResult = SignUpResult.Success(user)
        // result.sendEmailVerification() is possible
        userService.createUser(signUpResult.user, verifiedEmail)
        signUpResult
    } catch (e: FirebaseAuthWeakPasswordException) {
        SignUpResult.Failure.InvalidCredentials(e.message.toString())
    } catch (e: FirebaseAuthInvalidCredentialsException) {
        SignUpResult.Failure.InvalidCredentials(e.message.toString())
    } catch (_: FirebaseAuthUserCollisionException) {
        SignUpResult.Failure.UserExists
    } catch (e: FirebaseAuthException) {
        when (e.errorCode) {
            "NETWORK_REQUEST_FAILED" -> {SignUpResult.Failure.Network}
            else -> {SignUpResult.Failure.General}
        }
    } catch (_: Exception) {
        SignUpResult.Failure.General
    }
}
```
