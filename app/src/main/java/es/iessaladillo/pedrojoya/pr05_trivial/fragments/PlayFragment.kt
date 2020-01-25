package es.iessaladillo.pedrojoya.pr05_trivial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.MainActivityViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.db.Question
import kotlinx.android.synthetic.main.play_fragment.*

class PlayFragment : Fragment(R.layout.play_fragment) {

    private val viewModel: MainActivityViewModel by activityViewModels()
    private val number: Int=4

    companion object {
        fun newInstance() = PlayFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
        setObservers()
        setHasOptionsMenu(true)
        setListeners()
        if(savedInstanceState==null){
            changeTittle(1)
            writeQuestion()
        }

    }

    private fun setListeners() {
        btnSubmit.setOnClickListener {
            val question: Question = viewModel.getQuestion(viewModel.questionNum.value?:0)
            if(rdAnswer1.isChecked &&question.answer[0].isCorrect){
                if(viewModel.questionNum.value==number){
                    viewModel.setFragment(6)
                }
                else{
                    viewModel.nextQuestion()
                    rdAnswer1.isChecked=false
                }
            }
            else if(rdAnswer2.isChecked &&question.answer[1].isCorrect){
                if(viewModel.questionNum.value==number){
                    viewModel.setFragment(6)
                }
                else{
                    viewModel.nextQuestion()
                    rdAnswer2.isChecked=false
                }
            }
            else if(rdAnswer3.isChecked &&question.answer[2].isCorrect){
                if(viewModel.questionNum.value==number){
                    viewModel.setFragment(6)
                }
                else{
                    viewModel.nextQuestion()
                    rdAnswer3.isChecked=false
                }
            }
            else if(rdAnswer4.isChecked &&question.answer[3].isCorrect){
                if(viewModel.questionNum.value==number){
                    viewModel.setFragment(6)
                    rdAnswer4.isChecked=false
                }
                else{
                    viewModel.nextQuestion()
                }
            }
            else{

            }
        }
    }

    private fun setObservers() {
        viewModel.questionNum.observe(this){
            changeTittle(it)
            writeQuestion()
        }
    }

    private fun writeQuestion() {
        val question: Question = viewModel.getQuestion(viewModel.questionNum.value?:0)
        lblQuestion.text = question.question
        rdAnswer1.text=question.answer[0].answer
        rdAnswer2.text=question.answer[1].answer
        rdAnswer3.text=question.answer[2].answer
        rdAnswer4.text=question.answer[3].answer

    }

    private fun changeTittle(it: Int) {
        (requireActivity() as AppCompatActivity).supportActionBar?.setTitle("Question "+it+"/"+number)
    }

    private fun setupViews() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }
    }

}
