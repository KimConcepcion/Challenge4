package dk.pme.kim.challenge4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.toolbar.*

class GitHubInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_githubinfo)

        //  Setup toolbar:
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    //  Click listener for open github button:
    fun click_guthub(view : View)
    {
        //  Overvej at lave et webview her...
    }
}