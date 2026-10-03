public class Main {
    public static void main(String[] args) {

        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        }
    }

    public static void runDemo() {

        int passed = 0;
        int total = 5;

        // T1: Circle + VectorRenderer
        Circle circle1 = new Circle("C1", 2, new VectorRenderer());

        String actual1 = circle1.execute();
        String expected1 = "VECTOR circle radius=2";

        if (actual1.equals(expected1)) {
            System.out.println("T1 PASS | Circle + VectorRenderer | result=" + actual1);
            passed++;
        } else {
            System.out.println("T1 FAIL | expected=" + expected1 + " | actual=" + actual1);
        }


        // T2: Circle + RasterRenderer
        Circle circle2 = new Circle("C2", 2, new RasterRenderer());

        String actual2 = circle2.execute();
        String expected2 = "RASTER circle radius=2";

        if (actual2.equals(expected2)) {
            System.out.println("T2 PASS | Circle + RasterRenderer | result=" + actual2);
            passed++;
        } else {
            System.out.println("T2 FAIL | expected=" + expected2 + " | actual=" + actual2);
        }


        // T3: Square + VectorRenderer
        Square square1 = new Square("S1", 3, new VectorRenderer());

        String actual3 = square1.execute();
        String expected3 = "VECTOR square side=3";

        if (actual3.equals(expected3)) {
            System.out.println("T3 PASS | Square + VectorRenderer | result=" + actual3);
            passed++;
        } else {
            System.out.println("T3 FAIL | expected=" + expected3 + " | actual=" + actual3);
        }


        // T4: Square + RasterRenderer
        Square square2 = new Square("S2", 3, new RasterRenderer());

        String actual4 = square2.execute();
        String expected4 = "RASTER square side=3";

        if (actual4.equals(expected4)) {
            System.out.println("T4 PASS | Square + RasterRenderer | result=" + actual4);
            passed++;
        } else {
            System.out.println("T4 FAIL | expected=" + expected4 + " | actual=" + actual4);
        }


        // T5: Change implementation on the same object
        Circle switchCircle = new Circle("C3", 2, new VectorRenderer());

        Circle originalReference = switchCircle;

        String originalId = switchCircle.getId();
        int originalRadius = switchCircle.getRadius();

        String before = switchCircle.execute();

        switchCircle.setImplementation(new RasterRenderer());

        String after = switchCircle.execute();

        boolean sameObject = originalReference == switchCircle;

        boolean stateUnchanged =
                switchCircle.getId().equals(originalId)
                        && switchCircle.getRadius() == originalRadius;

        boolean correctBefore =
                before.equals("VECTOR circle radius=2");

        boolean correctAfter =
                after.equals("RASTER circle radius=2");

        if (sameObject && stateUnchanged && correctBefore && correctAfter) {
            System.out.println(
                    "T5 PASS | sameObject=" + sameObject
                            + " | stateUnchanged=" + stateUnchanged
            );

            System.out.println(
                    " before=" + before
                            + " | after=" + after
            );

            passed++;
        } else {
            System.out.println("T5 FAIL");
        }


        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }
}
