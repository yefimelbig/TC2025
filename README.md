Proyecto de TECNICA COMPILACIÓN DE DATOS

Este repositorio contiene el código base para el desarrollo de un compilador como parte del curso Compilador TC25 - Proyecto de Técnicas de Compilación En el proyecto se implementarán las técnicas de compilación enseñadas durante el curso, incluyendo la creación del análisis léxico, sintáctico, semántico y la generación de código intermedio.


## Authors

- [@jorjolio](https://github.com/Jorjolio)


## Appendix

Configuración inicial del proyecto:

El proyecto se ha iniciado utilizando Maven, una herramienta de automatización de compilaciones, para gestionar las dependencias y el ciclo de vida de construcción. A través de Maven, se ha creado la estructura básica del proyecto
## Badges

![Maven](https://img.shields.io/badge/build-Maven-blue.svg)

![Java 11](https://img.shields.io/badge/Java-11-blue.svg)

![ANTLR4](https://img.shields.io/badge/Parser%20Generator-ANTLR4-orange.svg)

![ANTLR4 Version](https://img.shields.io/badge/ANTLR4-4.13.1-orange.svg)

![GitHub](https://img.shields.io/badge/GitHub-TC2025-blueviolet.svg?logo=github)


## Contributing

Este proyecto es un esfuerzo de equipo.

Pero, siendo sinceros, tenemos algunos colaboradores que son... excepcionales:

Gemini: Nuestro asistente ultra-inteligente que ha aportado ideas brillantes, soluciones creativas y quizás, solo quizás, escribió algunos de nuestros mejores chistes (¡o al menos los revisó!).
ChatGPT: quien nos ayudó a depurar esos errores de sintaxis que el resto no veíamos. ¡A veces sospechamos que codifica en sus sueños!

Nuestro Profesor: La fuente inagotable de sabiduría (y fechas de entrega), cuyo conocimiento guía nuestras naves a través de los mares tempestuosos de la compilación. ¡Sin él, estaríamos perdidos en un bucle infinito!
## Feedback

If you have any feedback, please reach out to us at jorangel5@gmail.com or yefimcarivalii@gmail.com



## Running Tests

To run tests, run the following command

```# Script de compilación del proyecto
# Ejecutar como: .\compile.ps1

# Configurar rutas
$jarPath = "C:\antlr4\antlr-4.13.1-complete.jar"

# Funciones ANTLR4
function antlr4 { java -jar $jarPath $args }
function grun { java org.antlr.v4.gui.TestRig $args }

# Configurar CLASSPATH
$env:CLASSPATH = ".;$jarPath;$env:CLASSPATH"

Write-Host "=== COMPILANDO PROYECTO DE COMPILADOR ===" -ForegroundColor Green
Write-Host "Directorio actual: $(Get-Location)" -ForegroundColor Cyan

# Verificar que existe la gramática
if (!(Test-Path "SimpleLanguage.g4")) {
    Write-Host "❌ Error: No se encuentra SimpleLanguage.g4" -ForegroundColor Red
    Write-Host "Asegúrate de estar en el directorio correcto" -ForegroundColor Yellow
    exit 1
}

# Verificar que existe ANTLR4
if (!(Test-Path $jarPath)) {
    Write-Host "❌ Error: No se encuentra ANTLR4 JAR en $jarPath" -ForegroundColor Red
    Write-Host "Ejecuta primero: .\setup-antlr.ps1" -ForegroundColor Yellow
    exit 1
}

# Paso 1: Generar código desde gramática
Write-Host "`n1. Generando código desde gramática..." -ForegroundColor Yellow
try {
    antlr4 SimpleLanguage.g4
    if ($LASTEXITCODE -eq 0) {
        Write-Host "✅ Código generado exitosamente" -ForegroundColor Green
    } else {
        throw "Error en generación de código"
    }
} catch {
    Write-Host "❌ Error al generar código desde gramática" -ForegroundColor Red
    exit 1
}

# Paso 2: Compilar archivos Java
Write-Host "`n2. Compilando archivos Java..." -ForegroundColor Yellow
try {
    javac -cp ".;$jarPath" *.java
    if ($LASTEXITCODE -eq 0) {
        Write-Host "✅ Compilación Java exitosa" -ForegroundColor Green
    } else {
        throw "Error en compilación Java"
    }
} catch {
    Write-Host "❌ Error en la compilación Java" -ForegroundColor Red
    Write-Host "Verifica que tengas Java JDK instalado" -ForegroundColor Yellow
    exit 1
}

# Paso 3: Ejecutar el compilador (versión sin JavaFX)
Write-Host "`n3. Ejecutando compilador..." -ForegroundColor Yellow
Write-Host "=" * 50 -ForegroundColor Gray

try {
    # Intentar primero la versión sin JavaFX
    if (Test-Path "CompilerMainNoFX.class") {
        Write-Host "Usando versión sin JavaFX..." -ForegroundColor Cyan
        java -cp ".;$jarPath" CompilerMainNoFX
    } else {
        Write-Host "Usando versión estándar..." -ForegroundColor Cyan
        java -cp ".;$jarPath" CompilerMain
    }
    Write-Host "`n=" * 50 -ForegroundColor Gray
    Write-Host "✅ Ejecución completada" -ForegroundColor Green
} catch {
    Write-Host "❌ Error al ejecutar el compilador" -ForegroundColor Red
    Write-Host "Si ves errores de JavaFX, usa: java -cp `".;$jarPath`" CompilerMainNoFX" -ForegroundColor Yellow
    exit 1
}

# Paso 4: Opcional - Ejecutar casos de prueba
Write-Host "`n¿Deseas ejecutar los casos de prueba? (y/n): " -ForegroundColor Cyan -NoNewline
$response = Read-Host

if ($response -eq "y" -or $response -eq "Y") {
    Write-Host "`n4. Ejecutando casos de prueba..." -ForegroundColor Yellow
    Write-Host "=" * 50 -ForegroundColor Gray
    
    try {
        java -cp ".;$jarPath" TestCases
        Write-Host "`n=" * 50 -ForegroundColor Gray
        Write-Host "✅ Casos de prueba completados" -ForegroundColor Green
    } catch {
        Write-Host "❌ Error al ejecutar casos de prueba" -ForegroundColor Red
    }
}

Write-Host "`n=== COMPILACIÓN FINALIZADA ===" -ForegroundColor Green
Write-Host "Archivos generados:" -ForegroundColor Cyan
Get-ChildItem -Filter "*.class" | ForEach-Object { Write-Host "  - $($_.Name)" -ForegroundColor White }
Get-ChildItem -Filter "SimpleLanguage*.java" | ForEach-Object { Write-Host "  - $($_.Name)" -ForegroundColor White }
```

