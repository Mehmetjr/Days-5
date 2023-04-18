package com.example.days_5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var btn_alert : Button
    lateinit var btn_context_menu : Button
    lateinit var listContext: ListView
    var itemSelect =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arr = resources.getStringArray(R.array.cities)
        btn_context_menu = findViewById(R.id.btn_context_menu)
        btn_alert = findViewById(R.id.btn_alert)
        listContext = findViewById(R.id.listContext)
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr)
        listContext.adapter = adapter


        for (item in arr){
            print(item)

        }
        listContext.setOnItemLongClickListener { adapterView, view, i, l ->
            itemSelect = arr[i]
            false
        }

        // context register
        registerForContextMenu(btn_context_menu)
        registerForContextMenu(listContext)


        btn_alert.setOnClickListener {
            alertDialog()
        }


    }

    //menü tutucu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    //menü itemlera tıklanınca
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.profile ->{

            }
            R.id.settings ->{

            }
            R.id.logout ->{
                alertDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun alertDialog(){

        var titleView = layoutInflater.inflate(R.layout.custom_alert,null)
        var alert = AlertDialog.Builder(this)
        alert.setCustomTitle(titleView!!)
        alert.setMessage("Are you sure?")
        alert.setCancelable(false)//boşluğa tıklayınca gitmez
        //buttons
        alert.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->

        })
        alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->

        })
        //alert.setIcon(R.drawable.info_icon)
        alert.show()
    }
    //context menu confıg
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.main_menu,menu)
    }

    //seçilen item da ne yapılacak
    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

            R.id.profile -> {
                Log.d("profile",itemSelect)
            }
            R.id.settings -> {
                Log.d("settings",itemSelect)
            }
            R.id.logout -> {
                Log.d("logout",itemSelect)
            }
        }
        return true
    }
}