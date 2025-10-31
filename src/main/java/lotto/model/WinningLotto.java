package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {

    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        validateBonusNumber(bonusNumber);
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if(getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹치지 않아야 합니다.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
