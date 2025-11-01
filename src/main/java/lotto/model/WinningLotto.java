package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private static final String ERROR_DUPLICATE_NUMBER =
            "[ERROR] 보너스 번호는 당첨 번호와 겹치지 않아야 합니다.";
    private static final String ERROR_OUT_OF_RANGE =
            String.format("[ERROR] 보너스 번호는 %d부터 %d 사이의 숫자여야 합니다.", LottoGenerator.MIN_NUMBER, LottoGenerator.MAX_NUMBER);

    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        validateBonusNumber(bonusNumber);
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if(getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
