package com.suri.designpattern.visitor;

/**
 The Visitor Pattern is a behavioral design pattern that allows you to add new operations to objects without modifying their structure. It lets you separate algorithms from the objects on which they operate.


 When to Use?
 When you want to add new operations to existing classes without modifying them.
 When you have a hierarchy of objects with different behaviors but need a common way to process them.
 When you need to apply multiple operations to objects without polluting their classes.



 Example Scenario
 Imagine a File System where different file types (TextFile, ImageFile, etc.) need different processing (compression, virus scan). The Visitor Pattern allows new operations to be added without modifying existing file classes.
 */
// Step 1: Create the Visitor Interface
interface FileVisitor {
    void visit(TextFile textFile);
    void visit(ImageFile imageFile);
}

// Step 2: Create the Element Interface
interface FileElement {
    void accept(FileVisitor visitor);
}

// Step 3: Concrete Elements (Files)
class TextFile implements FileElement {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(FileVisitor visitor) {
        visitor.visit(this);
    }
}

class ImageFile implements FileElement {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(FileVisitor visitor) {
        visitor.visit(this);
    }
}

// Step 4: Concrete Visitors (Different operations)

// Virus Scanner
class VirusScanner implements FileVisitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Scanning text file: " + textFile.getName() + " for viruses.");
    }

    @Override
    public void visit(ImageFile imageFile) {
        System.out.println("Scanning image file: " + imageFile.getName() + " for viruses.");
    }
}

// File Compressor
class FileCompressor implements FileVisitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Compressing text file: " + textFile.getName());
    }

    @Override
    public void visit(ImageFile imageFile) {
        System.out.println("Compressing image file: " + imageFile.getName());
    }
}

// Step 5: Client Code
public class VisitorPatternDemo {
    public static void main(String[] args) {
        // Create files
        FileElement textFile = new TextFile("document.txt");
        FileElement imageFile = new ImageFile("photo.jpg");

        // Create visitors
        FileVisitor virusScanner = new VirusScanner();
        FileVisitor fileCompressor = new FileCompressor();

        // Apply visitors
        textFile.accept(virusScanner);
        imageFile.accept(virusScanner);
        
        textFile.accept(fileCompressor);
        imageFile.accept(fileCompressor);
    }
}
