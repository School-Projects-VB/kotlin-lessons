package com.example.kotlintest

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.example.kotlintest.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar

private const val MENU_ID_TIME_PICKER = 1
private const val MENU_ID_DATE_PICKER = 2
private const val MENU_ID_ALERT_DIALOG = 3
private const val MENU_ID_METEO = 4

@SuppressLint("SimpleDateFormat")
val SDF = SimpleDateFormat("dd/MM/yy HH:mm")

class MainActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btValidate.setOnClickListener(this)
        binding.btCancel.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val imageView = binding.ivAndroid

        when(view) {
            binding.btValidate -> {imageView.setImageResource(R.drawable.ic_baseline_flag_24)}
            binding.btCancel -> {imageView.setImageResource(R.drawable.ic_baseline_delete_forever_24)}
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, MENU_ID_TIME_PICKER, 0, "TimePicker")
        menu.add(0, MENU_ID_DATE_PICKER, 0, "DatePicker")
        menu.add(0, MENU_ID_ALERT_DIALOG, 0, "AlertDialog")
        menu.add(0, MENU_ID_METEO, 0, "Météo")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_ID_TIME_PICKER -> TimePickerDialog(this, this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
            MENU_ID_DATE_PICKER -> DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
            MENU_ID_ALERT_DIALOG -> AlertDialog.Builder(this).setTitle("Mon titre").setMessage("Afficher un toast").setPositiveButton("OK") {dialog, which -> Toast.makeText(this, "Ceci est un toast", Toast.LENGTH_SHORT).show()}.setIcon(R.mipmap.ic_launcher).show()
            MENU_ID_METEO -> {
                intent = Intent(this, WeatherActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)

        Toast.makeText(this, SDF.format(calendar.time), Toast.LENGTH_SHORT).show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(year, month, dayOfMonth)
        Toast.makeText(this, SDF.format(calendar.time), Toast.LENGTH_SHORT).show()
    }
}