## 🗺️ Feuille de route interactive – Spring Framework (version personnalisée sur 10 semaines)

### 🔄 Rythme : 5 jours/semaine, 2 à 4h/jour

### 🟢 Ce que tu as déjà commencé à explorer

* Tu travailles déjà sur **une API REST** avec ArrayList → un **gestionnaire de visites d’hôpital** qui **génère un rapport de chaque visite**.
* Tu explores aussi **les DTOs avec mapping** en même temps que l’API REST.
* Il te manque seulement `@Autowired` pour finaliser la base du Spring Core.

---

### ✅ Semaine 1 – Spring Core : IoC et DI *(à faire normalement)*

* [ ] Comprendre l'Inversion of Control (IoC)
* [ ] Utiliser `@Component`, `@Autowired`, `@Service`, `@Repository`
* [ ] Créer une configuration avec `@Configuration` et `@Bean`
* [ ] Mini projet : construire une calculatrice modulaire avec injection de dépendances (addition, soustraction, etc.)

---

### ⚙️ Semaine 2 – Spring Boot + API REST + DTOs *(fusionné avec ce que tu fais déjà)*

* [ ] Générer un projet via [https://start.spring.io](https://start.spring.io)
* [ ] Comprendre `@SpringBootApplication` et l’auto-configuration
* [ ] Lire et modifier `application.properties`
* [ ] Créer des contrôleurs REST (`@RestController`, `@GetMapping`, etc.)
* [ ] Créer des DTOs pour requests/responses (et mappeurs associés)
* [ ] Mini projet : continuer le **gestionnaire de visites d’hôpital** (ajouter CRUD + génération d’un rapport simple avec DTO)

---

### 🗃️ Semaine 3 – Spring Data JPA : CRUD de base

* [ ] Définir des entités (`@Entity`, `@Id`, `@GeneratedValue`)
* [ ] Créer des interfaces `JpaRepository`
* [ ] Configurer H2 ou PostgreSQL localement
* [ ] Mini projet : persister les visites, les patients, et les docteurs dans ton API hôpital

---

### 🗃️ Semaine 4 – JPA : relations et requêtes personnalisées

* [ ] Gérer les relations `@OneToMany`, `@ManyToOne`, `@ManyToMany`
* [ ] Comprendre `mappedBy`, `@JoinColumn`, `cascade`
* [ ] Créer des requêtes avec `@Query`
* [ ] Mini projet : permettre de consulter l’historique de visite d’un patient, les visites d’un médecin, etc.

---

### 📦 Semaine 5 – Validation & gestion d’erreurs *(DTOs vus plus tôt)*

* [ ] Utiliser `@Valid`, `@NotBlank`, `@Email`, etc.
* [ ] Gérer les exceptions avec `@ControllerAdvice`
* [ ] Mini projet : retour d’erreurs lisibles dans ton API hôpital (ex : patient non trouvé, données invalides, etc.)

---

### 🔐 Semaine 6 – Spring Security : login simple avec formulaire ou basic auth

* [ ] Ajouter Spring Security
* [ ] Protéger certaines routes (CRUD patient par ex.)
* [ ] Implémenter `UserDetailsService` personnalisé
* [ ] Mini projet : restreindre l’accès au module de génération de rapports à des utilisateurs authentifiés

---

### 🔐 Semaine 7 – Sécurité avancée avec JWT

* [ ] Ajouter JWT (ex: `jjwt`, `java-jwt`, etc.)
* [ ] Générer un token lors de l’authentification
* [ ] Intercepter les requêtes avec un filtre JWT
* [ ] Extraire l’utilisateur du token et autoriser selon les rôles
* [ ] Mini projet : gestion de rôles "admin" (gestion patients, docteurs) / "visiteur" (lecture seule)

---

### 🧪 Semaine 8 – Tests unitaires et d’intégration

* [ ] Tester les services avec JUnit + Mockito
* [ ] Utiliser `@WebMvcTest` pour les contrôleurs
* [ ] `@SpringBootTest` pour tests d’intégration complets
* [ ] Mini projet : tester les endpoints clés de ton API hôpital

---

### ✉️ Semaine 9 – Modules utiles

* [ ] Envoyer un email avec `JavaMailSender` (confirmation d’une visite, par exemple)
* [ ] Planifier une tâche avec `@Scheduled` (génération automatique de rapport, archivage...)
* [ ] Gérer l'upload de fichiers (ex : fichiers joints dans les rapports)
* [ ] Mini projet : automatiser une tâche quotidienne dans l’application hôpital (ex: synthèse journalière)

---

### 🚀 Semaine 10 – Préparation à la mise en production

* [ ] Créer les profils `dev`, `test`, `prod`
* [ ] Générer le `.jar` final avec Maven
* [ ] Déployer l’API sur un service cloud (Heroku, Railway, Render…)
* [ ] Mini projet : déployer ton gestionnaire de visites hospitalières en ligne + README d’installation

---

Souhaites-tu que je te propose un **modèle de structure de dossiers** pour ce projet de gestion hospitalière, ou des **exemples de fichiers `VisitDTO`, `VisitController`** à titre illustratif ?
