package fr.mastersid.rekkas.webapp

import android.webkit.JavascriptInterface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class ToasterJavascriptInterface {

    private val _message = MutableLiveData ("")
    val message : LiveData<String>
        get () = _message

    @JavascriptInterface
    fun showToast(msg : String) {
            _message.postValue(msg)
    }
}

