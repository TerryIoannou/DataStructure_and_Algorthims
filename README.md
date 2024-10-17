# Dataset Conversion and Algorithm Application

## Overview
This application enables users to convert a dataset (in CSV format) into three different data structures:
- **Array List**
- **Linked List**
- **Binary Tree**

Once the dataset is converted into these structures, users can apply sorting and searching algorithms to the data.

### Sorting Algorithms:
- **Bubble Sort**
- **Combo Sort**

### Search Algorithms:
- **Linear Search**
- **Binary Search**

Users can apply these algorithms to the entire dataset or to selected portions of it. A graphical user interface (GUI) allows users to interact with the application and visualize the results.

## Features

### 1. Custom Data Structures
- **Array List**, **Linked List**, and **Binary Tree** are built from scratch, and they come with the necessary fields and methods for data manipulation, such as:
  - Getters and setters
  - `add()`, `get()`, and `delete()` methods
- **Generic Programming**: These data structures are designed to handle generic types, allowing for the storage of different data types.
- **Cross-comparison methods** are included, enabling comparisons across the fields of the objects within the data structures.

### 2. Algorithms
- The application implements **4 algorithms**, two sorting and two searching:
  - **Sorting Algorithms**:
    - **Bubble Sort**: A comparison-based sort.
    - **Combo Sort**: A hybrid algorithm that uses multiple sorting techniques.
  - **Search Algorithms**:
    - **Linear Search**: Sequentially checks each element.
    - **Binary Search**: A more efficient search algorithm for sorted data.
- **Comparator Support**: The sorting algorithms support custom comparators and can sort based on object fields.
- **Generic Support**: All algorithms are capable of working with generic types, ensuring flexibility in the types of data processed.

### 3. Graphical User Interface (GUI)
- **Data Import**: The GUI allows users to import CSV datasets and convert them into the three data structures.
- **Algorithm Selection and Execution**: Through the GUI, users can select and execute different algorithms on the dataset.
- **Performance Metrics**: The GUI provides real-time feedback on the speed and performance of the algorithms being executed.
- **Data Structure Control**: Users can choose between Array List, Linked List, or Binary Tree and apply algorithms on them.

### 4. Dataset Handling
- The dataset imported from the CSV file is converted into objects of a **pre-established class**.
- These objects are then stored in any of the three available data structures, making it possible to manipulate the data and perform algorithmic operations.

## How to Use the Application
1. **Import Data**: Use the GUI to load a CSV file into the application.
2. **Choose Data Structure**: Select a data structure (Array List, Linked List, or Binary Tree) to convert the dataset into.
3. **Run Algorithms**: Select and execute any of the sorting or searching algorithms.
4. **View Results**: The GUI will display the sorted or searched results, along with performance information such as execution time and data size.
