
public class SimpleTesting {

    private static final String PASS = "Successful";
    private static final String FAIL = "Failed";
    private static final String NON_EXISTENT = "Minas Tirinth";
    public static void main(String[] args) {
        // Create a small train line and add a few stations to it with names
        // drawn from a String[]
        TrainLine redLineSB = new TrainLine();
        String[] stationNames = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale" };
        for (String name : stationNames) {
            redLineSB.addStation(name);
        }
        TrainLine redLine2SB = new TrainLine();
        String[] stationNames2 = { "Bryn Mawr", "Berwin", "Argyle",
                "Lawrence", "Wilson", "Sheridan" };
        for (String name : stationNames2) {
            redLine2SB.addStation(name);
        
        redLineSB.append(redLine2SB);
        System.out.println(redLineSB.toString());
        boolean appended = true;
        for (int i = 0; i < stationNames2.length; i++) {
            appended = appended && (redLineSB.indexOf(stationNames2[i]) == stationNames.length + i);
        }
        System.out.printf("\n\nAppend test: %s", (appended ? PASS : FAIL));


        }
        // Test sequence
        boolean sequence = true;
        for (int i = 0; i < stationNames.length; i++) {
            sequence = sequence && (redLineSB.indexOf(stationNames[i]) == i);
        }
        System.out.printf("\n\nSequence test: %s", (sequence ? PASS : FAIL));
        // Test non existent
        boolean nonExisting = (redLineSB.indexOf(NON_EXISTENT) == -1);
        System.out.printf("\n\nSequence test: %s", (nonExisting ? PASS : FAIL));
    }
}
