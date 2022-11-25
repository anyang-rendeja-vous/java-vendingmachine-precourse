package vendingmachine;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;
    private VendingMachine vendingMachine;

    public MachineController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        RemainingCoins coins = generateCoins();
        outputView.printMachineCoinInfo(coins);

        Stocks stock = addStocks();
        UsersMoney usersMoney = insertMoney();
        vendingMachine = new VendingMachine(coins, stock, usersMoney);

        purchase();
    }

    private RemainingCoins generateCoins() {
        outputView.printMachineMoneyInputOpening();
        try {
            return new RemainingCoins(inputView.userInput());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return generateCoins();
        }
    }

    private Stocks addStocks() {
        outputView.printMerchandiseInfoOpening();
        try{
            return new Stocks(inputView.userInput());
        }catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            return addStocks();
        }
    }

    private UsersMoney insertMoney(){
        outputView.printUserMoneyInputOpening();
        try{
            return new UsersMoney(inputView.userInput());
        }catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            return insertMoney();
        }
    }

    private void purchase() {
        do{
            outputView.printLeftovers(vendingMachine.getUsersMoney());
            outputView.printUsersStockChoiceOpening();
            try{
                // vendingMachine.purchase(inputView.userInput());
            }catch (IllegalArgumentException exception){
                outputView.printErrorMessage(exception.getMessage());
                purchase();
            }

        } while (vendingMachine.isPurchasable());
    }


}
