# Dynamic Service Registration with Eureka

This Maven multi-module project contains:
- `eureka-server`: Eureka Discovery Server on port **8761**
- `restaurant-service`: Eureka client that starts on a **random port** and registers as `RESTAURANT-SERVICE`

## Requirements
- JDK 17
- Spring Tool Suite 4 (or Eclipse with Maven support)
- Internet access for Maven to download dependencies the first time

## Import into Spring Tool Suite
1. Extract `eureka-food-delivery.zip` to a folder.
2. Open STS.
3. Select **File → Import → Maven → Existing Maven Projects**.
4. Browse to the extracted `eureka-food-delivery` root folder (the folder containing the parent `pom.xml`).
5. Select the parent project and both modules, then click **Finish**.
6. Wait for Maven dependencies to finish downloading.

## Run (important: server first)
1. In Package Explorer, open `eureka-server`.
2. Right-click `EurekaServerApplication.java` → **Run As → Spring Boot App**.
3. Wait until the console says the application has started.
4. Open `restaurant-service`.
5. Right-click `RestaurantServiceApplication.java` → **Run As → Spring Boot App**.
6. Open **http://localhost:8761** in your browser.
7. Under **Instances currently registered with Eureka**, confirm `RESTAURANT-SERVICE` is listed with status **UP**.

## Test the service
The restaurant service uses a random port. Find the assigned port in its STS console startup log (look for `Tomcat started on port ...`).

Then open:
- `http://localhost:<assigned-port>/`
- `http://localhost:<assigned-port>/restaurants`

Example response from `/`:
```json
{
  "service": "Restaurant Service",
  "status": "UP",
  "message": "Restaurant Service is registered with Eureka",
  "port": "xxxxx"
}
```

## Notes
- Keep the Eureka Server running while starting the Restaurant Service.
- `server.port: 0` tells Spring Boot to choose an available random port.
- Eureka client registration is automatic; no manual IP/port entry is required.
- If STS shows a Java version error, set the project JRE to JDK 17: **Project → Properties → Java Build Path**.
- If the dashboard is not available, confirm port 8761 is not already in use.
