package es.iessaladillo.pedrojoya.pr05_trivial.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.MainActivityViewModel

class ConfirmationDialogFragment : DialogFragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.main_confirmation))
            .setMessage(getString(R.string.main_quit_game))
            .setPositiveButton(getString(R.string.main_yes)) { _, _ ->
                viewModel.setResponse(true)
            }
            .setNegativeButton(getString(R.string.main_no)) { _, _ ->
                viewModel.setResponse(false)
            }
            .create()





}