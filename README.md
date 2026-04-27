# Vehicle Production Concurrency System in Java

This project simulates a distributed vehicle production and sales chain using Java.

## Overview

The system is composed of:

- A vehicle factory
- Production stations
- Workers represented by threads
- Shared tools controlled by semaphores
- Circular buffers for vehicle belts
- Remote stores communicating with the factory via sockets
- Remote clients purchasing vehicles from stores
- Client garages implemented as buffers

## Main Concepts

- Java Threads
- Semaphores
- Producer-consumer problem
- Dining Philosophers problem adaptation
- Circular buffer
- Socket communication
- Object serialization
- Distributed architecture simulation

## Architecture

The system is divided into three main execution points:

1. `MainFabrica`
2. `MainLojasClientes`
3. `MainClientes`

Execution order:

```bash
MainFabrica
MainLojasClientes
MainClientes
``` 

## Academic Context

  This project was developed as part of a concurrency and distributed programming assessment.
  The goal was to simulate a production chain using only semaphores for synchronization.

## Technologies
- Java
- Threads
- Semaphores
- Sockets
- ObjectInputStream
- ObjectOutputStream
  
