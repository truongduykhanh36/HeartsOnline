package model.player;

import javafx.beans.property.StringProperty;
import model.card.Card;
import model.card.CardType;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public StringProperty nameProperty;
    private Position position;
    private int id;
    private int accumulatedPoint = 0;
    private boolean bot = false;

    private static ArrayList<Integer> usedIds = new ArrayList<>();
    public static int generateId() {
        int validId = 0;
        while(usedIds.contains(validId)) {
            validId++;
        }
        return validId;
    }
    public static void resetUsedIds(int... idsReserved) {
        usedIds.clear();
        for(int id : idsReserved) {
            usedIds.add(id);
        }
    }
    public static void useId(int id) {
        usedIds.add(id);
    }

    List<Card> cards = new ArrayList<>();
    List<Card> eatenCards = new ArrayList<>();

    public Player(){}

    public Player(Position position, String name) {
        this.position = position;
        nameProperty.set(name);
    }

    public void sortCards() {
        cards.sort((card1, card2)->{
            if(card1.getCardTypeOrder() == card2.getCardTypeOrder()) {
                return Integer.compare(card1.getValue(), card2.getValue());
            }
            else {
                return Integer.compare(card1.getCardTypeOrder(), card2.getCardTypeOrder());
            }
        });
    }

    public void eatCards(Card... cards) {
        for(Card card : cards) {
            if(card.getPoint() > 0)
                eatenCards.add(card);
        }
    }

    public Card autoPlayACard(int trickNum, CardType trickCardType, Card... cardsOnBoard) {
        //TODO: code máy chơi
        return cards.get(0);
    }



    public boolean hasCardType(CardType type) {
        for(Card card : cards) {
            if(card.getCardType().equals(type))
                return true;
        }
        return false;
    }

    public List<Card> getEatenCards() {
        return eatenCards;
    }

    public void setPosition(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentHandPoint() {
        int result = 0;
        for(Card card : eatenCards) {
            result += card.getPoint();
        }
        return result;
    }

    public boolean isBot() {
        return bot;
    }

}
