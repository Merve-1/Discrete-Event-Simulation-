# System Modeling Package

The `system.modelinggg` package provides a Java implementation for system modeling, specifically focusing on generating statistics related to queuing systems. The package contains two main functions: `function1()` for fixed values and `function2()` for random number generation.

## Table of Contents
- [Overview](#overview)
- [Functions](#functions)
- [Usage](#usage)


## Overview

The `SystemModelinggg` class aims to model and analyze queuing systems. It includes functions to generate statistics such as waiting times, system utilization, and queue lengths based on either fixed or randomly generated input values.

## Functions

### 1. `function1()`
   - **Description:** Processes a predefined set of service and inter-arrival times to simulate a queuing system.
   - **Input:** Fixed service and inter-arrival arrays.
   - **Output:** Displays statistics including service times, arrival times, system times, waiting times, idle times, and queue lengths.
   - **Usage:**
     ```java
     function1();
     ```

### 2. `function2()`
   - **Description:** Allows users to input rates and probabilities to generate random service and inter-arrival times for queuing system simulation.
   - **Input:** User-provided rates and probabilities.
   - **Output:** Displays statistics similar to `function1()` based on randomly generated service and inter-arrival times.
   - **Usage:**
     ```java
     function2();
     ```

## Usage

1. **Clone the Repository:**
   ```bash
   git clone <repository_url>
   ```

2. **Navigate to the Package Directory:**
   ```bash
   cd system/modelinggg
   ```

3. **Run the Program:**
   ```bash
   javac SystemModelinggg.java
   java SystemModelinggg
   ```

4. **Follow the On-Screen Instructions:**
   - For fixed values, enter `1`.
   - For random values, enter `2` and follow the prompts.

