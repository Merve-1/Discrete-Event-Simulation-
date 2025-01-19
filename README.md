# SICXE Assembler

## Overview
SICXE Assembler is a Java-based assembly language program designed to translate SICXE assembly code into machine code. It encompasses functionalities for parsing, assembling, and generating machine code compatible with the SICXE architecture.

## Contents

1. [Introduction](#introduction)
2. [Main.java](#mainjava)
    - [Dependencies](#dependencies)
    - [SICXEAssembler Class](#sicxeassembler-class)
    - [Constants and Data Structures](#constants-and-data-structures)
    - [Main Method](#main-method)
    - [Assembler Workflow](#assembler-workflow)
    - [Pass One](#pass-one)
    - [Pass Two](#pass-two)
    - [Generate Object Code](#generate-object-code)
    - [Write Object Code to File](#write-object-code-to-file)
3. [Running the Assembler](#running-the-assembler)

## Introduction
The SICXE Assembler is developed in Java, providing a solution for translating SICXE assembly code into machine-readable instructions. The `Main.java` file serves as the main entry point, orchestrating the entire assembly process.

## Main.java
The `Main.java` file encapsulates the core logic of the SICXE Assembler. Here's a breakdown of its structure:

### Dependencies
- `java.io.BufferedReader`, `java.io.FileReader`, `java.io.IOException`: Java IO classes for file handling.
- `java.util.ArrayList`, `java.util.HashMap`: Utility classes for data storage.

### SICXEAssembler Class
- `SICXEAssembler` class encapsulates the assembly logic.

### Constants and Data Structures
- `SOURCE_FILE`, `OUTPUT_FILE`: Constants for source and output file names.
- `symbolTable`, `intermediateCode`, `objectCode`: Data structures for storing symbols, intermediate code, and final object code.

### Main Method
- The entry point for the SICXE Assembler program.

### Assembler Workflow
- Orchestrates the assembler workflow, including Pass 1, Pass 2, object code generation, and file writing.

### Pass One
- Performs the first pass, building the symbol table and generating intermediate code.

### Pass Two
- Performs the second pass, generating the final object code.

### Generate Object Code
- Generates object code based on intermediate code and symbol table.

### Write Object Code to File
- Writes the final object code to the output file.

## Running the Assembler
1. Ensure the `input.asm` file contains SICXE assembly code.
2. Execute `Main.java`.
3. The assembler will perform Pass 1, Pass 2, generate object code, and write the output to `output.obj`.

Explore and customize the `Main.java` file based on your requirements. Experimenting with different SICXE assembly code inputs will showcase the capabilities of the SICXE Assembler.
