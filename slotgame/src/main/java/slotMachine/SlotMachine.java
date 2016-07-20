package slotMachine;


import com.netent.games.simplegames.logger.Logger;
import com.netent.games.simplegames.money.Wallet;
import com.netent.games.simplegames.random.Random;

public class SlotMachine {

    private Wallet wallet;
    private Random random;

    public SlotMachine() {
        int startCoins = 100000000;
        wallet = new Wallet(startCoins);
        random = new Random();
    }

    public void spin() {

        int DEFAULT_WIN = 20;
        int DEFAULT_BET = 10;

        wallet.roundPayment(DEFAULT_BET);

        if (hasWin()) {
            wallet.addMoney(DEFAULT_WIN);
        }

        if (hasFreeRound()) {
            wallet.addMoney(DEFAULT_BET);
        }

    }

    public int getAllPays() {
        return wallet.getAllPays();
    }

    public void showRTP() {
        Logger.showRTP( getRTP() );
    }

    public float getRTP() {
        return (float)this.wallet.getAllWins() / this.wallet.getAllPays();
    }

    private boolean hasFreeRound() {
        return random.randInt(0, 100) < 10;
    }

    private boolean hasWin() {
        return random.randInt(0, 100) < 30;
    }

}

