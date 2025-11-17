## TP Android — Gestion des Fragments

- Ce projet présente l’utilisation de fragments dans une activité Android, incluant :

- Le remplacement dynamique de fragments

- La navigation entre fragments avec BackStack

- Les événements du cycle de vie (onResume(), onPause())

- Les interactions dans les fragments (boutons, TextView)

## Structure du projet

<img width="606" height="897" alt="image" src="https://github.com/user-attachments/assets/cb1e8de2-ce0d-4cb3-9e5f-a8bd779b381f" />



## Fonctionnalités principales



 **Affichage d’un fragment au démarrage**

**L'activité charge automatiquement FragmentOne grâce à :**



```text
if (savedInstanceState == null) {
    replaceFragment(new FragmentOne(), false);
}
```



 **Navigation entre fragments**

**L’activité contient deux boutons permettant de remplacer le fragment affiché :**


```text
btn1.setOnClickListener(v -> replaceFragment(new FragmentOne(), true));
btn2.setOnClickListener(v -> replaceFragment(new FragmentTwo(), true));
```



**Gestion de la pile de retour (BackStack)**

**Chaque remplacement peut être ajouté à la pile :**


```text
private void replaceFragment(Fragment fragment, boolean addToBackStack) {
    FragmentTransaction ft = getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, fragment);

    if (addToBackStack) {
        ft.addToBackStack(null);
    }

    ft.commit();
}
```

**Résultat :**


```text
Fragment 1 → Fragment 2 → Back = retour à Fragment 1
```

## Layouts utilisés

**activity_main.xml**


**Contient les deux boutons + le conteneur du fragment :**


```text
<FrameLayout
    android:id="@+id/fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```



**fragment_one.xml**

**Un TextView + un bouton :**



```text
<Button
    android:id="@+id/btnHello"
    android:text="Dire Bonjour" />

<TextView
    android:id="@+id/textOne"
    android:text="Fragment 1" />
```



**fragment_two.xml**



Un layout simple affichant un texte.

## Log du cycle de vie du fragment

**FragmentOne logge les méthodes onResume et onPause :**



```text
@Override
public void onResume() {
    super.onResume();
    Log.d("FragmentOne", "onResume()");
}

@Override
public void onPause() {
    super.onPause();
    Log.d("FragmentOne", "onPause()");
}
```




 **Cela permet de visualiser dans Logcat ce qui se passe lors d’un remplacement de fragment.**

## Technologies utilisées

- Java

- Android Studio

- Fragments (API AndroidX)

- BackStack Navigation

- Logcat pour observer le cycle de vie

## Démonstration Vidéo




https://github.com/user-attachments/assets/75c67e8c-377c-4bbc-bfbc-f55521c3220a




