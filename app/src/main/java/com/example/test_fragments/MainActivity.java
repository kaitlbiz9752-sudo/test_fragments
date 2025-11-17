package com.example.test_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des boutons
        btn1 = findViewById(R.id.btnFragment1);
        btn2 = findViewById(R.id.btnFragment2);

        // Afficher FragmentOne au démarrage (pas dans la back stack)
        if (savedInstanceState == null) {
            replaceFragment(new FragmentOne(), false);
        }

        // Clic sur bouton 1 → affiche FragmentOne
        btn1.setOnClickListener(v ->
                replaceFragment(new FragmentOne(), true)
        );

        // Clic sur bouton 2 → affiche FragmentTwo
        btn2.setOnClickListener(v ->
                replaceFragment(new FragmentTwo(), true)
        );
    }

    /**
     * Remplace le fragment actuellement affiché dans le FrameLayout
     * @param fragment        : le nouveau fragment à afficher
     * @param addToBackStack  : true → on ajoute la transaction à la pile de retour
     */
    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // Remplacer le contenu du FrameLayout (fragment_container)
        ft.replace(R.id.fragment_container, fragment);

        // Permet de revenir au fragment précédent avec le bouton Back
        if (addToBackStack) {
            ft.addToBackStack(null);
        }

        // Appliquer la transaction
        ft.commit();
    }
}
