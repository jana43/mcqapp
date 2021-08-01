package `in`.mcqapp.jana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView;
import android.widget.Toast  
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import android.util.Log
import android.content.Intent
import android.view.View
import android.content.SharedPreferences  
import android.content.Context 


class MainActivity : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val themeKey = "my.mcq.themekey"

        val sharedPrefFile = "scrolldata"  
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
       
        
//        getTheme()applyStyle(R.style.OverlayThemeLime, true) in Java
//        theme.applyStyle(R.style.OverlayThemeBlue, true) // -> Replaced
        when (sharedPreferences.getString(themeKey, "default")) {
            "default" -> println("hash")
            "purpleTheme" ->  theme.applyStyle(R.style.purpleTheme, true)
            "blackTheme" ->  theme.applyStyle(R.style.blackTheme, true)
           
        }

        
        setContentView(R.layout.activity_main)

    }

    fun clickButton(v: View){  
            val pageNumber = v.getTag().toString()
            val intent = Intent(this@MainActivity, QuestionPage::class.java )
            intent.putExtra("chapterName",pageNumber)
            startActivity(intent)
    }  


    fun colorthemeChange(v: View){  
            val intent = Intent(this@MainActivity, ColorTheme::class.java )
            startActivity(intent)
    }  


    

    

    

     
}