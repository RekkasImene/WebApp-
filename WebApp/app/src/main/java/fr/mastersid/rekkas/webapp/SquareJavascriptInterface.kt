package fr.mastersid.rekkas.webapp

import android.webkit.JavascriptInterface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SquareJavascriptInterface : ViewModel(){

    private val _square = MutableLiveData (0)
    val square : LiveData<Int>
        get () = _square

    @JavascriptInterface
    fun calculSquare(sq : Int) {
        _square.postValue(sq*sq)
    }
}