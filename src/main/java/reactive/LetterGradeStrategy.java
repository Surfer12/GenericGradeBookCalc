package reactive;

import reactor.core.publisher.Mono;

public class LetterGradeStrategy implements GradeStrategy {
    @Override
    public Mono<String> applyStrategy(Integer grade) {
        return Mono.just(grade)
                .map(this::convertToLetterGrade);
    }

    private String convertToLetterGrade(Integer grade) {
        if (grade >= 90)
            return "A";
        else if (grade >= 80)
            return "B";
        else if (grade >= 70)
            return "C";
        else if (grade >= 60)
            return "D";
        else
            return "F";
    }

    @Override
    public Object calculateGrade(int i) {
        return convertToLetterGrade(i);
    }
}