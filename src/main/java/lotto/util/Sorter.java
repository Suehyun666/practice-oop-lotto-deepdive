package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.ErrorConstants.INSTANCE_ERROR;

public class Sorter {

    private Sorter(){
        throw new AssertionError(INSTANCE_ERROR);
    }

    public static List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
