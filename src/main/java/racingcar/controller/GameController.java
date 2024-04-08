package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.validate.CarNameValidate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

// 연결 다리
public class GameController {

    private final Cars cars = new Cars();


    public void gameStart(){
       String[] carNames = InputView.inputCarName();
       CarNameValidate.validateCarName(carNames);
       cars.inputCarName(carNames);
       int repeat =InputView.showMoveCount();
       Racing(repeat);
       OutputView.printWinnerCars(findWinners());
    }

    public void Racing(int repeat){
        OutputView.outputMessage();
        for(int round = 0; round < repeat; round++){
            cars.carForward();
            OutputView.showCar(cars);

        }
//         여기서 winner들 출력해주는 거 가져와 OutputView에서

    }
    public List<String> findWinners(){
        return cars.findWinners();
    }
}
