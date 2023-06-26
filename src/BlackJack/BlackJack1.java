package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 내가 테스트한 블랙잭

class Card1 {
    // 무늬도 enum으로 만들 수 있음. 그러나 무늬점수는 계산하지 않을 것이므로 String
    String pattern;
    int rank; // 숫자

    Card1 (String pattern, int rank) {
        this.pattern = pattern;
        this.rank = rank;
        // J, Q, K => 10
        if (rank > 10) this.rank = 10;
    }

    // 카드 정보 표시
    void showCardInfo() {
        System.out.print("[" + pattern + ", " + rank + "]");
    }
} // end of Card Class

class Player1 {
    String name;
    int credit;
    ArrayList<Card1> hands;

    // 기본생성자
    Player1() { }

    // 생성자
    Player1(String name, int credit) {
        this.name = name;
        this.credit = credit;
        hands = new ArrayList<>();
    }

    void clearHands() {
        hands.clear();
    }

    // 플레이어의 정보를 표시
    void showPlayerInfo() {
        System.out.println("===============================");
        System.out.println("Player : " + name + " ( " + credit + "원 )");
        for (int i = 0; i < hands.size(); i++) {
            hands.get(i).showCardInfo();
        }
        System.out.println("\n===============================");
    }

    // 점수 계산 메서드
    // ACE(1) 는 플레이어 숫자 합이 21 초과할 경우 1로, 이하일 경우 11로 계산한다
    int getScore() {
        int score = 0;
        int ace = 0;

        for (int i = 0; i < hands.size(); i++) {
//            System.out.println("지금 카드는 " + hands.get(i).rank);
            if (hands.get(i).rank == 1) ace++;
            else {
                score += hands.get(i).rank;
            }
//            System.out.println("점수 : " + score);
        }
        int max;
        int min;
        if (ace != 0) {
            max = score + ace + 10;
//            System.out.println("최대치 : " + max);
            min = score + ace;
//            System.out.println("최소치 : " + min);
            if (max < 22) score = max;
            else score = min;
        } else {
            score = score + ace;
        }
        System.out.println(name + "의 점수 합은 " + score);

        return score;
    }
} // end of Player Class

class Dealer1 extends Player1 {
    Dealer1(String name, int credit) {
        super(name, credit); // 상위 클래스 상속
        hands = new ArrayList<>();
    }

    // 딜러의 정보를 표시
    void showPlayerInfo() {
        System.out.println("\t\t\t\t\t\t===============================");
        System.out.println("\t\t\t\t\t\tDealer : " + name + " ( " + credit + "원 )");
        System.out.print("\t\t\t\t\t\t");
        for (int i = 0; i < hands.size(); i++) {
            hands.get(i).showCardInfo();
        }
        System.out.println("\n\t\t\t\t\t\t===============================");
    }
} // end of Dealer Class


public class BlackJack1 {
    Scanner sc = new Scanner(System.in);

    // 게임 상태
    enum GameState { INIT, PLAY, CAL_SCORE, MAKEUP, END };

    GameState curState;


    // 플레이어 정보
    ArrayList<Player1> players = new ArrayList<>();
    // 딜러 정보
    Dealer1 dealer = new Dealer1("딜러", 10000);
    // 카드 정보
    ArrayList<Card1> deck = new ArrayList<>();

    // 기본 생성자 : 게임 생성
    BlackJack1() {
        curState = GameState.INIT;
    }

    // 게임 시작
    void start() {

        System.out.println("테이블이 오픈되었습니다.");

        // 테이블이 닫히면 END state. 즉, 게임이 종료되기 전까지 계속된다
        while (curState != GameState.END) {
            switch (curState) {
                case INIT:
                    initGame();
                    curState = GameState.MAKEUP;
                    break; // break 했어도 GameState.End 가 아니므로 while 루프를 돈다
                case MAKEUP:
                    makeupGame();
                    curState = GameState.PLAY;
                    break;
                case PLAY:
                    System.out.println("게임이 진행중입니다.");
                    playGame();
                    curState = GameState.CAL_SCORE;
                    break;
                case CAL_SCORE:
                    System.out.println("점수 계산중...");
                    calScore();
                    // 원래는 makeup 으로 간다. 지금은 한판만 하고 끝냄
                    curState = GameState.END;
                    break;
                default:
                    // case END 는 할 필요 없다. 애초에 while 루프에서 벗어나기 때문
                    // 잘못된 입력에서 종료하게 함
                    curState = GameState.END;
                    break;
            }
        }
        System.out.println("게임이 끝났습니다.");
    } // end of start()

