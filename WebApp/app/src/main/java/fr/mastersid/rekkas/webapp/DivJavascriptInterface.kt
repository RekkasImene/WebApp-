package fr.mastersid.rekkas.webapp

import android.webkit.JavascriptInterface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DivJavascriptInterface : ViewModel(){

    private val _div = MutableLiveData (7)
    val div : LiveData<Int>
        get () = _div

    @JavascriptInterface
    fun countDiv(num : Int) {
        var cmpt=0
        viewModelScope.launch(Dispatchers.IO) {
            for (i in 1..num) {
                if (num % i == 0) {
                    cmpt +=1
                }

            }
            _div.postValue(cmpt)
        }

    }
}