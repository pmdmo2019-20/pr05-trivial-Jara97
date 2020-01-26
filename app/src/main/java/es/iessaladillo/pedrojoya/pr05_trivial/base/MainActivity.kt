package es.iessaladillo.pedrojoya.pr05_trivial.base

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.commit
import androidx.lifecycle.observe
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.fragments.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            showInitialDestination()
        }
        setObservers()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setObservers() {
        viewModel.fragment.observe(this){
            changeFragment(it)
        }
        viewModel.response.observe(this){
            if(it){
                viewModel.setFragment(1)
            }
        }
    }

    private fun changeFragment(fragment:Int) {
        when (fragment) {
            1 -> supportFragmentManager.commit {
                replace(R.id.ContainerView, PrincipalFragment.newInstance()).run { setTitle(R.string.app_name) }
            }
            2 -> supportFragmentManager.commit {
                replace(R.id.ContainerView, PlayFragment.newInstance()).run { setTitle(R.string.title_btnPlay) }
            }
            3 -> supportFragmentManager.commit {
                replace(R.id.ContainerView, RulesFragment.newInstance()).run { setTitle(R.string.rules_title) }
            }
            4 -> supportFragmentManager.commit {
                replace(R.id.ContainerView, AboutFragment.newInstance()).run { setTitle(R.string.about_title) }
            }
            5 -> supportFragmentManager.commit {
                replace(R.id.ContainerView, SettingsFragment.newInstance()).run { setTitle(R.string.settings_title) }
            }
            6 -> supportFragmentManager.commit {
                replace(R.id.ContainerView, WinFragment.newInstance()).run { setTitle(R.string.title_win) }
            }
            7 -> supportFragmentManager.commit {
                replace(R.id.ContainerView, LoseFragment.newInstance()).run { setTitle(R.string.game_over_title) }
            }
        }
    }

    private fun showInitialDestination() {
        supportFragmentManager.commit {
            replace(R.id.ContainerView, PrincipalFragment.newInstance())
        }
    }

    override fun onBackPressed() {
        if(!viewModel.dialog){
            if(viewModel.fragment.value==1){
                super.onBackPressed()
            }
            else{
                viewModel.setFragment(1)
            }
        }
        else{
            if(viewModel.fragment.value==2){
                showConfirmationDialog()
            }
            else{
                viewModel.setFragment(1)
            }
        }

    }

    private fun showConfirmationDialog() {
        ConfirmationDialogFragment()
            .show(supportFragmentManager, "")
    }




}
