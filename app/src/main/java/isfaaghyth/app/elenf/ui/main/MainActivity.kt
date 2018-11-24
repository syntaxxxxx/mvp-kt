package isfaaghyth.app.elenf.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import isfaaghyth.app.elenf.R
import isfaaghyth.app.elenf.base.BaseActivity
import isfaaghyth.app.elenf.data.entity.Elen
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.ext.android.inject
import isfaaghyth.app.elenf.ui.adapter.ViewPagerAdapter
import isfaaghyth.app.elenf.ui.main.fragment.MainFragment
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by isfaaghyth on 21/11/18.
 * github: @isfaaghyth
 */
class MainActivity: BaseActivity<MainPresenter>(), MainView {

    override fun contentView(): Int = R.layout.activity_main

    private val presenter by inject<MainPresenter>()
    override fun presenter() = presenter

    override fun onCreated(state: Bundle?) {
        presenter.attachView(this)

        setSupportActionBar(toolbar)
        txtTitle.text = "Elen STTNF"
        txtSubTitle.text = "e-learning!"

        tabPrepared()
    }

    private fun tabPrepared() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(MainFragment(), "Due Date")
        adapter.addFragment(MainFragment(), "Courses")
        vpMain.adapter = adapter

        tabMain.setupWithViewPager(vpMain)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.mn_notification -> {
                Log.e("TAG", "Notification!")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}