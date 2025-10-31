package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoService {


    public void purchaseLottos(){

    }

    List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
