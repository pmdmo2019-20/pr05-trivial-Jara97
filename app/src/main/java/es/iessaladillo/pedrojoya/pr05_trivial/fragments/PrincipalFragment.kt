package es.iessaladillo.pedrojoya.pr05_trivial.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.MainActivityViewModel
import kotlinx.android.synthetic.main.principal_fragment.*


class PrincipalFragment : Fragment(R.layout.principal_fragment) {

    private val viewModel: MainActivityViewModel by activityViewModels()

    companion object {
        fun newInstance() = PrincipalFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListeners()
        setupViews()
        setHasOptionsMenu(true)
    }

   private fun setListeners(){
       btnPlay2.setOnClickListener {
            viewModel.setFragment(2)
            viewModel.loadQuestions(5)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.activity_main, menu)
        return super.onCreateOptionsMenu(menu,inflater)
    }

    private fun setupViews() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setTitle(R.string.app_name)
            setDisplayHomeAsUpEnabled(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.mnuSettings -> { viewModel.setFragment(5); true }
            R.id.mnuAbout -> { viewModel.setFragment(4) ; true }
            R.id.mnuRules -> { viewModel.setFragment(3) ; true }
            else -> super.onOptionsItemSelected(item)
        }

}
