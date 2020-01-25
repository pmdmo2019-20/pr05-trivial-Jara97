package es.iessaladillo.pedrojoya.pr05_trivial.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.db.Question
import es.iessaladillo.pedrojoya.pr05_trivial.db.getQuestions

class MainActivityViewModel : ViewModel() {

    private var questionList: List<Question> = emptyList()

    private val _fragment: MutableLiveData<Int> = MutableLiveData()
    val fragment: LiveData<Int>
        get() = _fragment

    private val _questionNum: MutableLiveData<Int> = MutableLiveData(1)
    val questionNum: LiveData<Int>
        get() = _questionNum

    fun setFragment(fragment: Int) {
        _fragment.value=fragment
    }

    fun loadQuestions(number:Int){
        questionList= getQuestions().subList(0,number)
    }

    fun getQuestion(number:Int):Question{
        return questionList[number-1]
    }

    fun nextQuestion(){
        if(_questionNum.value!=5){
            _questionNum.value= _questionNum.value?.plus(1)
        }
    }

}