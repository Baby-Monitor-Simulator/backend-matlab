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




# Baby Monitor Simulator Project -- NEW VERSION

## Initial Setup
1. Download the setup-microservices.ps1 file
2. Open Powershell with administrator privileges (windows key + x)
3. Run the script line by line:
   3.1 Set-ExecutionPolicy RemoteSigned
   3.2 .\setup-microservices.ps1

## Development

### Working with Docker Compose

Once initial setup is complete, you can begin developing with Docker Compose. Here’s a step-by-step guide on how to do this:

1. Navigate to the Project Directory:
   Open a terminal (PowerShell or Command Prompt) and navigate to the `microservices-dev` folder:
   
   cd C:\Users\<YourUsername>\Desktop\microservices-dev

2. Start the Services: Use the following command to start the microservices defined in the docker-compose.yml file:
   docker-compose up

   This command will build the images (if not already built) and start the containers for each microservice.

3. Accessing services: Each service can be accessed at the port defined in the docker-compose.yml file

4. Hot Reloading: Changes made to the source code in the gateway-api or identity-service folders will automatically be reflected in the running containers due to the volume mounts defined in the docker-compose.yml file. This allows for a smoother development experience without needing to rebuild the containers.

### Docker Compose commands:

Shutting down the services can be done by either pressing CTRL + C in the terminal where docker-compose up is running. Alternatively you can use docker-compose down

Viewing the logs can be done using docker-compose logs or docker-compose logs  <service_name>

Running Migrations or Initialization Scripts: If your services require database migrations or any initialization scripts, ensure that these are integrated within the services’ Dockerfiles or handled through entrypoint scripts. You may need to execute these after starting the containers or define specific commands in the docker-compose.yml.

Check status of running containers: docker ps

To access a running containers shell: docker exec -it <container_id_or_name> /bin/sh

# Deployment
   
