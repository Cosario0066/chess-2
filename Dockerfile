# --- ÉTAPE 1 : Le build (compilation avec Maven) ---
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copier le fichier de configuration des dépendances
COPY pom.xml .

# Télécharger les dépendances (mise en cache Docker pour aller plus vite)
RUN mvn dependency:go-offline

# Copier le code source
COPY src ./src

# Compiler et empaqueter l'application (génère le fichier .jar dans target/)
RUN mvn clean package -DskipTests

# --- ÉTAPE 2 : L'exécution (conteneur léger final) ---
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copier le fichier JAR généré depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar

# Ouvrir le port 8080 (celui utilisé par Spring Boot)
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]