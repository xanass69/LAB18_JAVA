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

### screenshots

1. ACCUEIL
 <img width="184" height="365" alt="01scrn" src="https://github.com/user-attachments/assets/42c8db57-48d7-48b8-b69b-03b150b70645" />

2. PROBLEM DE ROTATE, APRES INCREMENTATION DE 10 REVIENS a 0
<img width="235" height="123" alt="rotatee" src="https://github.com/user-attachments/assets/6e60b9db-3bee-43cd-9c1b-c70beb3ab0e0" />

3. AVEC VIEW MODEL, INCREMENTATION 15
<img width="188" height="359" alt="15fois" src="https://github.com/user-attachments/assets/a0798f03-9202-4eb9-b424-bfd2141acf8d" />

4. PROBLEM RESOLU APRES ROTATE
   <img width="226" height="117" alt="rotatework" src="https://github.com/user-attachments/assets/846ebeac-7972-4b3f-8d47-b5c4f54d72cd" />





