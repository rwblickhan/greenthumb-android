package com.example.sherryuan.greenthumb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import android.support.design.widget.FloatingActionButton
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView: GridView = findViewById(R.id.gridview)
        gridView.adapter = PlantAdapter(this)

        gridView.onItemClickListener =
                AdapterView.OnItemClickListener { parent, v, position, id ->
                    Toast.makeText(this, "$position", Toast.LENGTH_SHORT).show()
                }

        val fab: FloatingActionButton = findViewById(R.id.floating_action_button)
        fab.setOnClickListener { _ ->
            startActivity(Intent(this, AddPlantActivity::class.java))
        }
    }
}
