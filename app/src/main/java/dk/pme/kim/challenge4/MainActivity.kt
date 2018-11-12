package dk.pme.kim.challenge4

//  Remember to use android.support.v7.widget.SearchView.
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.ViewManager
import android.widget.LinearLayout
import android.support.v7.widget.SearchView
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity()
{
    private lateinit var recyclerView : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    //  Initialize recyclerview:
    fun vRecycler_init(aList : ArrayList<Repository>){

        //  Linear layout, since I want the recyclerview to function like a listview:
        viewManager = LinearLayoutManager(this)
        viewAdapter = Repository_Adapter(aList, applicationContext)

        recyclerView  = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val srchItem = menu?.findItem(R.id.search_bar)

        if(srchItem != null){
            val srchView = srchItem.actionView as SearchView
            srchView.layoutParams = ActionBar.LayoutParams(Gravity.RIGHT)
            srchView.queryHint = "Search repository here..."

            srchView.isIconified = false
            srchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    //  Call API here

                    //  If query(your search is not empty)
                    if(query != null){
                        Toast.makeText(baseContext, query, Toast.LENGTH_SHORT).show()
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    //  onCreate()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(my_toolbar) //  Setup toolbar to main activity
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //  Test list:
        val testList = ArrayList<Repository>()
        testList.add(Repository("First", "Kim", "", 3))
        testList.add(Repository("Second", "Frank", "", 5))

        vRecycler_init(testList)
    }
}