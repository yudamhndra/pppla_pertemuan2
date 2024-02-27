import org.example.Tugas.Wallet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class WalletTest {

    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet("John Doe");
    }

    @Test
    public void testAddMoney() {
        wallet.addMoney(1000);
        wallet.addMoney(5000);
        wallet.addMoney(10000);

        HashMap<Integer, Integer> moneys = wallet.getMoneys();
        assertEquals(1, moneys.get(1000));
        assertEquals(1, moneys.get(5000));
        assertEquals(1, moneys.get(10000));
    }

    @Test
    public void testTakeMoney() {
        wallet.addMoney(10000);
        wallet.takeMoney(10000);

        HashMap<Integer, Integer> moneys = wallet.getMoneys();
        assertEquals(0, moneys.get(10000));
    }

    @Test
    public void testAddCoins() {
        wallet.addCoins(100);
        wallet.addCoins(500);
        wallet.addCoins(1000);

        HashMap<Integer, Integer> coins = wallet.getCoins();
        assertEquals(1, coins.get(100));
        assertEquals(1, coins.get(500));
        assertEquals(1, coins.get(1000));
    }

    @Test
    public void testTakeCoins() {
        wallet.addCoins(1000);
        wallet.takeCoin(1000);

        HashMap<Integer, Integer> coins = wallet.getCoins();
        assertEquals(0, coins.get(1000));
    }

    @Test
    public void testGetMoneyAvailable() {
        wallet.addMoney(2000);
        wallet.addCoins(100);

        assertEquals(2100, wallet.getMoneyAvailable());
    }
}
