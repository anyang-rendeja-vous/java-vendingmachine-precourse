package vendingmachine;

public enum Coin {
    COIN_500(500,0),
    COIN_100(100,0),
    COIN_50(50,0),
    COIN_10(10,0);

    private final int amount;
    public int count;

    Coin(final int amount,int count) {
        this.amount = amount;
        this.count=count;
    }
    public void setCount(int newCount){
        this.count=newCount;
    }
    public int getCount(){
        return this.count;
//        return Coin.valueOf("COIN_"+amount).count;
    }
    public int getAmount(){
        return this.amount;
    }



    // 추가 기능 구현
}
