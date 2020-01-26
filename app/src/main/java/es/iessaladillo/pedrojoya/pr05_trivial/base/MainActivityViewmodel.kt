package es.iessaladillo.pedrojoya.pr05_trivial.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.db.Question
import es.iessaladillo.pedrojoya.pr05_trivial.db.getQuestions

class MainActivityViewModel : ViewModel() {

    private var questionList: List<Question> = emptyList()

    var dialog:Boolean=false
    var number:Int =4

    private val _response: MutableLiveData<Boolean> = MutableLiveData()
    val response: LiveData<Boolean>
        get() = _response

    private val _fragment: MutableLiveData<Int> = MutableLiveData()
    val fragment: LiveData<Int>
        get() = _fragment

    private val _questionNum: MutableLiveData<Int> = MutableLiveData(1)
    val questionNum: LiveData<Int>
        get() = _questionNum

    fun setFragment(fragment: Int) {
        _fragment.value=fragment
    }

    fun setResponse(value: Boolean) {
        _response.value = value
    }

    fun loadQuestions(number:Int){
        questionList= getQuestions().subList(0,number)
        _questionNum.value=1
    }

    fun getQuestion(number:Int):Question{
        return questionList[number-1]
    }

    fun nextQuestion(){
        _questionNum.value= _questionNum.value?.plus(1)

    }

}