    // 처음에 블랙잭 테이블을 오픈하면 반드시 초기화를 해줘야 함
    void initGame() {
        System.out.println("게임이 생성되었습니다.");

        // 게임 초기화에 필요한 정보를 넣음
        // 덱 만들기
        makeDeck();

        // 플레이어의 카드 초기화
        for (Player1 p : players) {
            p.hands.clear();
        }

//        // 섞인 카드덱 정보 출력
//        for (int i = 0; i < deck.size(); i++) {
//            deck.get(i).showCardInfo();
//        }

    } // end of initGame()

    // 덱 만드는 메서드
    private void makeDeck() {
        // 덱이 남아있으면 clear 해줌
        deck.clear();

        // 52장의 카드를 준비해서 deck에 넣음
        String [] patterns = {"♣", "♠", "♥", "♦"};
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                Card1 c = new Card1(patterns[i], j);
                deck.add(c); // 생성된 카드를 덱에 넣어줌
            }
        }
        // 덱 만들었으면 셔플
        Collections.shuffle(deck);
    } // end of makeDeck()

    // 게임 진행 메서드
    void playGame() {
        // 카드를 2장씩 각 플레이어에게 돌린다
        // 딜러에게 카드 2장 주기
        dealer.hands.add(deck.remove(0)); // 덱의 제일 앞 카드를 빼서 딜러에게 줌
        dealer.hands.add(deck.remove(0));
        // 인덱스 0에서 remove 하면 앞에게 사라지니까 계속 0이 제일 앞이 됨

        // 플레이어에게 카드 두장씩 주기
        for (int i = 0; i < players.size(); i++) {
            players.get(i).hands.add(deck.remove(0));
            players.get(i).hands.add(deck.remove(0));
        }

        // 딜러의 정보를 표시
        dealer.showPlayerInfo();

        // 플레이어의 정보를 표시
        for (int i = 0; i < players.size(); i++) {
            players.get(i).showPlayerInfo();
        }

        // 플레이어 한명씩 돌아가며 hit / stay 를 선택한다
        String hs;
        int sum = 0;
        int num = 0;
        for (int i = 0; i < players.size(); i++) {
            do {
                System.out.print(players.get(i).name + " >> 카드를 더 받으시겠습니까? (y/n) ");
                hs = sc.next();
                if (hs.equals("n")) {
                    break;
                }

                players.get(i).showPlayerInfo();
                // 플레이어가 hit을 하면 카드 한장을 더 받는다. 합이 21 초과시 bust
                players.get(i).hands.add(deck.remove(0));

                for (int j = 0; j < players.get(i).hands.size(); j++) {
                    sum = players.get(i).getScore();
                }
//                System.out.println(players.get(i).name + "의 현재 합계는 " + sum);

                if (sum > 21) {
                    System.out.println("21 초과");
                    break;
                }
            } while (hs.equals("y"));
        }


        // 모든 플레이어가 stay면 계산한다.
        // 딜러는 숫자의 합이 17 미만이면 무조건 카드 한장을 받는다. 17 이상이면 무조건 stay. 합이 21 초과시 bust
        if (dealer.getScore() < 17) {
            dealer.hands.add(deck.remove(0));
        }
    }

    // 승패 계산 메서드
    void calScore() {
        int dlScore = dealer.getScore();

        if (dlScore > 21) {
            System.out.println("딜러가 bust 하였습니다. 모든 플레이어들이 승리하였습니다.");
        } else {
            for (Player1 p : players) {
                if (p.getScore() < 22) {
                    if (p.getScore() > dlScore) {
                        System.out.println("플레이어 " + p.name + "가 승리하였습니다.");
                    } else if (p.getScore() < dlScore) {
                        System.out.println("플레이어 " + p.name + "가 패배하였습니다.");
                    } else {
                        System.out.println("--무승부--");
                    }
                } else {
                    System.out.println("플레이어 " + p.name + "가 bust 하였습니다.");
                }
            }
        }
    }

    // 플레이어 입장 / 퇴장
    void makeupGame () {
        while (players.size() < 5) {
            System.out.println("현재 테이블에 " + players.size() + "명의 플레이어가 있습니다.");
            System.out.print("참여를 희망하십니까? (y/n) ");
            String input = sc.next();
            System.out.println(input);
            if (input.equals("y")) {
                System.out.print("이름 : ");
                input = sc.next();
                Player1 p = new Player1(input, 1000);
                players.add(p);
            }
            else if (input.equals("n")) {
                break; // 플레이어가 1명이라도 게임이 실행 가능해야 함
            }
            else System.out.println("유효한 값을 입력하세요");
        }
    }

} // end of BlackJackGame Class
