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

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Setup toolbar:
        setSupportActionBar(my_toolbar)

        //  Linear layout, since I want the recyclerview to function like a listview:
        viewManager = LinearLayoutManager(this)
        viewAdapter = Repository_Adapter()

        recyclerView  = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //  First we should inflate the empty menu with the menu xml file:
        menuInflater.inflate(R.menu.search_menu, menu)

        //  Find id of views in menu - searchbar:
        val searchItem = menu?.findItem(R.id.search_bar)

        if(searchItem != null)
        {
            val searchView = searchItem.actionView as SearchView
        }

        return super.onCreateOptionsMenu(menu)
    }
}
