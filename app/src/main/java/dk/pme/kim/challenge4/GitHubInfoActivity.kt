package dk.pme.kim.challenge4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_githubinfo.*
import kotlinx.android.synthetic.main.list_item_layout.*
import kotlinx.android.synthetic.main.toolbar.*

class GitHubInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_githubinfo)

        //  Setup toolbar:
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getFromIntent()
    }

    //  Receive from intent:
    private fun getFromIntent(){
        if(
                intent.hasExtra("extra_name") &&
                intent.hasExtra("extra_date") &&
                intent.hasExtra("extra_owner") &&
                intent.hasExtra("extra_stars")){

            val name = intent.getStringExtra("extra_name")
            val date = intent.getStringExtra("extra_date")
            val owner = intent.getStringExtra("extra_owner")
            val stars = intent.getStringExtra("extra_stars")

            //  Set toolbar title to repo name:
            supportActionBar?.setTitle(name)

            //  Fill textviews:
            txtRepoAuth.setText(owner)
            txtRepoDate.setText(date)
            txtRepoStars.setText(stars)
        }
    }

    //  Click listener for open github button:
    fun click_github(view : View)
    {
        //  Overvej at lave et webview her...
    }
}