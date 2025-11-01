package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String ERROR_INVALID_SIZE =
            String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LottoGenerator.LOTTO_NUMBER_COUNT);
    private static final String ERROR_DUPLICATE_NUMBER =
            "[ERROR] 로또 번호는 중복이 없어야 합니다.";
    private static final String ERROR_OUT_OF_RANGE =
            String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LottoGenerator.MIN_NUMBER, LottoGenerator.MAX_NUMBER);

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers); // 방어적 복사
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_INVALID_SIZE);
        }
        if(numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
        if(numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
