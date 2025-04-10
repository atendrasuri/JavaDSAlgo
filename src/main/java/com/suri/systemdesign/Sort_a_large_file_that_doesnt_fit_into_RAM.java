package com.suri.systemdesign;

public class Sort_a_large_file_that_doesnt_fit_into_RAM {

/**
 Question:- Sort a file with huge volume of data given memory constraint

 https://stackoverflow.com/questions/2087469/sort-a-file-with-huge-volume-of-data-given-memory-constraint/2087514#2087514

 Soln - External Sorting (https://en.wikipedia.org/wiki/External_sorting)
 External merge sort
 One example of external sorting is the external merge sort algorithm, which uses a K-way merge algorithm. It sorts chunks that each fit in RAM, then merges the sorted chunks together.[1][2]

 The algorithm first sorts M items at a time and puts the sorted lists back into external memory.

 For example, for sorting 900 megabytes of data using only 100 megabytes of RAM:

 Read 100 MB of the data in main memory and sort by some conventional method, like quicksort.
 Write the sorted data to disk.
 Repeat steps 1 and 2 until all of the data is in sorted 100 MB chunks (there are 900MB / 100MB = 9 chunks), which now need to be merged into one single output file.
 Read the first 10 MB (= 100MB / (9 chunks + 1)) of each sorted chunk into input buffers in main memory and allocate the remaining 10 MB for an output buffer. (In practice, it might provide better performance to make the output buffer larger and the input buffers slightly smaller.)
 Perform a 9-way merge and store the result in the output buffer. Whenever the output buffer fills, write it to the final sorted file and empty it. Whenever any of the 9 input buffers empties, fill it with the next 10 MB of its associated 100 MB sorted chunk until no more data from the chunk is available.
 The merge pass is key to making external merge sort work externally. The merge algorithm only makes one pass through each chunk, so chunks do not have to be loaded all at once; rather, sequential parts of the chunk are loaded as needed. And as long as the blocks read are relatively large (like the 10 MB in this example), the reads can be relatively efficient even on media with low random-read performance, like hard drives.

 Historically, instead of a sort, sometimes a replacement-selection algorithm[3] was used to perform the initial distribution, to produce on average half as many output chunks of double the length.


 Solutions (Steps):
 1️⃣ Phase 1: Split and Sort Chunks
 Read a small chunk that fits in memory.
 Sort it using QuickSort/HeapSort.
 Write each sorted chunk to a temporary file.
 2️⃣ Phase 2: Multi-Pass K-Way Merge
 Instead of merging all chunks at once,
 Merge M chunks at a time, creating intermediate sorted files.
 Repeat until one final sorted file remains.

 More Detailed Step-by-Step with a Large Dataset
 Initial Split:

 File = 10 GB.
 Memory = 100 MB.
 Split file into 100 MB chunks (approximately 100 chunks).
 Phase 1:

 Merge 2 chunks at a time (e.g., 2 chunks of 100 MB).
 Resulting files after phase 1: 50 files of ~200 MB each.
 Phase 2:

 Merge 2 files of ~200 MB each.
 Resulting files after phase 2: 25 files of ~400 MB each.
 Phase 3:

 Merge 2 files of ~400 MB each.
 Resulting files after phase 3: 12 files of ~800 MB each.
 Phase 4:

 Merge 2 files of ~800 MB each.
 Resulting files after phase 4: 6 files of ~1.6 GB each.
 Final Phase:

 After several such passes, you may end up with just 2-3 files, and each file will be small enough to fit into memory for the final merge.

 Input (Sorted Chunks)
 Chunk 1:
 1
 4
 7
 Chunk 2:
 2
 5
 8
 Chunk 3:
 3
 6
 9
 Step-by-Step Merging Process


 Step 1: Initialize Min-Heap

 Add the first element from each chunk into the Min-Heap
 Min-Heap = [1 (from Chunk 1), 2 (from Chunk 2), 3 (from Chunk 3)]

 Step 2: Extract Smallest and Refill Heap
 Extract the smallest element (1 from Chunk 1), and write 1 to the output.
 Advance the pointer in Chunk 1 to the next element (4).
 Push 4 into the Min-Heap
 Min-Heap = [2 (from Chunk 2), 3 (from Chunk 3), 4 (from Chunk 1)]

 Next Extract: Extract 2 from Chunk 2, write it to the output, and push the next element (5) into the heap:

 Min-Heap = [3 (from Chunk 3), 4 (from Chunk 1), 5 (from Chunk 2)]

 Step 3: Continue the Process
 Continue extracting the smallest element and refilling the heap:

 Extract 3 → Write 3 → Push 6 (from Chunk 3)
 Min-Heap = [4 (from Chunk 1), 5 (from Chunk 2), 6 (from Chunk 3)]

 Extract 4 → Write 4 → Push 7 (from Chunk 1)
 Min-Heap = [5 (from Chunk 2), 6 (from Chunk 3), 7 (from Chunk 1)]

 Extract 5 → Write 5 → Push 8 (from Chunk 2)
 Min-Heap = [6 (from Chunk 3), 7 (from Chunk 1), 8 (from Chunk 2)]

 Extract 6 → Write 6 → Push 9 (from Chunk 3)
 Min-Heap = [7 (from Chunk 1), 8 (from Chunk 2), 9 (from Chunk 3)]

 Extract 7 → Write 7 → No more elements in Chunk 1.
 Min-Heap = [8 (from Chunk 2), 9 (from Chunk 3)]

 Extract 8 → Write 8 → No more elements in Chunk 2.
 Min-Heap = [9 (from Chunk 3)]

 Extract 9 → Write 9 → No more elements in Chunk 3.
 Output (Merged File)
 Copy
 Edit
 1 2 3 4 5 6 7 8 9
 */
}
