package models;

import java.util.Arrays;
import java.util.List;

public class DataItem implements Comparable<DataItem>
{
    private List<String> fields;
    private String rawData;

    public DataItem(String rawData)
    {
        this.rawData = rawData;
        // Check if the raw data is empty or null
        if (rawData == null || rawData.trim().isEmpty()) {
            this.fields = Arrays.asList("");  // Set fields to an empty list
            System.err.println("Warning: Empty or malformed line in CSV.");
            return;
        }
        this.fields = Arrays.asList(rawData.split(","));

        // Handle the case where no fields exist after splitting
        if (fields.size() == 0 || fields.get(0).isEmpty()) {
            System.err.println("Warning: Empty or malformed line in CSV.");
        }
    }


    public List<String> getFields()
    {
        return fields;
    }

    public String getField(int index)
    {
        // Add bounds check to avoid out-of-bounds errors
        if (index >= 0 && index < fields.size() && !fields.get(index).isEmpty()) {
            return fields.get(index);
        }
        System.err.println("Field index out of bounds or empty: " + index);
        return ""; // Return empty string if out of bounds or field is empty
    }


    public String getRawData() {
        return rawData;
    }

    @Override
    public int compareTo(DataItem other)
    {
        int fieldIndex = 0;
        return this.getField(fieldIndex).compareTo(other.getField(fieldIndex));
    }

    @Override
    public String toString()
    {
        return String.join(", ", fields);
    }
    // Override equals() to compare DataItem objects based on the first field (or adjust as needed)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DataItem other = (DataItem) obj;
        // Compare based on the first field (adjust this to compare by any other field)
        return this.getField(0).equalsIgnoreCase(other.getField(0));
    }
}
