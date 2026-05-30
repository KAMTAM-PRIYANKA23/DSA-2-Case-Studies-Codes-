public class Set1CO1 {

    public static void main(String[] args) {

        int messagesPerSec = 5000;
        int seconds = 3600;

        long totalMessages = (long) messagesPerSec * seconds;

        long bstHeight = totalMessages;

        double avlHeight =
                1.44 * (Math.log(totalMessages + 2) / Math.log(2));

        long bstHops = bstHeight;
        long avlHops = (long) Math.ceil(avlHeight);

        double hopCostNs = 200;

        double bstLatencyUs = (bstHops * hopCostNs) / 1000.0;
        double avlLatencyUs = (avlHops * hopCostNs) / 1000.0;

        System.out.println("Total Messages: " + totalMessages);

        System.out.println("\nPlain BST");
        System.out.println("Tree Shape : Right Skewed");
        System.out.println("Height     : " + bstHeight);
        System.out.println("Latency    : " + bstLatencyUs + " microseconds");

        System.out.println("\nAVL Tree");
        System.out.println("Height     : " + avlHops);
        System.out.println("Latency    : " + avlLatencyUs + " microseconds");

        System.out.println("\nSLA = 500 microseconds");

        if (avlLatencyUs < 500)
            System.out.println("AVL meets SLA");
        else
            System.out.println("AVL violates SLA");

        if (bstLatencyUs < 500)
            System.out.println("BST meets SLA");
        else
            System.out.println("BST violates SLA");
    }
}
