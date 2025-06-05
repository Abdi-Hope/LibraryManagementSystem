package model;

import java.util.Objects;

public class Author {
    private String name;
    private String biography;

    public Author(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    // toString for readable display
    @Override
    public String toString() {
        return "Author: " + name + "\nBiography: " + biography;
    }

    // Proper equality check
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Author)) return false;
        Author other = (Author) obj;
        return Objects.equals(name, other.name) &&
               Objects.equals(biography, other.biography);
    }

    // Consistent with equals()
    @Override
    public int hashCode() {
        return Objects.hash(name, biography);
    }

    /**
     * Returns a shortened version of the biography (used for previews).
     * @param length max characters
     * @return short bio with "..." if truncated
     */
    public String getShortBio(int length) {
        if (biography == null) return "";
        if (biography.length() <= length) {
            return biography;
        } else {
            return biography.substring(0, length - 3) + "...";
        }
    }

    /**
     * Returns biography length in characters.
     */
    public int getBiographyLength() {
        return biography != null ? biography.length() : 0;
    }

    /**
     * Checks if a keyword is in the biography (case-insensitive).
     */
    public boolean hasKeywordInBiography(String keyword) {
        if (biography == null || keyword == null) return false;
        return biography.toLowerCase().contains(keyword.toLowerCase());
    }

    /**
     * Formats author data for saving in a CSV-style file.
     */
    public String toFileFormat() {
        // Replace commas to avoid breaking CSV
        String safeBio = biography != null ? biography.replace(",", "") : "";
        return name + "," + safeBio;
    }
}