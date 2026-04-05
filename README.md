# ViewModel & LiveData Demo Enrichi

## 🎯 Objectifs du Lab

Ce projet démontre de manière pratique pourquoi et comment utiliser **ViewModel** et **LiveData** (ou StateFlow) pour résoudre le problème classique de la perte de données lors des changements de configuration (rotation d'écran, changement de thème, etc.).

## 📚 Concepts couverts

- ✅ Pourquoi une variable classique est perdue à chaque rotation d'écran
- ✅ Les limites de `onSaveInstanceState()` (ancienne méthode)
- ✅ Comment `ViewModel` survit à la destruction/re-création d'une Activity
- ✅ `LiveData` / `StateFlow` : des observables "lifecycle-aware"
- ✅ Bonnes pratiques Android 2026 (Jetpack Compose + ViewModel)

## 🏗️ Structure du projet
app/
├── src/main/java/.../
│ ├── MainActivity.kt # Interface utilisateur (Compose)
│ └── CounterViewModel.kt # Logique métier + état
├── src/main/res/ # Ressources (thèmes, icônes)
└── build.gradle.kts # Dépendances


## 🚀 Comment exécuter le projet

### Prérequis
- Android Studio (Dernière version stable)
- SDK Android API 24 ou supérieur
- Émulateur ou appareil physique

### Étapes
1. Clone ou télécharge ce projet
2. Ouvre-le dans Android Studio
3. Synchronise les dépendances Gradle (Sync Now)
4. Lance l'application (Shift + F10)

## 🧪 Scénarios de test

### ✅ Ce qui fonctionne (Version ViewModel)
| Action | Résultat attendu |
|--------|------------------|
| Incrémenter/Décrémenter | Le compteur change |
| Rotation d'écran | Le compteur reste à la même valeur |
| Changement de thème | Le compteur persiste |
| Process death (kill app) | Le compteur est conservé |

### ❌ Problème résolu
```kotlin
// Sans ViewModel - La variable est PERDUE à la rotation !
private var count = 0  

// Avec ViewModel - L'état SURVIT !
class CounterViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()
}