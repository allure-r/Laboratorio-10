@echo off
chcp 65001 >nul
setlocal
cd /d "%~dp0"
if not exist "src\actividad\multimedia\assets\sample-3s.wav" (
    echo No se encontro el archivo sample-3s.wav en assets.
    pause
    exit /b 1
)
call "%~dp0COMPILAR_AUDIO.bat"
if errorlevel 1 goto error
java -cp out actividad.multimedia.AppAudioSimilar
if errorlevel 1 goto error
echo.
echo La aplicacion se cerro.
pause
exit /b 0
:error
echo.
echo No se pudo ejecutar la aplicacion. Revisa el mensaje anterior.
pause
exit /b 1
