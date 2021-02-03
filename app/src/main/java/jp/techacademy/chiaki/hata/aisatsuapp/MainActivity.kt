package jp.techacademy.chiaki.hata.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(this)
        txt.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn){
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                if (hour >= 2 && hour <= 9) {
                    txt.setText("おはよう")
                } else if (hour >= 10 && hour <= 17){
                    txt.setText("こんにちは")
                } else if (hour >= 18 || hour <= 2){
                    txt.setText("こんばんは")
                }
                Log.d("UI_PARTS", "$hour: $minute")
            },
            12, 0, true)

        timePickerDialog.show()
    }
}