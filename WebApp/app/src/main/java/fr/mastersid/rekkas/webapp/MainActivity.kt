package fr.mastersid.rekkas.webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import fr.mastersid.rekkas.webapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView . settings . javaScriptEnabled = true
        binding.webView.loadUrl ("file:///android_asset/index.html")


        val toasterJavascriptInterface = ToasterJavascriptInterface()

        binding.webView.addJavascriptInterface ( toasterJavascriptInterface , "Android")
        toasterJavascriptInterface . message . observe ( this ) { value ->
            if ( value.isNotBlank()) {
                Toast.makeText (this , value , Toast.LENGTH_LONG ).show()
            }
        }
        val squareJavascriptInterface: SquareJavascriptInterface by viewModels()

        binding.webView.addJavascriptInterface(squareJavascriptInterface,"Square")
        squareJavascriptInterface.square.observe(this){value->
            if(value!=null){
                Log.d("Square",value.toString())
                binding.webView.loadUrl("JavaScript:square($value)")
            }
        }

        val divJavascriptInterface:DivJavascriptInterface by viewModels()

        binding.webView.addJavascriptInterface(divJavascriptInterface,"Div")
        divJavascriptInterface.div.observe(this){value->
            if(value!=null){
                Log.d("Diviseur",value.toString())
                binding.webView.loadUrl("JavaScript:div($value)")
            }
        }

    }
}