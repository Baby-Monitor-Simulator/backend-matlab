# Baby Monitor Simulator Project
This is a group project for Fontys and the Eindhoven University of Technology.

# Running
> Run **API Main.kt** function after completing setup below: https://github.com/Baby-Monitor-Simulator/backend-matlab/blob/master/api/src/main/kotlin/org/fontys/api/Main.kt

With _IntelliJ Idea_ you can simply right-click on the function and run or run via the play button top-right.

# Setup
> Setup primarily designed for _IntelliJ Idea_ (Fontys provides a free license for all students).

## Java
Use version **19**.

Additionally, _IntelliJ Idea_ lets you easily configure JVM of project in its settings:

![Reference](https://github.com/Baby-Monitor-Simulator/backend-matlab/assets/83029234/71049199-7d4f-4a51-97df-860b9bec6c87)

## Dependencies
### Adding Matlab Engine to Project:
> This should be handled automatically by Gradle. If using other package managers, the instructions below may help:

_IntelliJ Idea Instructions_:
- File -> Project Structure
- Libraries
- Click on + to add library
- Add `engine.jar` probably here: `C:\Program Files\MATLAB\R2022b\extern\engines\java\jar`
  - For convenience, we have placed the library file in the repo if you cannot find it locally: https://github.com/Baby-Monitor-Simulator/backend-matlab/tree/master/lib  
- Select all projects

For other IDEs I am not familiar. If you do it, please document it here!
