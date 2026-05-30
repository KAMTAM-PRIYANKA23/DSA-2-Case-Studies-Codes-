public class Set1CO2 {

    public static void main(String[] args) {

        long records = 500_000_000L;

        int pageSize = 4096;
        int keySize = 64;
        int payloadSize = 100;
        int pointerSize = 8;

        int leafEntrySize = keySize + payloadSize;
        int leafFanout = pageSize / leafEntrySize;

        int internalEntrySize = keySize + pointerSize;
        int internalFanout = pageSize / internalEntrySize;

        double leaves = Math.ceil((double) records / leafFanout);

        int height = 1;
        double nodes = leaves;

        while (nodes > 1) {
            nodes = Math.ceil(nodes / internalFanout);
            height++;
        }

        int topCachedLevels = 3;
        int ioCost = Math.max(0, height - topCachedLevels);

        System.out.println("Leaf Fanout = " + leafFanout);
        System.out.println("Internal Fanout = " + internalFanout);
        System.out.println("Tree Height = " + height);
        System.out.println("Point Lookup I/O Cost = "
                + ioCost + " page reads");
    }
}
