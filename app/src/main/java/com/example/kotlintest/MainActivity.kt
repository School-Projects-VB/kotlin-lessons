package com.example.kotlintest

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.kotlintest.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity(), View.OnClickListener {

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
        menu.add(0, 1, 0, "foo")
        menu.add(0, 2, 0, "bar")
        menu.add(0, 3, 0, "baz")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val timePickerDialogListener: TimePickerDialog.OnTimeSetListener =
            TimePickerDialog.OnTimeSetListener { context, hour, minute -> Toast.makeText(this, "La nouvelle heure est ${hour}:${minute}", Toast.LENGTH_LONG).show() }
        val datePickerDialogListener: DatePickerDialog.OnDateSetListener =
            DatePickerDialog.OnDateSetListener {context, year, month, day -> Toast.makeText(this, "La nouvelle date est ${day}/${month+1}/${year}", Toast.LENGTH_LONG).show()}
        val alert = AlertDialog.Builder(this)
        when (item.itemId) {
            1 -> TimePickerDialog(this, timePickerDialogListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
            2 -> DatePickerDialog(this, datePickerDialogListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()
            3 -> alert.setTitle("Mon titre").setMessage("Afficher un toast").setPositiveButton("OK") {dialog, which -> Toast.makeText(this, "Ceci est un toast", Toast.LENGTH_SHORT).show()}.setIcon(R.mipmap.ic_launcher).show()
        }
        return super.onOptionsItemSelected(item)
    }
}