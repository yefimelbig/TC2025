# Script de configuración de Java 8
# Ejecutar si tienes múltiples versiones de Java

# Buscar instalación de Java 8
$java8Paths = @(
    "C:\Program Files\Eclipse Adoptium\jdk-8*",
    "C:\Program Files\Java\jdk1.8*",
    "C:\Program Files\OpenJDK\jdk-8*"
)

foreach ($pattern in $java8Paths) {
    $java8Path = Get-ChildItem $pattern -ErrorAction SilentlyContinue | Select-Object -First 1
    if ($java8Path) {
        $env:JAVA_HOME = $java8Path.FullName
        $env:PATH = "$env:JAVA_HOME\bin;" + ($env:PATH -replace [regex]::Escape("$env:JAVA_HOME\bin;"), "")
        Write-Host "✅ Java 8 configurado: $env:JAVA_HOME" -ForegroundColor Green
        java -version
        break
    }
}

if (-not $java8Path) {
    Write-Host "❌ No se encontró Java 8 instalado" -ForegroundColor Red
}
