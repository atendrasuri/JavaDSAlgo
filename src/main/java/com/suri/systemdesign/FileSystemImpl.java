package com.suri.systemdesign;

import java.util.*;

public class FileSystemImpl implements FileSystem {

    // A map to store file names and their sizes
    private final Map<String, Integer> fileMap;

    // A priority queue to keep track of file sizes for efficient retrieval of largest files
    private final PriorityQueue<Map.Entry<String, Integer>> sizeHeap;

    FileSystemImpl(){
        fileMap = new HashMap<>();
        sizeHeap = new PriorityQueue<>((a, b)-> b.getValue()-a.getValue());
    }
    @Override
    public boolean addFiles(String name, int size) {
        if(fileMap.containsKey(name)){
            return false;
        }
        fileMap.put(name, size);
        sizeHeap.add(new AbstractMap.SimpleEntry<>(name, size));
        return true;
    }

    @Override
    public Optional<Integer> getSize(String name) {
        return Optional.ofNullable(fileMap.get(name));
    }

    @Override
    public Optional<Integer> deleteFile(String name) {
        Integer size = fileMap.remove(name);
        if (size != null) {
            // Rebuild the heap after deletion
            sizeHeap.clear();
            for (Map.Entry<String, Integer> entry : fileMap.entrySet()) {
                sizeHeap.add(entry);
            }
            return Optional.of(size);
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> getLargestFile() {
        if(sizeHeap.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(sizeHeap.peek().getKey());
    }

    @Override
    public List<String> getNLargest(String prefix, int n) {
        // Filter files with the given prefix
        List<Map.Entry<String, Integer>> matchingFiles = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: fileMap.entrySet()){
            if(entry.getKey().startsWith(prefix)){
                matchingFiles.add(entry);
            }
        }
        // Sort by size in descending order
        matchingFiles.sort((a,b)-> b.getValue()-a.getValue());
        // Collect the top n files
        List<String> topNFiles = new ArrayList<>();
        for(int i=0; i<Math.min(n, matchingFiles.size());i++){
            topNFiles.add(matchingFiles.get(i).getKey());
        }
        return topNFiles;
    }
}
