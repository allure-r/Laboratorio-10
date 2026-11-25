@echo off
chcp 65001 >nul
setlocal
set "ROOT=%~dp0"
cd /d "%ROOT%"
:menu
cls
echo ================================================
echo       GUIA 10 LP3 - EXPERIENCIA DE PRACTICA
echo ================================================
echo.
echo BINDING DE DATOS
echo 1. Ejemplo Persona (guia)
echo 2. Aplicacion similar Estudiante
echo.
echo GRAFICOS
echo 3. Graphics - dibujo simple
echo 4. Graphics2D - transformaciones
echo 5. Grafico de barras
echo 6. Dibujo similar
echo.
echo MULTIMEDIA
echo 7. Reproduccion WAV (guia)
echo 8. Aplicacion similar de audio
echo 9. Reproduccion de video (JavaFX)
echo.
echo X. Salir
echo.
choice /c 123456789X /n /m "Selecciona una aplicacion: "
if errorlevel 10 goto salir
if errorlevel 9 (
    call "%ROOT%03_Multimedia_Swing\EJECUTAR_VIDEO.bat"
    goto menu
)
if errorlevel 8 (
    call "%ROOT%03_Multimedia_Swing\EJECUTAR_AUDIO_SIMILAR.bat"
    goto menu
)
if errorlevel 7 (
    call "%ROOT%03_Multimedia_Swing\EJECUTAR_AUDIO.bat"
    goto menu
)
if errorlevel 6 (
    call "%ROOT%02_Graficos_Swing\EJECUTAR_DIBUJO_SIMILAR.bat"
    goto menu
)
if errorlevel 5 (
    call "%ROOT%02_Graficos_Swing\EJECUTAR_BARRAS.bat"
    goto menu
)
if errorlevel 4 (
    call "%ROOT%02_Graficos_Swing\EJECUTAR_GRAFICOS2D.bat"
    goto menu
)
if errorlevel 3 (
    call "%ROOT%02_Graficos_Swing\EJECUTAR_GRAFICOS.bat"
    goto menu
)
if errorlevel 2 (
    call "%ROOT%01_Binding_Datos_Swing\EJECUTAR_ESTUDIANTE.bat"
    goto menu
)
if errorlevel 1 (
    call "%ROOT%01_Binding_Datos_Swing\EJECUTAR_PERSONA.bat"
    goto menu
)
:salir
exit /b 0
