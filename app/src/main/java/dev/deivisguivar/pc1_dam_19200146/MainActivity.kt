package dev.deivisguivar.pc1_dam_19200146

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import dev.deivisguivar.pc1_dam_19200146.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Tu layout principal con el DrawerLayout

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        // Listener para manejar la navegación entre los fragments
        navigationView.setNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.nav_equipos -> {
                    selectedFragment = EquiposFragment()
                }
                R.id.nav_futbolistas -> {
                    selectedFragment = FutbolistasFragment()
                }
                R.id.nav_rendimiento -> {
                    selectedFragment = RendimientoFragment()
                }
            }

            // Cambiamos el fragmento si se seleccionó uno
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
            }

            drawerLayout.closeDrawer(GravityCompat.START)  // Cerramos el drawer después de la selección
            true
        }
    }
}