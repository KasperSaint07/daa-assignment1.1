# Divide and Conquer Algorithms (DAA Assignment)

This project was created as part of the **Design and Analysis of Algorithms (DAA)** course.  
It implements classic **divide-and-conquer algorithms** with metrics collection, tests, CLI interface, and benchmarks.

---

## Implemented Algorithms
- **MergeSort** — merge sort with reusable buffer and cutoff for small arrays.
- **QuickSort** — randomized pivot selection, recurse on smaller partition to keep stack ≈ O(log n).
- **Deterministic Select (Median of Medians, MoM5)** — find k-th order statistic in O(n).
- **Closest Pair of Points** — divide-and-conquer closest pair algorithm in O(n log n).

---

##  Metrics
Each run collects:
- Execution time (ms)
- Number of comparisons
- Number of operations
- Maximum recursion depth

Results are written to **results.csv**.

---

## 🗂 Project Structure
