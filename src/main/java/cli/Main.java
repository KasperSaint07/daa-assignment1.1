    package cli;

    import java.io.FileWriter;

    public class Main {
        public static void main(String[] args) {
            String algo = "mergesort";
            int size = 100;
            int trials = 1;

            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "--algo" -> algo = args[++i];
                    case "--size" -> size = Integer.parseInt(args[++i]);
                    case "--trials" -> trials = Integer.parseInt(args[++i]);
                }
            }

            try (FileWriter csv = new FileWriter("results.csv")) {
                csv.write("algo,size,trial,time(ms),comparisons,operations,maxDepth\n");

                AlgorithmRunner runner = switch (algo.toLowerCase()) {
                    case "mergesort" -> new MergeSortRunner();
                    case "quicksort" -> new QuickSortRunner();
                    case "select" -> new SelectRunner();
                    case "closest" -> new ClosestPairRunner();
                    default -> throw new IllegalArgumentException("Unknown algorithm: " + algo);
                };

                runner.run(size, trials, csv);
                System.out.println("Results written to results.csv");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
