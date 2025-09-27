# Assignment 1 – Divide and Conquer Algorithms

**Author:** Amanzhol Madiyar (SE-2407)  
**Course:** Algorithms & Data Structures  
**Repository:** [daa-assignment1.1](https://github.com/KasperSaint07/daa-assignment1.1)

---

## 🎯 Learning Goals
- Implement classic **divide-and-conquer algorithms** with safe recursion.
- Analyse **recurrence relations** using Master Theorem (3 cases) and Akra–Bazzi.
- Validate theory with **empirical measurements**.
- Collect metrics: execution time, recursion depth, comparisons, and operations.
- Apply proper **GitHub workflow** with feature branches and structured commits.

---

## 📂 Project Structure
src/
├── main/java
│ ├── mergesort/ # MergeSort (buffer reuse + cutoff to InsertionSort)
│ ├── quicksort/ # QuickSort (random pivot, smaller-side recursion)
│ ├── select/ # Deterministic Select (Median-of-Medians, O(n))
│ ├── closestpair/ # Closest Pair of Points (O(n log n))
│ ├── metrics/ # Metrics (comparisons, operations, recursion depth, time)
│ ├── cli/ # CLI runners (CSV output)
│ ├── bench/ # JMH benchmarks
│ └── utils/ # Partition, swap, shuffle, helpers
└── test/java
├── mergesort/ # Tests for MergeSort
├── quicksort/ # Tests for QuickSort (depth check)
├── select/ # Tests for Select vs Arrays.sort
├── closestpair/ # Validate vs brute-force O(n²)
└── metrics/ # Unit tests


---

## ⚙️ Architecture Notes
- **Recursion depth control**:  
  - QuickSort always recurses on the *smaller partition*, iterates on the larger one → depth = O(log n).  
  - MergeSort switches to **InsertionSort** for subarrays ≤ 16.  
- **Buffer reuse**: MergeSort uses one buffer array → fewer allocations.  
- **Metrics**: tracked for every algorithm:  
  - Comparisons  
  - Operations (swaps, assignments)  
  - Recursion depth (current and max)  
  - Execution time (ms)  

---

## 🔢 Recurrence Analysis

### MergeSort
T(n) = 2T(n/2) + Θ(n)
→ Θ(n log n) (Master Theorem, Case 2)

### QuickSort (random pivot, smaller-side recursion)
- Average: Θ(n log n)  
- Worst-case: Θ(n²) (rare with randomization)  
- Depth bounded by ~2·log₂n.

### Deterministic Select (Median-of-Medians, MoM5)
T(n) ≤ T(n/5) + T(7n/10) + Θ(n)
→ Θ(n) (Akra–Bazzi)
Guarantees linear selection.

### Closest Pair of Points (2D)
T(n) = 2T(n/2) + Θ(n)
→ Θ(n log n) (Master Theorem, Case 2)
Strip check ≤ 7–8 neighbors per point.

---

## 📊 Empirical Results

CSV format:
algo,size,trial,time(ms),comparisons,operations,maxDepth
mergesort,1000,1,3,10897,12000,12
quicksort,1000,1,2,9753,10500,11
select,1000,1,1,4300,5100,8
closest,1000,1,4,22981,24500,14


### Example Plots
- ⏱ **Time vs n** – shows n log n vs linear growth.  
- 🌲 **Recursion depth vs n** – QuickSort bounded, MergeSort depth ≈ log n.  
- 📊 **Comparisons vs n** – Select is linear, others are n log n.  

**Discussion**:
- MergeSort is stable, low variance.  
- QuickSort slightly faster but with more variance (random pivot).  
- Select slower for small n but linear scaling visible for large n.  
- Closest Pair has large constants but follows n log n growth.  

---

## 🧪 Testing
- Sorting correctness checked on random/adversarial arrays.  
- QuickSort depth verified ≤ 2·log₂n.  
- Select compared vs `Arrays.sort()[k]` on 100 random trials.  
- Closest Pair validated vs brute-force for n ≤ 2000.  

---

## 🌱 GitHub Workflow
- **Branches**:  
  - `feature/metrics`  
  - `feature/mergesort`  
  - `feature/quicksort`  
  - `feature/select`  
  - `feature/closest`  
  - `feature/cli`  
  - `bench/jmh`  
  - `docs/report`  

- **Commit storyline**:  
  - `init: maven, junit5, readme`  
  - `feat(metrics): counters, depth tracker, CSV writer`  
  - `feat(mergesort): buffer reuse + cutoff`  
  - `feat(quicksort): randomized pivot, smaller-side recursion`  
  - `feat(select): deterministic MoM5`  
  - `feat(closest): divide-and-conquer + strip check`  
  - `feat(cli): parse args, CSV output`  
  - `bench(jmh): select vs sort`  
  - `docs(report): analysis & plots`  
  - `release: v1.0`  

---

## ✅ Summary
- Implemented 4 D&C algorithms with correct complexity.  
- Ensured safe recursion and bounded depth.  
- Collected detailed metrics and confirmed theory with experiments.  
- Used GitHub workflow with feature branches and structured commits.  

Next steps: add more plots, measure **cache effects** and **GC overhead**.
