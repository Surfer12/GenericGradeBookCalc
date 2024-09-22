package reactive; 

public class BackpressureDemo {
   public static void main(String[] args) {
      Flux<Integer> grades = Flux.range(1, 100)
            .onBackpressureBuffer()
            .publishOn(Schedulers.boundedElastic());

      grades.subscribe(
            grade -> System.out.println("Processing grade: " + grade),
            error -> System.err.println("Error: " + error),
            () -> System.out.println("Processing complete"));
   }
}