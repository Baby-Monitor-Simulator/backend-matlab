# Baby Monitor Simulator Project
This is a group project for Fontys and the Eindhoven University of Technology.

# Setup
> Setup primarily designed for _IntelliJ Idea_ (Fontys provides a free license for all students).

## Java
Use version **11**:
![Java Version Command-Line](https://github.com/Baby-Monitor-Simulator/backend-matlab/assets/83029234/4d5c4560-c9b2-46dc-ba4a-7eb983c6341d)

Additionally, _IntelliJ Idea_ lets you easily configure JVM of project in its settings:

1. ![image](https://github.com/Baby-Monitor-Simulator/backend-matlab/assets/83029234/5c3c8492-6f0f-40b0-b267-871e76cd0cce)
2. ![image](https://github.com/Baby-Monitor-Simulator/backend-matlab/assets/83029234/7d6364e7-a961-4ba1-93bd-091fc783bebf)

Download the JDK if missing: ![image](https://github.com/Baby-Monitor-Simulator/backend-matlab/assets/83029234/fc807474-f9bb-4500-a6ee-cb451da2828b)

## Dependencies
### Adding Matlab Engine to Project:
This should be handled automatically by Gradle. If using other package managers, the instructions below may help:

_IntelliJ Idea Instructions_:
- File -> Project Structure
- Libraries
- Click on + to add library
- Add `engine.jar` probably here: `C:\Program Files\MATLAB\R2022b\extern\engines\java\jar`
  - For convenience, we have placed the library file in the repo if you cannot find it locally: https://github.com/Baby-Monitor-Simulator/backend-matlab/tree/master/lib  
- Select all projects

For other IDEs I am not familiar. If you do it, please document it here!

