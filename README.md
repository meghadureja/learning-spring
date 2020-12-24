# learning-spring
This repository contains various Spring Programming problems

# There are multiple ways to set profiles for your springboot application.
# 1. add this in your property file:
spring.profiles.active=dev
# 2. Programmatic way:
SpringApplication.setAdditionalProfiles("dev");
# 3. Tests make it very easy to specify what profiles are active
@ActiveProfiles("dev")
# JVM System Parameter
-Dspring.profiles.active=dev