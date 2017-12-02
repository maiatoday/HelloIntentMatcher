package net.maiatoday.hellointentmatcher

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_star.*

class StarActivity : AppCompatActivity() {
    companion object IntentDetail {
        val EXTRA_PARAMS:String = "EXTRA_PARAMS"
        fun intent(context: Context, params:ContrivedParams): Intent {
            val i = Intent(context, StarActivity::class.java)
            i.putExtra(EXTRA_PARAMS, params)
            return i
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star)
        var params = intent.extras.getParcelable<ContrivedParams>(EXTRA_PARAMS)
        requireNotNull(params) { "no params provided in Intent extras" }
        if (params.starCount >= 1) imageView1.setImageResource(R.drawable.ic_star_black_24dp)
        if (params.starCount >= 2) imageView2.setImageResource(R.drawable.ic_star_black_24dp)
        if (params.starCount >= 3) imageView3.setImageResource(R.drawable.ic_star_black_24dp)
        if (params.starCount >= 4) imageView4.setImageResource(R.drawable.ic_star_black_24dp)
        if (params.starCount == 5) imageView5.setImageResource(R.drawable.ic_star_black_24dp)
        setSupportActionBar(starToolbar)
        supportActionBar?.title = params.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val color = Color.parseColor(params.colour)
        starLayout.setBackgroundColor(color)

    }
}
