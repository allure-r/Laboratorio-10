@echo off
chcp 65001 >nul
setlocal
cd /d "%~dp0"
call "%~dp0COMPILAR.bat"
if errorlevel 1 goto error
java -cp out actividad.graficos.AppDibujoSimilar
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
