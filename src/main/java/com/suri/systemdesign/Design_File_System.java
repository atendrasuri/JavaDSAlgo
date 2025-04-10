package com.suri.systemdesign;
/*
This implementation includes the following features:

addFiles checks for file existence before adding.
getSize retrieves the file size if the file exists.
deleteFile removes the file and returns its size if it exists.
getNLargest filters files by prefix and returns the n largest files based on size.

 */

public class Design_File_System {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystemImpl();

        // Test addFiles
        System.out.println(fileSystem.addFiles("file1.txt", 100)); // true
        System.out.println(fileSystem.addFiles("file2.txt", 200)); // true
        System.out.println(fileSystem.addFiles("file1.txt", 150)); // false

        // Test getSize
        System.out.println(fileSystem.getSize("file1.txt")); // Optional[100]
        System.out.println(fileSystem.getSize("file3.txt")); // Optional.empty

        // Test deleteFile
        System.out.println(fileSystem.deleteFile("file2.txt")); // Optional[200]
        System.out.println(fileSystem.deleteFile("file3.txt")); // Optional.empty

        // Test getNLargest
        fileSystem.addFiles("file3.txt", 300);
        fileSystem.addFiles("file4.log", 250);
        System.out.println(fileSystem.getNLargest("file", 2)); // [file3.txt, file1.txt]
        System.out.println(fileSystem.getNLargest("file4", 1)); // [file4.log]

        // Test getLargestFile
        System.out.println(fileSystem.getLargestFile()); // Optional[file3.txt]

    }

}


