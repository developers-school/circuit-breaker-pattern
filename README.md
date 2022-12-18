# circuit-breaker-pattern

This repository is an example to build a microservice application that uses the Circuit Breaker pattern to gracefully degrade functionality when a method call fails. Use of the Circuit Breaker pattern can allow a microservice to continue operating when a related service fails, preventing the failure from cascading and giving the failing service time to recover.

In this simple example, Hystrix will keep track of how many IOExceptions occur within a rolling time window. Once an error threshold is crossed all requests to the method will be forwarded to the method defined in the ‘fallbackMethod’, then it resumes calling the original method after the sleep window duration has passed. In other words, calling the ‘pingGoogle’ method will return the output (“Ping to Google was successful!”). If Google was down for some reason or the application using this service loses connectivity, calls to ‘pingGoogle’ will temporarily return the output of the ‘pingFallback’ method (“Resource is busy or offline”) until Google is back up or connectivity is restored.

Hystrix’s default and custom Error Threshold %, Sleep Window duration and other settings (see below in Resources section) can be configured in the application.yml file:

hystrix:

    command:

        default:

            circuitBreaker:

               errorThresholdPercentage: 50 # 50%

               sleepWindowInMilliseconds: 5000 # 5s

        customCommandKey:

            fallback:

               enabled: false

            circuitBreaker:

               errorThresholdPercentage: 75 # 75%

               sleepWindowInMilliseconds: 15000 # 15s
