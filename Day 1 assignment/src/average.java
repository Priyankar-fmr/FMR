public class average {
    public static double calcavg(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum / numbers.length;
    }
    public static void main(String[] args) {
        int[] numbers = {10,20,30,40,50,60,70,80,90,100};
        double average = calcavg(numbers);
        System.out.println("Average: "+average);
    }
}