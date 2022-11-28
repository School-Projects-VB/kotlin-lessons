package com.example.kotlintest

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
        menu.add(0, 25, 0, "foo")
        menu.add(0, 26, 0, "bar")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val timePickerDialogListener: TimePickerDialog.OnTimeSetListener =
            TimePickerDialog.OnTimeSetListener { context, hour, minute -> Toast.makeText(this, "La nouvelle heure est ${hour}:${minute}", Toast.LENGTH_LONG).show() }
        val datePickerDialogListener: DatePickerDialog.OnDateSetListener =
            DatePickerDialog.OnDateSetListener {context, year, month, day -> Toast.makeText(this, "La nouvelle date est ${day}/${month+1}/${year}", Toast.LENGTH_LONG).show()}
        when (item.itemId) {
            25 -> TimePickerDialog(this, timePickerDialogListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
            26 -> DatePickerDialog(this, datePickerDialogListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        return super.onOptionsItemSelected(item)
    }
}