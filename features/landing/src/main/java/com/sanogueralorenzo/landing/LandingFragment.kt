package com.sanogueralorenzo.landing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sanogueralorenzo.views.extensions.onFragmentBackCallback
import kotlinx.android.synthetic.main.fragment_landing.*

/**
 * @see com.sanogueralorenzo.navigation.features.LandingNavigation.landingIntent
 */
@Suppress("Unused")
class LandingFragment : Fragment(R.layout.fragment_landing) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView.apply {
                setOnNavigationItemSelectedListener {
                    when (it.itemId) {
                        R.id.navigation_home -> { }
                        R.id.navigation_search -> { }
                        R.id.navigation_add -> { }
                        R.id.navigation_notifications -> { }
                        R.id.navigation_profile -> { }
                        else -> error("unhandled bottom navigation item")
                    }
                    true
                }
        }

        // onBackPressed select home if not selected, otherwise just close
        onFragmentBackCallback(
            callback = { bottomNavigationView.selectedItemId = R.id.navigation_home },
            predicate = { bottomNavigationView.selectedItemId != R.id.navigation_home }
        )

        if (savedInstanceState != null) return
        // replaceFragment(HomeNavigation.homeFragment(), backstack = false, containerId = homeContainer.id)
    }
}
