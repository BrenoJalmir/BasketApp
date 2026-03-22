# BasketApp 🏀

**Autores:** Breno Jalmir de Medeiros Almeida, Felipe Madureira de Almeida

**Descrição:** Aplicativo Android para simulação de placar de basquete.

## Identificação do projeto

- **Projeto:** `BasketApp`
- **Application ID:** ver `build.gradle.kts:15`

## Versões do projeto

- **Gradle Wrapper:** `9.3.1` (`gradle-wrapper.properties:5`)
- **Android Gradle Plugin (AGP):** `9.1.0` (`libs.versions.toml:2`)
- **Kotlin (plugin compose):** `2.2.10` (`libs.versions.toml:9`)
- **Compose BOM:** `2024.09.00` (`libs.versions.toml:10`)
- **Java Toolchain do Gradle Daemon:** `21` (`gradle-daemon-jvm.properties:12`)
- **Source/Target Compatibility do módulo app:** `Java 11` (`build.gradle.kts:34`, `build.gradle.kts:35`)
- **compileSdk:** `36` (`build.gradle.kts:8`, `build.gradle.kts:9`)
- **targetSdk:** `36` (`build.gradle.kts:17`)
- **minSdk:** `24` (`build.gradle.kts:16`)
- **versionName:** `1.0` (`build.gradle.kts:19`)

## Requisitos

- Android Studio atualizado (preferencialmente panda 2)
- SDK Android instalado para API 36
- JDK 21 disponível no ambiente
- Dispositivo Android ou emulador configurado

## Como rodar o projeto

### 1. Clonar e entrar na pasta
```
git clone https://github.com/BrenoJalmir/BasketApp.git
cd BasketApp
```

### 2. Realizar o build do projeto

No Windows:
```
gradlew.bat build
```

No Linux/macOS:
```
./gradlew build
```

### 3. Instalar e executar no dispositivo/emulador
Com um dispositivo/emulador já conectado:

No Windows:
```
gradlew.bat installDebug
```

No Linux/macOS:
```
./gradlew installDebug
```

Depois abra o app **BasketApp** no dispositivo.


## Estrutura principal
Módulo principal Android: build.gradle.kts
Configuração de versões: libs.versions.toml
Gradle Wrapper: gradle-wrapper.properties
Configuração do projeto: settings.gradle.kts
