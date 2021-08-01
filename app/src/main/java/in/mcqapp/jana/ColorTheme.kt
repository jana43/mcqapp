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

class ColorTheme : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.color_theme)

    }

    fun themeChange(v: View){  
            
            val sharedPrefFile = "scrolldata"  
            val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
            val theme = v.getTag().toString()
            val themeKey = "my.mcq.themekey"
            sharedPreferences.edit().putString(themeKey, theme).apply()
            
            val intent = Intent(this@ColorTheme, MainActivity::class.java )
            Toast.makeText(this@ColorTheme, "theme change", Toast.LENGTH_SHORT).show()
            startActivity(intent)
    }  


    

    

     
}