package com.suri.systemdesign;

import java.util.List;
import java.util.Optional;

public interface FileSystem {
    boolean addFiles(String name, int size);

    Optional<Integer> getSize(String name);

    Optional<Integer> deleteFile(String name);

    Optional<String> getLargestFile();

    List<String> getNLargest(String prefix, int n);


}
