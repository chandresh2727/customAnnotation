package com.example.customAnotation.dto;

import java.util.Collection;
import java.util.Set;

public class DuplicateCheckResponse<T> {
    private Collection<T> originalData;
    private Set<T> duplicates;

    public DuplicateCheckResponse(Collection<T> originalData, Set<T> duplicates) {
        this.originalData = originalData;
        this.duplicates = duplicates;
    }

    public Collection<T> getOriginalData() {
        return originalData;
    }

    public void setOriginalData(Collection<T> originalData) {
        this.originalData = originalData;
    }

    public Set<T> getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(Set<T> duplicates) {
        this.duplicates = duplicates;
    }
}
