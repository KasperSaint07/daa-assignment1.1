# Design and Analysis of Algorithms — Assignment 1

**Author:** Madiyar Amanzhol (SE-2407)  
**Course:** Design and Analysis of Algorithms  
**Instructor:** Khaimuldin Nursultan

---

##  Project Overview

This project implements **classic divide-and-conquer algorithms** with safe recursion patterns.  
It also includes a **metrics collection system** (time, recursion depth, comparisons, operations) and a **CLI interface** to run experiments and export results to CSV for analysis.

Implemented algorithms:
- **MergeSort** (D&C, Master Theorem Case 2)
- **QuickSort** (robust: randomized pivot, recurse smaller side)
- **Deterministic Select** (Median-of-Medians, O(n))
- **Closest Pair of Points** (2D plane, O(n log n))

---

##  Architecture Notes

- **Recursion depth** is explicitly tracked with `Metrics.enterRecursion()` and `exitRecursion()`.
- **Operations and comparisons** are counted at each critical step (swaps, merges, key comparisons).
- **Time** is measured with `System.nanoTime()` inside `metrics.start()` and `metrics.stop()`.
- **Safe recursion**:
    - QuickSort always recurses on the **smaller partition** and iterates on the larger one → ensures stack depth is bounded ≈ `O(log n)`.
    - MergeSort switches to **InsertionSort** for small arrays (`n ≤ 16`) to reduce constant factors.
    - Select (MoM5) only recurses into the **necessary side** (at most half of the array).
    - Closest Pair checks the "strip" with at most 7–8 neighbours per point.

---

##  Recurrence Analysis

### 1. MergeSort
- **Recurrence:**  
  \[
  T(n) = 2T\left(\frac{n}{2}\right) + \Theta(n)
  \]
- **Method:** Master Theorem (Case 2).
- **Result:**  
  \[
  T(n) = \Theta(n \log n)
  \]

### 2. QuickSort (randomized, smaller-side recursion)
- **Recurrence (expected):**  
  \[
  T(n) = T(k) + T(n-k-1) + \Theta(n), \quad k \sim U(0,n-1)
  \]
- **Expected case:** average split → `O(n log n)`.
- **Worst case:** degenerate split → `O(n^2)`, but avoided with randomized pivot.
- **Recursion depth:** bounded by `≈ 2 log₂ n`.

### 3. Deterministic Select (Median-of-Medians, MoM5)
- **Recurrence:**  
  \[
  T(n) = T\left(\frac{n}{5}\right) + T\left(\frac{7n}{10}\right) + \Theta(n)
  \]
- **Analysis:** By Akra–Bazzi or intuition:  
  \[
  T(n) = \Theta(n)
  \]

### 4. Closest Pair of Points (2D)
- **Recurrence:**  
  \[
  T(n) = 2T\left(\frac{n}{2}\right) + \Theta(n)
  \]
- **Method:** Master Theorem (Case 2).
- **Result:**  
  \[
  T(n) = \Theta(n \log n)
  \]

---

##  Experimental Results

Algorithms were executed using the CLI runner.  
Metrics were written into `results.csv` in the format:  

