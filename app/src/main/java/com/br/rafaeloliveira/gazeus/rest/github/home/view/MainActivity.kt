package com.br.rafaeloliveira.gazeus.rest.github.home.view

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.rafaeloliveira.gazeus.rest.github.R
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import com.br.rafaeloliveira.gazeus.rest.github.di.AppModules
import com.br.rafaeloliveira.gazeus.rest.github.home.view.adapter.RepoNameAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module


class MainActivity : AppCompatActivity(), RepoNameAdapter.OnRepoClickListener {

    private lateinit var searchView: SearchView
    private val viewModel by inject<HomeViewModel>()
    private var adapter : RepoNameAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(applicationContext)
            modules(module {
                factory {  }
            })

            val listModules = listOf(AppModules.loadDomainModule())
            modules(listModules)
        }
        rvReposUser.layoutManager = LinearLayoutManager(this)
        setupObservers()


    }

    override fun onBackPressed() {
        if (searchView != null && !searchView.isIconified) {
            searchView.onActionViewCollapsed()
        } else {
            super.onBackPressed();
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        if (searchItem != null) {
            searchView = MenuItemCompat.getActionView(searchItem) as SearchView
            searchView.setOnCloseListener(object : SearchView.OnCloseListener {
                override fun onClose(): Boolean {
                    return true
                }
            })

            val searchPlate =
                searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
            searchPlate.hint = "Pesquisa"

            val searchPlateView: View =
                searchView.findViewById(androidx.appcompat.R.id.search_plate)
            searchPlateView.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    android.R.color.transparent
                )
            )

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {

                    if(query != null && query.length >= 3) {

                        viewModel.getRepoNameUser(query)
                    }

                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    return false
                }

            })

            val searchManager =
                getSystemService(Context.SEARCH_SERVICE) as SearchManager
            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        }

        return super.onCreateOptionsMenu(menu)

    }

    private fun setupObservers() {

        viewModel.command.observe(this , Observer {

            when(it) {

                is HomeCommand.SuccessQueryRepo -> {

                    if(it.items != null && it.items.count() > 0) {
                        adapter = RepoNameAdapter(it.items.toMutableList(), this)
                        rvReposUser.adapter = adapter
                    } else {
                        alertNotItemRepoName()
                    }

                }
                else -> {
                    alertNotItemRepoName()
                }
            }
        })
    }

    private fun alertNotItemRepoName() {
        Toast.makeText(this@MainActivity, getString(R.string.text_not_repo_name_user), Toast.LENGTH_LONG).show()

    }

    override fun onClickItemRepo(repos: Repos) {

        Log.i("Item selecionado" , repos.id.toString())
    }
}