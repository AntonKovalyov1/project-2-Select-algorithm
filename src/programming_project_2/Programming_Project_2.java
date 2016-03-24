package programming_project_2;
public class Programming_Project_2 {
    public static void main(String[] args) {
        CorrectnessTest.test();
        System.out.println("");
        Benchmarking test = new Benchmarking();
        
        System.out.println("\n" + test.testRandomizedSelect(1000000, 1000)[1]);
        System.out.println("\n" + test.testRandomizedSelect(1000000, 1000)[1]);
        System.out.println("\n" + test.testRandomizedSelect(1000000, 1000)[1]);
        System.out.println("\n" + test.testRandomizedSelect(1000000, 1000)[1]);
        System.out.println("\n" + test.testRandomizedSelect(1000000, 1000)[1]);
    }
}
