import org.example.Tugas.Wallet;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WalletLifeCycleTest {

    private Wallet wallet;
    private static int testCounter = 0;
    @BeforeAll
    static void beforeAll() {
        System.out.println("Initializing tests..");
    }

    @BeforeEach
    void setUp() {
        testCounter++;
        System.out.println("Setting up for test #" + testCounter);
        wallet = new Wallet("Jono");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down after test #" + testCounter);
        wallet = null;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Test Completed.");
    }

    @Test
    @Order(1)
    void testAddCard() {
        wallet.addCard("ATM");
        assertEquals(1, wallet.getCards().size());
    }

    @Test
    @Order(2)
    void testTakeCard() {
        wallet.addCard("KTP");
        wallet.takeCard("ATM");
        assertEquals(1, wallet.getCards().size());
    }

    @Test
    @Order(3)
    void testAddMoney() {
        wallet.addMoney(1000);
        assertEquals(1, wallet.getMoneys().get(1000));
    }

    @Test
    @Order(4)
    void testTakeMoney() {
        wallet.addMoney(1000);
        wallet.takeMoney(1000);
        assertEquals(0, wallet.getMoneys().get(1000));
    }

    @Test
    @Order(5)
    void testAddCoins() {
        wallet.addCoins(500);
        assertEquals(1, wallet.getCoins().get(500));
    }

    @Test
    @Order(6)
    void testTakeCoin() {
        wallet.addCoins(500);
        wallet.takeCoin(500);
        assertEquals(0, wallet.getCoins().get(500));
    }

    @Test
    @Order(7)
    void testGetMoneyAvailable() {
        wallet.addMoney(1000);
        wallet.addCoins(500);
        assertEquals(1500, wallet.getMoneyAvailable());
    }
}