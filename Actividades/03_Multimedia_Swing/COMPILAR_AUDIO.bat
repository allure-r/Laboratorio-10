@echo off
chcp 65001 >nul
setlocal
cd /d "%~dp0"
where javac >nul 2>nul
if errorlevel 1 (
    echo No se encontro javac. Instala un JDK y agrega su carpeta bin al PATH.
    exit /b 1
)
if not exist out mkdir out
javac -encoding UTF-8 -d out src\actividad\multimedia\AppAudio.java src\actividad\multimedia\AppAudioSimilar.java
if errorlevel 1 (
    echo.
    echo Hubo un error al compilar los ejemplos de audio.
    exit /b 1
)
echo Compilacion de Audio finalizada correctamente.
exit /b 0
