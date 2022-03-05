package com.digitalamanmedia.bhumistar.data.remote.repositoryImpl




import android.widget.Toast
import androidx.activity.ComponentActivity
import com.digitalamanmedia.bhumistar.domain.repository.AuthenticationRepository
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class AuthenticationRepositoryImpl @Inject constructor(
    private val mAuth: FirebaseAuth,
    private var activity: ComponentActivity
) :AuthenticationRepository{

    var mVerificationId: String = ""


    override suspend fun sendOTP(number: String) {
        val options = PhoneAuthOptions.newBuilder(mAuth)
            .setPhoneNumber(number)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(mCallbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    override suspend fun verifyOTP(otp: String) {
        if (otp.isNotEmpty()){

            if (otp.length != 6){
                Toast.makeText(activity,"enter full otp...",Toast.LENGTH_SHORT).show()
            }else{
                val credential = PhoneAuthProvider.getCredential(mVerificationId, otp)
                signInWithPhoneAuthCredential(credential = credential)
            }
        }else{
            Toast.makeText(activity,"enter otp...",Toast.LENGTH_SHORT).show()
        }

    }
    private val mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(authCredential: PhoneAuthCredential) {
            signInWithPhoneAuthCredential(credential = authCredential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            Toast.makeText(activity,e.message,Toast.LENGTH_SHORT).show()
        }

        override fun onCodeSent(verificationId: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
            super.onCodeSent(verificationId, forceResendingToken)
            Toast.makeText(activity,"OTP sent successfully...", Toast.LENGTH_SHORT).show()
            mVerificationId = verificationId

        }

    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(activity,"Phone number verified...",Toast.LENGTH_SHORT).show()


                } else {
                    // Sign in failed, display a message and update the UI
                    Toast.makeText(activity, task.exception?.message,Toast.LENGTH_SHORT).show()


                }
            }
    }
}