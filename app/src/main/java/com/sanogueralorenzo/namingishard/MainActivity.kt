package com.sanogueralorenzo.namingishard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanogueralorenzo.navigation.features.LandingNavigation
import com.sanogueralorenzo.navigation.features.OnboardingNavigation
import com.sanogueralorenzo.usermanager.UserManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(0, 0)
        super.onCreate(savedInstanceState)
        when {
            UserManager().newUser -> startActivity(OnboardingNavigation.introIntent())
            else -> startActivity(LandingNavigation.landingIntent())
        }
        finish()
    }
}
