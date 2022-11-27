## 기능 명세

### 입력한 금액만큼의 동전 생성

- [X] 금액 입력
    - [X] 잘못된 형식의 입력이면 예외 발생
    - [X] 정상 입력이면 동전 생성 메커니즘으로ㄱㄱ
    
- [X] 동전 랜덤 생성 (금액 맞을 때까지 랜덤 생성기 돌리기)

- [X] 생성된 동전 출력

### 입력한 상품 정보만큼의 상품 생성

- [X] 입력 정보 파싱
    - [X] 잘못된 입력 형식이면 예외 발생
    - [X] 정상 입력이면 상품 생성 ㄱㄱ
    
- [X] 상품 목록 생성
    - [X] 파싱된 상품 목록 돌면서 상품 객체 생성, 목록에 추가 (Stock, Stocks)

### 구매하기

- [X] 투입 금액 입력
    - [X] 잘못된 형식의 입력이면 예외 발생
    
- [X] 상품 구매 
    - [X] 존재하는 상품이 아니면 예외 발생 -> #vendingMachine.checkStock
    - 정상 입력이면
        - [X] 살 수 있는지 확인 (남은 금액으로 해당 상품 살 수 있는지 && 상품 재고 남아 있는지) -> #vendingMachine.isPurchasable
        - [X] 살 수 있으면 구매하기 -> #vendingMachine.purchase
        - [X] 최저 상품 금액과 잔액 비교 && 모든 상품 재고 소진되지 않았는지 확인 -> #vendingMachine.isPurchasable

### 결과 출력

- [X] 잔돈 거슬러주기 계산 -> #vendingMachine.returnCoins
- [X] 최종 결과 출력

## 구조 명세

- MachineController : 메인 컨트롤러
- VendingMachine : 자판기 핵심 비즈니스 로직
- CoinMaker : 동전 랜덤 생성 
- Money : 금액
- RemainingCoins : 자판기가 보유한 동전들
- UsersMoney : 사용자가 입력한 금액
- Stocks : 재고 목록
- Stock : 재고 한 종류
- InputView, OutputView : 입출력
- MessageUtils : 출력 메세지, 에러 모음