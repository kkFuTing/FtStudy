package com.futing.myjetpack.lsn4_navigationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.futing.myjetpack.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        findViewById(R.id.action_page1);
        bottomNavigationView=findViewById(R.id.nav_view);
//        NavController controller=Navigation.findNavController(this,R.id.my_nav_host_fragment);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        //绑定它就可以用；了
        NavController controller = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(bottomNavigationView,controller);


        //官网代码
//        val finalHost = NavHostFragment.create(R.navigation.nav_graph_main)
//        supportFragmentManager.beginTransaction()
//                .replace(R.id.ll_fragment_navigation, finalHost)
//                .setPrimaryNavigationFragment(finalHost)
//                .commit();
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
//        return NavHostFragment.findNavController(fragment).navigateUp();
//    }
}

