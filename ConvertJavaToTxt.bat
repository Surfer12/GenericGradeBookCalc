@echo off
setlocal enabledelayedexpansion

:: Specify the directory where you want to save the .txt files (relative to the script's location)
set "TXT_FILES_DIR=%~dp0ConvertedJavaToTxtFilesForGemini"

:: Recursively loop through all .java files in the 'src' directory and its subdirectories
for /r "src" %%f in (*.java) do (
    echo Processing file: %%f
    :: Get the relative path of the file from the 'src' directory
    set "relativePath=%%f"
    set "relativePath=!relativePath:%~dp0src\=!"

    :: Create the directory structure if it does not exist
    set "outputDir=%TXT_FILES_DIR%\!relativePath!"
    set "outputDir=!outputDir:%%~nxf=!"
    if not exist "!outputDir!" (
        echo Creating directory: !outputDir!
        mkdir "!outputDir!"
    )

    :: Copy the content of each .java file into a corresponding .txt file in the specified directory, preserving the package structure
    set "outputFile=%TXT_FILES_DIR%\!relativePath:.java=.txt!"
    echo Converting file: %%f to !outputFile!
    type "%%f" > "!outputFile!"
)

echo Conversion complete!