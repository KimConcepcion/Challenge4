package dk.pme.kim.challenge4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.ViewManager
import android.widget.LinearLayout
import android.widget.SearchView
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity()
{
    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    fun vRecycler_init(aList : ArrayList<Repository>){
        //  Linear layout, since I want the recyclerview to function like a listview:
        viewManager = LinearLayoutManager(this)
        viewAdapter = Repository_Adapter(aList, applicationContext)


        recyclerView  = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Setup toolbar:
        setSupportActionBar(my_toolbar)

        //  Test list:
        val testList = ArrayList<Repository>()
        testList.add(Repository("First", "Kim", "", 3))
        testList.add(Repository("Second", "Frank", "", 5))

        vRecycler_init(testList)
    }
}