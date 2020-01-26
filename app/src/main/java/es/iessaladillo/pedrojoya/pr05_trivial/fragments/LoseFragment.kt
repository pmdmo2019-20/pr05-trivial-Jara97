package es.iessaladillo.pedrojoya.pr05_trivial.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.MainActivityViewModel
import kotlinx.android.synthetic.main.lose_fragment.*

class LoseFragment : Fragment(R.layout.lose_fragment) {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
        setListeners()
    }

    private fun setListeners() {
        btnTry.setOnClickListener {
            viewModel.loadQuestions(viewModel.number)
            viewModel.setFragment(2)

        }
    }

    companion object {
        fun newInstance() = LoseFragment()
    }
    private fun setupViews() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.game_over_title)
        }
    }

}