public class Set1CO3 {

    public static void main(String[] args) {

        int channels = 12000;
        int edges = 240000;

        long findOperations = edges * 2L;

        double alpha = 4.0;

        double pointerHops = findOperations * alpha;

        System.out.println("Channels = " + channels);
        System.out.println("Edges = " + edges);

        System.out.println("\nFind Operations = "
                + findOperations);

        System.out.println("Approx Pointer Hops = "
                + (long) pointerHops);

        System.out.println("\nTime Complexity:");
        System.out.println("O(E * α(V))");

        System.out.println("\nLargest Component:");
        System.out.println("Maintain size[] array");
        System.out.println("Update size during union");
        System.out.println("Track maximum size");
    }
}