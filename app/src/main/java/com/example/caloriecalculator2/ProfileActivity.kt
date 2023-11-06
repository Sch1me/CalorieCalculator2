package com.example.caloriecalculator2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.caloriecalculator2.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
     var changeStats : Boolean = false //ako je false, onda se ne prikazuje

    companion object {
        var weightArrayList = ArrayList<String>()
        var waterArrayList = ArrayList<String>()
        var caloriesArrayList = ArrayList<String>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardViewChange = binding.CardViewChange
       val cardViewShow = binding.CardViewShow

        //values za text koji se sam mjenja
        val textViewCalorie = binding.calorieGoalNumTxt
        val textViewWeight = binding.weightNumTxt
        val textViewWater = binding.waterGoalNumTxt
        //values za text koji user mijenja
        val textViewCalorieShow = binding.calorieGoalTxtNumShow
        val textViewWeightShow = binding.weightTxtNumShow
        val textViewWaterShow = binding.waterGoalTxtNumShow

        //kemijanje
        if(waterArrayList.isEmpty() || weightArrayList.isEmpty() || caloriesArrayList.isEmpty()){

            textViewCalorieShow.text = " kcal"
            textViewWaterShow.text = " liter"
            textViewWeightShow.text = " kg"

        }else{
            textViewCalorieShow.text = caloriesArrayList.last().toString() + " kcal"
            textViewWaterShow.text = waterArrayList.last().toString() + " liter"
            textViewWeightShow.text = weightArrayList.last().toString() + " kg"
        }

        binding.waterButtonIMG.setOnClickListener {

            intent = Intent(this,WaterActivity::class.java)
            startActivity(intent)
        }

        binding.foodButtonIMG.setOnClickListener {

            intent = Intent(this,FoodActivity::class.java)
            startActivity(intent)
        }

        binding.homeButtonIMG.setOnClickListener {

            intent = Intent(this,PocetnaActivity::class.java)
            startActivity(intent)
        }

        binding.goToProgressBtn.setOnClickListener{
            if(weightArrayList.isEmpty() && caloriesArrayList.isEmpty() && waterArrayList.isEmpty()){
                Toast.makeText(this, "Unesi svoje stats", Toast.LENGTH_SHORT).show()
            }
            else{
            intent = Intent(this,ProgressActivity::class.java)
            intent.putExtra("calories", caloriesArrayList.last().toString() + " kcal")
            intent.putExtra("weight", weightArrayList.last().toString() + " kg")
            intent.putExtra("water", waterArrayList.last().toString() + " liter")
            startActivity(intent)
            }

        }


        if(changeStats == false){
            cardViewChange.visibility = View.GONE
            changeStats = false
            cardViewShow.visibility = View.VISIBLE
            binding.changeStatsBtnFAKE.visibility = View.GONE
        }



            binding.changeStatsBtn.setOnClickListener{

                if(!changeStats){
                    changeStats = true //kad klikne upali ovaj za promjeniti
                    cardViewChange.visibility = View.VISIBLE
                    cardViewShow.visibility = View.GONE
                    binding.goToProgressBtn.visibility = View.GONE
                    binding.changeStatsBtn.visibility = View.GONE
                    binding.changeStatsBtnFAKE.visibility = View.VISIBLE
                }
            binding.changeStatsBtnFAKE.setOnClickListener {
                if(changeStats) {

                        textViewCalorieShow.text = textViewCalorie.text.toString() + " kcal"
                        textViewWaterShow.text = textViewWater.text.toString() + " liter"
                        textViewWeightShow.text = textViewWeight.text.toString() + " kg"

                        waterArrayList.add(textViewWater.text.toString())
                        weightArrayList.add(textViewWeight.text.toString())
                        caloriesArrayList.add(textViewCalorie.text.toString())
                        //gasi ovaj za promjeniti i pali normalan
                        changeStats = false
                        cardViewChange.visibility = View.GONE
                        cardViewShow.visibility = View.VISIBLE
                        binding.goToProgressBtn.visibility = View.VISIBLE
                        binding.changeStatsBtn.visibility = View.VISIBLE
                        binding.changeStatsBtnFAKE.visibility = View.GONE

                    }
                }




    }
}}
