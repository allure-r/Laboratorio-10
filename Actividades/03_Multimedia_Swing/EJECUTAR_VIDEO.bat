@echo off
chcp 65001 >nul
setlocal
cd /d "%~dp0"
where javac >nul 2>nul
if errorlevel 1 (
    echo No se encontro javac. Instala un JDK y agrega su carpeta bin al PATH.
    pause
    exit /b 1
)
if not exist demo.mp4 (
    echo No se encontro demo.mp4.
    echo Coloca un video MP4 en esta carpeta y llamalo demo.mp4.
    pause
    exit /b 1
)
if not defined PATH_TO_FX set "PATH_TO_FX=C:\javafx-sdk\lib"
if not exist "%PATH_TO_FX%\javafx.media.jar" (
    echo No se encontro JavaFX en: %PATH_TO_FX%
    echo Descarga y descomprime el JavaFX SDK compatible con tu JDK.
    echo Escribe la ruta completa a la carpeta lib de JavaFX, sin comillas.
    set /p "PATH_TO_FX=Ruta de JavaFX lib: "
)
if not exist "%PATH_TO_FX%\javafx.media.jar" (
    echo No se encontro javafx.media.jar en la ruta indicada.
    pause
    exit /b 1
)
if not exist out mkdir out
javac -encoding UTF-8 --module-path "%PATH_TO_FX%" --add-modules javafx.graphics,javafx.media,javafx.swing -d out src\actividad\multimedia\VideoExample.java
if errorlevel 1 (
    echo.
    echo No se pudo compilar el ejemplo de video.
    pause
    exit /b 1
)
java --module-path "%PATH_TO_FX%" --add-modules javafx.graphics,javafx.media,javafx.swing -cp out actividad.multimedia.VideoExample
if errorlevel 1 (
    echo.
    echo Ocurrio un error al ejecutar el video.
    pause
    exit /b 1
)
echo.
echo El reproductor de video se cerro.
pause
