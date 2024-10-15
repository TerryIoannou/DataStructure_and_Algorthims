package gui;

import algorithms.Pair;
import algorithms.SearchingAlgorithms;
import algorithms.SortingAlgorithms;
import data_structures.ArrayList;
import data_structures.BinaryTree;
import data_structures.LinkedList;
import models.DataItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class MainApp extends JFrame {
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JComboBox<String> dataStructureSelector;
    private JComboBox<String> algorithmSelector;
    private JButton executeButton;
    private JLabel speedLabel;
    private JTextArea resultArea;

    private ArrayList<DataItem> arrayList;
    private LinkedList<DataItem> linkedList;
    private BinaryTree<DataItem> binaryTree;

    public MainApp() {
        setTitle("Data Structure and Algorithm Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // UI PANEL:
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2));
        resultArea = new JTextArea();
        inputArea = new JTextArea();
        outputArea = new JTextArea();
        inputPanel.add(new JScrollPane(inputArea));
        inputPanel.add(new JScrollPane(outputArea));

        add(inputPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 5));

        dataStructureSelector = new JComboBox<>(new String[]{"ArrayList", "LinkedList", "BinaryTree"});
        algorithmSelector = new JComboBox<>(new String[]{"Bubble Sort", "Comb Sort", "Linear Search", "Binary Search"});
        executeButton = new JButton("Execute");
        JButton importButton = new JButton("Import CSV");
        speedLabel = new JLabel("Speed: ");

        controlPanel.add(dataStructureSelector);
        controlPanel.add(algorithmSelector);
        controlPanel.add(executeButton);
        controlPanel.add(speedLabel);
        controlPanel.add(importButton);

        add(controlPanel, BorderLayout.SOUTH);

        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        binaryTree = new BinaryTree<>();

        setVisible(true);
        // Add ActionListener for the import button
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importCSV();  // Call the importCSV method when the button is clicked
            }
        });

        // ActionListener for execute button
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeAlgorithm();
            }
        });
    }

    private void executeAlgorithm() {
        String selectedDataStructure = (String) dataStructureSelector.getSelectedItem();
        String selectedAlgorithm = (String) algorithmSelector.getSelectedItem();

        long startTime = System.nanoTime();

        switch (selectedDataStructure) {
            case "ArrayList":
                executeSelectedAlgorithmArrayList(selectedAlgorithm);
                break;
            case "LinkedList":
                executeSelectedAlgorithmLinkedList(selectedAlgorithm);
                break;
            case "BinaryTree":
                executeSelectedAlgorithmBinaryTree(selectedAlgorithm);
                break;
        }

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000_000.0;
        speedLabel.setText("Speed: " + String.format("%.1f", elapsedTime) + " seconds");
    }

    private void executeSelectedAlgorithmArrayList(String selectedAlgorithm) {
        StringBuilder result = new StringBuilder();

        switch (selectedAlgorithm) {
            case "Bubble Sort":
                DataItem[] array = arrayList.toArray(new DataItem[0]);
                SortingAlgorithms.bubbleSort(array, Comparator.comparing(item -> item.getField(0)));
                result.append("Sorted ArrayList: \n").append(Arrays.toString(array).replace(", ", "\n")).append("\n");
                break;

            case "Comb Sort":
                array = arrayList.toArray(new DataItem[0]);
                SortingAlgorithms.combSort(array, Comparator.comparing(item -> item.getField(0)));
                result.append("Sorted ArrayList: \n").append(Arrays.toString(array).replace(", ", "\n")).append("\n");
                break;

            case "Linear Search":
                DataItem[] arrayLinear = arrayList.toArray(new DataItem[0]);
                DataItem searchItem = new DataItem(JOptionPane.showInputDialog("Enter search term:"));
                Pair<DataItem> linearSearchResult = SearchingAlgorithms.linearSearch(arrayLinear, searchItem);

                if (linearSearchResult != null) {
                    result.append("Linear Search Result: \nFound at index ")
                            .append(linearSearchResult.index)
                            .append(" - ").append(linearSearchResult.element.toString()).append("\n");
                } else {
                    result.append("Linear Search Result: Not Found\n");
                }
                break;

            case "Binary Search":
                DataItem[] arrayBinary = arrayList.toArray(new DataItem[0]);
                Arrays.sort(arrayBinary, Comparator.comparing(item -> item.getField(0)));
                DataItem search = new DataItem(JOptionPane.showInputDialog("Enter search term:"));
                Pair<DataItem> binarySearchResult = SearchingAlgorithms.binarySearch(arrayBinary, search);

                if (binarySearchResult != null) {
                    result.append("Binary Search Result: \nFound at index ")
                            .append(binarySearchResult.index)
                            .append(" - ").append(binarySearchResult.element.toString()).append("\n");
                } else {
                    result.append("Binary Search Result: Not Found\n");
                }
                break;
        }

        outputArea.setText(result.toString());  // Update output area with line breaks
    }


    private void executeSelectedAlgorithmLinkedList(String selectedAlgorithm) {
        StringBuilder result = new StringBuilder();

        switch (selectedAlgorithm) {
            case "Bubble Sort":
                DataItem[] array = linkedList.toArray(new DataItem[0]);
                SortingAlgorithms.bubbleSort(array, Comparator.comparing(item -> item.getField(0)));
                result.append("Sorted LinkedList: \n").append(Arrays.toString(array).replace(", ", "\n")).append("\n");
                break;

            case "Comb Sort":
                array = linkedList.toArray(new DataItem[0]);
                SortingAlgorithms.combSort(array, Comparator.comparing(item -> item.getField(0)));
                result.append("Sorted LinkedList: \n").append(Arrays.toString(array).replace(", ", "\n")).append("\n");
                break;

            case "Linear Search":
                DataItem[] linkedListArray = linkedList.toArray(new DataItem[0]);
                DataItem searchItem = new DataItem(JOptionPane.showInputDialog("Enter search term:"));
                Pair<DataItem> linearSearchResult = SearchingAlgorithms.linearSearch(linkedListArray, searchItem);

                if (linearSearchResult != null) {
                    result.append("Linear Search Result: \nFound at index ")
                            .append(linearSearchResult.index)
                            .append(" - ").append(linearSearchResult.element.toString()).append("\n");
                } else {
                    result.append("Linear Search Result: Not Found\n");
                }
                break;

            case "Binary Search":
                DataItem[] linkBinary = linkedList.toArray(new DataItem[0]);
                Arrays.sort(linkBinary, Comparator.comparing(item -> item.getField(0)));
                DataItem search = new DataItem(JOptionPane.showInputDialog("Enter search term:"));
                Pair<DataItem> binarySearchResult = SearchingAlgorithms.binarySearch(linkBinary, search);

                if (binarySearchResult != null) {
                    result.append("Binary Search Result: \nFound at index ")
                            .append(binarySearchResult.index)
                            .append(" - ").append(binarySearchResult.element.toString()).append("\n");
                } else {
                    result.append("Binary Search Result: Not Found\n");
                }
                break;
        }

        outputArea.setText(result.toString());  // Update output area with line breaks
    }



    private void executeSelectedAlgorithmBinaryTree(String selectedAlgorithm) {
        StringBuilder result = new StringBuilder();

        switch (selectedAlgorithm) {
            case "Comb Sort":
            case "Bubble Sort":
                result.append("Sorting not supported for BinaryTree.\n");
                break;

            case "Linear Search":
                DataItem searchItem = new DataItem(JOptionPane. showInputDialog("Enter search term:"));
                boolean found = binaryTree.contains(searchItem);
                result.append("Linear Search Result: ").append(found ? "Found\n" : "Not Found\n");
                break;

            case "Binary Search":
                // Sort the arrayBinary before binary search
                DataItem[] arrayBinary = arrayList.toArray(new DataItem[0]);

                // Sorting array before performing binary search
                Arrays.sort(arrayBinary, Comparator.comparing(item -> item.getField(0))); // Adjust field index accordingly

                // Display sorted array for debugging
                System.out.println("DEBUG: Sorted Array for Binary Search: " + Arrays.toString(arrayBinary));

                // Search input
                DataItem searchItemBinary = new DataItem(JOptionPane.showInputDialog("Enter search term:"));

                // Perform binary search
                Pair<DataItem> binarySearchResult = SearchingAlgorithms.binarySearch(arrayBinary, searchItemBinary);

                if (binarySearchResult != null) {
                    result.append("Binary Search Result: \nFound at index ")
                            .append(binarySearchResult.index)
                            .append(" - ").append(binarySearchResult.element.toString()).append("\n");
                } else {
                    result.append("Binary Search Result: Not Found\n");
                }
                break;
        }

        outputArea.setText(result.toString());  // Update output area with line breaks
    }



    private void importCSV() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            StringBuilder importedData = new StringBuilder();
            try {
                arrayList = new ArrayList<>();
                linkedList = new LinkedList<>();
                binaryTree = new BinaryTree<>();

                for (File file : files) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        boolean firstLine = true;
                        String[] headers = null;
                        java.util.List<String[]> dataList = new java.util.ArrayList<>(); // Correct type

                        while ((line = br.readLine()) != null) {
                            line = line.trim();
                            if (!line.isEmpty()) {
                                if (firstLine) {
                                    headers = line.split(",");  // Treat first line as headers
                                    firstLine = false;
                                } else {
                                    // Create DataItem from the raw CSV line
                                    DataItem dataItem = new DataItem(line);

                                    // Add the DataItem to data structures
                                    arrayList.add(dataItem);
                                    linkedList.add(dataItem);
                                    binaryTree.add(dataItem);

                                    // Store split fields for display
                                    dataList.add(line.split(","));
                                }
                            }
                        }

                        // After reading all the lines, format and display the data
                        if (headers != null) {
                            String formattedData = formatCSVData(headers, dataList);
                            inputArea.setText(formattedData);  // Display formatted data in the input area
                        }

                    }
                }
                resultArea.append("CSV files imported successfully!\n");
            } catch (IOException ex) {
                ex.printStackTrace();
                resultArea.append("Error importing CSV files.\n");
            }
        }
    }



    private String formatCSVData(String[] headers, java.util.List<String[]> dataList) {
        StringBuilder sb = new StringBuilder();
        // Append headers
        for (String header : headers) {
            sb.append(String.format("%-15s", header)); // Adjust padding as needed
        }
        sb.append("\n");
        System.out.println("Headers: " + Arrays.toString(headers));

        // Append each row of data
        for (String[] data : dataList) {
            if (data == null || data.length == 0) {
                System.out.println("Row: " + Arrays.toString(data));
                continue; // Skip empty or malformed rows
            }
            for (String field : data) {
                sb.append(String.format("%-15s", field != null ? field : "")); // Avoid null values
            }
            sb.append("\n");
        }
        return sb.toString();
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }
}
