import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        File input = new File("../input");
        List<Integer> leftNumbers = new ArrayList<>();
        List<Integer> rightNumbers = new ArrayList<>();
        Integer distance = 0;
        Integer similarity = 0;
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                leftNumbers.add(Integer.parseInt(line.split("   ")[0]));
                rightNumbers.add(Integer.parseInt(line.split("   ")[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        leftNumbers.sort(Comparator.naturalOrder());
        rightNumbers.sort(Comparator.naturalOrder());

        Map<Integer, List<Integer>> collectedRight = rightNumbers.stream()
                .collect(Collectors.groupingBy(x -> x));

        for (int i = 0; i <= leftNumbers.size() - 1; i++) {
            distance += Math.abs( leftNumbers.get(i) - rightNumbers.get(i));
            if (collectedRight.containsKey(leftNumbers.get(i))) {
                similarity += leftNumbers.get(i) *  collectedRight.get(leftNumbers.get(i)).size();
            }
        }
        System.out.println("Part 1 solution: " + distance);
        System.out.println("Part 2 solution: " + similarity);

    }
}