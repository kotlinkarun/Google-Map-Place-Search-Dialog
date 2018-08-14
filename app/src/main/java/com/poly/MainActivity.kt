package com.poly

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import com.codemybrainsout.placesearch.PlaceSearchDialog
import kotlinx.android.synthetic.main.activity_maps.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        etLocation.setOnTouchListener {_,motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                showPlacePickerDialog()
            }
            false
        }
    }

    private fun showPlacePickerDialog() {

        val placeSearchDialog = PlaceSearchDialog.Builder(this)
                //.setHeaderImage(R.drawable.dialog_header)
                .setLocationNameListener {
                    locationName -> etLocation.setText(locationName)   }
                .build()
        placeSearchDialog.show()
    }
}