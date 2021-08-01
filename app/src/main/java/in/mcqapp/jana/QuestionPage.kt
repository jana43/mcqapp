package `in`.mcqapp.jana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView;
import android.widget.TextView;
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

class QuestionPage : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPrefFile = "scrolldata"  
        val chapterName = intent.getStringExtra("chapterName")
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        

        val themeKey = "my.mcq.themekey"

        when (sharedPreferences.getString(themeKey, "default")) {
            "default" -> println("hash")
            "purpleTheme" ->  theme.applyStyle(R.style.purpleTheme, true)
            "blackTheme" ->  theme.applyStyle(R.style.blackTheme, true)
           
        }
        
        setContentView(R.layout.question_page)
        // get reference to ImageView
        
        var Question: ArrayList<String> = ArrayList()
        var OptionA: ArrayList<String> = ArrayList()
        var OptionB: ArrayList<String> = ArrayList()
        var OptionC: ArrayList<String> = ArrayList()
        var OptionD: ArrayList<String> = ArrayList()
        var Answer: ArrayList<String> = ArrayList()
        var Solution: ArrayList<String> = ArrayList()
        var Key: ArrayList<String> = ArrayList()
      

          

        val editor:SharedPreferences.Editor =  sharedPreferences.edit()  
        var cnameVal = sharedPreferences.getInt(chapterName.toString(),0)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
      //   val chapter = findViewById<TextView>(R.id.chapterName)

        
       
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        
        recyclerView.layoutManager = linearLayoutManager
        
        

        //attaches scrollListener with RecyclerView
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener()
        {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int)
            {
               super.onScrolled(recyclerView, dx, dy)
               val position = (recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
               println("#######################################")
               println(position)
               if(position != -1){
                  var pos = position
                  var cname = chapterName.toString()
                  // val editor:SharedPreferences.Editor =  sharedPreferences.edit()  
                  editor.putInt(chapterName.toString(),pos)  
                  editor.apply()  
                  editor.commit()  
               } else {
                  var cnameVal = sharedPreferences.getInt(chapterName.toString(),0)
                  
                  println("************************************************")
                  println(cnameVal)
               }
              

            }
            })


        
        
     
        
        try {
            val obj = JSONObject(loadJSONFromAsset(chapterName.toString()))
            val userArray = obj.getJSONArray("questions")
            println(userArray)
            println(userArray.length())
            for (i in 0 until userArray.length()) {
               val userDetail = userArray.getJSONObject(i)
               println(userDetail)
               Question.add(userDetail.getString("Question"))
               OptionA.add(userDetail.getString("optionA"))
               OptionB.add(userDetail.getString("optionB"))
               OptionC.add(userDetail.getString("optionC"))
               OptionD.add(userDetail.getString("optionD"))
               Answer.add(userDetail.getString("Answar"))
               Solution.add(userDetail.getString("solution"))
              
               
               
               }
            }
        catch (e: JSONException) {
           e.printStackTrace()
        }

        println(Question)

        
        val customAdapter = CustomAdapter(this@QuestionPage, Question, OptionA, OptionB, OptionC , OptionD, Answer, Solution )
      

        recyclerView.scrollToPosition(cnameVal)
        recyclerView.adapter = customAdapter
        
            
        

        

    }


    

    private fun loadJSONFromAsset(chapterName: String): String {
            val json: String?
            try {
               val inputStream = assets.open(chapterName)
               val size = inputStream.available()
               val buffer = ByteArray(size)
               val charset: Charset = Charsets.UTF_8
               inputStream.read(buffer)
               inputStream.close()
               json = String(buffer, charset)
            }
            catch (ex: IOException) {
               ex.printStackTrace()
               return ""
               
            }
            return json
        }

  

   // private fun addScrollerListener()
   //  {
   //      //attaches scrollListener with RecyclerView
   //      recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener()
   //      {
   //          override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int)
   //          {
   //              super.onScrolled(recyclerView, dx, dy)
                
   //          }
   //          })
   //  }

      

     
}