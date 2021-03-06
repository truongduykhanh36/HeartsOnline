package model.card;

import java.io.Serializable;

public enum CardType implements Serializable {
    SPADES(2),
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(3);

    private int order;
    CardType(int order) {
        this.order = order;
    }

    public int getOrder() {return order;}
}
