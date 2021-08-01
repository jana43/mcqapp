package `in`.mcqapp.jana
import android.os.Bundle  
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.appcompat.app.AlertDialog
import android.content.SharedPreferences  
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class CustomAdapter(
   private var context: Context,
   private var Question: ArrayList<String>,
   private var OptionA: ArrayList<String>,
   private var OptionB: ArrayList<String>,
   private var OptionC: ArrayList<String>,
   private var OptionD: ArrayList<String>,
   private var Answer: ArrayList<String>,
   private var Solution: ArrayList<String>

 
 
) :
RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
      return MyViewHolder(v)
   }
   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      // set the data in items
      holder.Question.text = "$position. " + Question[position]
      holder.OptionA.text = "A. " + OptionA[position]
      holder.OptionB.text = "B. "+OptionB[position]
      holder.OptionC.text = "C. "+OptionC[position]
      holder.OptionD.text = "D. "+OptionD[position]
      holder.Answer.text = Answer[position]
      holder.Solution.text = Solution[position]
      
     



     
      
      // implement setOnClickListener event on item view.
      holder.itemView.setOnLongClickListener { // display a toast with person name on item click
         
         println("nothing working here")
         Toast.makeText(context, "Clicked Laugh Vote", Toast.LENGTH_SHORT).show();
          
         return@setOnLongClickListener true

       
         
         
      }

      holder.Button.setOnClickListener{
         var con = holder.Answer.visibility
         

         if(con != 0){
            holder.Answer.visibility = View.VISIBLE
            holder.Solution.visibility = View.VISIBLE
            holder.Button.setText("Hide")
         }else if(con == 0){
            holder.Answer.visibility = View.GONE
            holder.Solution.visibility = View.GONE
            holder.Button.setText("Show")
         }
         println("########################################################################")
         println(con)
         
         

      }
   }
   override fun getItemCount(): Int {
      return Question.size
   }
   inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
      var Question: TextView = itemView.findViewById<View>(R.id.tvQuestion) as TextView
      var OptionA: TextView = itemView.findViewById<View>(R.id.tvOptionA) as TextView
      var OptionB: TextView = itemView.findViewById<View>(R.id.tvOptionB) as TextView
      var OptionC: TextView = itemView.findViewById<View>(R.id.tvOptionC) as TextView
      var OptionD: TextView = itemView.findViewById<View>(R.id.tvOptionD) as TextView
      var Answer: TextView = itemView.findViewById<View>(R.id.tvAnswer) as TextView
      var Solution: TextView = itemView.findViewById<View>(R.id.tvSolution) as TextView
      
      var Button: TextView = itemView.findViewById<View>(R.id.button) as Button
   }
}