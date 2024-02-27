package org.example.Tugas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Wallet {

    private String owner;
    private ArrayList<String> cards;

    HashMap<Integer, Integer> moneys;

    HashMap<Integer, Integer> coins;

    int[] coinTypes = {100, 500, 1000};

    int[] moneyTypes = {1000, 2000, 5000, 10000, 20000, 50000, 100000};

    public Wallet(String owner) {
        this.owner = owner;
        this.coins = new HashMap<Integer, Integer>();
        for (int i = 0; i < coinTypes.length; i++) {
            this.coins.put(coinTypes[i], 0);
        }

        this.moneys = new HashMap<Integer, Integer>();
        for (int i = 0; i < moneyTypes.length; i++) {
            this.moneys.put(moneyTypes[i], 0);
        }

        this.cards = new ArrayList<String>();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getCards() {
        return cards;
    }

    public void addCard(String card) {
        this.cards.add(card);
    }

    public void takeCard(String card) {
        this.cards.remove(card);
    }

    public HashMap<Integer, Integer> getMoneys() {
        return moneys;
    }

    public void addMoney(Integer moneyType) {
        if (isValidMoneyType(moneyType)) {
            int initialValue = this.moneys.get(moneyType);
            this.moneys.put(moneyType, initialValue + 1);
        }
    }

    public void takeMoney(Integer moneyType) {
        int initialValue = this.moneys.get(moneyType);
        if (initialValue > 0) {
            this.moneys.put(moneyType, initialValue - 1);
        }
    }

    public void addCoins(Integer coinType) {
        if (isValidCoinType(coinType)) {
            int initialValue = this.coins.get(coinType);
            this.coins.put(coinType, initialValue + 1);
        }
    }

    public void takeCoin(Integer coinType) {
        int initialValue = this.coins.get(coinType);
        if (initialValue > 0) {
            this.coins.put(coinType, initialValue - 1);
        }
    }

    public HashMap<Integer, Integer> getCoins() {
        return coins;
    }

    public int getMoneyAvailable() {
        int total = calculatedCoins() + calculatedMoneys();
        return total;
    }

    public int calculatedCoins() {
        int total = 0;
        for (Integer key : this.coins.keySet()) {
            total += key * this.coins.get(key);
        }
        return total;
    }

    public int calculatedMoneys() {
        int total = 0;
        for (Integer key : this.moneys.keySet()) {
            total += key * this.moneys.get(key);
        }
        return total;
    }

    private boolean isValidCoinType(Integer coinType) {
        for (int type : coinTypes) {
            if (type == coinType) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidMoneyType(Integer moneyType) {
        for (int type : moneyTypes) {
            if (type == moneyType) {
                return true;
            }
        }
        return false;
    }
}
